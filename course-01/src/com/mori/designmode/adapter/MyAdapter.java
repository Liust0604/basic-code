package com.mori.designmode.adapter;

/**
 * 适配器作为一个中间类，实现了接口所有方法。但是这些方法都是空的
 * 因为直接调用适配器里的方法是没有意义的，为了不让其他类创建适配器类的对象,所以适配器类设置为抽象类
 */
public abstract class MyAdapter implements Animal {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

}
