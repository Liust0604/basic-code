package com.mori.course02.demojdk8.service;

/**
 * 定义一个打印的函数式接口
 */
@FunctionalInterface
public interface PrintTable {
    public abstract void print(String s);
}
