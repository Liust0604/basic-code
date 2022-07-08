package com.mori.designmode.template;

/**
 * 本类继承了模板类
 * 1、重写内容方法，也就是向模板里填充内容，得到完整算法
 * 2、通过模板类，调用模板方法，执行完整算法
 */
public class Demo extends GetTime {
    @Override
    public void code() {
        int i = 0;
        while (i < 100000) System.out.println(i);
    }
}
