package com.mori.course01.exercises.domain.extendsex;

//老手机作为新手机的父类，新手机可以使用老手机原来的功能，也可以扩展新的show功能
public class NewPhone extends OldPhone {

    int num = 10;

    public NewPhone() {
        //super(); //默认调用父类无参构造
        super(10); //自定义调用父类无参构造
        System.out.println("子类构造方法");
        System.out.println("==1、子类的构造方法中，访问父类的构造方法");
    }

    @Override
    public void show() {
        super.show(); //执行父类的方法
        //子类添加更多内容
        System.out.println("显示姓名…");
        System.out.println("显示头像…");
    }

    /*public void method() {
        super(); //错误写法：只有子类构造方法，才能调用父类构造方法。
    }*/

    public void methodZi() {
        System.out.println("子类的成员变量num：" + num);
        System.out.println("==2、在子类的成员方法中，访问父类的成员变量num：" + super.num);
        System.out.println("子类的成员方法method：");
        method();
        System.out.println("==3、在子类的成员方法中，访问父类的成员方法method：");
        super.method();
    }

    public void method() {
        System.out.println("子类的成员方法…");
    }
}
