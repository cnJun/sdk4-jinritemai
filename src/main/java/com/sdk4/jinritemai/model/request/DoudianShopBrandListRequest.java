package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianShopBrandListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianShopBrandListRequest implements DoudianRequest<DoudianShopBrandListResponse> {
    private final String method = "shop.brandList";

    @Override
    public Class<DoudianShopBrandListResponse> getResponseClass() {
        return DoudianShopBrandListResponse.class;
    }
}
