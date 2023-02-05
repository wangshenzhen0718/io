package com.wang.reader04;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/4 21:15
 * @Description:FileReader字符流读取数据
 * @Version: 1.0
 * @Since: 1.0
 */
public class FileWriter02 {
    public static void main(String[] args){
        readWriter01();
    }

    /**
     *字符读取文件
     * */
    public static void readWriter01(){

        String filePath="e:\\story.txt";
        try(FileWriter fileWriter = new FileWriter(filePath)){
            //数据写入完毕一定要关闭！！
            fileWriter.write("H");
            fileWriter.write("嘎嘎嘎过1111");
            fileWriter.write("哈哈哈".toCharArray());
            fileWriter.write("123456",0,3);
            System.out.println("写入完成！！！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
