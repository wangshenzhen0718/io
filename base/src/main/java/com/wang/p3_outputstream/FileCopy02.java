package com.wang.p3_outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/4 19:00
 * @Description:文件拷贝（字节流读取写入综合）
 * @Version: 1.0
 * @Since: 1.0
 */
public class FileCopy02 {
    public static void main(String[] args){
        copyFile();
    }

    public static void copyFile(){
        String source = "e:\\hrm.jpg";
        String target = "e:\\hrm2.jpg";
        int readLength=0;
        byte[] buf=new byte[8];
        //使用try-with-resources语句自动关闭
        try(FileInputStream fileInputStream= new FileInputStream(source); FileOutputStream fileOutputStream = new FileOutputStream(target,true)){
            while ((readLength=fileInputStream.read(buf))!=-1){
                //流关闭之前操作的都是一个流对象，不会覆盖
                fileOutputStream.write(buf,0,readLength);
            }
            System.out.println("拷贝成功！！！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}