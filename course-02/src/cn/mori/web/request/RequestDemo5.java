package cn.mori.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 获取参数的通用方法（原来get用getQueryString()、post用输入流readLine(),不通用）
 */
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("====post=============");
        request.setCharacterEncoding("utf-8");
        //根据参数名，获取参数数组
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        System.out.println("--------------------------");
        //获取所有请求参数的名称 Enumeration看作迭代器
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);  // 根据参数名，获取参数值 （就算有多个值，也只显示一个）
            System.out.println(name + ":" + value);
        }
        System.out.println("--------------------------");
        //获取所有参数的Map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            String name = entry.getKey();
            String[] value = entry.getValue();
            System.out.println(name + ":" + Arrays.toString(value));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //一样的方式获取参数
        /* System.out.println("====get=============");
        String username = request.getParameter("username");
        System.out.println(username);*/
        this.doPost(request, response);
    }
}
