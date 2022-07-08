package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

import java.util.Map;

/**
 * 线路Service
 */
public interface RouteService {

    /**
     * 根据类别进行分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> pageQuery(int currentPage, int pageSize, Map<String, String[]> condition);

    /**
     * 根据id查询
     *
     * @param rid
     * @return
     */
    public Route findOne(String rid);
}
