package cn.mori.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet 快速入门
 *
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/20 19:32
 */
public class ServletDemo implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法
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
