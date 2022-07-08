package com.mori.course01.demoapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WrapperDemo {
    @Test
    public void Test01() {
        //装箱
        //Integer in1 = new Integer(1);
        Integer in1 = 1; // 自动装箱，相当于 Integer in1 = new Integer(1);
        Integer in2 = Integer.valueOf(1);
        Integer in3 = new Integer("2"); //注意不能写成 Integer in3 = "2";
        Integer in4 = Integer.valueOf("2"); //若无法转换为Integer类型，则报数字格式化异常java.lang.NumberFormatException
        System.out.println(in1); //重写了toString方法
        System.out.println(in2);
        System.out.println(in3);
        System.out.println(in4);

        List<Integer> list = new ArrayList<>();
        list.add(1); //自动装箱
        int k = list.get(0); //自动拆箱

        //拆箱
        System.out.println("=====");
        int i = in1.intValue();
        System.out.println(i);
        Integer j = in1 + 2; //先自动拆箱，相当于 int j = in1.intValue() + 2; 再自动装箱，Integer j = 3;
        System.out.println(j);
    }

    @Test
    /**
     * 基本数据类型与字符串之间的相互转换
     * */
    public void Test02() {
        //基本数据类型->字符串String
        String s1 = 100 + "";
        System.out.println(s1 + 200);

        String s3 = String.valueOf(100);
        System.out.println(s3 + 200);

        String s2 = Integer.toString(100);
        System.out.println(s2 + 200);

        //字符串String -> 基本数据类型
        Integer i = Integer.parseInt("100"); //NumberFormatException
        System.out.println(i + 200);
    }

    @Test
    public void Test03() {
        //A、装箱 基本->引用
        Integer integer1 = 100; //1、自动装箱
        Integer integer2 = new Integer(100); //2、创建一个包装对象
        Integer integer3 = Integer.valueOf(100); //3、包装对象的值来自于什么值

        //B、拆箱 引用到->基本
        int i1 = integer1; //1、自动拆箱
        int i2 = integer1.intValue(); //2、包装对象得到原来的值

        //C、不是拆箱也不是装箱，只是包装类有个可以字符串转基本数据类型的方法parse
        int i3 = Integer.parseInt("100");
    }
}
