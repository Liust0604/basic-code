package com.mori.course01.exercises.domain.multi;

public class Zi1 extends Fu1 {

    public int num = 10;
    public int num2 = 10;

    @Override
    public void method() {
        System.out.println("子类重写父类方法！");
    }

    public void methodZi() {
        System.out.println("子类特有方法！");
    }

    public void showNum() {
        System.out.println(num);
    }
}
