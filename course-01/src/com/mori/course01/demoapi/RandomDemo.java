package com.mori.course01.demoapi;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * Random类：产生随机数
 */
public class RandomDemo {

    @Test
    public void test01() {
        Random r = new Random();
        System.out.println(r.nextInt());
        System.out.println(r.nextInt(10));//0~9
    }

    /**
     * 根据n获取随机数1~n
     */
    @Test
    public void test02() {
        int n = 5;
        int result = new Random().nextInt(n) + 1;
        System.out.println(result);//1~5
    }

    /**
     * 猜一个1~100之间数字
     */
    @Test
    public void test03() {
        int num = new Random().nextInt(100) + 1; //[1,100]
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你猜的数：");
        int result = sc.nextInt();
        while (result != num) {
            if (result > num) {
                System.out.println("猜大了，请重输：");
            }
            if (result < num) {
                System.out.println("猜小了，请重输：");
            }
            result = sc.nextInt();
        }
        System.out.println("猜对了！正确答案是：" + num);
    }

}
