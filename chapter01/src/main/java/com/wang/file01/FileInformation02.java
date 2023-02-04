package com.wang.file01;

import java.io.File;

/**
 * @Author:wsz
 * @Date: 2023/2/1 21:27
 * @Description:获取文件信息
 * @Version: 1.0
 * @Since: 1.0
 */
public class FileInformation02 {
    public static void main(String[] args){
        info();
    }

    public static void info(){
        File file = new File("e:\\news1.txt");
        System.out.println("文件名字:"+file.getName());
        System.out.println("文件绝对路径:"+file.getAbsolutePath());
        System.out.println("文件父级目录:"+file.getParent());
        System.out.println("文件大小:"+file.length());
        System.out.println("文件是否存在:"+file.exists());
        System.out.println("文件是否是文件:"+file.isFile());
        System.out.println("文件是否是目录:"+file.isDirectory());
    }
}
