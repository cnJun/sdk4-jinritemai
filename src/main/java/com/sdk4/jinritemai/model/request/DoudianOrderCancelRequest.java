package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianOrderCancelResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianOrderCancelRequest implements DoudianRequest<DoudianOrderCancelResponse> {
    private final String method = "order.cancel";

    /**
     * 父订单，订单号后面需要加大写字母"A"
     */
    private String orderId;

    /**
     * 取消订单的原因
     */
    private String reason;

    @Override
    public Class<DoudianOrderCancelResponse> getResponseClass() {
        return DoudianOrderCancelResponse.class;
    }
}
