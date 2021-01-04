package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianAddressArea {
    /**
     * long整型，市ID
     */
    private Long areaId;

    /**
     * 区县名称，中文
     */
    private String area;

    /**
     * long整型，父节点ID
     */
    private Long fatherId;
}
