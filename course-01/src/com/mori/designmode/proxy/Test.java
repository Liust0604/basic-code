package com.mori.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式
 */
public class Test {
    public static void main(String[] args) {
        //1、创建真实对象
        Lenovo lenovo = new Lenovo();

        //2、动态代理，增强lenovo对象
        SaleComputer LenovoProxy = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法，代理对象调用的所有方法，都会触发该方法执行
             *
             * 1、proxy 代理对象 一般不用
             * 2、method 代理对象调用的方法，封装为对象
             * 3、args 代理对象调用方法时，传递的实参
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //System.out.println("代理对象的处理器方法invoke执行了……" + "   " + method.getName() + "   " + Arrays.toString(args));

                String methodName = method.getName();
                if ("sale".equals(methodName)) {
                    //1、增强参数
                    double money = (double) args[0] * 0.85;
                    System.out.println("专车接你……"); //3、增强方法体
                    String res = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货……"); //3、增强方法体
                    //2、增强返回值
                    return (res + " + 鼠标垫");
                }

                //利用反射机制，真实对象执行该方法
                Object obj = method.invoke(lenovo, args);
                return obj;
            }
        });

        //3、调用方法
        System.out.println("==========真实对象===========");
        String computer1 = lenovo.sale(8000);
        System.out.println(computer1);
        lenovo.show();
        System.out.println("==========代理对象===========");
        String computer2 = LenovoProxy.sale(8000);
        System.out.println(computer2);
        LenovoProxy.show();
    }
}
