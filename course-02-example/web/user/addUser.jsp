<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>添加用户</title>

        <!-- Bootstrap -->
        <link rel="stylesheet"
              href="${ctx}/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="${ctx}/plugin/jquery/jquery-3.2.1.min.js"></script>
        <script src="${ctx}/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <!-- js -->
        <script>

        </script>
    </head>
    <body>
        <div class="add_page">
            <div class="add_form_container">
                <div class="add_form_content">
                    <form action="${ctx}/addUserServlet" method="post">
                        <div class="form-group">
                            <label>用户名</label>
                            <input type="text" class="form-control" name="username">
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input type="password" class="form-control" name="userpsw">
                        </div>
                        <div class="form-group">
                            <label>姓名</label>
                            <input type="text" class="form-control" name="name">
                        </div>
                        <div class="form-group">
                            <label>年龄</label>
                            <input type="number" class="form-control" name="age">
                        </div>
                        <div class="form-group">
                            <label>地址</label>
                            <input type="text" class="form-control" name="address">
                        </div>
                        <div class="form-group">
                            <label>QQ</label>
                            <input type="number" class="form-control" name="qq">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email">
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </body>


    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .add_page {
            width: 100%;
            height: 100%;
        }

        .add_form_container .add_form_content {
            padding-top: 2%;
            width: 25%;
            margin: 0 auto;
        }

    </style>
</html>
