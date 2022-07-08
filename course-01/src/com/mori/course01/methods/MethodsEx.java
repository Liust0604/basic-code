package com.mori.course01.methods;

import org.junit.Test;

import java.util.Arrays;

public class MethodsEx {
    MethodsDemo methodsDemo = new MethodsDemo();

    @Test
    public void test01() {
        methodsDemo.print();
    }

    @Test
    public void test02() {
        int sum = methodsDemo.getSum(10, 5);
        System.out.println(sum);
    }

    @Test
    public void test03() {
        System.out.println(methodsDemo.isSame(10, 10));
        System.out.println(methodsDemo.isSame(10, 5));
    }

    @Test
    public void test04() {
        System.out.println(methodsDemo.getDefnSum());
    }

    @Test
    public void test05() {
        System.out.println(methodsDemo.sum(1, 2));
        System.out.println(methodsDemo.sum(1, 2, 3));
        System.out.println(methodsDemo.sum(1, 2, 3, 4));
        System.out.println(methodsDemo.sum(1, 5.5));
        System.out.println(methodsDemo.sum(5.5, 1));
    }

    //数组
    @Test
    public void test06() {
        //int[] array = new int[3];
        int[] array = {10, 20, 30};

        System.out.println("=打印=");
        //[I@5d6f64b1 ：数组对应的内存地址哈希值
        //[:数组 I:int @后数字:一串16进制内存地址哈希值
        System.out.println(array);

        //元素
        System.out.println(array[0]);
        System.out.println(array[1]);
        int num = array[2];
        System.out.println(num);

        //遍历
        System.out.println("=遍历=");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //求数组最大值
        System.out.println("最大值：" + methodsDemo.getArrMax(array));

        //元素反转
        System.out.println("=反转=");
        int[] arr1 = methodsDemo.arrReverse(new int[]{1, 2, 3, 4, 5});
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("");
        int[] arr2 = methodsDemo.arrReverse1(new int[]{1, 2, 3, 4});
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    //二维数组
    @Test
    public void test07() {
        int[][] arr = new int[2][]; //二维数组中含有两个数组，每个数组中3个元素，两行三列
        System.out.println(Arrays.toString(arr));
        arr[0] = new int[]{1, 2};
        arr[1] = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(arr));
        print2D(arr);
    }

    //遍历二维数组
    public static void print2D(int[][] arr2d) {
        for (int i = 0; i < arr2d.length; i++) {
            int[] arr = arr2d[i];
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j];
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
