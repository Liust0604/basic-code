package com.mori.course02.demothread.thread;

import com.mori.course02.demothread.domain.BaoZi;

/**
 * 生产者
 */
public class BaoZiPuThread extends Thread {

    private BaoZi bao; //锁对象，资源变量作为成员变量

    public BaoZiPuThread(BaoZi bao) {  //构造方法，给资源变量赋值，生产者和消费者传递的是同一个对象
        this.bao = bao;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) { //一直生产

            //同步技术
            synchronized (bao) {
                if (bao.isFlag()) {
                    //有资源，等待
                    try {
                        bao.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //注意：消费者消费完成，生产者wait()之后执行！！！先等待，后执行，不是 if else 的关系！！！
                if (!bao.isFlag()) { //没有资源
                    if (count % 2 == 0) {  //生产两种包子
                        bao.setPi("薄皮");
                        bao.setXian("猪肉馅");
                    } else {
                        bao.setPi("冰皮");
                        bao.setXian("豆沙馅");
                    }
                    count++;
                    System.out.println("生产者：正在生产" + bao.getPi() + bao.getXian() + "的包子…");
                    try {
                        Thread.sleep(3000); //不交出锁对象，只是暂停等待而已，之后继续生产者的工作
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //生产资源，唤醒消费者
                    bao.setFlag(true);
                    bao.notify();
                    System.out.println("生产者：" + bao.getPi() + bao.getXian() + "的包子生产好了，可以开始吃了！");
                }
            }

        }
    }
}
