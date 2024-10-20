package com.Jkong.nonblocking;

import java.io.IOException;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class SimpleServerC implements Runnable {

    //这里的写法是有点想往单例模式靠
    private static SimpleServerC instance;
    private static Selector selector;

    private SimpleServerC() throws IOException {
        selector = Selector.open();
    }

    public static SimpleServerC getInstance() throws IOException {
        if (instance == null) {
            instance = new SimpleServerC();
        }

        return instance;
    }

    public static void registerNew(SocketChannel channel) throws IOException {
        channel.register(selector, SelectionKey.OP_READ);
    }

    @Override
    public void run() {
        try {
            while(true){

                //此处如果用的是select方法，就一直堵塞，没办法选择出来
                if (selector.selectNow() > 0){
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();

                    while(iterator.hasNext()){
                        SelectionKey tempkey = iterator.next();
                        if (tempkey.isReadable()){
                            try {
                                handleRead(tempkey);
                                iterator.remove();
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                                /*
                                把对应的注册取消，不然下次还能select到它，
                                还会导致断连信息刷屏
                                */
                                tempkey.cancel();
                            }
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleRead(SelectionKey key) throws IOException {
        try {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();
            channel.read(buffer);
            buffer.flip();

            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer);
            System.out.println("收到"+channel.getRemoteAddress()+"发来的："+charBuffer);
        } catch (IOException e) {
            if (e.getMessage().equals("Connection reset")) {
                //通过这个方式将断连ip传上去
                throw new IOException(((SocketChannel) key.channel()).getRemoteAddress().toString() + "断开连接");
            } else {
                e.printStackTrace();
            }
        }
    }
}
