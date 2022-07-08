package cn.mori.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求头
 */
@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agent = request.getHeader("user-agent"); //请求浏览器信息。不区分大小写
        //根据浏览器处理兼容性问题
        if (agent.contains("Chrome")) {
            System.out.println("谷歌浏览器… ");
        } else if (agent.contains("FireFox")) {
            System.out.println("火狐浏览器… ");
        }
        String referer = request.getHeader("referer"); //请求来源
        //防盗链
        response.setContentType("text/html;charset=utf-8");
        if (referer != null && referer.contains("/course02/login.html")) {
            System.out.println("正常访问：" + referer);
            response.getWriter().write("正常访问：" + referer);
        } else {
            //盗链
            System.out.println("访问路径非法…");
            response.getWriter().write("访问路径非法…");
        }
        System.out.println("=======================================");
    }
}
