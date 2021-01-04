package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianOrderLogisticsCompanyListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianOrderLogisticsCompanyListRequest implements DoudianRequest<DoudianOrderLogisticsCompanyListResponse> {
    private final String method = "order.logisticsCompanyList";

    @Override
    public Class<DoudianOrderLogisticsCompanyListResponse> getResponseClass() {
        return DoudianOrderLogisticsCompanyListResponse.class;
    }
}
