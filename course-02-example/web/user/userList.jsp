<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>用户信息管理系统</title>

        <!-- Bootstrap -->
        <link rel="stylesheet"
              href="${ctx}/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="${ctx}/plugin/jquery/jquery-3.2.1.min.js"></script>
        <script src="${ctx}/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <!-- js -->
        <script>
            window.onload = function () {
                const queryBtn = document.getElementById("query_btn");
                const addBtn = document.getElementById("add_btn");
                const deleteBtn = document.getElementById("delete_btn");

                queryBtn.onclick = queryFun;
                addBtn.onclick = addFun;
                deleteBtn.onclick = deleteFun;

                const allChecked = document.getElementById("user_cb_all");
                allChecked.onclick = function (e) {
                    const el = e.target;
                    const cbs = document.getElementsByName("user_cb");
                    for (cb of cbs) {
                        cb.checked = el.checked;
                    }
                }
            }

            const queryFun = function () {
                document.getElementById("userlist_form").submit();
            }

            const addFun = function () {
                console.log("添加…");
            }

            const deleteFun = function () {
                const cbs = document.getElementsByName("user_cb");
                let flag = false;
                for (cb of cbs) {
                    if (cb.checked) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    if (confirm("确认删除选中项？")) {
                        const form = document.getElementById("user_tab_form");
                        form.submit();
                    }
                }
            }

            const deleteUserById = function (id) {
                if (confirm("确认删除?")) {
                    location.href = "${ctx}/delUserServlet?id=" + id;
                }
            }

            const updateUserById = function (id) {
                location.href = "${ctx}/updateUserServlet?findid=" + id;
            }
        </script>
    </head>
    <body>
        <div class="home_page">
            <div class="user_tab_container">
                <div class="user_tab_content">
                    <div class="list_title" style="margin: 3px 0">
                        用户信息列表
                    </div>
                    <div class="list_inqu" style="margin-bottom: 2px">
                        <form id="userlist_form" action="${ctx}/findUserByPageServlet" method="post"
                              class="form-inline">
                            <div class="form-group">
                                <label for="inqu_name">姓名</label>
                                <input type="text" class="form-control" id="inqu_name" name="name"
                                       value="${condition.name[0]}" placeholder="请输入姓名">
                            </div>
                            <div class="form-group">
                                <label for="inqu_native">籍贯</label>
                                <input type="text" class="form-control" id="inqu_native" name="address"
                                       value="${condition.address[0]}" placeholder="请输入籍贯">
                            </div>
                            <div class="form-group">
                                <label for="inqu_email">邮箱</label>
                                <input type="email" class="form-control" id="inqu_email" name="email"
                                       value="${condition.email[0]}" placeholder="请输入邮箱">
                            </div>
                            <button class="btn btn-default" id="query_btn">查询</button>
                            <a class="btn btn-primary" id="add_btn" style="float: right"
                               href="${ctx}/user/addUser.jsp"
                            >添加
                            </a>
                            <input type="button" class="btn btn-primary" id="delete_btn" style="float: right"
                                   value="删除">
                        </form>
                    </div>
                    <div class="table-responsive">
                        <%--表单天然会提交选中的复选框--%>
                        <form id="user_tab_form" action="${ctx}/delUserServlet" method="post">
                            <table class="table table-bordered" id="userList_table">
                                <tr class="tab_th">
                                    <th>
                                        <input type="checkbox" id="user_cb_all">
                                    </th>
                                    <th>编号</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>年龄</th>
                                    <th>籍贯</th>
                                    <th>QQ</th>
                                    <th>邮箱</th>
                                    <th>操作</th>
                                </tr>
                                <c:if test="${not empty requestScope.pageBean.list}">
                                    <c:forEach items="${requestScope.pageBean.list}" var="user" varStatus="s">
                                        <tr class="tab_tr">
                                            <td>
                                                <input type="checkbox" name="user_cb" value="${user.id}">
                                            </td>
                                            <td>${s.count}</td>
                                            <td>${user.name}</td>
                                            <td>${user.gender}</td>
                                            <td>${user.age}</td>
                                            <td>${user.address}</td>
                                            <td>${user.qq}</td>
                                            <td>${user.email}</td>
                                            <td>
                                                <a class="btn btn-default btn-sm"
                                                   href="javascript:updateUserById(${user.id});">修改</a>&nbsp;
                                                <a class="btn btn-default btn-sm"
                                                   href="javascript:deleteUserById(${user.id});">删除</a>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </c:if>
                            </table>
                        </form>
                    </div>
                    <div class="tab_pagination">
                        <c:set var="currentPage" value="${empty pageBean.currentPage ? 1:pageBean.currentPage}"></c:set>
                        <c:set var="pageSize" value="${empty pageBean.pageSize ? 5:pageBean.pageSize}"></c:set>
                        <c:set var="pageServlet" value="${ctx}/findUserByPageServlet"></c:set>
                        <c:set var="pageParams"
                               value="name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"></c:set>
                        <nav aria-label="Page navigation">
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    ${pageSize} 条/页
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li>
                                        <a href="${pageServlet}?currentPage=${currentPage}&pageSize=3&${pageParams}">3
                                            条/页</a>
                                    </li>
                                    <li>
                                        <a href="${pageServlet}?currentPage=${currentPage}&pageSize=5&${pageParams}">5
                                            条/页</a>
                                    </li>
                                    <li>
                                        <a href="${pageServlet}?currentPage=${currentPage}&pageSize=10&${pageParams}">10
                                            条/页</a>
                                    </li>
                                </ul>
                            </div>
                            <ul class="pagination">
                                <c:if test="${currentPage <= 1}">
                                    <li class="disabled">
                                        <a href="#" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${currentPage > 1}">
                                    <li>
                                        <a href="${pageServlet}?currentPage=${currentPage - 1 >= 1? currentPage - 1 : 1}&pageSize=${pageSize}&${pageParams}"
                                           aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${pageBean.totalPage}" step="1" var="i"
                                           varStatus="s">
                                    <c:if test="${i == currentPage}">
                                        <li class="active"><a
                                                href="${pageServlet}?currentPage=${i}&pageSize=${pageSize}&${pageParams}">${i}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${i != currentPage}">
                                        <li>
                                            <a href="${pageServlet}?currentPage=${i}&pageSize=${pageSize}&${pageParams}">${i}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>

                                <c:if test="${currentPage >= pageBean.totalPage}">
                                    <li class="disabled">
                                        <a href="#" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${currentPage < pageBean.totalPage}">
                                    <li>
                                        <a href="${pageServlet}?currentPage=${currentPage + 1 <= pageBean.totalPage? currentPage + 1 : pageBean.totalPage}&pageSize=${pageSize}&${pageParams}"
                                           aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </c:if>

                                <span style="position: relative;top: 8px;left: 5px;">
                                    共<span>${pageBean.totalPage}</span>页，<span>${pageBean.totalCount}</span>条数据
                                </span>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .home_page {
            width: 100%;
            height: 100%;
        }

        .user_tab_container .user_tab_content {
            width: 60%;
            margin: 0 auto;
        }

        .user_tab_content .list_title {
            text-align: center;
            color: black;
            font-size: 2.5rem;
        }

        .user_tab_content table td, th {
            text-align: center;
        }

        .user_tab_content table .tab_th {
            background: #EEFFE9;
        }
    </style>
</html>
