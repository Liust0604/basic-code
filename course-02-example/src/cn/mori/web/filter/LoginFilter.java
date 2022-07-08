package cn.mori.web.filter;

import cn.mori.web.domian.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 验证登录的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;  //强制转换

        String uri = request.getRequestURI(); //获取资源请求路径
        //不光要排除全部登录相关的Servlet和页面，静态资源也要排除
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/checkCodeServlet") || uri.contains("/checkCodeValueServlet")
                || uri.contains("/js/") || uri.endsWith(".js") || uri.contains("/css/") || uri.endsWith(".css") || uri.contains("/img/") || uri.contains("/fonts/")
                || uri.contains("/regist.html") || uri.contains("/checkUserNameServlet") || uri.contains("/provinceServlet")) {
            //1、若是登录相关的资源，直接放行
            chain.doFilter(req, resp);
        } else {
            User loginUser = (User) request.getSession().getAttribute("loginUser");
            //2、若不是登录相关资源，则要判断用户是否已经登录。若未登录，跳转到登录页面，若已经登录，放行。
            if (loginUser != null) {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute("login_msg", "您尚未登录，请先登录。");
                request.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}
