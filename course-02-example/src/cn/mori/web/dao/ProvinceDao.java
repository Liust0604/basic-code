package cn.mori.web.dao;

import cn.mori.web.domian.Province;

import java.util.List;

public interface ProvinceDao {
    /**
     * 查询全部省份
     *
     * @return
     */
    List<Province> findAllProvince();
}
