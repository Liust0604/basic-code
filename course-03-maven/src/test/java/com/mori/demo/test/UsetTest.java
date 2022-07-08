package com.mori.demo.test;

import com.mori.demo.mapper.UserDao;
import com.mori.demo.mapper.impl.UserDaoImpl;
import com.mori.demo.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/5/20 18:54
 */
public class UsetTest {

    @Test
    public void findAll(){
        UserDao userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        System.out.println(all);
    }
}
