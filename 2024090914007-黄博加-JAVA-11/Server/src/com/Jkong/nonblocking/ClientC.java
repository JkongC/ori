package com.Jkong.nonblocking;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class ClientC implements Runnable {

    private static ClientC Collector;
    private static Selector selector;
    private static final ByteBuffer buffer = ByteBuffer.allocate(1024);

    private ClientC() throws IOException {
        selector = Selector.open();
    }

    public static ClientC getInstance() throws IOException {
        if (Collector == null) {
            Collector = new ClientC();
        }

        return Collector;
    }

    public static void registerNew(SocketChannel channel) throws IOException {
        channel.register(selector, SelectionKey.OP_READ);
    }

    @Override
    public void run() {
        try {
            while (true) {

                if (selector.selectNow() > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();

                    while (iterator.hasNext()) {
                        SelectionKey tempkey = iterator.next();
                        if (tempkey.isReadable()) {
                            handleRead(tempkey);
                            iterator.remove();
                        }
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

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel rchannel = (SocketChannel) key.channel();
        buffer.clear();
        rchannel.read(buffer);
        buffer.flip();

        CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer);
        System.out.println("收到服务器提供的时间："+charBuffer);
        System.out.println("你要发送：（输入Esc退出）");
    }
}
