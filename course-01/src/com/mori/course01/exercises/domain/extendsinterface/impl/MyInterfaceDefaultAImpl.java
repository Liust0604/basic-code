package com.mori.course01.exercises.domain.extendsinterface.impl;

import com.mori.course01.exercises.domain.extendsinterface.MyInterfaceDefault;

public class MyInterfaceDefaultAImpl implements MyInterfaceDefault {

    @Override
    public void methodAbs() {
        System.out.println("A实现接口抽象方法！");
    }
}
