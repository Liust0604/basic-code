package com.mori.course02.demoannotation;

import com.mori.course02.demoannotation.anno.Pro;

import java.lang.reflect.Method;

/**
 * 框架类：现在用注解来实现
 * 实现功能：不能改变该类的任何代码的前提下，可以创建任意类的对象，并执行其中任意方法
 * 思路：通过1、配置文件 来指定类，利用2、反射技术 创建对象
 * <p>
 * 不用配置文件，用注解
 */
@Pro(className = "com.mori.course02.demoannotation.domain.AnnoDemo", methodName = "show2")
class ReflectTest {
    public static void main(String[] args) throws Exception {
        //1、解析注解
        //a、获取当前类的字节码对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //b、获取该类上标注的注解对象。
        //其实是在内存中生成了一个该注解接口的实现类对象。重写接口方法的返回的就是在注解中赋值的内容
        Pro pro = reflectTestClass.getAnnotation(Pro.class);
        //c、调用注解的抽象方法，获取返回值
        String className = pro.className();
        String methodName = pro.methodName();

        //2、反射技术，类加载进入内存
        Class cls = Class.forName(className);
        Object o = cls.newInstance(); //创建对象
        Method method = cls.getMethod(methodName); //获取方法
        //执行方法
        method.invoke(o);
    }
}
