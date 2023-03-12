package com.wang.p8_printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author:wsz
 * @Date: 2023/2/11 14:28
 * @Description:演示PrintWriter使用方式
 * @Version: 1.0
 * @Since: 1.0
 */
public class PrintWriter02 {
    public static void main(String[] args) throws IOException {
        //PrintWriter writer =new PrintWriter(System.out);
        PrintWriter writer =new PrintWriter(new FileWriter("e:\\ww.txt"));
        //默认输出位置是标准输出 即显示器
        writer.print("hello world哈哈哈!!!");
        //如果没有关闭数据不会写入成功！！
        writer.close();
    }
}
