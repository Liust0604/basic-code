<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <title>EL表达式</title>
    </head>
    <body>
        <h3>比较运算符</h3>
        ${3>4}
        \${3>4}
        <hr>

        <h3>算数运算符</h3>
        ${3+4} <br>
        ${3-4} <br>
        ${3*4} <br>
        ${3/4} ${3 div 4} <br>
        ${3%4} ${3 mod 4} <br>
        <hr>

        <h3>逻辑运算符</h3>
        ${3>4 && 3<5}<br>
        ${3>4 || 3<5}<br>
        <hr>

        <%
            //在域中存储集合
            List list = new ArrayList();
            list.add("1");
            list.add("2");
            list.add("3");

            request.setAttribute("str", "str");

            request.setAttribute("list1", list);
            request.setAttribute("list2", new ArrayList());
            request.setAttribute("list3", null);
        %>
        <h3>空运算符</h3>
        ${not empty requestScope.str}
        ${empty requestScope.list1}
        ${empty requestScope.list2}
        ${empty requestScope.list3}
        <hr>

    </body>
</html>
