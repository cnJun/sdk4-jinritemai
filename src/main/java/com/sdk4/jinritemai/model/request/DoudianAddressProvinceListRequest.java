package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianAddressProvinceListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianAddressProvinceListRequest implements DoudianRequest<DoudianAddressProvinceListResponse> {
    private final String method = "address.provinceList";

    @Override
    public Class<DoudianAddressProvinceListResponse> getResponseClass() {
        return DoudianAddressProvinceListResponse.class;
    }
}
