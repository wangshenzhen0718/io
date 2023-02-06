package com.wang.inputstream02;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/4 16:53
 * @Description: 演示FileInputStream的使用
 * @Version: 1.0
 * @Since: 1.0
 */
public class FileInputStream01 {
    public static void main(String[] args){
        //readFile01();
        readFile02();

    }

    /**
     *FileInputStream读取文件的第一种方法，单个字节读取效率较低
     */
    public static void readFile01(){
        String path = "e:\\hello.txt";
        int read=0;
        //使用try-with-resources语句自动关闭
        try(FileInputStream fileInputStream= new FileInputStream(path)) {
            //如果读取正常，返回实际读取的字节数
            //如果返回-1，表示读取完毕
            while ((read= fileInputStream.read())!=-1){
                System.out.println((char) read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *FileInputStream读取文件的第二种方法，读取到数组，效率较高
     */
    public static void readFile02(){
        String path = "e:\\hello.txt";
        //读取到的字符串长度
        int readLen=0;
        byte[] buf=new byte[8];
        //使用try-with-resources语句自动关闭
        try(FileInputStream fileInputStream= new FileInputStream(path)) {
            //从该输入流读取最多len字节的数据为字节数组。 如果len不为零，该方法将阻塞，直到某些输入可用; 否则，不会读取字节，并返回0 。
            //每次读取一个字符，一个中文3个字节，读取会乱码
            while ((readLen=fileInputStream.read(buf))!=-1){
                //每次读取一个字符，一个中文3个字节，读取会乱码
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
