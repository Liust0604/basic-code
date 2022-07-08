package com.mori.designmode.template;

/**
 * 模板类
 * 模板方法是不可被重写修改的
 * 内容方法需要被子类重写，是抽象的
 */
public abstract class GetTime {

    //1、定义一个模板方法，
    //计算时间是必须要执行的，固定的内容。不可被改变，不可被重写，所以要用final修饰
    public final long getTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        return (end - start);
    }

    //2、定义一个内容模板
    // 是具体实现算法的内容，不固定，需要子类来实现
    // 所以是一个抽象的方法，需要写在抽象类里
    public abstract void code();
}
