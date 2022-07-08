package com.mori.designmode.wrap;

/**
 * 装饰设计模式
 *
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 3:37
 */
public class Test {
    public static void main(String[] args) {
        SchoolStudent ss = new SchoolStudent(new Student());
        ss.code();
    }
}
