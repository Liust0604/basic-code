package com.mori.course01.demoapi;

import org.junit.Test;

import java.util.Scanner;

/**
 * String类
 */
public class StringDemo {

    /**
     * 3+1种创建字符串String的方法
     */
    @Test
    public void test01() {
        //使用空参构造
        String str1 = new String();
        System.out.println("str1：" + str1);
        //根据字符数组创建字符串
        char[] charArr = {'A', 'B', 'C'};
        String str2 = new String(charArr);
        System.out.println("str2：" + str2);
        //根据字节数组创建字符串
        byte[] byteArr = {97, 98, 99};
        String str3 = new String(byteArr);
        System.out.println("str3：" + str3);

        //直接创建
        String str4 = "Hello!";
        System.out.println("str4：" + str4);
    }

    /**
     * 字符串的常量池,字符串的比较
     */
    @Test
    public void test02() {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String(new char[]{'a', 'b', 'c'});

        System.out.println(str1 == str2); //true
        System.out.println(str1 == str3); //false
        System.out.println(str2 == str3); //false
        System.out.println("===");
        System.out.println(str1.equals(str2)); //true
        System.out.println(str1.equals(str3)); //true
        System.out.println(str2.equals(str3)); //true
        System.out.println("===");
        System.out.println("ABC".equals(str1)); //false 区分大小写
        System.out.println("ABC".equalsIgnoreCase(str1)); //true 忽略大小写
    }

    /**
     * 字符串的获取
     */
    @Test
    public void test03() {
        int length = "dasdsadas".length();
        System.out.println("字符串的长度：" + length);
        System.out.println("===");
        String str1 = "123";
        String str2 = "456";
        String str3 = str1.concat(str2);
        System.out.println(str1); //"123"不变
        System.out.println(str2); //"456"不变
        //str3并不是真的在str1后拼接而成，是创建了一个新的字符串
        System.out.println("拼接字符串：" + str3);
        System.out.println("===");
        char ch = "Hello".charAt(1);
        System.out.println("Hello第二个字母为：" + ch);
        System.out.println("===");
        int index = "HelloHello".indexOf("llo");
        System.out.println("第一次出现位置：" + index);
    }

    /**
     * 字符串的截取
     */
    @Test
    public void test04() {
        String str1 = "HelloWorld";
        String str2 = str1.substring(1);
        String str3 = str1.substring(2, 5);
        System.out.println(str1);//HelloWorld原字符串
        System.out.println(str2);//elloWorld
        System.out.println(str3);//llo

        System.out.println("==========");
        //以下字符串的内容仍然是没有改变的
        //有两个字符串"Hello"，"JAVA"，strA保存的地址值发生改变
        String strA = "Hello";
        System.out.println(strA);
        strA = "JAVA";
        System.out.println(strA);

    }

    /**
     * 字符串的转换
     */
    @Test
    public void test05() {

        String str1 = "Hello";

        char[] chars = str1.toCharArray();
        System.out.println(chars);
        byte[] bytes = str1.getBytes();
        System.out.println(bytes);
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + " ");
        }
        System.out.println();
        String str2 = str1.replace("l", "A");
        System.out.println(str2);

    }

    /**
     * 字符串的分割
     */
    @Test
    public void test06() {

        String str1 = "aaa,bbb,ccc";
        String[] strings = str1.split(",");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println();

        //
        String str2 = "AAA.BBB.CCC";
        /*
        String[] strings2 = str2.split(".");
        System.out.print(strings2.length); //0
        */
        String[] strings2 = str2.split("\\.");
        System.out.println(strings2.length); //0
        for (int i = 0; i < strings2.length; i++) {
            System.out.print(strings2[i] + " ");
        }
        System.out.println();

    }

    /**
     * 练习：把数组{1,2,3}按指定格式拼接成字符串。格式[word1#word2#word3]
     */
    @Test
    public void test07() {
        int[] strArr = new int[]{1, 2, 3};

        String str = "[";
        for (int i = 0; i < strArr.length; i++) {
            str += "word" + strArr[i];
            if (i == strArr.length - 1) {
                str += "]";
            } else {
                str += "#";
            }
        }
        System.out.print(str);
    }

    /**
     * 练习：键盘输入一个字符串，统计各种字符出现的次数。（大写字母、小写字母、数字、其他）
     */
    @Test
    public void test08() {
        int upperCount = 0;
        int lowerCount = 0;
        int numCount = 0;
        int otherCount = 0;

        System.out.println("请输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String inStr = sc.next();

        char[] chars = inStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ('A' <= c && c <= 'Z') {
                ++upperCount;
            } else if ('a' <= c && c <= 'z') {
                ++lowerCount;
            } else if ('0' <= c && c <= '9') {
                ++numCount;
            } else {
                ++otherCount;
            }
        }
        System.out.println("输入字符串为：" + inStr);
        System.out.print("大写字母：" + upperCount + "，" + "小写字母：" + lowerCount + "，" + "数字：" + numCount + "，" + "其他：" + otherCount);
    }
}
