package com.mori.course02.democollection.domain;

/**
 * 定义 含有泛型的方法
 * 1、方法修饰符后加<M>
 * 2、方法传递的数据类型可以用E来代替
 */
public class GenericMethod {
    //定义含有泛型的方法
    public <M> void method(M m) {
        System.out.println("方法!");
    }

    //定义含有泛型的静态方法
    public static <S> void methodStatic(S m) {
        System.out.println("静态方法!");
    }
}
