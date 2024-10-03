package com.Jkong.netrepeat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerCR {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(80);
            System.out.println("服务器启动了");
            System.out.println("等待连接...");
            Socket s = ss.accept();
            System.out.println("已连接上");

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            while (true) {
                String message = reader.readLine();

                if (message.equals("exit")) {
                    break;
                }

                System.out.println("客户端消息：" + message);

                writer.write("服务器接收到你的消息了：" + message + "\n");
                writer.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
