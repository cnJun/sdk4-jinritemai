package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianSpecDelResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianSpecDelRequest implements DoudianRequest<DoudianSpecDelResponse> {
    private final String method = "spec.del";

    /**
     * 规格id (spec_id)
     */
    private Long id;

    @Override
    public Class<DoudianSpecDelResponse> getResponseClass() {
        return DoudianSpecDelResponse.class;
    }
}
