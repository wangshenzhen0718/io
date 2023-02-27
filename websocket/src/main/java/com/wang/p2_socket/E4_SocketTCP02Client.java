package com.wang.p2_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author:wsz
 * @Date: 2023/2/27 21:20
 * @Description:客户端，发送 "hello, server" 给服务端
 * @Version: 1.0
 * @Since: 1.0
 */
public class E4_SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999端口, 如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //   得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello server".getBytes());
        //设置结束标记,写完表示输出结束
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        //4. IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));//根据读取到的实际长度，显示内容.
        }

        //5. 关闭流对象和socket, 必须关闭
        outputStream.close();
        socket.close();
        inputStream.close();
        System.out.println("客户端退出.....");

    }
}
