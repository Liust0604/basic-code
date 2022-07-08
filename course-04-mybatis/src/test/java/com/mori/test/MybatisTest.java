package com.mori.test;

import com.mori.demo.domain.User;
import com.mori.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception {
        //1、读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SQLSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3、工厂生产SQLSession对象
        SqlSession session = factory.openSession();
        //4、SQLSession对象创建Dao接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //5、使用代理对象执行方法
        List<User> list = userMapper.findAll();
        System.err.println(list);
        //6、释放资源
        session.close();
        is.close();
    }
}
