package com.mori.course03.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC 工具类
 * 工具类的方法一般都是静态的
 * <p>
 * 1、声明配置项变量
 * 2、静态代码块，读取配置文件给配置项赋值，并注册数据库驱动
 * 3、通过 DriverManager 获取连接 的方法（传入配置项）
 * 4、释放连接资源（注意，此处是关闭连接）
 */
public class JDBCUtils {

    private static String driver; //静态变量才能被静态代码块、静态方法访问
    private static String url;
    private static String user;
    private static String password;

    /**
     * 文件读取只需要一次，得到配置内容。使用静态代码块
     */
    static {
        //静态代码块只能处理异常，不能抛出，因为抛出异常需要借助于方法
        try {
            Properties prop = new Properties();
            //prop.load(new FileReader("src/jdbc.properties"));
            //获取src路径下文件的方式-->ClassLoader类 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties"); //相对于src
            String path = resource.getPath(); //获取绝对路径字符串
            prop.load(new FileReader(path));

            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

            //注册JDBC驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取JDBC连接
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     *
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    /**
     * 释放资源
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
