package com.Jkong.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerC {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(80);
            System.out.println("服务器启动了");
            System.out.println("等待连接...");
            Socket s = ss.accept();
            System.out.println("已连接上");

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            String message = reader.readLine();

            System.out.println("客户端消息：" + message);

            writer.write("服务器接收到你的消息了！\n");
            writer.flush();

            s.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
