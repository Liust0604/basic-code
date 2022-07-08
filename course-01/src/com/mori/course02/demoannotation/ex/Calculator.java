package com.mori.course02.demoannotation.ex;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 2:13
 */
public class Calculator {
    //加add、减sub、乘mul、除div

    @Check
    public void mul() {
        System.out.println("1 * 0=" + (1 * 0));
    }

    @Check
    public void div() {
        System.out.println("1 / 0=" + (1 / 0));
    }

    @Check
    public void str() {
        String s = null;
        s.toString();
    }

    public void show() {
        System.out.println("无bug…");
    }
}
