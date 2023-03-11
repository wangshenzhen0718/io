package com.wang.client.service;

import java.net.Socket;

public class ClientConnectServerThread extends Thread{
    //该线程需要持有Socket
    private Socket socket;

    //构造器可以接受一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {

        //因为Thread需要在后台和服务器通信，因此我们while循环
        while (true) {

        }

    }
}
