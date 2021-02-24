package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianProductGetCatePropertyResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianProductGetCatePropertyRequest implements
        DoudianRequest<DoudianProductGetCatePropertyResponse> {

    private final String method = "product.getCateProperty";

    private String firstCid;
    private String secondCid;
    private String thirdCid;
    private String categoryLeafId;

    @Override
    public Class<DoudianProductGetCatePropertyResponse> getResponseClass() {
        return DoudianProductGetCatePropertyResponse.class;
    }
}
