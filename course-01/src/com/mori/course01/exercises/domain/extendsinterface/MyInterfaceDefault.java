package com.mori.course01.exercises.domain.extendsinterface;

/**
 * Java 8 版本的java中接口允许定义默认方法
 */
public interface MyInterfaceDefault {

    //抽象方法
    public abstract void methodAbs();

    //默认方法
    public default void methodDefault() {
        System.out.println("默认方法");
    }
}
