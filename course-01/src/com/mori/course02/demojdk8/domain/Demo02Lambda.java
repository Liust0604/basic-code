package com.mori.course02.demojdk8.domain;

import com.mori.course02.demojdk8.service.MessageBuilder;

/**
 * 使用Lambda优化日志案例性能浪费的问题
 */
public class Demo02Lambda {
    //定义一个显示日志信息的方法，传递不是字符串，而是MessageBuilder
    //传递函数式接口
    //优化性能：只有满足level==1时，才会调用接口的方法拼接字符串，否则不会提前做没用的工作
    public static void showLog(int level, MessageBuilder mb) {
        if (level == 1) {
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";
        showLog(1, () -> msg1 + msg2 + msg3);
    }
}
