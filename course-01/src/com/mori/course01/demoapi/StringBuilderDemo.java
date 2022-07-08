package com.mori.course01.demoapi;

import org.junit.Test;

public class StringBuilderDemo {

    /**
     * 构造方法
     */
    @Test
    public void test01() {
        StringBuilder sb1 = new StringBuilder();
        System.out.println(sb1); //""

        StringBuilder sb2 = new StringBuilder("AAABBB");
        System.out.println(sb2);
    }

    /**
     * 常用
     */
    @Test
    public void test02() {
        StringBuilder sb = new StringBuilder();
/*        StringBuilder sb1 = sb.append("ABC"); //append()方法返回的是this，调用方法的对象sb，所以是把sb的地址值赋值给了sb1
        System.out.println(sb); //"ABC"
        System.out.println(sb1); //"ABC"
        System.out.println(sb == sb1); //true，比较的是地址值，相同，说明StringBuilder是可变的，指向同一个对象*/

        //所以使用append方法，无需接收返回值。操作返回的就是同一个stringBuilder对象
        /*sb.append("ABC");
        sb.append('中');
        sb.append(1);
        sb.append(8.8);
        sb.append(true);
        sb.append(new char[]{'A', '三', '9'});
        System.out.println(sb);*/

        //链式编程
        sb.append("ABC").append(1).append(false);
        System.out.println(sb);
    }

    @Test
    public void test03() {
        //String -> StringBuilder
        String strA = "Hello";
        System.out.println("strA:" + strA);
        StringBuilder sb = new StringBuilder(strA);
        sb.append("World");
        System.out.println("sb:" + sb);
        //StringBuilder ->String
        String strB = sb.toString();
        System.out.println("strB:" + strB);
    }
}
