package com.Jkong.netrepeat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class NetR {
    public static void main(String[] args) {
        try {
            Socket s = new Socket(InetAddress.getLocalHost(),80);
            Scanner sc = new Scanner(System.in);

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            writer.write("服务器你好！\n");
            writer.flush();

            System.out.println("发送给了服务器消息");

            while (true) {
                System.out.println("服务器回答：" + reader.readLine());

                System.out.println("发送消息：");

                String toSend = sc.nextLine();

                writer.write(toSend + "\n");
                writer.flush();

                if (toSend.equals("exit")) {
                    break;
                }
            }


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
