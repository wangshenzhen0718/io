package com.wang.p4_reader;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/4 21:15
 * @Description:FileReader字符流读取数据
 */
public class Demo01FileReader {
    public static void main(String[] args) {
        //readFile01();
        readFile02();
    }

    /**
     * 单个字符读取文件
     */
    public static void readFile01() {

        String filePath = "e:\\story.txt";
        int data = 0;
        try (FileReader fileReader = new FileReader(filePath)) {
            //读取一个字符的数据，并将字符的值作为int类型返回( 0 - 65535 之间的一个值，即Unicode值)。如果未读出字符则返回- 1 （返回值为- 1 表示读取结束）。
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 字符数组读取文件
     */
    public static void readFile02() {
        System.out.println("--------字符数组读取文件-----------");
        String filePath = "e:\\story.txt";
        int readLen;
        char[] buf = new char[8];
        try (FileReader fileReader = new FileReader(filePath)) {
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
