package com.mori.course02.demoannotation.anno;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) //注解会被保留到字节码文件，并被jvm读取到
@Documented //注解会被抽取到Javadoc文档中
@Inherited //父类用了该注解，那么子类自动继承父类的这个注解
public @interface MyAnno3 {
}
