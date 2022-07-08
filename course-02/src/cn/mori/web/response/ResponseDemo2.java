package cn.mori.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输出字符
 */
@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、设置流的编码；2、告诉浏览器，响应消息体的编码，建议浏览器用该编码解码
        //response.setHeader("content-type", "text/html;charset=utf-8"); //该消息体是 文本类型中的html文档类型；字符集是utf-8
        //简单设置编码
        response.setContentType("text/html;charset=utf-8");

        //1、获取字符输出流
        PrintWriter pw = response.getWriter();

        //2、输出数据
        pw.write("<h1>你好 response</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
