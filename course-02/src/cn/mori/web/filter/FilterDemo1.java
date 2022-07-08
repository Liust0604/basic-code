package cn.mori.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Filter过滤器
 */
//@WebFilter("/*") //访问所有资源之前，都会执行该过滤器
//@WebFilter("/index.jsp") //访问index.jsp， 会执行该过滤器
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1、执行操作
        System.out.println("FilterDemo1执行了");

        //2、放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter销毁");
    }
}
