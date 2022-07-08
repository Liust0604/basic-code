package com.mori.course03;

import com.mori.course03.domain.Emp;
import com.mori.course03.util.JDBCUtils;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/13 20:20
 */
public class JDBCDemo {
    /**
     * JDBC入门
     */
    public static void main(String[] args) {
        //1、导入驱动jar包
        Connection conn = null;
        Statement state = null;
        try {
            //2、注册驱动，可省略，自动注册驱动
            //Class.forName("com.mysql.cj.jdbc.Driver"); //把驱动类的字节码文件加载进内存
            //3、获取数据库连接对象 Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "root");
            //4、定义sql
            String sql = "update account set balance = 500 where id = 1"; //不加分号;
            //5、获取执行sql语句的对象 Statement
            state = conn.createStatement();
            //6、执行sql，接收返回的结果
            int count = state.executeUpdate(sql);
            //7、处理结果
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        //8、释放资源
    }

    /**
     * insert
     */
    @Test
    public void test01() {
        Connection conn = null;
        Statement state = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "root");
            state = conn.createStatement();
            String sql = "insert into account values(null,'wangwu','500')";
            int count = state.executeUpdate(sql);
            System.out.println(count);
            if (count == 0) {
                System.out.println("添加失败！");
            } else {
                System.out.println("添加成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * update
     */
    @Test
    public void test02() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "root");
            stmt = conn.createStatement();
            String sql = "update account set balance = 1500 where id = 3";
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if (count == 0) {
                System.out.println("修改失败！");
            } else {
                System.out.println("修改成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * query
     */
    @Test
    public void test03() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "root");
            stmt = conn.createStatement();
            String sql = "select * from account";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);
                System.out.println(id + " " + name + " " + balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 查询emp，记录封装成对象
     * 1、定义Emp实体类
     * 2、定义并实现方法 findAll()返回emp对象集合
     */
    @Test
    public void test04() {
        List<Emp> list = findAllEmp();
        System.out.println(list);
    }

    /**
     * 查询所有emp对象
     *
     * @return
     */
    public List<Emp> findAllEmp() {
        List<Emp> res = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "root");
            stmt = conn.createStatement();

            String sql = "select * from emp";
            rs = stmt.executeQuery(sql);
            Emp emp = null; //定义在外面，防止栈中创建多个引用
            while (rs.next()) {

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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

        return res;
    }

    /**
     * JDBC工具类
     */
    @Test
    public void test05() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();

            String sql = "select * from account";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);
                System.out.println(id + " " + name + " " + balance);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
    }

    /**
     * 需求：用户登录
     * 1、创建用户表
     * 2、登录方法
     */
    @Test
    public void test06() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = sc.next();
        System.out.println();
        System.out.print("请输入密码：");
        String userpsw = sc.next();
        System.out.println();
        if (!login(username, userpsw)) {
            System.out.println("登录失败！");
        } else {
            System.out.println("登录成功！");
        }
    }

    private boolean login(String username, String userpsw) {
        if (username == null || userpsw == null) {
            return false;
        }
        //查询数据库
        Connection conn = null;
        // Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            /*stmt = conn.createStatement();
            String sql = "select * from user where username = '" + username + "' and userpsw = '" + userpsw + "' ";
            rs = stmt.executeQuery(sql);*/
            String sql = "select * from user where username = ? and userpsw = ? ";
            pstmt = conn.prepareStatement(sql); //创建对象时，传sql
            pstmt.setString(1, username); //给占位符赋值
            pstmt.setString(2, userpsw);
            rs = pstmt.executeQuery();//执行，不需要传递sql

            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //JDBCUtils.close(rs, stmt, conn);
            JDBCUtils.close(rs, pstmt, conn);
        }
        return false;
    }

    /**
     * Connection 对象 管理事务
     */
    @Test
    public void test07() {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn = JDBCUtils.getConnection();

            //开启事务（不自动提交）
            conn.setAutoCommit(false);

            String sql1 = "update account set balance = (balance - ?) where id = ?";
            String sql2 = "update account set balance = (balance + ?) where id = ?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 2);
            int count1 = pstmt1.executeUpdate();
            int count2 = pstmt2.executeUpdate();

            //提交事务
            conn.commit();

            System.out.println(count1 + " " + count2);
        } catch (Exception e) {
            //出现异常，代表一系列操作失败了，需要回滚
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1, conn);
            JDBCUtils.close(pstmt2, null);
        }
    }
}
