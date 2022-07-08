package cn.mori.web.util;

import cn.mori.web.requestlogin.LoginServlet;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * JDBC工具类,使用Durid连接池
 */
public class JDBCUtils {

    //1、声明连接池
    private static DataSource ds;

    //2、通过读取配置文件，给连接池变量赋值
    static {
        try {
            ClassLoader loader = LoginServlet.class.getClassLoader();
            InputStream is = loader.getResourceAsStream("druid.properties");

            Properties prop = new Properties();
            prop.load(is);
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3、获取连接池 （若用了Spring JDBC 的JDBCTemplate来保证连接池， 就不用下面获取和释放连接池的连接的两个方法了）
    public static DataSource getDataSource() {
        return ds;
    }
}
