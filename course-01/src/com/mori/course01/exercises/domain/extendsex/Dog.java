package com.mori.course01.exercises.domain.extendsex;

/**
 * 子类也是一个抽象类，不用实现所有抽象父类的抽象方法
 */
public abstract class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("狗吃骨头…");
    }

    //sleep
}
