package com.wang.p10_homework;

import java.io.*;

/**
 * @Author:wsz
 * @Date: 2023/2/11 21:29
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class Demo02HomeWork {
    public static void main(String[] args){
        //要求:使用BufferedReader读取一个文本文件，为每行加上行号,再连同内容一并输出到屏幕上。
        readFile();
    }

    public static void  readFile(){
        File file = new File("e:\\poem.txt");
        String line;
        int count = 1;
        try(InputStreamReader isr=new InputStreamReader(new FileInputStream(file),"gbk");BufferedReader br=new BufferedReader(isr)){
            while ((line=br.readLine())!=null){
                System.out.println(count+++"."+line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
