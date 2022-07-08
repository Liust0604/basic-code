package com.mori.course02.democollection.domain;

/**
 * 定义 含有泛型的类 ，模拟ArrayList集合
 * 1、类名后加<E>
 * 2、类里所有的数据类型都可以用E来代替
 */
public class GenericClass<E> {
    private E Name;

    public E getName() {
        return Name;
    }

    public void setName(E name) {
        Name = name;
    }
}
