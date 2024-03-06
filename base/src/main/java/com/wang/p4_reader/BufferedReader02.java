package com.wang.p4_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/6 22:19
 * @Description: BufferedReader使用
 * @Version: 1.0
 * @Since: 1.0
 */
public class BufferedReader02 {
    public static void main(String[] args){
        String path="e:\\story.txt";
        String line;
        // 关闭处理流BufferedReader会自动关闭节点流FileReader
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
