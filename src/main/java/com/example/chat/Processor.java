package com.example.chat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Date;
import java.util.Objects;

public class Processor {

    public ChatFrame ui;
    public History hist;
    public ConnectionFactory connection;
    public RabbitTemplate rabbitTemplate;



    public Processor(ChatFrame frame, ConnectionFactory yourConnectionFactory){
        ui = frame;
        this.connection=yourConnectionFactory;
        this.rabbitTemplate =new RabbitTemplate(connection);
        this.hist = ui.hist;


        try {
            // 如果连接成功建立，表示已连接到RabbitMQ。
            System.out.println("success to contact RabbitMQ\n");

        } catch (AmqpException ex) {

            System.out.println("failed to contact RabbitMQ:" + ex.getMessage() + "\n");
        }

    }

    public void send(Message msg) {
        try {
            // 构造要发送的数据对象
            Message messageData = new Message(msg.type, msg.sender, msg.content,msg.recipient,msg.filename);

            // 创建一个 ObjectMapper 来序列化数据为 JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(messageData);
            // 发送 JSON 数据到队列
            if(Objects.equals(msg.recipient, "All")){
                rabbitTemplate.convertAndSend("topic_exchange","ly.uu",jsonMessage);
            }
            if (Objects.equals(msg.type, "login")){
                rabbitTemplate.convertAndSend("topic_exchange","ly.uu",jsonMessage);
            }
            if (Objects.equals(msg.type, "message")||Objects.equals(msg.type, "file")||Objects.equals(msg.type, "upload_res")) {
                rabbitTemplate.convertAndSend("topic_exchange",messageData.recipient+".uu" , jsonMessage);
            }
            System.out.println("Sent: " + jsonMessage);

            if (msg.type.equals("message")&&(msg.sender.equals(ui.username) || msg.recipient.equals("All")||msg.recipient.equals(ui.username))) {
                String msgTime = (new Date()).toString();
                try {
                    hist.addMessage(msg, msgTime);
                    DefaultTableModel table = (DefaultTableModel) ui.historyFrame.jTable1.getModel();
                    table.addRow(new Object[]{msg.sender, msg.content, msg.recipient, msgTime});
                } catch (Exception ex) {
                }
            }
        } catch (AmqpException ex) {
            //jTextArea1.append("failed to send message:" + ex.getMessage() + "\n");
            System.out.println("Exception SocketClient send()");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void file(Message msg) {
        if (JOptionPane.showConfirmDialog(ui, ("Accept '" + msg.filename + "' from " + msg.sender + " ?")) == 0) {
            JFileChooser jf = new JFileChooser();
            jf.setSelectedFile(new File(msg.filename));
            int returnVal = jf.showSaveDialog(ui);

            String saveTo = jf.getSelectedFile().getPath();
            if (saveTo != null && returnVal == JFileChooser.APPROVE_OPTION) {
                Download dwn = new Download(saveTo, ui,msg.content);
                dwn.run();

                send(new Message("upload_res", ui.username, msg.filename, msg.sender,""));
            } else {
                send(new Message("upload_res", ui.username, "NO", msg.sender,""));
            }
        } else {
            send(new Message("upload_res", ui.username, "NO", msg.sender,""));
        }
    }
}
