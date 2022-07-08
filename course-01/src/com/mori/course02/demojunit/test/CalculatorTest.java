package com.mori.course02.demojunit.test;

import com.mori.course02.demojunit.domain.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 初始化方法。加上@Before注解，在所有测试方法执行前，都会执行该方法。常用于资源申请
     */
    @Before
    public void init() {
        System.out.println("init…");
    }

    /**
     * 关闭方法。加上@After注解，在所有测试方法执行后，都会执行该方法。常用于资源释放
     */
    @After
    public void close() {
        System.out.println("close…");
    }

    @Test
    public void testAdd() {
        Calculator cal = new Calculator();
        int sum = cal.add(1, 2);
        //System.out.println(sum);

        //通常输出是执行成功的，但不能确定是否是期望的结果
        //断言。通过断言指定期望结果，和测试结果比较
        Assert.assertEquals(3, sum);
    }
}
