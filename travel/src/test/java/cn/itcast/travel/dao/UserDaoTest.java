package cn.itcast.travel.dao;

import cn.itcast.travel.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void findByUsernameTest() {
        userDao.findByUsername("zhangsan");
    }

}