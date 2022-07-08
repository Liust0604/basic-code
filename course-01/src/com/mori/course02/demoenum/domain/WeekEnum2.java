package com.mori.course02.demoenum.domain;

public enum WeekEnum2 {
    MON("星期一"), TUE("星期二"), WED("星期三"); //2、变量名(参数)

    private String name;  //1、定义有参构造

    WeekEnum2(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //重写toString()

    @Override
    public String toString() {
        return name;
    }
}
