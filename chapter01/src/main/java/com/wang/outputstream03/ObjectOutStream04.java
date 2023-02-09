package com.wang.outputstream03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Author:wsz
 * @Date: 2023/2/9 21:06
 * @Description:对象流写入演示
 * @Version: 1.0
 * @Since: 1.0
 */
public class ObjectOutStream04 {
    public static void main(String[] args){
      String path = "e:\\data.dat";
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))){
            objectOutputStream.write(10);
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeChar('a');
            objectOutputStream.writeDouble(5.5);
            objectOutputStream.writeUTF("我是豪杰！！！");
            objectOutputStream.writeObject(new Dog("www",18));
            objectOutputStream.close();
            System.out.println("数据写入完毕！！！");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
class  Dog implements Serializable {
    private String name;
    private Integer age;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}