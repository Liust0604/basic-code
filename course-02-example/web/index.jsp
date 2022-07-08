<%@ page import="cn.mori.web.domian.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <title>首页</title>
    </head>
    <body>
        <h3>欢迎您,${sessionScope.loginUser.name}</h3>
        <a href="${ctx}/findUserByPageServlet">用户信息管理系统</a>
    </body>
</html>
