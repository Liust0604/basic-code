package cn.mori.web.requestlogin;

import cn.mori.web.domian.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginSuccessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loginUser = (User) request.getAttribute("loginUser");
        if (loginUser != null) {
            response.getWriter().write("登录成功！" + loginUser.getUsername() + "，欢迎您。");
            response.sendRedirect(request.getContextPath() + "/index.jsp"); //重定向
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
