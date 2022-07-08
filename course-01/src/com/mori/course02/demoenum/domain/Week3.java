package com.mori.course02.demoenum.domain;

public abstract class Week3 {

    private String name;

    //使用匿名内部类，必须重写抽象方法。每个对象重写都实现show()方法
    public static final Week3 MON = new Week3("星期一") {
        @Override
        public void show() {
            System.out.println("星期一");
        }
    };
    public static final Week3 TUE = new Week3("星期二") {
        @Override
        public void show() {
            System.out.println("星期二");
        }
    };
    public static final Week3 WED = new Week3("星期三") {
        @Override
        public void show() {
            System.out.println("星期三");
        }
    };

    public Week3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //定义一个抽象方法，必须在抽象类里
    public abstract void show();
}
