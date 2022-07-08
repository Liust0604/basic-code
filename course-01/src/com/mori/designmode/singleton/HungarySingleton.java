package com.mori.designmode.singleton;

/**
 * 单例模式
 * 饿汉式：不管用不用的到，都会先创建对象
 */
public class HungarySingleton {

    //1、私有构造方法。先不让其他类创建对象
    private HungarySingleton() {
    }

    //2、创建本类对象。先不能让别人访问
    private static HungarySingleton instance = new HungarySingleton();

    //3、对外提供公共方法，其他类只能通过公共方法访问实例
    public static HungarySingleton getInstance() {
        return instance;
    }
}
