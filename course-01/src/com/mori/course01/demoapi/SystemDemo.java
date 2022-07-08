package com.mori.course01.demoapi;

import org.junit.Test;

import java.util.Arrays;

public class SystemDemo {
    @Test
    public void Test01() {
        Long start = System.currentTimeMillis();

        for (int i = 0; i < 999; i++) {
            System.out.println(i);
        }
        Long end = System.currentTimeMillis();

        System.out.println("程序耗时：" + (end - start) + "ms");
    }

    @Test
    /**
     * 复制数组
     * */
    public void Test02() {
        int[] src = new int[]{1, 2, 3, 4, 5};
        int[] dest = new int[]{6, 7, 8, 9, 10};

        System.out.println("复制前：" + Arrays.toString(dest));
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println("复制后：" + Arrays.toString(dest));
    }

}
