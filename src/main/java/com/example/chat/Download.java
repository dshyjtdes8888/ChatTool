package com.example.chat;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

public class Download implements Runnable{

    public String saveTo = "";
    public ChatFrame ui;

    public String fileContent;

    public Download(String saveTo, ChatFrame ui,String fileContent){
        this.saveTo = saveTo;
        this.ui = ui;
        this.fileContent = fileContent;
    }

    public void run() {
        try {
            // 使用Base64解码将文件内容还原为二进制数据
            byte[] binaryData = Base64.getDecoder().decode(fileContent);
            // 将文件内容写入选择位置的同名文件
            OutputStream os = new FileOutputStream(saveTo);
            os.write(binaryData);
            os.close();

            ui.jTextArea1.append("[Application > Me] : Download complete\n");

        }
        catch (Exception ex) {
            System.out.println("Exception [Download : run(...)]");
        }
    }
}