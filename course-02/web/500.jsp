<%--
  Created by IntelliJ IDEA.
  User: LiuShitian
  Date: 2022/5/9
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
    <head>
        <title>失败页面</title>
    </head>
    <body>
        <h1>服务器正忙……</h1>
        <%
            String msg = exception.getMessage();
            out.print(msg);
        %>
    </body>
</html>
