package cn.mori.web.userServlet;

import cn.mori.web.domian.User;
import cn.mori.web.service.UserService;
import cn.mori.web.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        if (request.getParameter("findid") != null) {
            String id = request.getParameter("findid");
            User updateUser = userService.findUserById(id);
            //重定向
            request.setAttribute("updateUser", updateUser);
            request.getRequestDispatcher("/user/updateUser.jsp").forward(request, response);
            return;
        } else {
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user, parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            userService.updateUserById(user);
            //重定向
            response.sendRedirect(request.getContextPath() + "/findUserByPageServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
