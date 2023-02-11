package com.wang.transformation07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:wsz
 * @Date: 2023/2/11 12:46
 * @Description:演示使用InputStreamReader 转换流解决中文乱码问题
 * 将字节流FileInputStream转成字符流、InputStreamReader，指定编码gbk/utf-8
 * @Version: 1.0
 * @Since: 1.0
 */
public class InputStreamReader02 {
    public static void main(String[] args){

        String path = "e:\\a.txt";
        try(InputStreamReader isr=new InputStreamReader(new FileInputStream(path),"gbk");BufferedReader br=new BufferedReader(isr)){
            String s = br.readLine();
            System.out.println(s);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
