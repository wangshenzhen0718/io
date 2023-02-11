package com.wang.properties09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * @Author:wsz
 * @Date: 2023/2/11 16:41
 * @Description:配置文件引出Properties
 * @Version: 1.0
 * @Since: 1.0
 */
public class Properties01 {
    public static void main(String[] args){
        String line;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\王深圳项目\\io_project\\chapter01\\src\\main\\java\\com\\wang\\properties09\\mysql.properties"));){
            while((line = bufferedReader.readLine()) != null){
                String[] split = line.split("=");
                System.out.println(split[0]+":"+split[1]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
