package com.mori.course01.exercises.domain.multi;

public class KeyBoard implements USB {
    @Override
    public void openUSB() {
        System.out.println("打开键盘…");
    }

    @Override
    public void closeUSB() {
        System.out.println("关闭键盘…");
    }

    public void type() {
        System.out.println("键盘输入！");
    }
}