<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>用户登录</title>

        <!-- Bootstrap -->
        <link rel="stylesheet"
              href="${ctx}/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="${ctx}/plugin/jquery/jquery-3.2.1.min.js"></script>
        <script src="${ctx}/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <!-- js -->
        <script>
            const refreshVcode = () => {
                const img = document.getElementById("vcode_img");
                img.src = "${ctx}/checkCodeServlet?" + (new Date().getTime());
            }

            window.onload = function () {
                const verifyCode = document.getElementById("verifycode");
                const vCodeMsg = document.getElementById("vcode_msg");

                verifyCode.onblur = function () {
                    const vCodeValue = verifyCode.value;
                    if (vCodeValue == "") {
                        vCodeMsg.innerText = "验证码不能为空";
                    } else {
                        vCodeMsg.innerText = "";
                        const xhr = new XMLHttpRequest();
                        xhr.open("GET", "${ctx}/checkCodeValueServlet?verifycode=" + vCodeValue);
                        xhr.send();
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4 && xhr.status === 200) {
                                const json = xhr.responseText;
                                if (typeof json === "string") {
                                    const res = JSON.parse(json);
                                    vCodeMsg.innerText = res["vCodeMsg"] ? res["vCodeMsg"] : "";
                                }
                            }
                        }
                    }
                }
            }
        </script>
    </head>
    <body>
        <div class="login_page">
            <div class="login_form_container">
                <div class="login_form_content">
                    <form action="${ctx}/loginServlet" method="post">
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="text" class="form-control" id="username" name="username"
                                   placeholder="请输入用户名">
                        </div>
                        <div class="form-group">
                            <label for="userpsw">密码</label>
                            <input type="password" class="form-control" id="userpsw" name="userpsw"
                                   placeholder="请输入密码">
                        </div>
                        <div class="form-group">
                            <label for="verifycode">验证码</label>
                            <input type="text" class="form-control" id="verifycode" name="verifycode">
                            <p id="vcode_msg">${requestScope.checkCode_msg}</p>
                        </div>
                        <div class="form-group">
                            <a href="javascript:refreshVcode()"><img id="vcode_img"
                                                                     src="${ctx}/checkCodeServlet"></a>
                            <a href="javascript:refreshVcode()">换一张</a>
                        </div>
                        <button type="submit" class="btn btn-default">登录</button>
                        <span>${requestScope.login_msg}</span>
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

        .login_page {
            width: 100%;
            height: 100%;
        }

        .login_form_container .login_form_content {
            width: 25%;
            margin: 0 auto;
        }

    </style>
</html>