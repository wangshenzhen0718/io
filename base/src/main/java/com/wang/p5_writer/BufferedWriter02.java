package com.wang.p5_writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/7 21:23
 * @Description:BufferedWriter使用
 * @Version: 1.0
 * @Since: 1.0
 */
public class BufferedWriter02 {
    public static void main(String[] args){
      String path="e:\\a.txt";
        //new FileWriter(path,true)表示以覆盖的方式追加
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path,true))){
            //多次写入到缓存中，只要没有关闭都是一次！
            bufferedWriter.write("这是第一行");
            bufferedWriter.newLine();
            bufferedWriter.write("这是第二行");
            bufferedWriter.newLine();
            bufferedWriter.write("这是第三行");
            bufferedWriter.newLine();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
