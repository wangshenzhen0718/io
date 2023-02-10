package com.wang.standard06;

import java.util.Scanner;

/**
 * @Author:wsz
 * @Date: 2023/2/10 22:23
 * @Description:标准输入输出流
 * @Version: 1.0
 * @Since: 1.0
 */
public class InputAndOutPut {
    public static void main(String[] args){
        //System 类的 public final static InputStream in = null;
        //system.in 编译类型 InputStream
        //System.in运行类型BufferedInputStream
        //4.表示标准输如 键盘
        System.out.println(System.in.getClass());

        //老韩解读
        //1. System.out public final static PrintStream out = null
        //2．编译类型 PrintStream
        //3．运行类型 PrintStream
        //4.表示标准输出 显示器
        System.out.println(System.out.getClass());
        System.out.println("hello world!");
        //System.in  代表BufferedInputStream 从键盘获取数据！！！
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容：");
        String next = scanner.next();
        System.out.println(next);

    }
}
