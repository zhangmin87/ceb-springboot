package com.ceb.exterior.page;

import java.io.Serializable;
import java.util.List;

/**
 * @Author by zhangmin on 2018/9/5.12:11
 * 分页对象，适配boostrap
 */
public class BootrapTablePaginationData<T> implements Serializable {
    private int total;
    private List<T> rows;


    // 对象进行序列化和反序列化有什么的必须有一个无参数构造器，不然报错
    public BootrapTablePaginationData() {

    }

    public BootrapTablePaginationData(Pagination pagination, List<T> rows) {
            this.total = pagination.getTotalCount();
            this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
