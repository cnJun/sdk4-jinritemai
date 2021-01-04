package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianOrderStockUpResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianOrderStockUpRequest implements DoudianRequest<DoudianOrderStockUpResponse> {
    private final String method = "order.stockUp";

    /**
     * 父订单，订单号后面需要加大写字母"A"
     */
    private String orderId;

    @Override
    public Class<DoudianOrderStockUpResponse> getResponseClass() {
        return DoudianOrderStockUpResponse.class;
    }
}
