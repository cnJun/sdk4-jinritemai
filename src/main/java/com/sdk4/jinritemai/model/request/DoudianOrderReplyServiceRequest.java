package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianOrderReplyServiceResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianOrderReplyServiceRequest implements DoudianRequest<DoudianOrderReplyServiceResponse> {
    private final String method = "order.replyService";

    /**
     * 服务请求列表中获取的id
     */
    private String id;

    /**
     * 回复内容
     */
    private String reply;

    @Override
    public Class<DoudianOrderReplyServiceResponse> getResponseClass() {
        return DoudianOrderReplyServiceResponse.class;
    }
}
