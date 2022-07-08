package com.mori.course01.exercises.domain.extendsinterface;

/**
 * Java 9 版本的java中接口允许定义私有方法 (因为是9有的，本项目8 所以注释)
 */
public interface MyInterfacePrivate {
    public default void methodDefault1() {
        System.out.println("默认方法1");
        //methodDefaultCommon();
    }

    public default void methodDefault2() {
        System.out.println("默认方法2");
        // methodDefaultCommon();
    }

/*    private void methodDefaultCommon() {
        System.out.println("默认方法的公共代码");
    }*/

    /*    private static void methodStaticCommon() {
        System.out.println("静态方法的公共代码");
    }*/

}
