package com.mori.demo.mapper.impl;

import com.mori.demo.mapper.UserDao;
import com.mori.demo.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/5/20 18:30
 */
public class UserDaoImpl implements UserDao {

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try {
            //https的请求需要加上ssl的验证，取消验证
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?useSSL=false", "root", "root");
            PreparedStatement ps = conn.prepareStatement("select  * from db2.user");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                list.add(user);
            }
            rs.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
