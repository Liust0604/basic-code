package com.mori.course04.demoxml;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Jsoup 是 xml文档的解析器
 */
public class JsoupDemo {
    @Test
    public void test01() throws IOException {
        //获取文件路径
        ClassLoader classLoader = JsoupDemo.class.getClassLoader();
        String path = classLoader.getResource("student.xml").getPath(); //根据相对src的路径，获取到文件的绝对路径

        //1、获取Document对象
        // 解析xml文件，加载进内存，获取dom树 -> Document对象
        Document dom = Jsoup.parse(new File(path), "utf-8");
        //2、获取元素对象
        Elements elements = dom.getElementsByTag("name");
        Element element = elements.get(0);
        //获取数据
        String text = element.text();
        System.out.println(text);
    }

    @Test
    public void test02() throws IOException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                "<students>\n" +
                "    <student number=\"no_01\">\n" +
                "        <name>tom</name>\n" +
                "        <age>18</age>\n" +
                "        <sex>male</sex>\n" +
                "    </student>\n" +
                "\n" +
                "    <student number=\"no_02\">\n" +
                "        <name>lily</name>\n" +
                "        <age>16</age>\n" +
                "        <sex>female</sex>\n" +
                "    </student>\n" +
                "</students>";
        Document dom = Jsoup.parse(xml);
        System.out.println(dom);

        System.out.println("---------------------");
        URL url = new URL("https://www.baidu.com/");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);
    }

    @Test
    public void test03() throws IOException {
        ClassLoader classLoader = JsoupDemo.class.getClassLoader();
        String path = classLoader.getResource("student.xml").getPath(); //根据相对src的路径，获取到文件的绝对路径

        Document dom = Jsoup.parse(new File(path), "utf-8");
        Elements els = dom.select("name");
        System.out.println(els.size());

        System.out.println("------------");

        Elements els2 = dom.select("#tom");
        System.out.println(els2);

        System.out.println("------------");
        Elements els3 = dom.select("student[number='no_01'] age");
        System.out.println(els3);
    }


    @Test
    public void test04() throws IOException, XpathSyntaxErrorException {
        ClassLoader classLoader = JsoupDemo.class.getClassLoader();
        String path = classLoader.getResource("student.xml").getPath(); //根据相对src的路径，获取到文件的绝对路径

        Document dom = Jsoup.parse(new File(path), "utf-8");
        JXDocument jxDocument = new JXDocument(dom);

        //查找所有student节点，不考虑它的位置
/*        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }*/

        //查找所有student节点下的name标签
/*        List<JXNode> jxNodes = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }*/

        //查找所有student节点下的name标签，name标签需要带有 id
/*
        List<JXNode> jxNodes = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
*/

        //查找所有student节点下的name标签，name标签 id = ‘name1’
        List<JXNode> jxNodes = jxDocument.selN("//student/name[@id='name1']");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
    }
}
