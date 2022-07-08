package com.mori.course01.demoapi;

import org.junit.Test;

import java.util.Scanner;

/**
 * Scanner类：键盘输入数据到程序中
 */
public class ScannerDemo {

    @Test
    public void test01() {
        //System.in：代表从键盘进行录入
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        System.out.println("输入的数字为：" + num);

        String str = sc.next();
        System.out.println("输入的文字为：" + str);


    }

    /**
     * 键盘输入两个int数字，求和
     */
    @Test
    public void test02() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int a = sc.nextInt();
        System.out.println("请输入第二个数字：");
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println(a + "+" + b + "=" + sum);
    }

    /**
     * 键盘输入三个int数字，求最大值
     */
    @Test
    public void test03() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int a = sc.nextInt();
        System.out.println("请输入第二个数字：");
        int b = sc.nextInt();
        System.out.println("请输入第三个数字：");
        int c = sc.nextInt();

        int temp = a > b ? a : b;
        int max = temp > c ? temp : c;
        System.out.println("最大值为：" + max);
    }


}
