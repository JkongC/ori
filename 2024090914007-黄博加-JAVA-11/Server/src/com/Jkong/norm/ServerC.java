package com.Jkong.norm;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;


public class ServerC implements Runnable {

    private SocketChannel channel;

    public ServerC(SocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            try {
                channel.read(buffer);
                buffer.flip();

                CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer);
                System.out.println("收到"+channel.getRemoteAddress()+"发来的："+ charBuffer);
                System.out.println("你要发送：");

                buffer.clear();
            } catch (IOException e) {
                System.out.println("连接断开。");
                return;
            }
        }
    }
}
