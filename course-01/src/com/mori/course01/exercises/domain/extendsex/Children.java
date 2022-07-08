package com.mori.course01.exercises.domain.extendsex;

public class Children extends Father {
    public int numC = 20;
    public int num = 200;

    public void methodC() {
        System.out.println(num);
    }

    public void method() {
        int num = 300;
        System.out.println(num);        //局部变量，300
        System.out.println(this.num);   //本类的成员变量，200
        System.out.println(super.num);  //父类的成员变量，100
    }

    public void methodover() {
        System.out.println("孩子的methodover方法执行了！");
    }
}
