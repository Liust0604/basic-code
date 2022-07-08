package com.mori.course02.demoannotation.ex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单测试框架。当主方法执行后，会自动检测所有加了@Check注解的方法,若有异常，记录到文件中
 *
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 2:14
 */
public class CheckTest {
    public static void main(String[] args) throws IOException {
        //1、创建对象，获取字节码对象，通过字节码对象获取所有方法
        Calculator cal = new Calculator();
        Class cls = cal.getClass();
        Method[] methods = cls.getMethods();
        //2、遍历方法判断是否有@Checked注解，有则执行
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt")); //输出流
        int num = 0; //记录出现异常的次数
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                //有@Checked注解，则执行方法
                try {
                    method.invoke(cal);
                } catch (Exception e) {
                    num++;
                    //3、捕获异常，记录到文件
                    bw.write(method.getName() + " 方法出现异常！");
                    bw.newLine();
                    bw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("---------------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次一共出现：" + num + "次异常！");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
