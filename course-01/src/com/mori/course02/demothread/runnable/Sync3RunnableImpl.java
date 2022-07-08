package com.mori.course02.demothread.runnable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步机制3：锁机制（Lock锁）
 */
public class Sync3RunnableImpl implements Runnable {

    private static int ticket = 100;

    //3、Lock锁 （多态，接口指向实现类）
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //获取锁
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票。");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //无论程序释放异常，都会释放锁
                    lock.unlock();
                }
            }
        }
    }


}
