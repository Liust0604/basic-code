package com.mori.course02.democollection.impl;

import com.mori.course02.democollection.domain.GenericInterface;

public class GenericInterfaceImpl2<I> implements GenericInterface<I> {
    @Override
    public void method(I i) {
        System.out.println("方式2！");
    }
}
