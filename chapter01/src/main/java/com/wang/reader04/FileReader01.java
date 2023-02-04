package com.wang.reader04;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/4 21:15
 * @Description:FileReader字符流读取数据
 * @Version: 1.0
 * @Since: 1.0
 */
public class FileReader01 {
    public static void main(String[] args){
        //readFile01();
        readFile02();
    }

    /**
     *字符数组读取文件
     * */
    public static void readFile02(){
        System.out.println("--------字符数组读取文件-----------");
        String filePath="e:\\story.txt";
        int readLen=0;
        char[] buf = new char[8];
        try(FileReader fileReader = new FileReader(filePath)){
            while ((readLen=fileReader.read(buf))!=-1){
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     *单个字符读取文件
     * */
    public static void readFile01(){

        String filePath="e:\\story.txt";
        int data=0;
        try(FileReader fileReader = new FileReader(filePath)){
            while ((data=fileReader.read())!=-1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
