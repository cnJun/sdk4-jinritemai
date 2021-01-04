package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianOrderServiceListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianOrderServiceListRequest implements DoudianRequest<DoudianOrderServiceListResponse> {
    private final String method = "order.serviceList";

    /**
     * 开始时间时间戳，必须大于等于开始时间
     */
    private String startTime;

    /**
     * 结束时间时间戳
     */
    private String endTime;

    /**
     * 1、不传代表获取全部服务请求
     * 2、操作状态：0待处理，1已处理
     */
    private String status;

    /**
     * 是否获取分销商服务申请，0获取本店铺的服务申请，1获取分销商的服务申请
     */
    private String supply;

    /**
     * 页数（默认为0，第一页从0开始）
     */
    private Integer page = 0;

    /**
     * 每页订单数（默认为10，最大100）
     */
    private Integer size = 10;

    @Override
    public Class<DoudianOrderServiceListResponse> getResponseClass() {
        return DoudianOrderServiceListResponse.class;
    }
}
