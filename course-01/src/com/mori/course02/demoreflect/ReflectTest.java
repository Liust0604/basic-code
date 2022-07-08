package com.mori.course02.demoreflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类：
 * 实现功能：不能改变该类的任何代码的前提下，可以创建任意类的对象，并执行其中任意方法
 * 思路：通过1、配置文件 来指定类，利用2、反射技术 创建对象
 * 步骤：
 * 1、类的全类名 和 方法 定义在配置文件中
 * 2、程序中读取配置文件pro.properties，得到要创建对象的类文件
 * 3、反射技术，把类文件加载到内存
 * 4、创建对象并执行方法
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //1、加载配置文件
        Properties pro = new Properties();
        //需要获取配置文件路径，通过类加载器获取
        ClassLoader classLoader = ReflectTest.class.getClassLoader(); //获取类加载器
        InputStream is = classLoader.getResourceAsStream("pro.properties");//通过类加载器找到配置文件资源
        pro.load(is); //加载配置文件
        //获取配置文件中数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");


        //2、反射技术，类加载进入内存
        Class cls = Class.forName(className);
        Object o = cls.newInstance(); //创建对象
        Method method = cls.getMethod(methodName); //获取方法
        //执行方法
        method.invoke(o);
    }
}
