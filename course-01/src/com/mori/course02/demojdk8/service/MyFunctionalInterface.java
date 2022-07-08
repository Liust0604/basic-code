package com.mori.course02.demojdk8.service;

/**
 * 函数式接口：有且只有一个抽象方法的接口
 * 添加函数式接口的注解
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    public abstract void method(); //定义唯一一个抽象方法
}
