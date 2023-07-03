package com.wang.client.service;

import com.wang.common.Message;
import com.wang.common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class MessageClientService {

    /**
     * @param content  内容
     * @param senderId 发送用户id
     * @param getterId 接收用户id
     */
    public void sendMessageToOne(String content, String senderId, String getterId) {
        //构建message
        Message message = new Message();
        //普通的聊天消息这种类型
        message.setMesType(MessageType.MESSAGE_COMM_MES.getCode());
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        //发送时间设置到message对象
        message.setSendTime(new Date().toString());
        System.out.println(senderId + " 对 " + getterId + " 说 " + content);
        //发送给服务端

        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessageToAll(String content, String senderId) {
        //构建message
        Message message = new Message();
        //群发消息这种类型
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES.getCode());
        message.setSender(senderId);
        message.setContent(content);
        //发送时间设置到message对象
        message.setSendTime(new Date().toString());
        System.out.println(senderId + " 对大家说 " + content);
        //发送给服务端

        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
