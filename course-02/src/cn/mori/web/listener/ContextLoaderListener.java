package cn.mori.web.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;

/**
 * ServletContext 监听器
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * 监听servletContext创建。服务器启动后自动创建
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext被创建了……");
        //加载全局资源文件
        //获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        //根据servletContext获取web.xml的参数的值。根据绝对路径获取tomcat中真实路径，根据真实路径加载文件进内存，读取文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        String path = servletContext.getRealPath(contextConfigLocation);
        try {
            FileInputStream fis = new FileInputStream(path);
            System.out.println(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务器正常关闭，调用销毁方法，销毁ServletContext
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext被销毁了……");
    }
}
