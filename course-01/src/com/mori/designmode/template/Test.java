package com.mori.designmode.template;

/**
 * 模板模式
 */
public class Test {
    public static void main(String[] args) {
        Demo demo = new Demo();
        //注意这里是调用模板类的方法，子类只是用于填充模板内容
        System.out.println(demo.getTime());
    }
}
