package com.mori.course01.exercises.domain.multi;

public class Mouse implements USB {
    @Override
    public void openUSB() {
        System.out.println("打开鼠标…");
    }

    @Override
    public void closeUSB() {
        System.out.println("关闭鼠标…");
    }
    
    public void click() {
        System.out.println("鼠标点击！");
    }
}
