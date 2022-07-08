package com.mori.course02.demothread.thread;

import com.mori.course02.demothread.domain.BaoZi;

public class ChiHuoThread extends Thread {

    private BaoZi bao; //锁对象，资源变量作为成员变量

    public ChiHuoThread(BaoZi bao) {  //构造方法，给资源变量赋值，生产者和消费者传递的是同一个对象
        this.bao = bao;
    }

    @Override
    public void run() {
        while (true) { //一直消费
            synchronized (bao) {
                if (!bao.isFlag()) {
                    //没有资源，等待
                    try {
                        bao.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //先等待，后执行
                if (bao.isFlag()) {
                    System.out.println("消费者：正在消费" + bao.getPi() + bao.getXian() + "的包子");
                    try {
                        Thread.sleep(1000); //不交出锁对象，只是暂停等待而已，之后继续生产者的工作
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //消費资源，唤醒生产者
                    bao.setFlag(false);
                    bao.notify();
                    System.out.println("消费者：" + bao.getPi() + bao.getXian() + "的包子吃完了，可以开始生产包子了！");
                    System.out.println("----------------------");
                }
            }
        }
    }
}

