<%@ page import="cn.mori.web.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EL表达式：隐式对象（el可以直接使用的对象）</title>
    </head>
    <body>

        ${pageContext.request}<br>
        项目虚拟目录：${pageContext.request.contextPath}<br>

    </body>
</html>
