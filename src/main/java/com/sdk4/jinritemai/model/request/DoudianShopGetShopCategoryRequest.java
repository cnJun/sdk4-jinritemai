package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianShopGetShopCategoryResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianShopGetShopCategoryRequest implements DoudianRequest<DoudianShopGetShopCategoryResponse> {
    private final String method = "shop.getShopCategory";

    /**
     * 父类目id，根据父id可以获取子类目，一级类目cid=0
     */
    private Long cid = 0L;

    @Override
    public Class<DoudianShopGetShopCategoryResponse> getResponseClass() {
        return DoudianShopGetShopCategoryResponse.class;
    }
}
