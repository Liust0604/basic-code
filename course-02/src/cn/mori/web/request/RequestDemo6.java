package cn.mori.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发
 * 把当前demo6的请求转发给demo7
 */
@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问demo6");
        //获取请求转发器，传入转发目的路径(Servlet路径)
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo7");
        //通过转发器，把请求和响应对象都发送给转发目的
        //requestDispatcher.forward(request, response);

        //转发请求之前，存储到request域中
        request.setAttribute("msg", "hello");

        //绝对路径。因为是请求转发，是服务器内使用这个路径，所以不加虚拟目录
        request.getRequestDispatcher("/requestDemo7").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
