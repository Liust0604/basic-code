<%@ page import="cn.mori.web.domian.User" %><%--
  Created by IntelliJ IDEA.
  User: LiuShitian
  Date: 2022/5/9
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登录成功</title>
    </head>
    <body>
        <h1><%=  ((User) request.getSession().getAttribute("user")).getUsername()%>
        </h1>
    </body>
</html>
