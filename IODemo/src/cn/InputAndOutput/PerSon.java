package cn.InputAndOutput;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import java.io.Serializable;

/**
 * 要实现序列化与反序列化的实体类
 */

public class PerSon implements Serializable {
    private final static long SerialVersionUIDAdder = 1L;//自定义一个序列化ID,防止更改实体类后系统给的序列化ID不一样，产生冲突
    private String name;
    private int age;

    public PerSon() {
    }

    public PerSon(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PerSon{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
