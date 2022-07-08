package com.mori.demo.servlet;

import com.mori.demo.domain.User;
import com.mori.demo.service.impl.UserServiceImpl;
import com.mori.demo.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        List<User> list = userService.findAll();

        response.setContentType("test/html;charset=utf-8");
        response.getWriter().write(String.valueOf(list));
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
        //response.sendRedirect(request.getContextPath() + "/hello.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
