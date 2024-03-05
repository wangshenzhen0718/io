package com.wang.p1_file;

import java.io.File;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/1/31 22:11
 * @Description: 创建文件的三种方式
 */
public class Demo01FileCreate {
    public static void main(String[] args) {
        createFile01();
        createFile02();
        createFile03();
    }

    /**
     * 创建文件：方法一
     */
    public static void createFile01() {
        String filepath = "d:\\news1.txt";
        File file = new File(filepath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功！！！");
        } catch (IOException e) {
            System.out.println("文件创建失败！！！");
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建文件：方法二
     */
    public static void createFile03() {
        //创建父类路径
        String parentPath = "d:\\";
        String fileName = "news2.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功！！！");
        } catch (IOException e) {
            System.out.println("文件创建失败！！！");
            throw new RuntimeException(e);
        }
    }


    /**
     * 创建文件：方法三
     */
    public static void createFile02() {
        //创建父类文件
        File parentFile = new File("d:\\");
        String fileName = "news3.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功！！！");
        } catch (IOException e) {
            System.out.println("文件创建失败！！！");
            throw new RuntimeException(e);
        }
    }

}
