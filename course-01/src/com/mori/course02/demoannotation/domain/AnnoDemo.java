package com.mori.course02.demoannotation.domain;

import com.mori.course02.demoannotation.anno.MyAnno;
import com.mori.course02.demoannotation.anno.MyAnno2;
import com.mori.course02.demoannotation.anno.MyAnno3;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/9 0:55
 */
//3、压制警告
@SuppressWarnings("all") //类
@MyAnno3()
public class AnnoDemo {

    //1、重写注解
    @Override
    public String toString() {
        return super.toString();
    }

    //2、过时注解
    @Deprecated
    @SuppressWarnings("all") //压制所有警告
    public void show1() {
        //有缺陷的方法，让这个方法过时，推荐新的方法来替代
    }

    @MyAnno(age = 12, showPerson = Person.P1, anno2 = @MyAnno2(12), strs = {"a", "b"})
    public void show2() {
        //替代show1方法
        System.out.println("show2…");
    }

}
