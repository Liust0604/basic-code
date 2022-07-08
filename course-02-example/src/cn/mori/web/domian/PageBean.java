package cn.mori.web.domian;

import java.util.List;

/**
 * 分页实体类
 * <p>
 * MYSQL分页：limit startIndex, pageSize; (limit 开始条索引, 每页几条;)
 * startIndex = (currentPage - 1) * pageSize
 * <p>
 * 为了接收不同类型结果，添加泛型
 */
public class PageBean<T> {
    private int currentPage; //当前页码。客户端获取，1开始
    private int pageSize; //每页几条。客户端获取
    private int startIndex; //开始索引。服务器计算
    private List<T> list; //数据
    private int totalCount; //总条数。服务器查询
    private int totalPage; //总页数。服务器计算，totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;

    public PageBean() {
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", startIndex=" + startIndex +
                ", list=" + list +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}

