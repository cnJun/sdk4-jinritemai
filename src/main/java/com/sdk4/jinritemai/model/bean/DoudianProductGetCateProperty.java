package com.sdk4.jinritemai.model.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品分类对应的属性列表
 */
@Getter
@Setter
public class DoudianProductGetCateProperty {

    private Long propertyId;
    private String propertyName;
    private List<Option> options;
    private Boolean required;

    @Data
    public static class Option {

        private String name;
        private String value;
    }
}
