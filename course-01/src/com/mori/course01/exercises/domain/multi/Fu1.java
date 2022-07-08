package com.mori.course01.exercises.domain.multi;

public class Fu1 {

    public int num = 20;

    public void method() {
        System.out.println("父类方法！");
    }

    public void methodFu() {
        System.out.println("父类特有方法！");
    }

    public void showNum() {
        System.out.println(num);
    }

}
