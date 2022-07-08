package com.mori.course02.demothread;

public class Thread1Demo {

    /**
     * 线程间通信：生产者、消费者
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
                    //1、消费者线程和生产者线程，同时执行run()方法。消费者线程一开始就遇到了锁，锁没有被生产者占用，所以可以进入同步。
                    synchronized (obj) {
                        //3、生产者线程开始等待。释放锁。
                        System.out.println("消费者：告知生产者所需资源信息！");
                        try {
                            System.out.println("消费者：开始等待…");
                            obj.wait();
                            //7、当生产者结束了唤醒的同步代码块，消费者又重新获得锁。继续wait()之后的内容
                            // 因为生产者后面的是异步代码，所以和这里不冲突
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //8、消费者休眠的代码块结束之后，释放锁，执行异步的方法，因为写的while，所以
                    System.out.println("消费者：开始消费资源！");
                    System.out.println("=======================================");
                }
            }
        };

        Thread producer = new Thread() {
            @Override
            public void run() {
                //一直做包子
                while (true) {
                    try {
                        //1、消费者线程和生产者线程，同时执行run()方法。生产者进程开始等待
                        // 注意sleep(ms)仅仅代表线程休眠而已，让出CPU,不会改变锁的状态。所以一进入是生产者休眠，锁不变，消费者可以去获取锁
                        // 若sleep写在同步里，不会释放锁，仅仅表示当前线程暂停了，还是继续执行当前被锁的同步程序。
                        // 若要写在里面，需要用obj.wait(ms)，这个才会修改锁的状态，当前程序等待，锁让渡给其他线程
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //2、生产者线程，结束等待，遇到了同步。发现锁被消费者占用。于是阻塞（这里就是为了休眠和唤醒只能唯一一个线程调用）。
                    //4、消费者线程因为等待，所以让出了锁，生产者线程结束阻塞，进入同步。
                    synchronized (obj) {
                        //5、生产者线程，唤醒消费者线程。但是并没有释放锁，到synchronized代码块结束，才释放了锁
                        System.out.println("生产者：告知消费者可以消费资源了！");
                        obj.notify();
                        System.out.println("生产者：通知结束！");
                    }
                    //6、锁后的代码不是同步的，所以可以立即执行，现在是while，所以又到了生产者线程sleep
                }
            }
        };

        customer.start();
        producer.start();
    }
}
