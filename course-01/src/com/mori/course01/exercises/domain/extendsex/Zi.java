package com.mori.course01.exercises.domain.extendsex;

public class Zi extends Fu {

    int num = 33;

    public Zi() {
        // super(); //和this()构造调用一起是错误写法，super()不再赠送。
        this(123); //本类的无参构造，调用了本类的有参构造。
        // this(1,2); //错误写法，this()构造调用只能唯一第一行。
        System.out.println("子类的构造方法1：");
    }

    public Zi(int n) {
        this(1, 2);
        System.out.println("子类的构造方法2：" + n);
    }

    public Zi(int n, int m) {
        //super();
        super(0);
        System.out.println("子类的构造方法3：" + n + "," + m);
    }

    /**
     * 子类返回值范围 <= 父类返回值类型
     * 子类返回值类型String的范围小于父类返回值类型Object,所以可以成立
     */
    @Override
    public String m1() {  //扩展：java.lang.Object是所有类的公共最高父类，java.lang.String就是Object的子类
        return null;
    }

    /**
     * 子类方法权限 >= 父类方法权限
     * 子类方法权限public的范围大于父类方法权限(defalut),所以可以成立
     */
    @Override
    public String m2() {  //扩展：权限大小：private < protect < (default) < public
        return null;
    }

    public void showNum() {
        int num = 11;
        System.out.println("===");
        System.out.println("局部变量：" + num);
        System.out.println("本类成员变量：" + this.num);
        System.out.println("父类成员变量：" + super.num);

        System.out.println("===");
        System.out.println("本类另一个成员方法：");
        this.methodA();

    }

    public void methodA() {
        System.out.println("AAA");
    }

}
