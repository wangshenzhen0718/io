package com.wang.p8_printstream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @Author:wsz
 * @Date: 2023/2/11 14:28
 * @Description:演示PrintStream使用方式
 * @Version: 1.0
 * @Since: 1.0
 */
public class Demo01PrintStream {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //默认输出位置是标准输出 即显示器
        out.print("hello world哈哈哈!!!");
        out.close();
        System.setOut(new PrintStream("e:\\t.txt"));
        System.out.print("hello world哈哈哈3333333333!!!");
    }
}
