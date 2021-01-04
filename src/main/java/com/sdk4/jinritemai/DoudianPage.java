package com.sdk4.jinritemai;

import com.sdk4.jinritemai.util.DoudianUtils;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.sdk4.jinritemai.util.DoudianUtils.isNotEmpty;

@Setter
public class DoudianPage<T> {
    /**
     * 商品总数
     */
    private Integer total;

    /**
     * 商品总数
     */
    private Integer all;

    /**
     * 以当前size所得的分页数
     */
    private Integer allPages;

    /**
     * 当前条件data返回结果数量
     */
    private Integer count;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 数据列表
     */
    private List<T> data;

    /**
     * 数据列表
     */
    private List<T> list;

    public int getTotal() {
        return DoudianUtils.returnAnyGreaterThanZero(all, total);
    }

    public int getPageNumber() {
        return DoudianUtils.returnAnyGreaterThanZero(currentPage);
    }

    public int getPageSize() {
        return DoudianUtils.returnAnyGreaterThanZero(pageSize);
    }

    public List<T> getPageData() {
        return isNotEmpty(data) ? data : isNotEmpty(list) ? list : new ArrayList<>(0);
    }
}
