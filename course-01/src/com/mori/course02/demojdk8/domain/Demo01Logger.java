package com.mori.course02.demojdk8.domain;

/**
 * 日志案例
 */
public class Demo01Logger {
    //定义一个根据日志级别显示日志信息的方法
    //以下方法，性能浪费：
    //因为是先拼接字符串，再调用方法。若level不为1，那么字符串就白拼接了
    public static void showLog(int level, String message) {
        if (level == 1) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";
        showLog(1, msg1 + msg2 + msg3);
    }

}
