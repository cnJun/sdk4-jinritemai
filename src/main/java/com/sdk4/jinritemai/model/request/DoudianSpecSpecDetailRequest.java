package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianSpecSpecDetailResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianSpecSpecDetailRequest implements DoudianRequest<DoudianSpecSpecDetailResponse> {
    private final String method = "spec.specDetail";

    /**
     * 规格id (spec_id)
     */
    private Long id;

    @Override
    public Class<DoudianSpecSpecDetailResponse> getResponseClass() {
        return DoudianSpecSpecDetailResponse.class;
    }
}
