package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;
import java.util.Map;

public interface RouteDao {

    /**
     * 根据cid查询总记录数
     */
    public int findTotalCount(Map<String, String[]> condition);

    /**
     * 根据cid，start,pageSize查询当前页的数据集合
     */
    public List<Route> findByPage(int start, int pageSize, Map<String, String[]> condition);

    /**
     * 根据id查询
     *
     * @param rid
     * @return
     */
    public Route findOne(int rid);
}
