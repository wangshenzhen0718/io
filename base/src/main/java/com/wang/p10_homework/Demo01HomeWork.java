package com.wang.p10_homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/11 20:44
 * @Description:
 */
public class Demo01HomeWork {
    public static void main(String[] args){
        /*(1)在判断e盘下是否有文件夹mytemp ,如果没有就创建mytemp
        (2)在e:\\mytemp目录下,创建文件hello.txt
        (3)如果hello.txt已经存在，提示该文件已经存在，就不要再重复创建了
        (4)写入chatgpt 新中国
        */
        createDirectory();
        createFile();
        writeFile();


    }

    public static void  createDirectory(){
        File file = new File("e:\\mytemp");
        if (file.exists()){
            System.out.println("文件夹已存在！");
        }else {
            if (file.mkdir()){
                System.out.println("文件创建成功！");
            }else {
                System.out.println("文件创建失败！");
            }

        }
    }

    public static void  createFile() {
        File file = new File("e:\\mytemp\\hello.txt");
        if (file.exists()){
            System.out.println("文件已存在！");
        }else {
            try {
                if (file.createNewFile()){
                    System.out.println("文件创建成功！");
                }else {
                    System.out.println("文件创建失败！");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void  writeFile() {
        File file = new File("e:\\mytemp\\hello.txt");

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));){
            bufferedWriter.write("chatgpt 新中国");

        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
