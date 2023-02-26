package com.wang.properties09;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author:wsz
 * @Date: 2023/2/11 16:41
 * @Description:Properties读取文件
 * @Version: 1.0
 * @Since: 1.0
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("E:\\王深圳项目\\io_project\\chapter01\\src\\main\\java\\com\\wang\\properties09\\mysql.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
        String ip = properties.getProperty("ip");
        System.out.println(ip);
        properties.list(System.out);


    }
}
