package com.wang.transformation07;

import java.io.*;

/**
 * @Author:wsz
 * @Date: 2023/2/11 12:46
 * @Description:演示使用OutputStreamWriter 转换流解决中文乱码问题
 * 将字节流FileOutputStream转成字符流、OutputStreamWriter，指定编码gbk/utf-8
 * @Version: 1.0
 * @Since: 1.0
 */
public class OutputStreamWriter03 {
    public static void main(String[] args){

        String path = "e:\\wsz.txt";
        try(OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(path),"gbk"); BufferedWriter bw=new BufferedWriter(osw);){
            bw.write("哈哈哈哈111");
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
