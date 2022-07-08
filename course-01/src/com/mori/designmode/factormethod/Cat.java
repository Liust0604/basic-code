package com.mori.designmode.factormethod;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 3:23
 */
public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼！");
    }
}