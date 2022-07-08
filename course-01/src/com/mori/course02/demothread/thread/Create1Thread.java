package com.mori.course02.demothread.thread;

/**
 * 创建线程类，方法一
 * 1、继承Thread方法
 * 2、重写run方法
 */
public class Create1Thread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 20; i++) {
            System.out.println("runA:" + i);
        }
    }
}
