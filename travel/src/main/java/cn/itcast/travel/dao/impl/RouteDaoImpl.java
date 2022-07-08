package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        List params = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (condition.size() > 0) {
            Set<Map.Entry<String, String[]>> entries = condition.entrySet();
            for (Map.Entry<String, String[]> entry : entries) {
                String key = entry.getKey();
                String value = entry.getValue()[0];
                if (value != null && value.length() > 0 && !"null".equals(value)) {
                    if ("cid".equals(key)) {
                        sb.append(" and cid = ? ");
                        params.add(Integer.parseInt(value));
                    } else if ("rname".equals(key)) {
                        sb.append(" and rname like ? ");
                        //解决乱码问题
                        try {
                            value = new String(value.getBytes("iso-8859-1"), "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        params.add("%" + value + "%");
                    }
                }
            }
        }
        String sql = "select count(*) from tab_route where 1=1 " + sb.toString();
        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<Route> findByPage(int start, int pageSize, Map<String, String[]> condition) {
        List params = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (condition.size() > 0) {
            Set<Map.Entry<String, String[]>> entries = condition.entrySet();
            for (Map.Entry<String, String[]> entry : entries) {
                String key = entry.getKey();
                String value = entry.getValue()[0];
                if (value != null && value.length() > 0 && !"null".equals(value)) {
                    if ("cid".equals(key)) {
                        sb.append(" and cid = ? ");
                        params.add(Integer.parseInt(value));
                    } else if ("rname".equals(key)) {
                        sb.append(" and rname like ? ");
                        //解决乱码问题
                        try {
                            value = new String(value.getBytes("iso-8859-1"), "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        params.add("%" + value + "%");
                    }
                }
            }
        }
        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(pageSize);
        String sql = "select * from tab_route where 1=1 " + sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
    }
}
