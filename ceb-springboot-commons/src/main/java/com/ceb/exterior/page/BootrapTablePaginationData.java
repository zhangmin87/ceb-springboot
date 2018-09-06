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

    public BootrapTablePaginationData(int total, List<T> rows) {
            this.total = total;
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
