package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianOrderListResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianOrderListRequest implements DoudianRequest<DoudianOrderListResponse> {
    private final String method = "order.list";

    /**
     * 子订单状态
     */
    private String orderStatus;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间，必须大于等于开始时间
     */
    private String endTime;

    /**
     * 排序
     */
    private String orderBy;

    /**
     * 订单排序方式：0按时间升序， 1按时间降序 默认为1
     */
    private String isDesc;

    /**
     * 页数（默认为0，第一页从0开始）
     */
    private Integer page = 0;

    /**
     * 每页订单数（默认为10，最大100）
     */
    private Integer size = 10;

    @Override
    public Class<DoudianOrderListResponse> getResponseClass() {
        return DoudianOrderListResponse.class;
    }
}
