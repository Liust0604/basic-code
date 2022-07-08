package cn.mori.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//REQUEST 默认：浏览器直接请求(url请求，包括重定向)，该过滤器执行 ； 服务器转发时(请求转发)，该过滤器执行
//@WebFilter(value = "/user/index.jsp", dispatcherTypes = DispatcherType.REQUEST) //只有浏览器直接访问/user/index.jsp，会执行过滤
//@WebFilter(value = "/user/index.jsp", dispatcherTypes = DispatcherType.FORWARD) //只有浏览器请求转发访问/user/index.jsp，会执行过滤
//直接访问和addServlet请求转发访问，都会执行过滤。addServlet自己执行一次，请求转发到/user/index.jsp一次，共执行过滤器两次
@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class FilterDemo2 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1、request的请求消息增强
        System.out.println("filterDemo2执行了…");

        //2、放行
        chain.doFilter(req, resp);

        //3、对response的响应消息增强

        System.out.println("filterDemo2回来了…");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
