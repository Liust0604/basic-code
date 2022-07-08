package cn.mori.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    private List<String> list = new ArrayList<>(); //敏感词汇集合

    public void init(FilterConfig config) throws ServletException {
        //读取文件，把数据存在list中
        BufferedReader br = null;
        try {
            ServletContext servletContext = config.getServletContext(); //web项目上下文
            String path = servletContext.getRealPath("/WEB-INF/classes/sensitiveWords.txt");//web项目中该文件在tomcat中的真实路径。注意默认是从web目录开始的，src的内容会保存在/WEB-INF/classes内
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (!"".equals(line.trim())) {
                    list.add(line.trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1、使用代理模式，创建代理对象。对getParameter方法进行增强
        ServletRequest reqProxy = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                if ("getParameter".equals(methodName)) {
                    //增强返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null && list.size() > 0) {
                        for (String s : list) {
                            if (value.contains(s)) {
                                value = value.replaceAll(s, "**");
                            }
                        }
                    }
                    return value;
                }
                //getParameterValues
                //getParameterMap
                return method.invoke(req, args);
            }
        });

        //2、放行
        chain.doFilter(reqProxy, resp); //注意：一定要用新的代理对象
    }

    public void destroy() {

    }
}
