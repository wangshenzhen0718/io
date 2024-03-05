package com.wang.p1_file;

import java.io.File;

/**
 * @Author:wsz
 * @Date: 2023/2/1 21:39
 * @Description:目录操作
 * @Version: 1.0
 * @Since: 1.0
 */
public class Demo03Directory {
    public static void main(String[] args){
      //m1();
      //m2();
      m3();
    }
    /**
     * 判断文件是否存在，存在就删除
     */
    public static void m1(){
        File file = new File("e:\\news1.txt");
        if (file.exists()){
            if (file.delete()){
                System.out.println("删除成功！！！");
            }else {
                System.out.println("删除失败！！！");
            }

        }else {
            System.out.println("文件不存在！！！");
        }

    }

    /**
     * 判断目录是否存在，存在就删除
     */
    public static void m2(){
        File file = new File("e:\\demo2");
        if (file.exists()){
            if (file.delete()){
                System.out.println("删除成功！！！");
            }else {
                System.out.println("删除失败！！！");
            }

        }else {
            System.out.println("目录不存在！！！");
        }

    }

    /**
     * 判断目录是否存在，存在提示已存在，否则创建
     */
    public static void m3(){
        File file = new File("e:\\demo2\\aa\\bb\\cc");
        if (file.exists()){
            System.out.println("目录已存在！！！");

        }else {
            if (file.mkdirs()){
                System.out.println("目录创建成功！");
            }else {
                System.out.println("目录创建失败!");
            }
        }

    }
}
