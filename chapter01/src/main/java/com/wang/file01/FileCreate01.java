package com.wang.file01;

import java.io.File;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/1/31 22:11
 * @Description: 创建文件
 * @Version: 1.0
 * @Since: 1.0
 */
public class FileCreate01 {
    public static void main(String[] args){
        //createFile01();
        //createFile02();
        createFile03();
    }

    /*创建文件：方法一*/
    public static void createFile01(){
        String filepath="e:\\news1.txt";
        File file=new File(filepath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功！！！");
        } catch (IOException e) {
            System.out.println("文件创建失败！！！");
            throw new RuntimeException(e);
        }
    }

    /*创建文件：方法二*/
    public static void createFile02(){
        //创建父类文件
        File parentFile=new File("e:\\");
        String fileName="news2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功！！！");
        } catch (IOException e) {
            System.out.println("文件创建失败！！！");
            throw new RuntimeException(e);
        }
    }

    /*创建文件：方法三*/
    public static void createFile03(){
        //创建父类路径
        String parentPath="e:\\";
        String fileName="news3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功！！！");
        } catch (IOException e) {
            System.out.println("文件创建失败！！！");
            throw new RuntimeException(e);
        }
    }
}
