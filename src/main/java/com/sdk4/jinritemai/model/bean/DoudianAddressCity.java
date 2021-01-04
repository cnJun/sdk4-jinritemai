package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianAddressCity {
    /**
     * long整型，市ID
     */
    private Long cityId;

    /**
     * 市名称，中文
     */
    private String city;

    /**
     * long整型，父节点ID
     */
    private Long fatherId;
}
