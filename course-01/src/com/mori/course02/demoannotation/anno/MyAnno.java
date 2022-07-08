package com.mori.course02.demoannotation.anno;

import com.mori.course02.demoannotation.domain.Person;

/**
 * 自定义一个注解
 */
public @interface MyAnno {

    //定义一些属性（接口的抽象方法）

    int age();

    String name() default "";

    Person showPerson();

    MyAnno2 anno2();

    String[] strs();
}
