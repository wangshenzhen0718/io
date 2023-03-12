package com.wang.p9_properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author:wsz
 * @Date: 2023/2/11 17:14
 * @Description:Properties创建或修改配置文件
 * @Version: 1.0
 * @Since: 1.0
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //Properties父类是HashTable
        Properties properties = new Properties();
        //如果该文件没有key就创建 有就修改
        properties.setProperty("ip","192.168.0.45");
        //汉字存的是Unicode
        properties.setProperty("name","深圳");
        properties.setProperty("age","18");
        properties.store(new FileOutputStream("E:\\王深圳项目\\io_project\\chapter01\\src\\main\\java\\com\\wang\\properties09\\mysql2.properties"),null);


    }
}
