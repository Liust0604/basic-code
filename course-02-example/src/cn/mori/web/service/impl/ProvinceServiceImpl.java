package cn.mori.web.service.impl;


import cn.mori.web.dao.ProvinceDao;
import cn.mori.web.dao.impl.ProvinceDaoImpl;
import cn.mori.web.domian.Province;
import cn.mori.web.service.ProvinceService;
import cn.mori.web.util.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvinceServiceImpl implements ProvinceService {

    ProvinceDao provinceDao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAllProvince() {
        return provinceDao.findAllProvince();
    }

    @Override
    public String findAllProvinceJson() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String provinceJson = jedis.get("province");
        if (provinceJson == null || provinceJson.length() == 0) {
            List<Province> list = provinceDao.findAllProvince();
            Map<String, Object> map = new HashMap();
            map.put("provinces", list);
            ObjectMapper mapper = new ObjectMapper();
            try {
                provinceJson = mapper.writeValueAsString(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province", provinceJson);
            JedisPoolUtils.closeJedis(jedis);
        }
        return provinceJson;
    }
}
