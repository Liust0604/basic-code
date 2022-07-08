package com.mori.course01.demoapi;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/10 12:26
 */
public class regexDemo {

    @Test
    public void test01() {
        boolean isMatch = Pattern.matches("(\\D*)(\\d+)(.*)", "This order was placed for QT3000! OK?");
        System.out.println(isMatch);
    }

    @Test
    public void test02() {
        //1、创建正则表达式模型
        Pattern p = Pattern.compile("(\\D*)(\\d+)(.*)");
        //2、创建匹配器
        Matcher m = p.matcher("This order was placed for QT3000! OK?");
        //3、遍历所有序列
        if (m.find()) {
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.println("Found value: " + m.group(i));
            }
        } else {
            System.out.println("NO MATCH");
        }
    }
}
