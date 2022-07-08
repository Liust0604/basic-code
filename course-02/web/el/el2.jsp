<%@ page import="cn.mori.web.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EL表达式：获取域中数据</title>
    </head>
    <body>

        <%
            //在域中存储数据
            request.setAttribute("requestMsg", "AAA");
            session.setAttribute("sessionMsg", "123");

            request.setAttribute("name", "111");
            session.setAttribute("name", "222");
        %>

        <h3>获取域中的值</h3>
        ${requestScope.requestMsg}
        ${sessionScope.sessionMsg}
        ${sessionScope.haha} <%--若不存在的数据，就显示空字符串--%>
        <br>
        ${name} <%--从最小域开始查找键值--%>
        <hr>


        <%
            //在域中存储对象
            request.setAttribute("user", new User("小明", 19, new Date()));
            session.setAttribute("user", new User("小红", 23, new Date()));
        %>

        <h3>获取域中的对象</h3>
        ${requestScope.user}
        <br>
        ${sessionScope.user}
        <br>
        ${user}
        <hr>

        <h3>获取域中的对象的值</h3>
        通过属性(getter/setter去掉get和set)获取对象的值
        <br>
        ${user.name} ${user.age} ${user.birthday}
        <br>
        ${user.birthday.month} <%-- user.birthday 得到的是Date对象，可以继续调用Date类型的方法--%>
        ${user.birthdayStr} <%--  或者自定义逻辑视图 --%>
        <hr>

        <%
            //在域中存储集合
            List list = new ArrayList();
            list.add("1");
            list.add("2");
            list.add("3");
            request.setAttribute("list", list);

            Map map = new HashMap();
            map.put("1", "A");
            map.put("2", "B");
            map.put("3", "C");
            map.put("key", "value");
            session.setAttribute("map", map);
        %>

        <h3>获取域中的集合</h3>
        ${requestScope.list} ${requestScope.list[0]} ${requestScope.list[10]} <%--越界不报异常，空字符串--%>
        <br>
        ${sessionScope.map} ${sessionScope.map.key} ${sessionScope.map["1"]}
        <hr>

    </body>
</html>
