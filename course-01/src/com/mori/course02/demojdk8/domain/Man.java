package com.mori.course02.demojdk8.domain;

import com.mori.course02.demojdk8.service.Greetable;
import com.mori.course02.demojdk8.service.Richable;

/**
 * 定义子类
 */
public class Man extends Human {
    //重写父类方法
    @Override
    public void sayHello() {
        System.out.println("你好！我是Man");
    }

    //定义一个方法，参数传递函数式接口
    public void method(Greetable g) {
        g.greet();
    }

    public void show() {
        /*method(() -> {
            super.sayHello();
        });*/
        method(super::sayHello);
    }

    //定义本类成员方法
    public void buyHouse() {
        System.out.println("买一套房子");
    }

    public void marry(Richable r) {
        r.buy();
    }

    public void happy() {
        // marry(() -> this.buyHouse());
        marry(this::buyHouse);
    }
}
