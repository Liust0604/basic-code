package com.mori.course02.demothread;

import com.mori.course02.demothread.domain.BaoZi;
import com.mori.course02.demothread.thread.BaoZiPuThread;
import com.mori.course02.demothread.thread.ChiHuoThread;

public class Thread3Demo {
    /**
     * 线程间通信，等待唤醒机制
     */
    public static void main(String[] args) {
        BaoZi bao = new BaoZi(); //传递同一个资源对象，作为锁对象
        new BaoZiPuThread(bao).start();
        new ChiHuoThread(bao).start();
    }
}
