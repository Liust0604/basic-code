package com.mori.course01.exercises.domain.multi;

public class Cat1 extends Animal1 {
    @Override
    public void eat() {
        System.out.println("猫吃鱼！");
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠！");
    }
}
