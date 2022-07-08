package com.mori.designmode.wrap;

/**
 * School类 对 Student类进行包装，对原有功能进行升级
 *
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 3:01
 */
public class SchoolStudent implements Coder {

    //1、获取被装饰类的引用
    private Student student;

    //2、构造方法中传入被包装类的对象（装饰类获取被装饰类对象）
    public SchoolStudent(Student student) {
        this.student = student;
    }

    @Override
    public void code() {
        student.code(); //3、对原有功能进行升级
        System.out.println("数据库");
        System.out.println("框架");
        System.out.println("大数据…");
    }
}

