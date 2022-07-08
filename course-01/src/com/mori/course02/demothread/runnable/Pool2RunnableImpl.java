package com.mori.course02.demothread.runnable;

public class Pool2RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
