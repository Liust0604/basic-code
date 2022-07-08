package com.mori.course01.demoapi;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间类
 */
public class DateDemo {
    @Test
    public void Test01() {
        Long now = System.currentTimeMillis();
        System.out.println("当前系统时间到时间原点经历了多少毫秒：" + now);
    }

    @Test
    /**
     * 常用方法
     * */
    public void Test02() {
        //1、Date()空参数构造
        Date date = new Date();
        System.out.println("当前日期：" + date);
        //2、Date(long date)
        Date date1 = new Date(0L);
        System.out.println("指定毫秒（时间原点）：" + date1);
        Date date2 = new Date(1648660620928L);
        System.out.println("指定毫秒：" + date2);
        long time = date.getTime();
        System.out.println("当前系统时间到时间原点经历了多少毫秒：" + time);
    }

    @Test
    /**
     * DateFormat 格式化日期/时间
     * */
    public void Test03() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String time = sdf.format(date);
        System.out.println("时间根据模式解析出的字符串为：" + time);

        try {
            Date date1 = sdf.parse("2022-01-01 01:30:20");
            System.out.println("字符串根据模式解析出的时间为：" + date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * Calendar:日历类
     * */
    public void Test04() {
        //get()
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int M = cal.get(Calendar.MONTH) + 1; //西方的月是0-11，所以需要+1
        //int d = cal.get(Calendar.DAY_OF_MONTH);
        int d = cal.get(Calendar.DATE);
        int H = cal.get(Calendar.HOUR_OF_DAY);
        int m = cal.get(Calendar.MINUTE);
        int s = cal.get(Calendar.SECOND);
        System.out.println(y + "-" + M + "-" + d + " " + H + ":" + m + ":" + s);

        //set()
        cal.set(Calendar.YEAR, 2999);
        cal.set(Calendar.MONTH, 9); //注意这里设的是0-11，12的话是第二年0月。若要中国10月，这里填9
        cal.set(Calendar.DAY_OF_MONTH, 20);
        System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH));
        //同时设年月，set方法重载
        cal.set(2088, 0, 12);
        System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH));

        //add
        cal.add(Calendar.YEAR, 10);
        cal.add(Calendar.DAY_OF_MONTH, -6);
        System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH));

        //getTime()
        Date date = cal.getTime();
        System.out.println(date);
    }
}
