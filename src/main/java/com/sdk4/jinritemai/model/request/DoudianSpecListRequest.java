package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianSpecListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianSpecListRequest implements DoudianRequest<DoudianSpecListResponse> {
    private final String method = "spec.list";

    @Override
    public Class<DoudianSpecListResponse> getResponseClass() {
        return DoudianSpecListResponse.class;
    }
}
