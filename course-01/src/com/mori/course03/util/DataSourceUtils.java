package com.mori.course03.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池工具类
 * <p>
 * 1、声明连接池
 * 2、静态代码块，读取配置文件，给连接池赋值
 * 3、获取 连接池方法 的方法
 * （连接池可以被SpringJDBC的JdbcTemplate所包装，就可以直接使用连接池的连接和调用连接方法。所以若用了JdbcTemplate，可以不用下面两步）
 * 4、通过 连接池 获取连接 的方法
 * 5、释放连接资源（注意，此处只是归还连接给连接池，并没有关闭连接）
 */
public class DataSourceUtils {

    //定义成员变量，Druid连接池对象
    private static DataSource dataSource;

    //1、加载配置文件，给连接池赋值
    static {
        try {
            ClassLoader loader = DataSourceUtils.class.getClassLoader();
            InputStream is = loader.getResourceAsStream("druid.properties");
            Properties prop = new Properties();
            prop.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池
     *
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 通过连接池获取连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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
