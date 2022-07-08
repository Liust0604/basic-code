package cn.mori.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responseDemo")
public class ResponseDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //客户端访问/responseDemo资源，会重定向到/responseDemo1资源
        System.out.println("访问ResponseDemo！");
        /*//1、设置重定向状态码 302
        response.setStatus(302);
        //2、设置响应头location，设置重定向的位置
        response.setHeader("location", "responseDemo1");*/

        //简单的重定向方法
        //绝对路径。因为是重定向，浏览器要用这个路径，所以要加虚拟路径
        //response.sendRedirect("/course02/responseDemo1");
        //动态虚拟路径
        String contextPath = request.getContextPath(); //contextPath 为 /course02
        response.sendRedirect(contextPath + "/responseDemo1");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
