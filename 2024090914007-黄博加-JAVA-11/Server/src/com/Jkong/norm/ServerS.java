package com.Jkong.norm;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ServerS {

    private static ByteBuffer buffer;
    private static SocketChannel channel = null;
    private static final Scanner sc = new Scanner(System.in);

    private ServerS(){}

    public static void main(String[] args) {
        try {
            new ServerS().go();
        } catch (Exception e){
            System.out.println("服务器出错了，无法运行");
            e.printStackTrace();
        }
    }

    public void go() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        System.out.println("服务器正在启动......");
        ssc.bind(new InetSocketAddress(8888));

        while (true){
            try {
                System.out.println("等待连接");
                channel = ssc.accept();

                System.out.println("用户端"+channel.getRemoteAddress()+"已连接");
                buffer = ByteBuffer.allocate(1024);
                ServerC sender = new ServerC(channel);
                Thread SenderThread = new Thread(sender);
                SenderThread.setName("SenderThreadS");
                SenderThread.start();

                while (true) {

                    buffer.clear();

                    System.out.println("你要发送：");
                    sendmsg(sc.nextLine());

                }
            } catch (IOException e) {
                System.out.println("连接断开。");
            }
        }
    }

    public static void sendmsg(String msg) throws IOException {
        buffer = StandardCharsets.UTF_8.encode(msg);
        channel.write(buffer);
        System.out.println("已发送");
        buffer.clear();
    }

}
