package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoudianShippedOrderInfo {
    /**
     * 需要发货的子订单id
     */
    private String shippedOrderId;

    /**
     * 上述子订单的待发货数
     */
    private Integer shippedNum;

    /**
     * 需要发货的子订单下的品ID列表
     * 传了之后表示该包裹指定要发这几件
     * 品ID数，要与shipped_num值一致
     */
    private List<String> shippedItemIds;
}
