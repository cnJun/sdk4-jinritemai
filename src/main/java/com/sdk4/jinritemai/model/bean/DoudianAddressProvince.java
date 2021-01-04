package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianAddressProvince {
    /**
     * long整型，省ID
     */
    private Long provinceId;

    /**
     * 省名称，中文
     */
    private String province;

    /**
     * long整型，父节点ID
     */
    private Long fatherId;
}
