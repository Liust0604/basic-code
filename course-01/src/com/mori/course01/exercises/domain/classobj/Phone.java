package com.mori.course01.exercises.domain.classobj;

public class Phone {
    //成员变量（如果和调用的类在同一个包下，则可以省略导包，也不需要public关键字）
    public String brand;
    public double price;

    //成员方法
    public void call(String who) {
        System.out.println("给" + who + "打电话……");
    }

    public void sendMsg() {
        System.out.println("群发短信……");
    }
}
