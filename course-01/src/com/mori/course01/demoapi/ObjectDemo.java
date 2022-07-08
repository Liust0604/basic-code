package com.mori.course01.demoapi;

import com.mori.course01.demoapi.domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectDemo {

    /**
     * Object的toString方法
     */
    @Test
    public void toStringTest() {
        //toString：默认打印对象内存中的地址值。
        Random r = new Random();
        System.out.println(r);

        //可重写toString()方法
        Person person = new Person();
        System.out.println(person.toString());
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
    }

    /**
     * Object的equals方法
     */
    @Test
    public void equalsTest() {
        //可重写equals方法
        Person p1 = new Person("AAA", 22);
        Person p2 = new Person("AAA", 22);
        Person p3 = new Person("BBB", 33);
        System.out.println(p1.equals(p1));
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(p1.equals(null));
    }

    /**
     * Object的hashCode()方法
     */
    @Test
    public void hashCodeTest() {
        //Person继承了Object类，所以可以使用Object的hashCode方法
        Person p1 = new Person();
        int h1 = p1.hashCode();
        System.out.println(p1);
        System.out.println(h1);

        //toString()方法源码：return getClass().getName() + "@" + Integer.toHexString(hashCode()); hashCode是十进制，后面拼接的是哈希码的十六进制表现形式
        Person p2 = new Person();
        int h2 = p2.hashCode();
        System.out.println(p2);
        System.out.println(h2);

        //若重写了hashCode方法，返回值和toString()显示的都是1，但是仍然不相等。因为==比较的是物理地址
        System.out.println(p1 == p2);

        //String的hash值
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode()); //96354
        System.out.println(s2.hashCode()); //96354

        System.out.println("AAA".hashCode()); //64545
        System.out.println("AAA".hashCode()); //64545
        System.out.println("你好".hashCode()); //652829
    }
}
