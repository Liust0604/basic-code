package cn.mori.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //存储多个cookie键值对
        /*Cookie cookie1 = new Cookie("cookieMsg1", "hello");
        Cookie cookie2 = new Cookie("cookieMsg2", "hello");
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);*/

        //设置Cookie存活时间
        /*Cookie cookie1 = new Cookie("cookieMsg1", "setMaxAge");
        //cookie1.setMaxAge(30); //Cookie持久化保存，30秒后自动删除cookie文件
        //cookie1.setMaxAge(-1); //默认值，浏览器被关闭时销毁
        cookie1.setMaxAge(0); // 删除Cookie，包括cookie文件
        resp.addCookie(cookie1);*/

        Cookie cookie = new Cookie("cookieMsg1", "你好");
        //默认是虚拟路径/course02，只有在这个虚拟路径下的项目才能获取到这个cookie。若设为/，则所有部署在当前tomcat上部署的所有web项目都可以访问这个cookie
        cookie.setPath("/");
        resp.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
