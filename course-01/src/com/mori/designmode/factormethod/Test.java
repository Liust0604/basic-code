package com.mori.designmode.factormethod;

/**
 * 工厂方法模式
 */
public class Test {
    public static void main(String[] args) {
        DogFactory dogFactory = new DogFactory();
        Dog dog = (Dog) dogFactory.createAnimal();
        CatFactory catFactory = new CatFactory();
        Cat cat = (Cat) catFactory.createAnimal();

        dog.eat();
        cat.eat();
    }
}
