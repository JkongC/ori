package com.Jkong.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Net {
    public static void main(String[] args) {
        try {
            Socket s = new Socket(InetAddress.getLocalHost(),80);

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            writer.write("服务器你好！\n");
            writer.flush();

            System.out.println("发送给了服务器消息");

            String message = reader.readLine();

            System.out.println("服务器返回了：" + message);


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
