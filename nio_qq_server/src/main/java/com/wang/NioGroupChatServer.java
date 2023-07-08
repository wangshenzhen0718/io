package com.wang;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author:wsz
 * @Date: 2023/7/8 16:59
 * @Description:NIO服务端
 * @Version: 1.0
 * @Since: 1.0
 */
public class NioGroupChatServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    public NioGroupChatServer(){
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

  public static void main(String[] args) {
    new NioGroupChatServer().listen();
  }

  public void listen() {
    System.out.println("监听线程: " + Thread.currentThread().getName());
    try {
      while (true) {
        int count = selector.select();
        if (count > 0) {
          Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
          while (iterator.hasNext()) {
            SelectionKey key = iterator.next();

            if (key.isAcceptable()) {
              SocketChannel socketChannel = serverSocketChannel.accept();
              socketChannel.configureBlocking(false);
              socketChannel.register(selector, SelectionKey.OP_READ);
              System.out.println(socketChannel.getRemoteAddress() + "   上线！！！");
            }

            if (key.isReadable()){
                readData(key);
            }

            iterator.remove();
          }
        }else {
          System.out.println("等待..........");
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

    private void readData(SelectionKey key) {
        try{
            SocketChannel channel = (SocketChannel)key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            if (count>0){
                String message = new String(buffer.array());
                System.out.println("from 客户端  " + message);

                sendInfoToOtherClients(message,channel);
            }
        }catch (Exception e){
            e.printStackTrace();;
        }

    }

    private void sendInfoToOtherClients(String msg, SocketChannel self ) throws IOException {
        System.out.println("服务器转发消息中...");
        System.out.println("服务器转发数据给客户端线程: " + Thread.currentThread().getName());

        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            SelectableChannel targetChannel = key.channel();

            if(targetChannel instanceof  SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel) targetChannel;
                ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
                dest.write(wrap);
            }
        }


    }
}

