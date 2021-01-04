package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 店铺后台供商家发布商品的类目
 */
@Getter
@Setter
public class DoudianShopCategory {
    /**
     * 类目id
     */
    private Long id;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类目级别：1，2，3级类目
     */
    private Integer level;

    /**
     * 父类目id
     */
    private Long parentId;

    /**
     * 是否是叶子节点
     */
    private String isLeaf;

    /**
     * 是否有效
     */
    private String enable;
}
