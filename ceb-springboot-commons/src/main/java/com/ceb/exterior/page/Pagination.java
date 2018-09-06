package com.ceb.exterior.page;

import java.io.Serializable;

/**
 * @Author by zhangmin on 2018/9/5.15:18
 * 分页对象(前端传来参数)
 */

public class Pagination implements Serializable {

    // 每页的条数
    private int pageSize;

    // 当前页码
    private int page;

    private int totalCount;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
