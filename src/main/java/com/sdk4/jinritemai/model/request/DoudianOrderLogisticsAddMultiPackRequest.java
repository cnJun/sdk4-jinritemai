package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.bean.DoudianShippedOrderInfo;
import com.sdk4.jinritemai.model.response.DoudianOrderLogisticsAddMultiPackResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoudianOrderLogisticsAddMultiPackRequest implements DoudianRequest<DoudianOrderLogisticsAddMultiPackResponse> {
    private final String method = "order.logisticsAddMultiPack";

    /**
     * 父订单ID，需在结尾带上大写字母A
     */
    private String orderId;

    /**
     * 包裹list
     */
    private List<Pack> packList;

    /**
     * 请求唯一标识
     */
    private String requestId;

    @Override
    public Class<DoudianOrderLogisticsAddMultiPackResponse> getResponseClass() {
        return DoudianOrderLogisticsAddMultiPackResponse.class;
    }

    @Getter
    @Setter
    public static class Pack {
        /**
         * 需要发货的子订单信息列表
         */
        private List<DoudianShippedOrderInfo> shippedOrderInfo;

        /**
         * 物流公司ID，由接口/order/logisticsCompanyList返回的物流公司列表中对应的ID
         */
        private Long logisticsId;

        /**
         * 物流公司名称
         */
        private String company;

        /**
         * 运单号
         */
        private String logisticsCode;
    }
}
