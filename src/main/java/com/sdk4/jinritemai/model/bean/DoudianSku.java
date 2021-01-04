package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * sku信息
 */
@Getter
@Setter
public class DoudianSku {
    /**
     * sku编号
     */
    private Long id;

    /**
     * 已废弃，无业务意义
     */
    @Deprecated
    private Long openUserId;

    /**
     * sku外部ID
     */
    private Long outSkuId;

    /**
     * 商品ID，整型格式
     */
    private Long productId;

    /**
     * 商品ID，字符串格式
     */
    private String productIdStr;

    /**
     * 一级规格id
     */
    private Long specDetailId1;

    /**
     * 二级规格id，缺失为0
     */
    private Long specDetailId2;

    /**
     * 三级规格id，缺失为0，最多三级
     */
    private Long specDetailId3;

    /**
     * 第一级子规格名称
     */
    private String specDetailName1;

    /**
     * 第二级子规格名称
     */
    private String specDetailName2;

    /**
     * 第三级子规格名称
     */
    private String specDetailName3;

    /**
     * 剩余库存数，如果sku_type=0，表示普通库存；如果sku_type=1，则为空
     */
    private Integer stockNum;

    /**
     * 价格，单位分
     */
    private Integer price;

    /**
     * 已废弃，无业务意义
     */
    @Deprecated
    private Integer settlementPrice;

    /**
     * 规格组ID
     */
    private Long specId;

    /**
     * sku创建时间
     */
    private Long createTime;

    /**
     * sku对应的商家编码
     */
    private String code;

    /**
     * 库存类型：0普通库存，1区域库存
     */
    private Integer skuType;

    /**
     * 区域仓库存信息，out_warehouse_id与stock_num对应关系
     */
    private Map<String, Integer> stockMap;
}
