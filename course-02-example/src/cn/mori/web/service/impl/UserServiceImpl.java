package cn.mori.web.service.impl;

import cn.mori.web.dao.UserDao;
import cn.mori.web.domian.PageBean;
import cn.mori.web.domian.User;
import cn.mori.web.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();

    @Override
    public User login(User user) {
        return userDao.findUserByUserNameAndPsw(user.getUsername(), user.getUserpsw());
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void delUserById(String id) {
        userDao.delUserById(id);
    }

    @Override
    public void delUsers(String[] ids) {
        userDao.delUsers(ids);
    }

    @Override
    public void updateUserById(User user) {
        userDao.updateUserById(user);
    }

    @Override
    public PageBean<User> findUserByPage(String currentPageStr, String pageSizeStr, Map<String, String[]> condition) {
        PageBean<User> pb = new PageBean<>();
        int currentPage = 1;
        int pageSize = 5;
        if (currentPageStr != null && !"".equals(currentPageStr) && Integer.parseInt(currentPageStr) >= 0) {
            currentPage = Integer.parseInt(currentPageStr);
        }
        if (pageSizeStr != null && !"".equals(pageSizeStr) && Integer.parseInt(pageSizeStr) >= 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        int totalCount = userDao.findTotalCount(condition);
        int totalPage = (totalCount % pageSize) == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        if (totalPage < currentPage) {
            currentPage = totalPage;
        }

        int startIndex = (currentPage - 1) * pageSize;
        List<User> list = userDao.findUserByPage(startIndex, pageSize, condition);

        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        pb.setStartIndex(startIndex);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public Map<String, Object> checkUserNameServlet(String username) {
        User user = userDao.findUserByUserName(username);
        Map<String, Object> map = new HashMap<>();
        if (user == null) {
            map.put("userExsit", true);
            map.put("msg", "用户名可用√");
        } else {
            map.put("userExsit", false);
            map.put("msg", "用户名已存在");
        }
        return map;
    }
}
