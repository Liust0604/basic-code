package cn.mori.web.userServlet;

import cn.mori.web.domian.PageBean;
import cn.mori.web.domian.User;
import cn.mori.web.service.UserService;
import cn.mori.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        Map<String, String[]> condition = request.getParameterMap();

        //注意：不是自定义分页对象，而是由service返回一个分页对象。在service里得到查询结果，分页对象作为结果返回给页面
        PageBean<User> pageBean = userService.findUserByPage(currentPage, pageSize, condition);

        request.setAttribute("pageBean", pageBean);
        request.setAttribute("condition", condition);
        request.getRequestDispatcher("/user/userList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
