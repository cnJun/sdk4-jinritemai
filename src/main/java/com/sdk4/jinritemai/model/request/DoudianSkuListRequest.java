package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianSkuListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianSkuListRequest implements DoudianRequest<DoudianSkuListResponse> {
    private final String method = "sku.list";

    /**
     * 商品id
     */
    private Long productId;

    @Override
    public Class<DoudianSkuListResponse> getResponseClass() {
        return DoudianSkuListResponse.class;
    }
}
