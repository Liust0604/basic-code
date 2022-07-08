package cn.mori.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContext")
public class ServletContextDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext
        /*ServletContext ctx1 = request.getServletContext();
        ServletContext ctx2 = this.getServletContext();
        System.out.println(ctx1 == ctx2); //true*/

        ServletContext ctx = this.getServletContext();

        //1、根据文件名的后缀名，获取MIME类型
        System.out.println(ctx.getMimeType("a.jpg"));
        System.out.println(ctx.getMimeType("1.html"));
        System.out.println("===========================");

        //2、域对象 共享数据
        //网ServletContext域保存数据
        System.out.println("servletContext 保存数据");
        ctx.setAttribute("ctxMsg", "hahaha");
        System.out.println("===========================");

        //3、获取文件真实路径 （就是运行在tomcat服务器上的项目副本的路径） 【这个方法只是简单拼接字符串，没有的文件也会生成路径】
        //（注意：web目录下的文件就是tomcat项目的第一层，src不是，src的所有文件都在web/WEB-INF/classes文件里）
        String realPath = ctx.getRealPath("/file2.txt");
        System.out.println(realPath); // D:\IdeaProjects\basic-code\out\artifacts\course_02_war_exploded\file2.txt
        System.out.println(ctx.getRealPath("/WEB-INF/file3.txt"));  //D:\IdeaProjects\basic-code\out\artifacts\course_02_war_exploded\WEB-INF\file3.txt
        System.out.println(ctx.getRealPath("/WEB-INF/classes/file1.txt")); //D:\IdeaProjects\basic-code\out\artifacts\course_02_war_exploded\WEB-INF\classes\file1.txt
        System.out.println("===========================");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
