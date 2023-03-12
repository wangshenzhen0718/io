package com.wang.p2_inputstream;

import com.wang.p3_outputstream.Dog;

import java.io.*;

/**
 * @Author:wsz
 * @Date: 2023/2/9 21:06
 * @Description:对象流读取演示
 * @Version: 1.0
 * @Since: 1.0
 */
public class ObjectInputStream02 {
    public static void main(String[] args){
      String path = "e:\\data.dat";
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))){
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readChar());
            System.out.println(objectInputStream.readDouble());
            System.out.println(objectInputStream.readUTF());
            Object dog = objectInputStream.readObject();
            System.out.println("运行类型"+dog.getClass());
            System.out.println("dog信息："+dog);
            //这里是特别重要的细节:
            //1．如果我们希望调用Dog的方法，需要向下转型
            //2．需要我们将Dog类的定义，放到可以引用的位置
            Dog dog2=(Dog)dog;
            System.out.println(dog2.getName());

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}