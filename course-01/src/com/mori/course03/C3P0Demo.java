package com.mori.course03;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC优化：C3P0技术
 */
public class C3P0Demo {

    /**
     * 数据库连接池 C3P0
     */
    @Test
    public void test01() throws SQLException {
        //1、创建数据库连接池对象.多态，实现类指向接口
        DataSource ds = new ComboPooledDataSource();
        //2、获取连接对象
        Connection conn = ds.getConnection();

        System.out.println(conn);
    }

    /**
     * 归还连接
     */
    @Test
    public void test02() throws SQLException {
        //1、创建数据库连接池对象.多态，实现类指向接口
        DataSource ds = new ComboPooledDataSource();
        //2、获取连接对象
        for (int i = 0; i < 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + "  " + conn);

            if (i == 5) {
                conn.close(); //归还连接
            }
        }
    }
}
