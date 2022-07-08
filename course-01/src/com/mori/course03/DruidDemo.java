package com.mori.course03;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mori.course03.util.DataSourceUtils;
import com.mori.course03.util.JDBCUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC优化：Druid技术
 */
public class DruidDemo {

    /**
     * 数据库连接池 Druid
     */
    @Test
    public void test01() throws Exception {
        //1、手动加载配置文件
        Properties prop = new Properties();
        ClassLoader loader = DruidDemo.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("druid.properties");
        prop.load(is);

        //2、根据配置文件，创建数据库连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);

        //3、获取连接对象
        Connection conn = ds.getConnection();

        System.out.println(conn);
    }


    /**
     * Druid 工具类
     */
    @Test
    public void test02() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DataSourceUtils.getConnection();
            String sql = "insert account values (null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "nana");
            pstmt.setDouble(2, 1000);
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }
}
