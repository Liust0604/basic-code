package com.mori.course02.demothread;

public class Thread2Demo {

    /**
     * 测试线程执行顺序
     */
    public static void main(String[] args) {
        //锁对象，保证线程唯一
        Object obj = new Object();
        //消费者
        Thread customer = new Thread() {
            @Override
            public void run() {
                //一直等着买包子
                while (true) {
                    System.out.println("消费者：锁前");
                    synchronized (obj) {
                        System.out.println("消费者：开始等待！");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("消费者：结束等待！");
                    }
                    System.out.println("消费者：锁后");
                }
            }
        };

        Thread producer = new Thread() {
            @Override
            public void run() {
                //一直做包子
                while (true) {
                    System.out.println("生产者：锁前");
                    synchronized (obj) {
                        System.out.println("生产者：开始唤醒！");
                        obj.notify();
                        System.out.println("生产者：结束唤醒！");
                    }
                    System.out.println("生产者：锁后");
                }
            }
        };

        customer.start();
        producer.start();
    }
}
