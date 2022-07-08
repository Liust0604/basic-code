package com.mori.course02.demoenum.domain;

/**
 * 自己实现枚举类，有参构造
 */
public class Week2 {
    private String name;

    public static final Week2 MON = new Week2("星期一");
    public static final Week2 TUE = new Week2("星期二");
    public static final Week2 WED = new Week2("星期三");

    public Week2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
