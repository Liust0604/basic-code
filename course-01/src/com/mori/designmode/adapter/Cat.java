package com.mori.designmode.adapter;

/**
 * Cat若直接实现Animal接口，就要实现接口中所有方法。
 * 现在Cat继承的是适配器类，适配器类已经帮忙把接口所有方法重写了，Cat只需要实现自己需要的功能即可，不用的可以不写
 */
public class Cat extends MyAdapter {
    @Override
    public void method1() {
        System.out.println("method1");
    }
}
