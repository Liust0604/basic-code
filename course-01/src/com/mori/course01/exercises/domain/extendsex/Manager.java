package com.mori.course01.exercises.domain.extendsex;

import java.util.ArrayList;

public class Manager extends User {

    public Manager() {
    }

    //调用父类的构造方法，操作父类内容，让该对象作为一个有name和money的User存在
    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> sendRedPacket(int totalMoney, int count) {
        //redList集合用于保存若干红包金额
        ArrayList<Integer> redList = new ArrayList<>();
        //balance群主当前的余额
        int balance = super.getMoney();
        if (totalMoney > balance) {
            System.out.println("余额不足。");
            return redList;
        }

        //扣钱，就是重新设置余额
        super.setMoney((balance - totalMoney));
        //拆分钱
        int avg = totalMoney / count;
        int mod = totalMoney % count; //除不开的零头，放在最后一个红包中
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }
        int last = avg + mod;
        redList.add(last);

        return redList;
    }
}
