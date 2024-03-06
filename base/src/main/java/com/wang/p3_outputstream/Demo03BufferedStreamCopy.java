package com.wang.p3_outputstream;

import java.io.*;

/**
 * @Author:wsz
 * @Date: 2023/2/8 22:48
 * @Description:BufferedStreamCopy字节流拷贝文件
 */
public class Demo03BufferedStreamCopy {
    public static void main(String[] args) {
        String source = "e:\\hrm.jpg";
        String target = "e:\\wsz.jpg";
        int readLen;
        byte[] bytes = new byte[1024];
        // 使用装饰器模式 InputStream：抽象目标接口 FileInputStream：具体目标接口 FilterInputStream:抽象装饰角色   BufferedInputStream具体装饰角色
        // 目的就是增强具体目标接口   当调用具体装饰角色的方法时，会调用具体目标接口的同名方法 做增强
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(source)); BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target))) {
            while ((readLen = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, readLen);
            }
            System.out.println("拷贝成功！！！");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
