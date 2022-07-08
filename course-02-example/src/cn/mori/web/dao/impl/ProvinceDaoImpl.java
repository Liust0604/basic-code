package cn.mori.web.dao.impl;

import cn.mori.web.dao.ProvinceDao;
import cn.mori.web.domian.Province;
import cn.mori.web.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAllProvince() {
        String sql = "select * from db2.province";
        List<Province> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Province.class));
        return result;
    }
}
