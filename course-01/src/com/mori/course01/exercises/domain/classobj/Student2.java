package com.mori.course01.exercises.domain.classobj;

/**
 * 静态static关键字
 */
public class Student2 {

    private int id;
    private String name;
    private int age;
    //static修饰的成员变量
    public static String room;
    private static int idCounter = 0;//学号计数器，每当new一个新对象，计数器+1

    public Student2() {
        this.id = ++idCounter;
        System.out.println("构造方法执行！");
    }

    public Student2(String name, int age) {
        this.id = ++idCounter;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void method() {
        System.out.println("这是一个普通成员方法！");
        //成员方法可以访问静态变量
        System.out.println(room);
        //成员方法可以访问成员变量
        System.out.println(name);
    }

    public static void methodStatic() {
        System.out.println("这是一个静态成员方法！");
        //静态方法可以访问静态变量
        System.out.println(room);
        //静态方法不能访问成员变量
        /*System.out.println(name); //【错误】*/
        //静态方法不能使用this关键字
        /*System.out.println(this); //【错误】*/
    }

    public int getIdCounter() {
        return this.idCounter;
    }

    static {
        System.out.println("静态代码块执行！");
    }

}
