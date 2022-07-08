package com.mori.course01.exercises.domain.extendsex;

/**
 * 抽象类
 */
public abstract class Animal {
    //抽象类的构造方法
    public Animal() {
        System.out.println("抽象父类构造方法执行……");
    }

    public Animal(int num) {
        System.out.println("抽象父类有参构造方法执行……" + num);
    }

    //抽象方法，必须写在抽象类里，相当于一个方法的声明，方法的具体内容是不确定的。
    public abstract void eat();

    public abstract void sleep();

    //普通成员方法
    public void normalMethod() {
        System.out.println("普通成员方法…");
    }
}
