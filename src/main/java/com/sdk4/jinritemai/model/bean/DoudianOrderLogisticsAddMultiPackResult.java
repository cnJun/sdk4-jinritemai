package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoudianOrderLogisticsAddMultiPackResult {
    /**
     * 包裹列表
     */
    private List<Pack> packList;

    @Getter
    @Setter
    public static class Pack {
        /**
         * 已发货子订单信息
         */
        private DoudianShippedOrderInfo shippedOrderInfo;

        /**
         * 包裹ID
         */
        private String packId;

        /**
         * 物流单号
         */
        private String logisticsCode;
    }
}
