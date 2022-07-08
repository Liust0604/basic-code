package com.mori.course01.exercises.domain.extendsex;

public class OldPhone {

    int num = 20;

    public OldPhone() {
        System.out.println("父类无参构造方法");
    }

    public OldPhone(int num) {
        System.out.println("父类有参构造方法:" + num);
    }

    public void call() {
        System.out.println("打电话！");
    }

    public void send() {
        System.out.println("发短信！");
    }

    public void show() {
        System.out.println("显示号码…");
    }

    public void method() {
        System.out.println("父类的成员方法…");
    }
}
