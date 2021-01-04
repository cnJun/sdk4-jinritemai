package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianSpecAddResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianSpecAddRequest implements DoudianRequest<DoudianSpecAddResponse> {
    private final String method = "spec.add";

    /**
     * 店铺通用规格，能被同类商品通用。多规格用^分隔，父规格与子规格用|分隔，子规格用,分隔
     */
    private String specs;

    /**
     * 如果不填，则规格名为子规格名用 "-" 自动生成
     *
     * @return
     */
    private String name;

    @Override
    public Class<DoudianSpecAddResponse> getResponseClass() {
        return DoudianSpecAddResponse.class;
    }
}
