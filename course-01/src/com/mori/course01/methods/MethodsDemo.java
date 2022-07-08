package com.mori.course01.methods;

public class MethodsDemo {
    /**
     * 打印矩形
     */
    public void print() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    /**
     * 两数求和
     */
    public int getSum(int a, int b) {
        int result = a + b;
        return result;
    }

    /**
     * 判断两个数字是否相同
     */
    public boolean isSame(int a, int b) {
        boolean same;
/*        if (a == b) {
            same = true;
        } else {
            same = false;
        }*/

        /* same = a == b ? true : false;*/
        return a == b;
    }

    /**
     * 求1~100之和
     */
    public int getDefnSum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * void没有返回值，不能写return 返回值;return;只是结束方法
     */
    public void method() {
        return; //可省略
    }

    /**
     * 方法重载，求和
     */
    //参数个数不同
    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    public int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    //参数类型不同
    public int sum(int a, double b) {
        return (int) (a + b);
    }

    //参数多类型数量不同
    public int sum(double a, int b) {
        return (int) (a + b);
    }

    //错误写法：重载与参数名无关
    //sum(int a,int b)和sum(int x,int y)仍然会冲突报错
    /*
        public int sum(int x, int y) {
            return (int) (x + y);
        }
    */
    //错误写法：重载与返回值类型无关，方法名、参数相同时，无法区分是返回的是哪种类型的方法
    //int sum(int a, int b)和double sum(int a, int b)仍然会冲突报错
    /*
        public double sum(int a, int b) {
            return (double) a + b;
        }
    */

    /**
     * 数组,求数组中的最大值
     */
    public int getArrMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 数组,数组反转
     */
    public int[] arrReverse(int[] array) {
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {  //双数数组：4/2 = 2 -> 0/1;2/3  单数数组：5/2 = 2 -> 0/1;2/3/4 ，交换的数量仅为前面2个
            int temp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = temp;
        }
        return array;
    }

    public int[] arrReverse1(int[] array) {
        /*
        int min = 0;
        int max = array.length - 1;
        while (min < max) { //双数：最后指向中间2/1，单数：最后指向中间2/2,都不符合继续循环的条件，只有min < max，即(1<2和1<3)符合条件
            int temp = array[min];
            array[min++] = array[max];
            array[max--] = temp; //循环前min和max分别在数组两端，每次循环最后，min向后移动一格，max向前移动一格
        }
         */

        //同上面的写法
        for (int min = 0, max = array.length - 1; min < max; min++, max--) {
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }
        return array;
    }
}
