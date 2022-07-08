package cn.mori.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器链
 */
@WebFilter("/*") //默认按照类名的字符串比较规则，值小的先执行
public class FilterDemo3 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo3执行了…");
        chain.doFilter(req, resp);
        System.out.println("filterDemo3回来了…");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}
