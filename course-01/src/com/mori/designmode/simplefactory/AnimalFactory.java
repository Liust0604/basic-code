package com.mori.designmode.simplefactory;

/**
 * 动物工厂,可以生产狗，也可以生产猫
 *
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 3:24
 */
public class AnimalFactory {
/*    public static Dog createDog() {
        return new Dog();
    }

    public static Cat createCat() {
        return new Cat();
    }*/
    //上面方法定义很多，复用性太差

    public static Animal createAnimal(String name) {
        if ("dog".equals(name)) {
            return new Dog();
        }
        if ("cat".equals(name)) {
            return new Cat();
        }
        return null;
    }
}
