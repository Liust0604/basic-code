package com.mori.designmode.singleton;

/**
 * 单例模式
 * 懒汉式：用到的时候才会创建对象
 */
public class LazySingleton {
    //1、私有构造方法。先不让其他类创建对象
    private LazySingleton() {
    }

    //2、先声明一个引用
    //B、线程安全：添加volatile关键字
    private static volatile LazySingleton instance;

    //3、对外提供公共方法，若不存在实例再赋值
    public static LazySingleton getInstance() {
        //A、线程安全：通过锁机制，防止多线程创建多个实例
        //若只加锁的话，其他线程会堵塞，优化:DCL双端检索机制
        if (instance == null) { //外层if，没有实例的线程获取同步锁，有实例的不被堵塞
            synchronized (LazySingleton.class) {
                if (instance == null) {    //内层if，没有实例的线程中第一个已经创建了实例，其他没有实例的线程不用再在锁里创建实例了
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
