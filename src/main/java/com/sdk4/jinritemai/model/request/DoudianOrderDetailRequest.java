package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianOrderDetailResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianOrderDetailRequest implements DoudianRequest<DoudianOrderDetailResponse> {
    private final String method = "order.detail";

    /**
     * 父订单，订单号后面需要加大写字母"A"
     */
    private String orderId;

    @Override
    public Class<DoudianOrderDetailResponse> getResponseClass() {
        return DoudianOrderDetailResponse.class;
    }
}
