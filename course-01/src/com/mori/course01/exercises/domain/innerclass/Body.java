package com.mori.course01.exercises.domain.innerclass;

public class Body { //外部类

    public class Heart { //成员内部类
        //成员内部类的方法
        public void beat() {
            System.out.println("成员内部类的方法！");
            System.out.println("名字：" + name); // 正确写法
        }
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void methodBody() {
        System.out.println("外部类的方法！");
        new Heart().beat();
    }
}
