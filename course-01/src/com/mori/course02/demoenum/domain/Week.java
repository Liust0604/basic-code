package com.mori.course02.demoenum.domain;

/**
 * 自己实现枚举类，空参构造
 */
public class Week {

    public static final Week MON = new Week(); //先初始化静态属性，可以调用构造方法(不属于非静态)。但是不能调用非静态方法
    public static final Week TUE = new Week();
    public static final Week WED = new Week();

    private Week() { //构造方法改为私有，不让其他类创建本类对象

    }
}
