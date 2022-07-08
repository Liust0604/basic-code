package cn.mori.web.service;

import cn.mori.web.domian.Province;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ProvinceService {
    /**
     * 查询所有省份
     *
     * @return
     */
    List<Province> findAllProvince();

    /**
     * Redis缓存 查询所有省份 JSON字符串
     *
     * @return
     */
    String findAllProvinceJson() throws JsonProcessingException;
}
