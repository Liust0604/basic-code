package com.mori.course02.democollection.impl;

import com.mori.course02.democollection.domain.GenericInterface;

public class GenericInterfaceImpl1 implements GenericInterface<String> {
    @Override
    public void method(String s) {
        System.out.println("方式1！");
    }
}
