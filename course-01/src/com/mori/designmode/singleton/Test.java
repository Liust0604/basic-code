package com.mori.designmode.singleton;

/**
 * 单例模式
 *
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 3:58
 */
public class Test {
    public static void main(String[] args) {
        HungarySingleton s1 = HungarySingleton.getInstance();
        HungarySingleton s2 = HungarySingleton.getInstance();
        System.out.println(s1 == s2);

        LazySingleton s3 = LazySingleton.getInstance();
        LazySingleton s4 = LazySingleton.getInstance();
        System.out.println(s3 == s4);
    }
}
