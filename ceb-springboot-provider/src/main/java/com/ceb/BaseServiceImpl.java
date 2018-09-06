package com.ceb;

import com.ceb.exterior.page.Pagination;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * @Author by zhangmin on 2018/9/6.11:09
 */
public abstract class BaseServiceImpl {

    /**
     *  适应boostrap 分页方法
     * @param op  分页参数
     * @param iSelect 分页接口(自己查询的分页接口)
     * @param <E>
     * @return
     */
    protected <E> List<E> executeQuery(Pagination op , ISelect iSelect) {
        Page page1 = PageHelper.startPage(op.getPage(), op.getPageSize()).doSelectPage(iSelect);
        op.setTotalCount((int)page1.getTotal());
        return page1.getResult();
    }
}
