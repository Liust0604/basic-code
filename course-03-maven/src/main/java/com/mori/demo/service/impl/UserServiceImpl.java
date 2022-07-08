package com.mori.demo.service.impl;

import com.mori.demo.mapper.UserDao;
import com.mori.demo.mapper.impl.UserDaoImpl;
import com.mori.demo.domain.User;
import com.mori.demo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public List<User> findAll() {
        return userDao.findAll();
    }
}
