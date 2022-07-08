package com.mori.designmode.simplefactory;

/**
 * 简单工厂模式
 *
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 3:36
 */
public class Test {
    public static void main(String[] args) {
        //向下转型
        Dog dog = (Dog) AnimalFactory.createAnimal("dog");
        Cat cat = (Cat) AnimalFactory.createAnimal("cat");

        dog.eat();
        cat.eat();
    }
}
