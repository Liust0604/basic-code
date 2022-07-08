package com.mori.course02.demoexception;

import com.mori.course02.demoexception.exception.RegisterException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExceptionDemo {

    @Test
    /**
     * 异常
     * */
    public void Test01() /*throws ParseException*/ {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //编译时异常，在编写代码的时候，就会报红提示让用户处理该异常
        //异常可以被处理，在编写代码时处理即可
        try {
            Date date = sdf.parse("199806-04");
        } catch (ParseException e) {
            //java.text.ParseException
            //System.out.println(e instanceof RuntimeException);
            e.printStackTrace();
        }

        System.out.println("=====后续代码=========");

        //运行时异常：编写代码时不报红，当代码运行到这里时才会发现异常抛出
        //异常可以被处理，发现运行有错误之后，再修改代码处理即可
        try {
            //可能会出现异常的代码
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            //异常的处理逻辑
            //java.lang.ArrayIndexOutOfBoundsException
            System.out.println(e instanceof RuntimeException);
            e.printStackTrace();
        }

        System.out.println("=====后续代码=========");

        //Error
        //内存溢出错误：java.lang.OutOfMemoryError。超过了jvm分配的内存
        //如果不修改代码的话，这个错误无法被处理。只可以被避免，就是不处理错误了，而是修改原来的逻辑
        int[] arr = new int[1024 * 1024 * 1024];
    }


    @Test
    /**
     *  throw 抛出异常
     * */
    public void Test02() {
        getElement(null, 0);
        //getElement(new int[]{100, 1, 2}, -1);
    }

    public int getElement(int[] arr, int index) {
        //对参数进行合法性校验
/*        if (arr == null || arr.length == 0) {
            //空指针异常 NullPointerException 运行时异常，不用处理，交给jvm
            throw new NullPointerException("传递的数组为空");
        }*/

        //判断对象是否为空
        Objects.requireNonNull(arr, "传递的数组为空");

        if (index < 0 || index > arr.length - 1) {
            //数组越界异常 运行时异常
            throw new ArrayIndexOutOfBoundsException("传递的索引超出了数组范围");
        }

        int ele = arr[index];
        return ele;
    }

    @Test
    /**
     * throws 声明抛出方法
     * */
    public void Test03() /*throws FileNotFoundException, IOException*/ throws Exception {
        //readFile("c:\\\\b.text");
        readFile("c:\\\\a.jpg");
    }

    //FileNotFoundException是IOException，所以 throws IOException 即可，甚至可以 throws Exception
    public void readFile(String fileName) /*throws FileNotFoundException, IOException*/ throws IOException {
        if (!fileName.endsWith(".txt")) {
            //报红，编译时异常 未找到文件异常 java.io.FileNotFoundException
            throw new IOException("文件后缀名不对！");
        }

        if (!"c:\\\\a.text".equals(fileName)) {
            //报红，编译时异常 未找到文件异常 java.io.FileNotFoundException
            throw new FileNotFoundException("传递路径不符合条件！");
        }
    }

    @Test
    /**
     * try…catch 捕获异常
     * 父类Throwable定义3个处理异常的办法
     * */
    public void Test04() {
        try {
            readFile1("c:\\\\a.jpg");
        } catch (IOException e) { //try中抛出什么异常，catch就定义什么异常变量，用来接收这个异常对象
            System.out.println(e.getMessage());
            System.out.println(e);
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void readFile1(String fileName) throws IOException {
        if (!fileName.endsWith(".txt")) {
            //报红，编译时异常 未找到文件异常 java.io.FileNotFoundException
            throw new IOException("文件后缀名不对！");
        }
    }

    @Test
    /**
     * finally 代码块
     * */
    public void Test05() {
        try {
            readFile1("c:\\\\a.jpg");
        } catch (IOException e) { //try中抛出什么异常，catch就定义什么异常变量，用来接收这个异常对象
            e.printStackTrace();
        } finally {
            System.out.println("资源释放");
        }
    }

    @Test
    /**
     * 多异常捕获处理
     * */
    public void Test06() {
        //1、分开捕获，分开处理
        //互不影响，都能处理，后面的也能执行

        //2、一次捕获，多次处理
        //只会处理第一个抛出的异常，try内后面的代码不会执行
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]); //java.lang.ArrayIndexOutOfBoundsException

            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println(list.get(3)); //java.lang.IndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //3、一次捕获，一次处理：一个catch内捕获父类异常即可
        //只会处理第一个抛出的异常，try内后面的代码不会执行
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]); //java.lang.ArrayIndexOutOfBoundsException

            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println(list.get(3)); //java.lang.IndexOutOfBoundsException
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    /**
     * finally 和 return
     * */
    public void Test07() {
        System.out.println(getA());
    }

    public String getA() {
        String a = "默认";
        try {
            int i = 10 % 0;
            return a;
        } catch (Exception e) {
            a = "catch";
            System.out.println(e);
        } finally {
            return "finally";
        }
    }

    @Test
    /**
     *  案例：注册
     *  若用户存在，则抛出异常；若用户不存在，注册成功！
     * */
    public void exceptionEx01() {
        List<String> users = new ArrayList<>(); //不能用Arrays.asList() 因为底层是数组，所以不允许添加元素
        users.add("AAA");
        users.add("BBB");
        users.add("CCC");
        Scanner sc = new Scanner(System.in);
        boolean isRegister = false;
        while (!isRegister) {
            System.out.print("请输入用户名：");
            String name = sc.next();
            System.out.println(name);
            try {
                register(users, name);
                System.out.println("注册成功！" + name);
                System.out.println(users);
                isRegister = true;
            } catch (RegisterException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void register(List<String> users, String name) throws RegisterException {
        if (users.indexOf(name) != -1) {
            throw new RegisterException("用户名已存在,请重新输入!");
        }
        users.add(name);
    }
}
