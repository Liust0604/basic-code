package com.mori.course02.demojdk8;

import com.mori.course02.demojdk8.service.MyFunctionalInterface;
import com.mori.course02.demojdk8.service.impl.MyFunctionalInterfaceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalDemo {

    @Test
    public void test01() {
        //前提：方法参数是接口
        //1、可传入接口的实现类对象(向上转型)
        show(new MyFunctionalInterfaceImpl());
        //2、可传入接口的匿名内部类
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口方法");
            }
        });
        //3、若接口是函数式接口，可以使用Lambda表达式
        show(() -> System.out.println("使用Lambda表达式重写接口方法(函数式编程)"));
    }

    //一个方法，参数是一个接口(函数式接口)
    public static void show(MyFunctionalInterface myInter) {
        myInter.method();
    }

    @Test
    public void test02() {
        //参数是一个接口。可以传递 1、实现类对象；2、匿名内部类
        //3、接口是函数式接口,Lambda表达式作为参数
        startThread(() -> System.out.println(Thread.currentThread().getName()));

        //Comparator是函数式接口，Lambda表达式作为返回值
        String[] arr = {"afdafd", "gggg", "1111111111111"};
        Arrays.sort(arr, getComparator());
        System.out.println(Arrays.toString(arr));
    }

    public static void startThread(Runnable run) {
        new Thread(run).start();
    }

    public Comparator<String> getComparator() {
        //可以返回匿名内部类
        /*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() -  o1.length();
            }
        };*/
        return (o1, o2) -> o2.length() - o1.length(); //根据方法指定的返回值类型，确定Lambda表达式要实现的接口
    }

    /*常用函数式接口*/

    @Test
    //Supplier接口
    public void test03() {
        String s = getString(() -> "Supplier接口："); //生产一个字符串，并返回
        System.out.println(s);

        int[] arr = {10, -1, 200, 12, 450, 56};
        int max = getMax(() -> {  //生产一个Integer类型的数
            int temp = arr.length == 0 ? 0 : arr[0];
            for (int i : arr) {
                if (i > temp) temp = i;
            }
            return temp;
        });
        System.out.println(max);
    }

    public static String getString(Supplier<String> sub) {
        return sub.get();  //Supplier函数式接口，泛型指定String，get()就会返回String类型的数据
    }

    public static Integer getMax(Supplier<Integer> sub) {
        return sub.get();
    }

    @Test
    //Consumer接口
    public void test04() {
        spendName("Consumer接口：", (name) -> {  //消费传递的字符串
            //消费方式：反转字符串
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });

        spendCon("默认方法andThen", (s) -> {  //消费传递的字符串
            System.out.println(s.toUpperCase());
        }, (s) -> {
            System.out.println(s.toLowerCase());
        });

        String[] arr = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        printInfo(arr, (s) -> {  //消费传递的字符串
            String name = s.split(",")[0];
            System.out.print("姓名：" + name + "。");
        }, (s) -> {
            String sex = s.split(",")[1];
            System.out.print("性别：" + sex + "。");
        });

    }

    public static void spendName(String name, Consumer<String> con) {
        con.accept(name);
    }

    public static void spendCon(String s, Consumer<String> con1, Consumer<String> con2) {
        /*con1.accept(s);
        con2.accept(s);*/
        con1.andThen(con2).accept(s);
    }

    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        for (String s : arr) {
            con1.andThen(con2).accept(s);
        }
    }

    @Test
    //Predicate接口
    public void test05() {
        boolean flag = checkString("Predicate：", s -> s.length() > 5);
        System.out.println(flag);

        boolean flag1 = checkString1("13324231a", s -> s.length() > 5, s -> s.contains("a"));
        System.out.println(flag1);

        boolean flag2 = checkString2("Predicate：", s -> s.length() > 5);
        System.out.println(flag2);

        String[] arr = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        List<String> list = checkInfo(arr, (s) -> {  //消费传递的字符串
            String name = s.split(",")[0];
            return name.length() == 4;
        }, (s) -> {
            String sex = s.split(",")[1];
            return "女".equals(sex);
        });
        System.out.println(list);
    }

    public static boolean checkString(String s, Predicate<String> pre) {
        return pre.test(s);
    }

    public static boolean checkString1(String s, Predicate<String> pre1, Predicate<String> pre2) {
        // return pre1.test(s) && pre2.test(s);
        return pre1.and(pre2).test(s);
        //return pre1.or(pre2).test(s);
    }

    public static boolean checkString2(String s, Predicate<String> pre) {
        //return !pre.test(s);
        return pre.negate().test(s);
    }

    public static List<String> checkInfo(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            boolean flag = pre1.and(pre2).test(s);
            if (flag) list.add(s);
        }
        return list;
    }

    @Test
    //Function 接口
    public void test06() {
        Integer in = changeInt("10", s -> Integer.valueOf(s));
        System.out.println(in);

        change("123", s -> Integer.parseInt(s) + 10, i -> String.valueOf(i));
    }

    public static Integer changeInt(String s, Function<String, Integer> fun) {
        return fun.apply(s);
    }

    public static void change(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        String str = fun1.andThen(fun2).apply(s);
        System.out.println(str);
    }
}
