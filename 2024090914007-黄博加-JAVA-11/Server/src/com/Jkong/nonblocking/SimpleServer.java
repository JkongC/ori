package com.Jkong.nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SimpleServer {

    private static Selector selector;
    private static Selector selectorA;
    private static ServerSocketChannel serverSocketChannel;
    private static Thread Sender;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8888));
            serverSocketChannel.configureBlocking(false);

            //两个Selector确实有点多此一举，不过写都写了（
            selector = Selector.open();
            selectorA = Selector.open();

            Sender = new Thread(SimpleServerC.getInstance(), "SenderThread");
            Sender.setDaemon(true);
            Sender.start();

            serverSocketChannel.register(selectorA, SelectionKey.OP_ACCEPT);
            System.out.println("服务器已启动");

            //创建一个Timer，每10秒向所有channel发送时间
            //Timer其实也是个独立线程
            Timer timer = new Timer(true);
            timer.schedule(new TimerTask() {
                               public void run() {
                                   try {
                                       if (selector.selectNow() > 0) {
                                           Set<SelectionKey> keysT = selector.selectedKeys();
                                           Iterator<SelectionKey> iteratorT = keysT.iterator();

                                           while (iteratorT.hasNext()) {
                                               SelectionKey tempkey = iteratorT.next();
                                               if (tempkey.isWritable()) {
                                                   tellTime(tempkey);
                                                   iteratorT.remove();
                                               }
                                           }
                                       }
                                   } catch (IOException ignored) {}
                               }
                           }
                    , 0, 10000);

            //处理连接
            while (true) {
                selectorA.select();

                Set<SelectionKey> keys = selectorA.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey tempkey = iterator.next();
                    if (tempkey.isAcceptable()) {
                        handleAccept(tempkey);
                        iterator.remove();
                    }
                }
            }

        } catch (SocketException e) {
            System.out.println("连接已关闭");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //处理连接请求
    public static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel achannel = (ServerSocketChannel) key.channel();
        SocketChannel channel = achannel.accept();

        if (channel.isConnected()) {
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_WRITE);//关注写就绪
            SimpleServerC.registerNew(channel);//让另一个线程关注读就绪
            System.out.println("客户端" + channel.getRemoteAddress() + "已连接");
        }
    }

    //发送时间
    public static void tellTime(SelectionKey key) throws IOException {
        Calendar calendar = Calendar.getInstance();
        ByteBuffer buffer = ByteBuffer.wrap(calendar.getTime().toString().getBytes(StandardCharsets.UTF_8));
        SocketChannel schannel = (SocketChannel) key.channel();
        schannel.write(buffer);
    }
}