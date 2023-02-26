package com.wang.outputstream03;

import java.io.Serializable;
/**
 * @Author:wsz
 * @Date: 2023/2/9 21:41
 * @Description:公有Dog 用于序列化和反序列化
 * @Version: 1.0
 * @Since: 1.0
 */
public class  Dog implements Serializable {
    private String name;
    private Integer age;
    //serialVersionUID序列化版本 提高兼容性，以后加了属性不会认为是新的类，会认为是升级版
    private static final long serialVersionUID = 1L;


    public Dog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}