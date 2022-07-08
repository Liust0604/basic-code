package com.mori.course02.demothread;

import com.mori.course02.demothread.runnable.Pool1RunnableImpl;
import com.mori.course02.demothread.runnable.Pool2RunnableImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread4Demo {
    /**
     * 线程池
     */
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new Pool1RunnableImpl());  //pool-1-thread-1
        es.submit(new Pool2RunnableImpl());  //pool-1-thread-1 重复利用线程池里的线程执行任务
        es.submit(new Pool1RunnableImpl());  //pool-1-thread-1
        es.submit(new Pool2RunnableImpl());  //pool-1-thread-2
        es.shutdown();

        es.submit(new Pool1RunnableImpl());
    }
}
