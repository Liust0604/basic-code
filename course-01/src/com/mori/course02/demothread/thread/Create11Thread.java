package com.mori.course02.demothread.thread;

public class Create11Thread extends Thread {

    public Create11Thread() {
        super();
    }

    //构造方法设置线程名字
    public Create11Thread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();

        //获取线程名称
        //Thread类提供获取线程的方法 getName
/*
        String name = getName();
        System.out.println("name：" + name);
*/

        //先获取当前线程，再获取名字
        String name1 = Thread.currentThread().getName();
        System.out.println("name：" + name1);

    }
}
