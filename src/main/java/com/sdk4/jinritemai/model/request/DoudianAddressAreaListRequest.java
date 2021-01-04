package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianAddressAreaListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianAddressAreaListRequest implements DoudianRequest<DoudianAddressAreaListResponse> {
    private final String method = "address.areaList";

    /**
     * 市ID
     */
    private Long cityId;

    @Override
    public Class<DoudianAddressAreaListResponse> getResponseClass() {
        return DoudianAddressAreaListResponse.class;
    }
}
