package cn.mori.web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 继承 Servlet接口的实现类 GenericServlet
 *
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/20 21:39
 */
@WebServlet("/demo4")
public class ServletDemo4 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }
}
