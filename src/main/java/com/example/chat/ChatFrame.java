package com.example.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

@Component
public class ChatFrame extends JFrame {
    public int port;
    public String serverAddr;
    public String  username;
    public String password;

    public DefaultListModel model;

    public File file;
    public String historyFile = "E:/code/软件架构设计/上机/Chat/src/main/resources/History.xml";
    public HistoryFrame historyFrame;
    public History hist;

    @Resource
    public ConnectionFactory yourConnectionFactory;

    @Autowired
    public RabbitAdmin rabbitAdmin;



    public ChatFrame() {
        initComponents();
        this.setTitle("jMessenger");
        model.addElement("All");
        jList1.setSelectedIndex(0);

        jTextField6.setText(historyFile);
        jTextField6.setEditable(false);

        hist = new History(historyFile);

        historyFrame = new HistoryFrame(hist);
        historyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        historyFrame.setVisible(false);


        this.addWindowListener(new WindowListener() {

            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) {}
            //@Override public void windowClosing(WindowEvent e) { try{ client.send(new Message("message", username, ".bye", "SERVER")); clientThread.stop();  }catch(Exception ex){} }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
        //使窗体可视
        setVisible(true);

    }

    public boolean isWin32(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Host Address : ");

        jTextField1.setText("114.132.150.220");

        jLabel2.setText("Host Port : ");

        jTextField2.setText("5672");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setText("Anurag");
        jTextField3.setEnabled(true);

        jLabel3.setText("Password :");

        jLabel4.setText("Username :");

        jButton3.setText("SignUp");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPasswordField1.setText("password");
        jPasswordField1.setEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jList1.setModel((model = new DefaultListModel()));
        jScrollPane2.setViewportView(jList1);

        jLabel5.setText("Message : ");

        jButton4.setText("Send Message ");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Login");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("...");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Send");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton6ActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jLabel6.setText("File :");

        jLabel7.setText("History File :");

        jButton7.setText("...");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Show");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField3)
                                                                        .addComponent(jTextField1))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField2)
                                                                        .addComponent(jPasswordField1)))
                                                        .addComponent(jTextField6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jButton3)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton7)
                                        .addComponent(jButton8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton4)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //连接按钮
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        serverAddr = jTextField1.getText();
        port = Integer.parseInt(jTextField2.getText());

        if(!serverAddr.isEmpty() && !jTextField2.getText().isEmpty()){
            try{
                Processor processor =new Processor( this,yourConnectionFactory);
                //发送一个数据测试是否连接成功
                processor.send(new Message("test", "testUser", "testContent", "SERVER",""));
                jTextArea1.append("success to connect RabbitMQ\n");

                jButton1.setEnabled(false);
                jButton2.setEnabled(true);
                jButton3.setEnabled(true);
                jTextField3.setEnabled(true);
                jPasswordField1.setEnabled(true);
                jTextField1.setEditable(false);
                jTextField2.setEditable(false);
                jButton7.setEnabled(true);

            }
            catch(Exception ex){
                jTextArea1.append("Server not found\n");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //登录按钮
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        username = jTextField3.getText();
        password = jPasswordField1.getText();

        if (!username.isEmpty() && !password.isEmpty()) {
            Login login = new Login();
            boolean exit = login.checkLogin(username, password);
            if (exit) {
                // 创建用户队列
                Queue userQueue = new Queue("ly_" + username, true);

                // 使用 BindingBuilder 来创建一个 Binding
                Binding binding1 = BindingBuilder.bind(userQueue).to(new DirectExchange("topic_exchange"))
                        .with("ly.#");  // 公共消息
                Binding binding2 = BindingBuilder.bind(userQueue).to(new DirectExchange("topic_exchange"))
                        .with(username+".#");  //私人消息

                rabbitAdmin.declareQueue(userQueue);
                rabbitAdmin.declareBinding(binding1);
                rabbitAdmin.declareBinding(binding2);

                // 创建监听器并配置
                SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
                container.setConnectionFactory(yourConnectionFactory);
                container.setQueues(userQueue);
                container.setMessageListener(message -> {
                    String jsonMessage = new String(message.getBody());
                    // 处理消息的逻辑
                    if (jsonMessage != null && username != null) {
                        try {
                            ObjectMapper objectMapper = new ObjectMapper();
                            Message messagel = objectMapper.readValue(jsonMessage, Message.class);
                            if ("message".equals(messagel.type)&&(username.equals(messagel.recipient) || "All".equals(messagel.recipient))) {
                                System.out.println("Received message: " + messagel);
                                jTextArea1.append(messagel.sender + ": " + messagel.content + "\n");
                                if ((!messagel.sender.equals(username)&&messagel.recipient.equals("All"))||messagel.recipient.equals(username)) {
                                    String msgTime = (new Date()).toString();
                                    try {
                                        hist.addMessage(messagel, msgTime);
                                        DefaultTableModel table = (DefaultTableModel) historyFrame.jTable1.getModel();
                                        table.addRow(new Object[]{messagel.sender, messagel.content, messagel.recipient, msgTime});
                                    } catch (Exception ignored) {
                                    }
                                }
                            }
                            if ("login".equals(messagel.type)) {
                                System.out.println(messagel.sender + " login\n");
                                System.out.println("Received message: " + messagel);
                                boolean isSenderAdded = false; // 添加一个变量来跟踪是否已经添加了messagel.sender
                                if (!Objects.equals(messagel.sender, username)) {
                                    for (int i = 0; i < model.getSize(); i++) {
                                        String target5 = model.getElementAt(i).toString();
                                        System.out.println(target5);
                                        if (Objects.equals(target5, messagel.sender)) {
                                            isSenderAdded = true;
                                            break; // 如果messagel.sender已经存在于model中，跳出循环
                                        }
                                    }
                                    if (!isSenderAdded) {
                                        model.addElement(messagel.sender); // 只有当messagel.sender不存在于model中时才添加
                                    }
                                }
                            }

                            if("file".equals((messagel.type))){
                                Processor processor =new Processor(this,yourConnectionFactory);
                                processor.file(messagel);
                                if ((!messagel.sender.equals(username)&&messagel.recipient.equals("All"))||messagel.recipient.equals(username)) {
                                    String msgTime = (new Date()).toString();
                                    try {
                                        hist.addMessage(messagel, msgTime);
                                        DefaultTableModel table = (DefaultTableModel) historyFrame.jTable1.getModel();
                                        table.addRow(new Object[]{messagel.sender, messagel.filename, messagel.recipient, msgTime});
                                    } catch (Exception ignored) {
                                    }
                                }
                            }
                            if("upload_res".equals(messagel.type)&&username.equals(messagel.recipient)){
                                if (!messagel.content.equals("NO")) {
                                    jButton5.setEnabled(false);
                                    jButton6.setEnabled(false);
                                } else {
                                    jTextArea1.append( messagel.sender + ": rejected file request\n");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("JSON message is null or user not logged in");
                    }
                });
                container.start();

                jTextArea1.append(username + " login successfully\n");
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                jButton4.setEnabled(true);
                jButton5.setEnabled(true);
                jButton8.setEnabled(true);
                jTextField3.setEnabled(false);
                jPasswordField1.setEnabled(false);
                model.addElement(username);
                Processor processor = new Processor(this, yourConnectionFactory);
                processor.send(new Message("login", this.username, "", "",""));
            } else {
                jTextArea1.append("Login failed\n");
            }
        }
    }



    //发送消息按钮
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String content = jTextField4.getText();
        String target = jList1.getSelectedValue().toString();

        if(!content.isEmpty() && !target.isEmpty()){
            jTextField4.setText("");
            Processor processor =new Processor(this,yourConnectionFactory);
            Message message = new Message("message", username, content, target,"");
            processor.send(message);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    //注册按钮
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        username = jTextField3.getText();
        password = jPasswordField1.getText();

        if(!username.isEmpty() && !password.isEmpty()){
            Login login = new Login();
            boolean exit = login.userExists(username);
            if(exit){
                JOptionPane.showMessageDialog(this, "User exists");
                return;
            }
            Signup signup = new Signup();
            boolean a = signup.registerUser(username,password);
            if(a){
                JOptionPane.showMessageDialog(this, "Sign up successfully,Please login");
            }
            else{
                JOptionPane.showMessageDialog(this, "Sign up failed");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Username and password can`t be null");
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    //选择发送文件按钮
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(this, "Select File");
        file = fileChooser.getSelectedFile();

        if(file != null){
            if(!file.getName().isEmpty()){
                jButton6.setEnabled(true); String str;

                if(jTextField5.getText().length() > 30){
                    String t = file.getPath();
                    str = t.substring(0, 20) + " [...] " + t.substring(t.length() - 20, t.length());
                }
                else{
                    str = file.getPath();
                }
                jTextField5.setText(str);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    public static byte[] readFileToBinary(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fileInputStream.read(data);
        fileInputStream.close();
        return data;
    }
    //发送文件按钮
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButton6ActionPerformed
        String target = jList1.getSelectedValue().toString();
        long size = file.length();
        if(size < 120 * 1024 * 1024){
            byte[] binaryData = readFileToBinary(file);
            String filedata = Base64.getEncoder().encodeToString(binaryData);
            Processor processor =new Processor(this,yourConnectionFactory);
            Message message = new Message("file", username, filedata , target,file.getName());
            processor.send(message);
        }
        else{
            jTextArea1.append("File is size too large\n");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    //历史记录选择文件
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.showDialog(this, "Select File");

        if(!jf.getSelectedFile().getPath().isEmpty()){
            historyFile = jf.getSelectedFile().getPath();
            if(this.isWin32()){
                historyFile = historyFile.replace("/", "\\");
            }
            jTextField6.setText(historyFile);
            jTextField6.setEditable(false);
            jButton7.setEnabled(false);
            jButton8.setEnabled(true);
            hist = new History(historyFile);

            historyFrame = new HistoryFrame(hist);
            historyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            historyFrame.setVisible(false);
        }
    }//GEN-LAST:event_jButton7ActionPerformed


    //历史记录显示
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        historyFrame.setLocation(this.getLocation());
        historyFrame.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JList jList1;
    public javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;;
    // End of variables declaration//GEN-END:variables
}
