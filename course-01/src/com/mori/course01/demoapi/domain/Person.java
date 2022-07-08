package com.mori.course01.demoapi.domain;

import java.util.Objects;

/**
 * Person类
 * 默认继承Object类
 */
public class Person {
    private String name;
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

    //默认可以使用Object的toString方法
    //可重写
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //默认可以使用Object的equals方法
    //可重写
/*
    @Override
    public boolean equals(Object o) {
        if (o == null) return false; //1、若传入对象是空，直接不相等
        if (this == o) return true;  //2、地址值判断，是同一个对象则相等
        //3、判断类型，若传入对象和本类是同一个类型，则可以向下转型
        if (o instanceof Person) {
            Person person = (Person) o;
            return (this.age == person.age) && (this.name == null ? person.name == null : this.name.equals(person.name));
        }
        return false;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; //getClass()反射判断类型是否相同
        Person person = (Person) o;
        return (age != person.age) && Objects.equals(name, person.name); // Objects.equals 防止空指针
    }

    //重写hashCode方法

    @Override
    public int hashCode() {
        return 1;
    }
}
