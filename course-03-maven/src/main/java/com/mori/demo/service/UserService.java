package com.mori.demo.service;

import com.mori.demo.domain.User;

import java.util.List;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/5/20 18:22
 */
public interface UserService {

    List<User> findAll();
}
