package com.mori.course02.demoenum;

import com.mori.course02.demoenum.domain.*;
import org.junit.Test;

public class EnumDemo {

    @Test
    /**
     * 自定义枚举类
     * */
    public void Test01() {
        Week mon = Week.MON; //不能new，通过类名访问
        Week tue = Week.TUE;
        Week wed = Week.WED;

        Week2 mon2 = Week2.MON;
        System.out.println(mon2.getName());

        Week3 mon3 = Week3.MON;
        mon3.show();
    }

    @Test
    /**
     * 通过enum实现枚举类
     * */
    public void Test02() {
        WeekEnum mon = WeekEnum.MON;
        System.out.println(mon); //enum重写了toString方法，输出的就是变量名

        WeekEnum2 mon2 = WeekEnum2.MON;
        System.out.println(mon2 + "   " + mon2.getName());

        WeekEnum3 mon3 = WeekEnum3.MON;
        System.out.println(mon3);
        mon3.show();
    }

    @Test
    /**
     * Switch中使用枚举类
     * */
    public void Test03() {
        WeekEnum3 mon = WeekEnum3.MON;
        switch (mon) {
            case MON: //可以根据switch()传入的类型，确定枚举类，找到枚举项
                System.out.println("星期一");
                break;
            case TUE: //可以根据switch()传入的类型，确定枚举类，找到枚举项
                System.out.println("星期二");
                break;
        }
    }

    @Test
    /**
     * 常用方法
     * */
    public void Test04() {
        WeekEnum2 mon = WeekEnum2.MON;
        WeekEnum2 tue = WeekEnum2.TUE;
        WeekEnum2 wed = WeekEnum2.WED;

        System.out.println(mon.name());
        System.out.println(mon.toString());

        System.out.println(mon.ordinal() + "," + tue.ordinal() + "," + wed.ordinal());

        System.out.println(mon.compareTo(tue));
        System.out.println(mon.compareTo(wed));

        WeekEnum2 mon2 = WeekEnum2.valueOf(WeekEnum2.class, "MON"); //通过字节码对象，获取枚举项
        System.out.println(mon2);

        WeekEnum2[] values = WeekEnum2.values();
        for (WeekEnum2 value : values) {
            System.out.println(value);
        }
    }
}
