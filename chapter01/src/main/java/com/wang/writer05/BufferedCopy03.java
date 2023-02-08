package com.wang.writer05;

import java.io.*;

/**
 * @Author:wsz
 * @Date: 2023/2/8 21:31
 * @Description:Buffered拷贝文件
 * @Version: 1.0
 * @Since: 1.0
 */
public class BufferedCopy03 {
    public static void main(String[] args){
      String source = "e:\\a.txt";
      String target = "e:\\t.txt";
      String line;
      //BufferedReader,BufferedWriter操作的字符文件，如果读取二进制文件，可能会损坏文件
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(source));BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(target));){
            while ((line=bufferedReader.readLine())!=null){
                //readLine读取一行 没有换行符
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
