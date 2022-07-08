package com.mori.course02.demoreflect;

import com.mori.course02.demoreflect.domain.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

    @Test
    public void test01() throws ClassNotFoundException {
        //1、加载.class字节码文件，返回Class对象
        Class cls1 = Class.forName("com.mori.course02.demoreflect.domain.Person");
        System.out.println(cls1);

        //通过类获取Class对象
        Class cls2 = Person.class;
        System.out.println(cls2);

        //通过对象获取Class对象
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);

        //比较Class对象，指向堆内存统一个对象
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        System.out.println(cls2 == cls3);
    }

    @Test
    public void test02() throws NoSuchFieldException, IllegalAccessException {
        //获取Class对象
        Class personClass = Person.class;
        //获取成员变量：public修饰的
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-----------------------");
        //获取所有成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("-----------------------");
        Person p = new Person("小明", 12);
        //操作成员变量
        Field fieldStr = personClass.getField("str"); //没有该成员变量会报异常 NoSuchFieldException
        Object strVal = fieldStr.get(p);//传入的是一个需要获取成员变量的对象
        System.out.println(strVal);
        fieldStr.set(p, "字符串");
        System.out.println(p);
        System.out.println("-----------------------");
        Field fieldName = personClass.getDeclaredField("name");
        fieldName.setAccessible(true); //暴力反射
        Object nameVal = fieldName.get(p); //若是私有的成员变量，会报非法访问异常 IllegalAccessException。需要忽略权限修饰符安全检查（暴力反射）
        System.out.println(nameVal);
        fieldName.set(p, "小红");
        System.out.println(p);
    }

    @Test
    public void test03() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class personClass = Person.class;
        //获取构造方法
        Constructor[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-----------------------");
        Constructor constructor = personClass.getConstructor(String.class, int.class);//根据参数区分构造方法。若没有该构造方法会抛出异常 NoSuchMethodException
        System.out.println(constructor);
        //创建对象.IllegalAccessException 非法访问异常；InvocationTargetException；调用目标异常 InvocationTargetException；实例化异常
        Object person = constructor.newInstance("张三", 23); //按照指定构造方法传参
        System.out.println(person);
        //空参构造
        Object person2 = personClass.newInstance();
        System.out.println(person2);
        System.out.println("-----------------------");
        //constructor.setAccessible(true);
    }

    @Test
    public void test04() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class personClass = Person.class; //根据方法名和参数列表区分成员方法
        //执行方法
        Method eatMethod = personClass.getMethod("eat");//NoSuchMethodException
        Person p = new Person();
        eatMethod.invoke(p); //调用方法。IllegalAccessException 非法访问异常；InvocationTargetException；调用目标异常

        Method eatMethod2 = personClass.getMethod("eat", String.class);
        eatMethod2.invoke(p, "水果");

        System.out.println("-----------------------");

        //若getMethods，则会显示包含父类的方法
        //eatMethod.setAccessible(true);
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    @Test
    public void test05() {
        Class personClass = Person.class;
        String className = personClass.getName(); //全类名
        System.out.println(className);
    }

}
