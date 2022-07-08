package com.mori.course02.demojdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("赵强");
        list.add("张三丰");

        list.stream().filter(name -> name.startsWith("张")) //过滤
                .filter(name -> name.length() == 3)  //过滤
                .forEach(name -> System.out.println(name)); //遍历
    }

    @Test
    public void test02() {
        Stream<String> stream = Stream.of("AAA", "BBB", "CCC");
        stream.forEach(s -> System.out.println(s));
    }

    @Test
    public void test03() {
        Stream<String> stream = Stream.of("张一", "张儿", "张三", "李四");
        Stream<String> stream1 = stream.filter(name -> name.startsWith("张")); //延迟方法，仍然返回流
        stream1.forEach(s -> System.out.println(s));

        //Stream只能被使用一次
        //java.lang.IllegalStateException: stream has already been operated upon or closed
        //stream.forEach(s -> System.out.println(s));
    }

    @Test
    public void test04() {
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        Stream<Integer> stream1 = stream.map(s -> Integer.valueOf(s));
        stream1.forEach(s -> System.out.println(s));
    }

    @Test
    public void test05() {
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        long count = stream.count();
        System.out.println(count);
    }

    @Test
    public void test06() {
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");
        Stream<String> stream1 = stream.limit(3);  //1、2、3
        stream1.forEach(s -> System.out.println(s));
    }

    @Test
    public void test07() {
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");
        Stream<String> stream1 = stream.skip(3);  //4、5
        stream1.forEach(s -> System.out.println(s));
    }

    @Test
    public void test08() {
        Stream<String> stream1 = Stream.of("1", "2", "3");
        Stream<String> stream2 = Stream.of("A", "B", "C");

        Stream<String> stream = Stream.concat(stream1, stream2);
        stream.forEach(s -> System.out.println(s));
    }

}
