package com.mori.course01.exercises.domain.classobj;

/**
 * 标准的类
 */
public class Student {
    //private修饰的成员变量
    private String name;
    private int age;

    //无参数的构造方法
    public Student() {
    }

    //全参数的构造方法
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //成员变量的Getter/Setter方法
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
}
