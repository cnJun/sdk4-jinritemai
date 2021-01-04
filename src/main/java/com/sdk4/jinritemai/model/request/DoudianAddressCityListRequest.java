package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianAddressCityListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianAddressCityListRequest implements DoudianRequest<DoudianAddressCityListResponse> {
    private final String method = "address.cityList";

    /**
     * 省ID
     */
    private Long provinceId;

    @Override
    public Class<DoudianAddressCityListResponse> getResponseClass() {
        return DoudianAddressCityListResponse.class;
    }
}
