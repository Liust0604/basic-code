package com.mori.course02.demojdk8;

import com.mori.course02.demojdk8.domain.*;
import com.mori.course02.demojdk8.service.ArrayBuilder;
import com.mori.course02.demojdk8.service.Calcable;
import com.mori.course02.demojdk8.service.PersonBuilder;
import com.mori.course02.demojdk8.service.PrintTable;
import org.junit.Test;

public class MethodDemo {

    @Test
    public void test01() {
        printString("Hello", (s) -> {
            System.out.println(s);
        });

        //方法引用，优化Lambda表达式
        //1、对象已存在(System.out)
        //2、方法已存在(println(s))
        //3、传参都是字符串
        //所以可以使用方法引用来优化：System.out对象直接引用println(s)方法，省略参数
        printString("Hello", System.out::println);

    }

    private void printString(String s, PrintTable pt) {
        pt.print(s);
    }

    @Test
    public void test2() {
        //对象名引用成员方法
        //Object对象已存在；打印大写的方法已存在；传参都是字符串
        //MethodReferObject的对象引用printUpperCaseString方法
        MethodReferObject obj = new MethodReferObject();
        printString("Hello", obj::printUpperCaseString);
    }

    @Test
    public void test3() {
        //类名引用静态方法
        //类名Math已存在，静态方法abs()已存在
        //Math类引用abs静态方法
        int number = calc(-10, Math::abs);
        System.out.println(number);
    }

    private int calc(int num, Calcable c) {
        return c.calcAbs(num);
    }

    @Test
    public void test4() {
        //通过super引用成员方法
        Man man = new Man();
        man.show();
    }

    @Test
    public void test5() {
        //通过this引用成员方法
        Man man = new Man();
        man.happy();
    }


    @Test
    public void test6() {
        /*printName("小明", (name) -> {
            return new Person(name);
        });*/
        //引用类的构造方法
        //构造方法已知，创建对象已知
        printName("小明", Person::new);
    }

    public void printName(String name, PersonBuilder pb) {
        Person p = pb.buildPerson(name);
        System.out.println(p.getName());
    }

    @Test
    public void test7() {
        //引用数组的构造方法
        //int[] arr = createArray(10, lenth -> new int[lenth]);
        //创建数组已知，长度已知
        int[] arr = createArray(10, int[]::new);
        System.out.println(arr.length);
    }

    public int[] createArray(int len, ArrayBuilder ab) {
        return ab.builderArray(len);
    }
}
