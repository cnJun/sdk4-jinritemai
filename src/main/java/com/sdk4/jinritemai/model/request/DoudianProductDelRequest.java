package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianProductDelResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianProductDelRequest implements DoudianRequest<DoudianProductDelResponse> {
    private final String method = "product.del";

    /**
     * 商品ID
     */
    private Long productId;

    @Override
    public Class<DoudianProductDelResponse> getResponseClass() {
        return DoudianProductDelResponse.class;
    }
}
