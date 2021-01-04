package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianProductListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianProductListRequest implements DoudianRequest<DoudianProductListResponse> {
    private final String method = "product.list";

    /**
     * 页数（默认为0，第一页从0开始）
     */
    private Integer page = 0;

    /**
     * 每页订单数（默认为10，最大100）
     */
    private Integer size = 10;

    /**
     * 指定状态返回商品列表：0上架 1下架
     */
    private String status;

    /**
     * 指定审核状态返回商品列表：1未提审 2审核中 3审核通过 4审核驳回 5封禁
     */
    private String checkStatus;

    @Override
    public Class<DoudianProductListResponse> getResponseClass() {
        return DoudianProductListResponse.class;
    }
}
