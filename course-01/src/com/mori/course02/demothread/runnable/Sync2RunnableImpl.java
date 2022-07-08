package com.mori.course02.demothread.runnable;

/**
 * 同步机制2：同步方法
 */
public class Sync2RunnableImpl implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            method();
        }
    }

    //2、同步方法(锁对象this)
    //一般不能写静态的，因为静态不能访问非静态的资源
    // 若要实现静态同步方法（static synchronized），资源也得是静态的 ，且锁对象不能使用this，
    // 静态同步方法(锁对象this)
    public synchronized void method() {
        if (ticket > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票。");
            ticket--;
        }
    }

}
