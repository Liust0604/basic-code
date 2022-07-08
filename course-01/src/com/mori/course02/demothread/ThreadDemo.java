package com.mori.course02.demothread;

import com.mori.course02.demothread.domain.Calculator;
import com.mori.course02.demothread.domain.Cook;
import com.mori.course02.demothread.domain.Person;
import com.mori.course02.demothread.runnable.RunnableImpl;
import com.mori.course02.demothread.runnable.Sync1RunnableImpl;
import com.mori.course02.demothread.thread.Create11Thread;
import com.mori.course02.demothread.thread.Create1Thread;
import com.mori.course02.demothread.thread.Create2RunnableImpl;
import org.junit.Test;

import java.util.Arrays;

public class ThreadDemo {

    public static void main(String[] args) {
        //RunnableImpl run = new RunnableImpl(); //1个实现类对象，所以只访问100张票
        Sync1RunnableImpl run = new Sync1RunnableImpl();
        //Sync2RunnableImpl run = new Sync2RunnableImpl();
        //Sync3RunnableImpl run = new Sync3RunnableImpl();

        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    @Test
    /**
     * 创建线程1：继承Thread类
     * */
    public void Test01() {
        //main线程和新线程抢占CPU，随机执行
        Create1Thread ct = new Create1Thread();
        ct.start(); //start()开启新线程，执行run方法
        for (int i = 0; i < 20; i++) {
            System.out.println("test01:" + i);
        }
    }

    @Test
    /**
     * 线程名
     * */
    public void Test02() {
        new Create11Thread().start();
        new Create11Thread().start();
        Create11Thread ct = new Create11Thread();
        ct.setName("线程A");
        ct.start();
        new Create11Thread("线程B").start();
        //Thread静态方法 获取当前线程
        System.out.println(Thread.currentThread());
        System.out.println("name：" + Thread.currentThread().getName());
    }

    @Test
    /**
     * sleep() 线程以指定时间暂停
     * */
    public void Test03() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    /**
     * 创建线程2：实现Runnable接口
     * */
    public void Test04() {
        //创建一个Runnable实现类对象
        Create2RunnableImpl run = new Create2RunnableImpl();
        //创建一个Thread类对象,并传入Runnable实现类
        Thread t = new Thread(run);
        //Thread对象调用start()方法，开启线程
        t.start();
    }

    @Test
    //匿名内部类创建线程
    public void Test05() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                }
            }
        }).start();
    }

    /*********同步机制*********/

    @Test
    /**
     * 多线程共享资源，安全问题
     * */
    public void Test06() {
        //若用了sleep，在main()方法中才能重现安全问题
        RunnableImpl run = new RunnableImpl(); //1个实现类对象，所以只访问100张票
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    @Test
    /**
     * Lambda 表达式
     * */
    public void Test07() {
        //匿名内部类方式，创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        //Lambda表达式，创建线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }

    @Test
    public void Test08() {
        invokeCook(() -> {
            System.out.println("吃饭了");
        });

        System.out.println("============");

        Person[] arr = {
                new Person("小红", 12),
                new Person("小李", 6),
                new Person("小贝", 21)
        };
        Arrays.sort(arr, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();
        });

        System.out.println(Arrays.toString(arr));

        System.out.println("============");
        int sum = invokeCalc(2, 3, (a, b) -> a + b);
        System.out.println("sum:" + sum);
    }

    private void invokeCook(Cook cook) { //接口对象作为参数
        cook.makeFood(); //调用接口对象的方法，（接口的抽象方法必须重写实现）
    }

    private int invokeCalc(int a, int b, Calculator c) { //接口对象作为参数
        return c.calc(a, b); //调用接口对象的方法，（接口的抽象方法必须重写实现）
    }

}
