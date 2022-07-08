package cn.mori.web.test;

import cn.mori.web.dao.UserDao;
import cn.mori.web.domian.User;
import org.junit.Test;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/23 15:53
 */
public class UserDaoTest {
    UserDao userDao = new UserDao();

    @Test
    public void loginTest() {
        User loginUser = new User(null, "zhangsan", "123");
        User user = userDao.login(loginUser);
        System.out.println(user);
    }
}
