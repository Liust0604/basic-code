package cn.mori.web.dao;

import cn.mori.web.domian.User;
import cn.mori.web.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

/**
 * 操作数据库中User表的类
 */
public class UserDao {

    //声明Spring JDBC的 JdbcTemplate，这个UserDao操作User数据表时，可以共用一个JdbcTemplate。传入一个连接池
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * @param loginUser 只有用户名密码
     * @return user 包含从数据查询到的，用户全部数据
     */
    public User login(User loginUser) {
        try {
            String username = loginUser.getUsername();
            String userpsw = loginUser.getUserpsw();

            String sql = "select * from db2.user where username = ? && userpsw = ?";
            List<User> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username, userpsw);
            if (result.size() > 0 && result.get(0) != null) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public User findUserById(String id) {
        User user = null;
        try {
            String sql = "select * from db2.user where id = ?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User findUserByUserNameAndPsw(String username, String userpsw) {
        User user = null;
        try {
            String sql = "select * from db2.user where username = ? && userpsw = ?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, userpsw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(User user) {
        String sql = "INSERT INTO db2.`user`\n" +
                "(username, userpsw, name, age, address, qq, email)\n" +
                "VALUES(null, null, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    public List<User> findAll() {
        try {
            String sql = "select * from db2.`user` where 1=1 order by id asc";
            List<User> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
            if (result.size() > 0 && result.get(0) != null) {
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void delUserById(String id) {
        String sql = "delete from db2.`user` where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void delUsers(String[] ids) {
        String inStr = Arrays.toString(ids).replaceAll("\\[", "(").replaceAll("]", ")");
        String sql = "delete from db2.`user` where id in " + inStr;
        jdbcTemplate.update(sql);
    }

    public void updateUserById(User user) {
        String sql = "UPDATE db2.`user`\n" +
                "SET name =?,  age=?, address=?, qq=?, email=?\n" +
                "WHERE id=?;\n";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    public List<User> findUserByPage(int startIndex, int pageSize, Map<String, String[]> condition) {
        //动态sql
        String sql = "select * from db2.`user` where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        if (condition.size() > 0) {
            Set<Map.Entry<String, String[]>> entries = condition.entrySet();
            for (Map.Entry<String, String[]> entry : entries) {
                String key = entry.getKey();
                String value = entry.getValue()[0];
                if ("currentPage".equals(key) || "pageSize".equals(key)) {
                    continue;
                }
                if (value != null && !"".equals(value)) {
                    sb.append("and `" + key + "` like ? ");
                    params.add("%" + value + "%");
                }
            }
        }
        sb.append("order by id asc limit ?,? ");
        params.add(startIndex);
        params.add(pageSize);

        sql = sb.toString();
        List<User> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), params.toArray());
        return result;
    }

    public int findTotalCount(Map<String, String[]> condition) {
        //动态sql
        String sql = "select count(*) from db2.`user` where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        if (condition.size() > 0) {
            Set<Map.Entry<String, String[]>> entries = condition.entrySet();
            for (Map.Entry<String, String[]> entry : entries) {
                String key = entry.getKey();
                String value = entry.getValue()[0];
                if ("currentPage".equals(key) || "pageSize".equals(key)) {
                    continue;
                }
                if (value != null && !"".equals(value)) {
                    sb.append("and `" + key + "` like ? ");
                    params.add("%" + value + "%");
                }
            }
        }
        sql = sb.toString();
        int count = jdbcTemplate.queryForObject(sql, Integer.class, params.toArray());
        return count;
    }

    public User findUserByUserName(String username) {
        try {
            String sql = "select * from db2.user where username = ?";
            List<User> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username);
            if (result.size() > 0 && result.get(0) != null) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
