package com.wang.transformation07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/11 12:17
 * @Description: 乱码引出转换流
 * @Version: 1.0
 * @Since: 1.0
 */
public class CodeQuestion01 {
    public static void main(String[] args){
        String path="e:\\a.txt";
        String line;
        //读取e:\\a.txt文件到程序
        //思路
        //1。创建字符输入流 BufferedReader[处理流]
        //2．使用 BufferedReader 对象读取a.txt
        //3．默认情况下，读取文件是按照utf-8编码,读取其他编码会乱码
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

}
