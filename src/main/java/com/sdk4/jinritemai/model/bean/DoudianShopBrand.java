package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 已授权品牌信息
 */
@Getter
@Setter
public class DoudianShopBrand {
    /**
     * 品牌ID
     */
    private Long id;

    /**
     * 品牌中文名
     */
    private String brandChineseName;

    /**
     * 品牌英文名
     */
    private String brandEnglishName;

    /**
     * 商标注册号
     */
    private String brandRegNum;
}
