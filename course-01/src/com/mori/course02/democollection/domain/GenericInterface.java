package com.mori.course02.democollection.domain;

/**
 * 定义 含有泛型的接口
 * 1、和方法一样，在接口名后加<I>
 * 2、接口中的数据类型可以用I代替
 * 3、使用含有泛型的接口有两种方式（首先都是需要实现类实现接口）
 * a、实现接口的时候指定泛型 实现类名 implements 接口名<类型>。那么实现类里重写的方法的泛型默认字符串
 * b、实现类的泛型和接口保持一致 实现类名<I> implements 接口名<I>。实现类里也使用的泛型变量，到创建对象时才指定泛型
 */
public interface GenericInterface<I> {
    public abstract void method(I i);
}
