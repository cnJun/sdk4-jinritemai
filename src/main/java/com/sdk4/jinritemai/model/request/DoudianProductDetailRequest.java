package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianProductDetailResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianProductDetailRequest implements DoudianRequest<DoudianProductDetailResponse> {
    private final String method = "product.detail";

    /**
     * 商品id
     */
    private Long productId;

    /**
     * "true"：读取草稿数据；"false"：读取上架数据
     */
    private Boolean showDraft;

    @Override
    public Class<DoudianProductDetailResponse> getResponseClass() {
        return DoudianProductDetailResponse.class;
    }
}
