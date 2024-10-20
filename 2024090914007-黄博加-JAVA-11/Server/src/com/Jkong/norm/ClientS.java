package com.Jkong.norm;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientS {
    private static ByteBuffer buffer;
    private static SocketChannel channel = null;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try {
            String message;

            channel = SocketChannel.open(new InetSocketAddress(8888));
            if (channel.isConnected()) {
                System.out.println("连接就绪。");
                buffer = ByteBuffer.allocate(1024);

                ClientC sender = new ClientC(channel);
                Thread SenderThread = new Thread(sender);
                SenderThread.setName("SenderThreadC");
                SenderThread.start();

                while (true) {
                    System.out.println("你要发送什么信息？输入\"Esc\"将自动退出");
                    message = sc.nextLine();
                    if (message.equals("Esc")) {
                        break;
                    } else {
                        sendmsg(message);
                    }
                }
            } else {
                System.out.println("连接出现问题！");
            }
        } catch (ConnectException e) {
            System.out.println("连接断开。");
        } finally {
            buffer = null;
            channel.close();
            System.out.println("客户端关闭");
        }
    }

    public static void sendmsg(String msg) throws IOException {
        buffer = StandardCharsets.UTF_8.encode(msg);
        channel.write(buffer);
        System.out.println("已发送");
        buffer.clear();
    }
}
