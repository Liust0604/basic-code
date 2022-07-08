package com.mori.course01.exercises.domain.extendsex;

/**
 * 实现抽象类
 */
public class Cat extends Animal {

    public Cat() {
        //super() ,抽象父类不能直接调用构造函数，只能在创建子类对象调用构造方法时通过super调用
        super(10);
        System.out.println("子类构造方法执行…");
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼…");
    }

    @Override
    public void sleep() {
        System.out.println("猫睡觉…");
    }
}
