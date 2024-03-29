package com.wang.p3_outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author:wsz
 * @Date: 2023/2/4 18:14
 * @Description:演示FileOutStream的使用
 */
public class Demo01FileOutStream {
    public static void main(String[] args) {
        readFile01();
    }

    public static void readFile01() {
        String path = "e:\\a.txt";
        //如果写入内容想要覆盖原来内容FileOutputStream参数添加false
        try (FileOutputStream fileOutputStream = new FileOutputStream(path, true)) {
            //写入单个字符
            String str = "hello world!!!";
            fileOutputStream.write('W');
            //写入字符串
            fileOutputStream.write(str.getBytes());
            //写入指定长度的字符串
            fileOutputStream.write(str.getBytes(), 0, str.length());
            System.out.println("写入成功！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
