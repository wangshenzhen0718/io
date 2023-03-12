package com.wang.p3_outputstream;

import java.io.*;

/**
 * @Author:wsz
 * @Date: 2023/2/8 22:48
 * @Description:BufferedStreamCopy字节流拷贝文件
 * @Version: 1.0
 * @Since: 1.0
 */
public class BufferedStreamCopy03 {
    public static void main(String[] args){
      String source = "e:\\hrm.jpg";
      String target = "e:\\wsz.jpg";
      int readLen=0;
        byte[] bytes = new byte[1024];
        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(source));BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target));){
            while ((readLen=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,readLen);
            }
            System.out.println("拷贝成功！！！");
        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
