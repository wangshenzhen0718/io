package com.wang.p2_socket;

import java.io.IOException;
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
public class E2_SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999端口, 如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //3.得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());
        //4. 关闭流对象和socket, 必须关闭
        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");

    }
}
