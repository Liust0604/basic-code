package com.mori.course01.exercises.domain.extendsinterface.impl;

import com.mori.course01.exercises.domain.extendsinterface.MyInterfaceAbstract;

public class MyInterfaceAbstractImpl implements MyInterfaceAbstract {

    @Override
    public void methodAbs1() {
        System.out.println("第一个方法！");
    }

    @Override
    public void methodAbs2() {
        System.out.println("第二个方法！");
    }
}
