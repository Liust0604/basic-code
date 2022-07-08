package cn.mori.web.service;

import cn.mori.web.domian.PageBean;
import cn.mori.web.domian.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 登录方法
     *
     * @param user
     * @return
     */
    User login(User user);


    /**
     * 查询全部user
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询一个user
     *
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 添加一个user
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 删除
     *
     * @param id
     */
    void delUserById(String id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void delUsers(String[] ids);

    /**
     * 修改
     *
     * @param user
     */
    void updateUserById(User user);

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String pageSize, Map<String, String[]> condition);

    Map<String, Object> checkUserNameServlet(String username);
}
