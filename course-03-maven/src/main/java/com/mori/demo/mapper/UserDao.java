package com.mori.demo.mapper;

import com.mori.demo.domain.User;

import java.util.List;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/5/20 18:25
 */
public interface UserDao {
    List<User> findAll();
}
