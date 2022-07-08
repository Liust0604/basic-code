package com.mori.course02.demojdk8.service.impl;

import com.mori.course02.demojdk8.service.MyFunctionalInterface;

public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    @Override
    public void method() {
        System.out.println("使用实现类重写接口中抽象方法");
    }
}
