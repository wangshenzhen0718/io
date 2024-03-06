package com.wang.p2_inputstream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/4 16:53
 * @Description: 演示FileInputStream的使用
 */
public class Demo01FileInputStream {
    public static void main(String[] args) {
        //readFile01();
        readFile02();

    }

    /**
     * FileInputStream读取文件的第一种方法，单个字节读取效率较低
     */
    public static void readFile01() {
        String path = "e:\\hello.txt";
        int read;
        //使用try-with-resources语句自动关闭
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            //读取一个字节的数据，并将字节的值作为int类型返回( 0 - 255 之间的一个值)。如果未读出字节则返回- 1 （返回值为- 1 表示读取结束）。
            //如果返回-1，表示读取完毕
            while ((read = fileInputStream.read()) != -1) {
                System.out.println((char) read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * FileInputStream读取文件的第二种方法，读取到数组，效率较高
     */
    public static void readFile02() {
        String path = "e:\\hello.txt";
        // 缓冲区
        byte[] buf = new byte[8];

        // readLen为每次读取到缓冲区的长度 读取完毕为-1
        int readLen;
        //使用try-with-resources语句自动关闭
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            //从该输入流读取最多readLen字节的数据为字节数组。 如果readLen不为零，该方法将阻塞，直到某些输入可用; 否则，不会读取字节，并返回0 。
            //每次读取一个字符，一个中文3个字节，读取会乱码
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.println("本次读取到：" + readLen);
                //每次读取一个字符，一个中文3个字节，读取会乱码
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
