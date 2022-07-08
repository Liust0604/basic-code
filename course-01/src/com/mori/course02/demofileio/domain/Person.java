package com.mori.course02.demofileio.domain;

import java.io.Serializable;

/**
 * 需要实现Serializable接口,开启序列化功能
 */
public class Person implements Serializable {

    private final static long serialVersionUID = 42L;

    private String name;
    // private transient int age; //transient 关键字，使成员变量不被序列化
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
