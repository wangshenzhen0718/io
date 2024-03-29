package com.wang.service;

import com.wang.common.Message;
import com.wang.common.MessageType;
import com.wang.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:wsz
 * @Date: 2023/3/11 21:06
 * @Description:这是服务器, 在监听9999，等待客户端的连接，并保持通信
 * @Version: 1.0
 * @Since: 1.0
 */
public class QQServer {
    //创建一个集合，存放多个用户，如果是这些用户登录，就认为是合法
    //这里我们也可以使用 ConcurrentHashMap, 可以处理并发的集合，没有线程安全
    //HashMap 没有处理线程安全，因此在多线程情况下是不安全
    //ConcurrentHashMap 处理的线程安全,即线程同步处理, 在多线程情况下是安全
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();

    //在静态代码块，初始化 validUsers
    static {

        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("菩提老祖", new User("菩提老祖", "123456"));

    }

    private ServerSocket ss = null;

    public QQServer() {
        try {
            System.out.println("服务端在9999端口监听...");
            ss = new ServerSocket(9999);
            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();
            //当和某个客户端连接后，会继续监听, 因此while
            while (true) {
                //如果没有客户端连接，就会阻塞在这里
                Socket socket = ss.accept();
                System.out.println("连接到了");
                //得到socket关联的对象输入流
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());

                //得到socket关联的对象输出流
                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());
                //读取客户端发送的User对象
                User u = (User) ois.readObject();
                //创建一个Message对象，准备回复客户端
                Message message = new Message();
                //登录通过
                if (checkUser(u.getUserId(), u.getPasswd())) {
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED.getCode());
                    //将message对象回复客户端
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信, 该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUserId());
                    //启动该线程
                    serverConnectClientThread.start();
                    //把该线程对象，放入到一个集合中，进行管理.
                    ManageClientThreads.addClientThread(u.getUserId(), serverConnectClientThread);

                } else {
                    System.out.println("用户 id=" + u.getUserId() + " pwd=" + u.getPasswd() + " 验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL.getCode());
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }


            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            //如果服务器退出了while，说明服务器端不在监听，因此关闭ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 验证用户是否有效的方法
     **/
    private boolean checkUser(String userId, String passwd) {
        User user = validUsers.get(userId);
        //过关的验证方式
        //说明userId没有存在validUsers 的key中
        if (user == null) {
            return false;
        }
        //userId正确，但是密码错误
        if (!user.getPasswd().equals(passwd)) {
            return false;
        }
        return true;
    }
}
