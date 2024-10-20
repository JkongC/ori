package com.Jkong.nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ClientS {
    private static ByteBuffer buffer;
    private static SocketChannel channel = null;
    public static Thread CollectorThread;

    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            channel = SocketChannel.open(new InetSocketAddress(8888));
            channel.configureBlocking(false);
            Scanner sc = new Scanner(System.in);

            CollectorThread = new Thread(ClientC.getInstance(),"CollectorThread");
            CollectorThread.setDaemon(true);
            CollectorThread.start();

            if (channel.isConnected()) {
                System.out.println("已连接上");
                channel.register(selector,SelectionKey.OP_WRITE);
                ClientC.registerNew(channel);
            }

            while (true) {
                System.out.println("你要发送：（输入Esc退出）");
                String message = sc.nextLine();

                if (message.equals("Esc")) {
                    break;
                }

                selector.select();

                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey tempkey = iterator.next();
                    if (tempkey.isWritable()) {
                        handleSend(message);
                        iterator.remove();
                        break;
                    }
                }

            }

        } catch (IOException e) {
            if (e.getMessage().equals("Connection reset")) {
                System.out.println("连接断开，将退出");
            } else {
                System.out.println("出错了，错误信息：");
                e.printStackTrace();
            }
        }
    }

    public static void handleSend(String msg) throws IOException {
        buffer = StandardCharsets.UTF_8.encode(msg);
        channel.write(buffer);
        System.out.println("已发送");
        buffer.clear();
    }
}
