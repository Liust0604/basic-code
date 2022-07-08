package com.mori.designmode.factormethod;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 3:24
 */
public class CatFactory implements AnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
