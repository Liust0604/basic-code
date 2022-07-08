package cn.mori.web.test;

import cn.mori.web.domian.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author LiuShitian
 * @version 1.0
 * @date: 2022/4/23 16:35
 */
public class BeanUtilsTest {
    @Test
    public void logintest() {
        try {
            User user = new User();
            BeanUtils.setProperty(user, "username", "AAA");
            BeanUtils.setProperty(user, "userpsw", "123");
            System.out.println(user);
            System.out.println(BeanUtils.getProperty(user, "userpsw"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
