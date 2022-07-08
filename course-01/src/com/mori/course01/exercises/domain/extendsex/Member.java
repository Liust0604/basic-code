package com.mori.course01.exercises.domain.extendsex;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receiveRedPacket(ArrayList<Integer> list) {
        //从所有红包中随机抽取一个给自己
        int index = new Random().nextInt(list.size());
        //根据索引从集合中删除，并且自己得到该红包
        Integer delta = list.remove(index);
        int balance = super.getMoney();
        super.setMoney((balance + delta));
    }
}
