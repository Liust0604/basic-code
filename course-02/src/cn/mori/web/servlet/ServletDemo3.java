package cn.mori.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet 注解
 *
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/20 19:32
 */
@WebServlet("/demo3")
public class ServletDemo3 implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet!");
    }


    @Override
    public String getServletInfo() {
        return null;
    }


    @Override
    public void destroy() {
    }
}
