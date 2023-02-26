package com.wang.p1_api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author:wsz
 * @Date: 2023/2/26 21:00
 * @Description:InetAddress的使用
 * @Version: 1.0
 * @Since: 1.0
 */
public class E1_API {
    public static void main(String[] args) throws UnknownHostException {
        //1.获取本机InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("本机："+localHost);
        //2.获取指定主机名获取InetAddress对象
        InetAddress byName = InetAddress.getByName("DESKTOP-G9D06G3");
        System.out.println("获取指定主机名获取InetAddress对象:"+byName);
        //3.根据域名获取InetAddress对象
        InetAddress byDomain = InetAddress.getByName("www.baidu.com");
        System.out.println("根据域名获取InetAddress对象:"+byDomain);
        //4.根据InetAddress对象获取对应地址
        String hostAddress = byDomain.getHostAddress();
        System.out.println("ip地址："+hostAddress);
        //5.根据InetAddress对象获取对应域名
        String hostName = byDomain.getHostName();
        System.out.println("域名："+hostName);
    }
}
