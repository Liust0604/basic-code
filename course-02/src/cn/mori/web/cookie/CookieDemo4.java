package cn.mori.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cookie案例：第一次显示首次访问，之后显示上一次的来访时间
 * 不登录的情况下，也就是不需要根据用户去访问数据库。可以用Cookie的方式存储
 */
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Cookie c = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    c = cookie;
                    break;
                }
            }
        }
        if (c == null) {
            response.getWriter().write("您好，欢迎您首次访问。");
        } else {
            //URL解码
            String value = c.getValue();
            String lastTime = URLDecoder.decode(value, "utf-8");
            System.out.println("Cookie值：" + value);
            System.out.println("URL解码后：" + lastTime);
            response.getWriter().write("欢迎回来，您上次访问时间为：" + lastTime);
        }

        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //Cookie值中存在无效字符[32]。cookie不能含有空格。所以可以用URL编码
        //URL编码
        String lastTime = URLEncoder.encode(dateStr, "utf-8");
        System.out.println("原字符串：" + dateStr);
        System.out.println("URL编码后：" + lastTime);
        Cookie cookie = new Cookie("lastTime", lastTime);
        cookie.setMaxAge(3600 * 24);
        response.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
