package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * HttpServlet 请求转发入口，进行方法分发。
 * BaseServlet不能被访问，所以不需要指定访问路径。
 * 模块Servlet需要继承BaseServlet
 */
public class BaseServlet extends HttpServlet {
    //方法入口。HTTPServlet中，不管是dopost、doget方法，都先经过service()方法。
    // 所以某个Servlet只要继承了BaseServlet，所有请求都会经过当前这个service()
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方法分发
        //1、获取请求路径
        String uri = req.getRequestURI(); // /travel/user/find
        System.out.println("请求uri：" + uri);
        //2、获取方法名
        String methodName = uri.substring(uri.lastIndexOf("/") + 1); //find
        System.out.println("方法名：" + methodName);
        //3、获取方法对象Method，并执行方法(反射机制)
        try {
            //根据继承关系的特性。谁调用该方法，就是谁。/user/*进入UserServlet，是UserServlet调用service()方法，所以this是UserServlet对象
            //所以不同根据uri的路径来自己创建对应的Servlet对象，只需要用this就可以了
            System.out.println(this);

            //子Servlet的方法用了 protected 修饰
            //可以用getDeclaredMethod，忽略权限获取方法、并且method.setAccessible(true);暴力反射执行方法
            //忽略权限不合适，只需要改为public即可
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将传入对象序列化为json，返回客户端
     *
     * @param response
     * @param obj
     * @throws IOException
     */
    public void writeValue(HttpServletResponse response, Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), obj);
    }

    /**
     * 将传入对象序列化为json，返回
     *
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(obj);
        return json;
    }
}
