package com.wang.p3_outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author:wsz
 * @Date: 2023/2/9 21:06
 * @Description:对象流写入演示
 * 注意事项和细节说明
 * 1)读写顺序要一致
 * 2)要求序列化或反序列化对象，需要实现Serializable
 * 3)序列化的类中建议添加SerialVersionUID,为了提高版本的兼容性
 * 4)序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员·
 * 5)序列化对象时，要求里面属性的类型也需要实现序列化接口
 * 6)序列化具备可继承性，也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化
 */
public class Demo04ObjectOutStream {
    public static void main(String[] args) {
        String path = "e:\\data.dat";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeInt(10);
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeChar('a');
            objectOutputStream.writeDouble(5.5);
            objectOutputStream.writeUTF("我是豪杰！！！");
            objectOutputStream.writeObject(new Dog("www", 18));
            System.out.println("数据写入完毕！！！");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
