<%@ page import="cn.mori.web.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>JSTL标签库</title>
    </head>
    <body>

        <%
            request.setAttribute("num", 11);
        %>

        <%--c:if标签（if）--%>
        <%--test(必填)内表达式，为true，显示标签体；为false，不显示标签体--%>
        <c:if test="true">
            <h3>AAA</h3>
        </c:if>
        <br>
        <c:if test="${num % 2 == 0}">
            偶数:${num}
        </c:if>
        <c:if test="${num % 2 != 0}">
            奇数:${num}
        </c:if>

        <hr>
        <%--c:choose标签（switch）--%>
        <c:choose>
            <c:when test="${num == 1}">星期一</c:when>
            <c:when test="${num == 2}">星期二</c:when>
            <c:when test="${num == 3}">星期三</c:when>
            <c:when test="${num == 4}">星期四</c:when>
            <c:when test="${num == 5}">星期五</c:when>
            <c:when test="${num == 6}">星期六</c:when>
            <c:when test="${num == 7}">星期日</c:when>
            <c:otherwise>数字有误</c:otherwise>
        </c:choose>

        <hr>
        <%
            List list = new ArrayList();
            list.add("1");
            list.add("2");
            list.add("3");
            request.setAttribute("list", list);
        %>

        <%--c:foreach标签（for）--%>
        <c:forEach begin="1" end="10" step="2" var="i" varStatus="s"
        >
            ${i} &nbsp  ${s.index} &nbsp  ${s.count} <br>
        </c:forEach>

        <hr>
        <c:if test="${not empty list}">
            <c:forEach items="${list}" var="item" varStatus="s">
                ${item} &nbsp  ${s.index} &nbsp  ${s.count} <br>
            </c:forEach>
        </c:if>

        <hr>
        <h3>案例</h3>

        <%
            List l = new ArrayList();
            l.add(new User("小A", 19, new Date()));
            l.add(new User("小B", 20, new Date()));
            l.add(new User("小C", 21, new Date()));
            request.setAttribute("l", l);
        %>

        <table border="1">
            <tr>
                <th>姓名</th>
                <th>年龄</th>
                <th>生日</th>
            </tr>
            <c:if test="${not empty requestScope.l}">
                <c:forEach items="${requestScope.l}" var="user" varStatus="s"
                >
                    <c:if test="${s.index % 2 == 0}">
                        <tr style="background: greenyellow">
                            <td>${user.name}</td>
                            <td>${user.age}</td>
                            <td>${user.birthdayStr}</td>
                        </tr>
                    </c:if>
                    <c:if test="${s.index % 2 != 0}">
                        <tr>
                            <td>${user.name}</td>
                            <td>${user.age}</td>
                            <td>${user.birthdayStr}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </c:if>
        </table>

    </body>
</html>
