package com.wang.service;

import java.net.Socket;

/**
 * @Author:wsz
 * @Date: 2023/3/11 21:01
 * @Description:该类的一个对象和某个客户端保持通信
 * @Version: 1.0
 * @Since: 1.0
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId;//连接到服务端的用户id
    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }
    public Socket getSocket() {
        return socket;

    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + " 保持通信，读取数据...");
            }
            catch (Exception e) {
                e.printStackTrace();
        }


        }
    }
}
