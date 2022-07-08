package com.mori.course02.demothread.runnable;

/**
 * 线程安全问题：重复访问共享资源、访问不存在的资源
 * 实现三个窗口卖100张票
 */
public class RunnableImpl implements Runnable {

    //共享资源
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
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
}
