package com.mori.course01.exercises.domain.innerclass;

public class Outer {

    int num = 10; //外部类的成员变量

    public class Inner { //成员内部类
        int num = 20; //内部类的成员变量

        public void methodInner() {
            int num = 30; //内部类成员方法的成员变量
            System.out.println(num); //局部变量，就近原则
            System.out.println(this.num); //本类（内部类）的成员变量
            System.out.println(Outer.this.num); //外部类的成员变量（注意内部类和外部类不是继承关系，不能用super，得用特殊格式）
        }
    }

    public void methodOuter() {
        int num = 50; // 实际上是被省略了的final修饰，保证内部类生命周期内一直存在这个常量
        class Inner { //局部内部类
            //int num = 40;

            public void methodInner() {
                System.out.println(num);
            }
        }
        Inner inner = new Inner();
        inner.methodInner();
    }
}
