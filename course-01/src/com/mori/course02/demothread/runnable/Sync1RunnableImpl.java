package com.mori.course02.demothread.runnable;

/**
 * 同步机制1 （同步机制解决线程安全问题）：同步代码块
 */
public class Sync1RunnableImpl implements Runnable {

    private int ticket = 100;

    //创建一个锁对象,创建在外面，才能保证每个线程的锁对象唯一
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //1、同步代码块，把需要同步操作的代码，放在同步代码块里
            synchronized (obj) { //似乎代码块里的内容不能抽出为一个方法，这样就一直是第一个线程执行了
                if (ticket > 0) {
                    try {
                        Thread.sleep(1); //sleep写在同步里，不释放锁，只是线程休眠而已
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票。");
                    ticket--;
                }
            }
        }
    }
}
