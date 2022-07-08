package com.mori.course01.exercises.domain.extendsinterface.impl;

import com.mori.course01.exercises.domain.extendsinterface.MyInterfaceDefault;

public class MyInterfaceDefaultBImpl implements MyInterfaceDefault {
    @Override
    public void methodAbs() {
        System.out.println("B实现接口抽象方法！");
    }

    @Override
    public void methodDefault() {
        System.out.println("B覆盖重写了接口的默认方法！");
    }
}
