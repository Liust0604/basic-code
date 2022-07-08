package com.mori.course02.demothread.thread;

/**
 * 创建线程类，方法二
 * 1、实现Runnable接口
 * 2、实现run方法
 */
public class Create2RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }
}
