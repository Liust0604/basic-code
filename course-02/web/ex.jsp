<%--jsp指令名1：page 配置页面信息。可以通过import导入java包--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="16kb" errorPage="500.jsp" %>
<%@ page import="java.util.List" %>

<%--jsp指令名3：tablib 导入标签库--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <title>JSP内容</title>
    </head>
    <body>
        <h1>页面主体</h1>
        <%--jsp指令名2：include 包含页面资源--%>
        <%@ include file="top.jsp" %>
    </body>
</html>
