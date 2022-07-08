package cn.mori.web.requestlogin;

import cn.mori.web.domian.User;
import cn.mori.web.service.UserService;
import cn.mori.web.service.impl.UserServiceImpl;
import cn.mori.web.util.checkFormUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //检查验证码
        String verifyCode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String verifyCodeSession = (String) session.getAttribute("VERIFYCODE_SESSION");
        session.removeAttribute("VERIFYCODE_SESSION"); //保证验证码一次有效

        if (!checkFormUtils.checkCode(verifyCode, verifyCodeSession)) {
            request.setAttribute("checkCode_msg", "验证码错误");
            request.getRequestDispatcher("/loginFailServlet").forward(request, response);
            return;
        }

        //获取参数、封装对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            //用BeanUtils工具类，将请求参数封装成对象
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserService的login方法，实现登录功能
        User loginUser = userService.login(user);
        if (loginUser == null) {
            request.setAttribute("login_msg", "用户名或密码错误");
            request.getRequestDispatcher("/loginFailServlet").forward(request, response);
            return;
        }

        request.setAttribute("loginUser", loginUser);
        session.setAttribute("loginUser", loginUser);
        request.getRequestDispatcher("/loginSuccessServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
