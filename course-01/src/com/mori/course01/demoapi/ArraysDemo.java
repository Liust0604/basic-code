package com.mori.course01.demoapi;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组工具类Arrays类
 */
public class ArraysDemo {

    public static void main(String[] args) {

    }


    @Test
    public void test01() {
        int[] array = {10, 20, 30};
        String arrStr = Arrays.toString(array);
        System.out.println(arrStr);
    }

    @Test
    public void test02() {
        int[] array = {10, 5, 60, 2, 45, 30, 11};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        String[] array1 = {"bbb", "ccc", "aaa"};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
    }

    /**
     * 使用Arrays相关API，将一个随机字符串中的所有字符升序排列，并倒序打印
     */
    @Test
    public void test03() {
        String str = "reywu88ibj3217dccx43ds2321657563dsa";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i] + " ");
        }
    }

}
