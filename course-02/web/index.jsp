<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>JSP：可定义html以及java</title>
    </head>
    <body>
        <%
            //Servlet的service方法
            System.out.println("Hello JSP！");
            int i = 5;
        %>

        <%!
            //Servlet的成员
            int i = 3;
        %>

        <%=
        //3、Servlet的service方法中write输出的内容
                i
        %>

        <hr>

        <%
            String contextPath = request.getContextPath();
            out.print(contextPath);
        %>

        <hr>

        <%
            Cookie c = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if ("lastTime".equals(name)) {
                        c = cookie;
                        break;
                    }
                }
            }
            String msg = "";
            if (c == null) {
                msg = "您好，欢迎您首次访问。";
            } else {
                //URL解码
                String value = c.getValue();
                String lastTime = URLDecoder.decode(value, "utf-8");
                msg = "欢迎回来，您上次访问时间为：" + lastTime;
            }

        %>
        <h1><%= msg %>
        </h1>
        <%
            String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String lastTime = URLEncoder.encode(dateStr, "utf-8");
            Cookie cookie = new Cookie("lastTime", lastTime);
            cookie.setMaxAge(3600 * 24);
            response.addCookie(cookie);
        %>
    </body>
</html>
