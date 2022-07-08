package com.mori.designmode.factormethod;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 3:41
 */
public class DogFactory implements AnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}