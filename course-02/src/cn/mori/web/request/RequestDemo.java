package cn.mori.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求行
 */
@WebServlet("/requestDemo")
public class RequestDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod(); //获取请求方式 get/post

        String contextPath = request.getContextPath(); //（重点）获得虚拟目录
        String servletPath = request.getServletPath(); //获得Servlet路径
        String queryString = request.getQueryString(); //获得get方式的请求参数
        String requestURI = request.getRequestURI();  // （重点）获取请求URL
        StringBuffer requestURL = request.getRequestURL();

        String protocol = request.getProtocol(); //获取协议/版本

        String remoteAddr = request.getRemoteAddr(); //获取客户机IP地址


        System.out.println("请求方式：" + method);
        System.out.println("---------------------");
        System.out.println("虚拟路径：" + contextPath);
        System.out.println("Servlet路径：" + servletPath);
        System.out.println("参数" + queryString);
        System.out.println("URI：" + requestURI);
        System.out.println("URL：" + requestURL);
        System.out.println("---------------------");
        System.out.println("协议：" + protocol);
        System.out.println("---------------------");
        System.out.println("客户端IP：" + remoteAddr);
    }
}
