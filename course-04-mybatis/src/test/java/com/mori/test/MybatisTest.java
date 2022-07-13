package com.mori.test;

import com.mori.demo.domain.QueryVo;
import com.mori.demo.domain.User;
import com.mori.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream is;
    private SqlSession session;
    private UserMapper userMapper;

    @Before
    public void init() throws Exception {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        session = factory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @After
    public void close() throws Exception {
        //提交事务
        session.commit();
        //释放资源
        session.close();
        is.close();
    }

    /**
     * 查询操作
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //1、读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、构建者模式 构建工厂 SQLSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3、工厂模式 生产对象 SQLSession
        SqlSession session = factory.openSession();
        //4、代理模式，通过 SQLSession对象 对 Dao接口 的进行代理，增加操作sql的功能
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //5、使用代理对象，执行方法
        List<User> list = userMapper.findAll();
        System.err.println(list);
        //6、释放资源
        session.close();
        is.close();
    }

    /**
     * 保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("老李");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("上海浦西");
        System.err.println(user);
        //保存方法
        userMapper.saveUser(user);
        System.err.println(user); //sql执行后返回了id
    }

    /**
     * 修改操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("老李");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("北京");
        //修改方法
        userMapper.updateUser(user);
    }

    /**
     * 删除操作
     */
    @Test
    public void testDelete() {
        //删除方法
        userMapper.deleteUser(50);
    }

    /**
     * 查询一个操作
     */
    @Test
    public void testFindOne() {
        User user = userMapper.findById(51);
        System.err.println(user);
    }

    /**
     * 模糊查询操作
     */
    @Test
    public void testFindByName() {
        String name = "王";
        //String username = "%" + name + "%"; // 方式1、手动加上模糊查询的%
        String username = name; //方式2：使用固定写法${value} (里面必须写成value)，不常用
        List<User> users = userMapper.findByName(username);
        System.err.println(users);
    }

    /**
     * 查询数量操作
     */
    @Test
    public void testFindTotal() {
        int count = userMapper.findTotal();
        System.err.println(count);
    }

    /**
     * 根据包装对象查询操作
     */
    @Test
    public void testFindUserByVo() {
        User user = new User();
        user.setUsername("%二%");
        QueryVo vo = new QueryVo();
        vo.setUser(user);
        List<User> users = userMapper.findUserByVo(vo);
        System.err.println(users);
    }
}
