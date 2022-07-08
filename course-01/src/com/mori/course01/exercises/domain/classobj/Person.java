package com.mori.course01.exercises.domain.classobj;

public class Person {
    private String name;
    private int age;
    private boolean male;//是不是男性

    public Person() {
        //System.out.println("无参构造方法执行了！");
    }

    public Person(String name, int age, boolean male) {
        //System.out.println("全参构造方法执行了！");
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public void show() {
        System.out.println("我叫" + name + "，性别为" + male + "，年龄是" + age + "岁。");
    }

    public void sayHello(String name) {
        System.out.println(name + "你好！我是" + this.name + "。");
        //对象person调用了sayHello方法，所以执行此方法时，this是person的地址
        System.out.println(this);
    }

    /**
     * 这个成员方法，专门用于获取age的数据
     */
    public int getAge() {
        return age;
    }

    /**
     * 这个成员方法，专门用于向age设置数据
     */
    public void setAge(int num) {
        if (0 <= num && num <= 100) {
            this.age = num;
        } else {
            System.out.println("年龄不合理！");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}
