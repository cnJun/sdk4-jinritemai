package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.bean.DoudianShippedOrderInfo;
import com.sdk4.jinritemai.model.response.DoudianOrderLogisticsCompanyListResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoudianOrderLogisticsAddSinglePackRequest implements DoudianRequest<DoudianOrderLogisticsCompanyListResponse> {
    private final String method = "order.logisticsAddSinglePack";

    /**
     * 父订单ID列表，需在结尾带上大写字母A
     */
    private List<String> orderIdList;

    /**
     * 需要发货的子订单信息
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

    /**
     * 请求唯一标识
     */
    private String requestId;

    @Override
    public Class<DoudianOrderLogisticsCompanyListResponse> getResponseClass() {
        return DoudianOrderLogisticsCompanyListResponse.class;
    }
}
