package com.mori.course01.exercises.domain.multi;

public class Dog1 extends Animal1 {
    @Override
    public void eat() {
        System.out.println("狗吃肉！");
    }

    public void watchHouse() {
        System.out.println("狗看家！");
    }
}
