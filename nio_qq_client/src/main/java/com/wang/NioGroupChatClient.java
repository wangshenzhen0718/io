package com.wang;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author:wsz
 * @Date: 2023/7/8 17:25
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class NioGroupChatClient {
    private final String HOST ="127.0.0.1";
    private final int PORT =9999;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

  public NioGroupChatClient() {
    try {
      selector = Selector.open();
      socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
      socketChannel.configureBlocking(false);
      socketChannel.register(selector, SelectionKey.OP_READ);
      username = socketChannel.getLocalAddress().toString().substring(1);
      System.out.println(username + "  is ok!!!");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args){
      NioGroupChatClient client = new NioGroupChatClient();
      Scanner scanner = new Scanner(System.in);

      new Thread(new Runnable() {
          @Override
          public void run() {
              client.readInfo();


          }
      } ).start();
      while (scanner.hasNextLine()) {
          String info = scanner.nextLine();
          client.sendInfo(info);
      }

  }

  public void sendInfo(String info){
      info=username+" ：说 "+info;
      try {
          socketChannel.write(ByteBuffer.wrap(info.getBytes()));
      } catch (IOException e) {
          throw new RuntimeException(e);
      }

  }

    public void readInfo() {
        try {
            int readChannels = selector.select();
            if (readChannels>0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();

                    if (key.isReadable()){
                        SocketChannel channel = (SocketChannel)key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        String message = new String(buffer.array());
                        System.out.println(message.trim());

                    }else {
                        System.out.println("没有可以用的通道！！！");
                    }
                    iterator.remove();

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
