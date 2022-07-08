package com.mori.course01.demoapi;

import org.junit.Test;

/**
 * 数学工具类Math类
 */
public class MathDemo {

    public static void main(String[] args) {

    }

    /**
     * 绝对值
     */
    @Test
    public void test01() {
        System.out.println(Math.abs(3.14));
        System.out.println(Math.abs(0));
        System.out.println(Math.abs(-2.5));
    }

    /**
     * 向上取整
     */
    @Test
    public void test02() {
        System.out.println(Math.ceil(3.14));
        System.out.println(Math.ceil(3.0));
        System.out.println(Math.ceil(0));
        System.out.println(Math.ceil(-2.5));
    }

    /**
     * 向下取整
     */
    @Test
    public void test03() {
        System.out.println(Math.floor(3.14));
        System.out.println(Math.floor(3.0));
        System.out.println(Math.floor(0));
        System.out.println(Math.floor(-2.5));
    }

    /**
     * 四舍五入
     */
    @Test
    public void test04() {
        System.out.println(Math.round(3.14));
        System.out.println(Math.round(3.0));
        System.out.println(Math.round(3.5));
        System.out.println(Math.round(0));
        System.out.println(Math.round(-3.14));
        System.out.println(Math.round(-3.0));
        System.out.println(Math.round(-3.5));
        System.out.println(Math.round(-3.6));
    }

    /**
     * 练习：计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个？
     * <p>
     * 注：若使用Math.ceil方法，-10.8变成-10.0，注意double也是可以进行++的。
     */
    @Test
    public void test05() {
        double min = -10.8;
        double max = 5.9;

        int count = 0;
        for (int i = (int) min; i < max; i++) {
            int abs = Math.abs(i);
            if (6 < abs || abs < 2.1) ++count;
        }
        System.out.println(count + "个");

    }

    @Test
    public void test07() {


    }


}
