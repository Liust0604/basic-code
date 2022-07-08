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
        <div class="update_page">
            <div class="update_form_container">
                <div class="update_form_content">
                    <form action="${ctx}/updateUserServlet" method="post">
                        <%--隐藏域保存id，用于提交表单--%>
                        <div class="form-group" style="display: none">
                            <label>id</label>F
                            <input type="text" class="form-control" name="id" value="${updateUser.id}">
                        </div>
                        <div class="form-group">
                            <label>姓名</label>
                            <input type="text" class="form-control" name="name" value="${updateUser.name}">
                        </div>
                        <div class="form-group">
                            <label>年龄</label>
                            <input type="number" class="form-control" name="age" value="${updateUser.age}">
                        </div>
                        <div class="form-group">
                            <label>地址</label>
                            <input type="text" class="form-control" name="address" value="${updateUser.address}">
                        </div>
                        <div class="form-group">
                            <label>QQ</label>
                            <input type="number" class="form-control" name="qq" value="${updateUser.qq}">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email" value="${updateUser.email}">
                        </div>

                        <%--<div class="form-group">
                            <label>性别：</label>
                            <c:if test="${updateUser.gender == '男'}">
                                <input type="radio" name="gender" value="男" checked/>男
                                <input type="radio" name="gender" value="女"/>女
                            </c:if>

                            <c:if test="${updateUser.gender == '女'}">
                                <input type="radio" name="gender" value="男"/>男
                                <input type="radio" name="gender" value="女" checked/>女
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="address">籍贯：</label>
                            <select name="address" id="address" class="form-control">
                                <c:if test="${updateUser.address == '陕西'}">
                                    <option value="陕西" selected>陕西</option>
                                    <option value="北京">北京</option>
                                    <option value="上海">上海</option>
                                </c:if>

                                <c:if test="${updateUser.address == '北京'}">
                                    <option value="陕西">陕西</option>
                                    <option value="北京" selected>北京</option>
                                    <option value="上海">上海</option>
                                </c:if>

                                <c:if test="${updateUser.address == '上海'}">
                                    <option value="陕西">陕西</option>
                                    <option value="北京">北京</option>
                                    <option value="上海" selected>上海</option>
                                </c:if>
                            </select>
                        </div>--%>

                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </body>


    <style>
        * {
            margin: 0;
            pupdateing: 0;
        }

        .update_page {
            width: 100%;
            height: 100%;
        }

        .update_form_container .update_form_content {
            padding-top: 2%;
            width: 25%;
            margin: 0 auto;
        }

    </style>
</html>
