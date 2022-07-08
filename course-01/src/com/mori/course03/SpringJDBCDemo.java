package com.mori.course03;

import com.mori.course03.domain.Emp;
import com.mori.course03.util.DataSourceUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Spring框架对JDBC进行封装，提供JdbcTemplate对象简化JDBC操作
 */
public class SpringJDBCDemo {

    //1、创建JdbcTemplate对象。传入一个数据源（数据库连接池）
    JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());

    @Test
    public void test01() {
        //2、调用方法
        String sql = "update account set balance = ? where id = ?";
        int count = template.update(sql, 5000, 3);//可变参数，给占位符赋值
        System.out.println(count);
    }

    /**
     * 增删改
     */
    @Test
    public void test02() {
        String sql = "update emp set salary = ? where id = ?";
        int count = template.update(sql, 10000, 1001);
        System.out.println(count);

        String sql2 = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count2 = template.update(sql2, 1015, "郭靖", 10);
        System.out.println(count2);
    }

    @Test
    public void test03() {
        String sql3 = "delete from emp where id = ?";
        int count3 = template.update(sql3, 1015);
        System.out.println(count3);
    }

    /**
     * queryForMap 查询 1条 记录，封装为Object的Map
     * queryForList 查询 多条 记录，封装为Object的List
     * query 创建一个BeanPropertyRowMapper，传入.class实体类对象。封装为JavaBean的List
     * queryForObject 查询一个记录，传递返回类型的.class类对象。返回为指定类型的结果
     */
    @Test
    public void test04() {
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);

        String sql2 = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql2);
        System.out.println(list);

        List<Emp> empList = template.query(sql, new BeanPropertyRowMapper<>(Emp.class), 1001);
        System.out.println(empList);

        String sql3 = "select count(*) from emp";
        Long count = template.queryForObject(sql3, Long.class);
        System.out.println(count);
    }
}
