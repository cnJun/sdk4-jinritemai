package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianOrderService {
    /**
     * 服务请求ID
     */
    private Long id;

    private String orderId;

    /**
     * 商家答复内容
     */
    private String reply;

    /**
     * 服务单详情
     */
    private String detail;

    /**
     * 服务创建时间
     */
    private String createTime;

    /**
     * 操作状态
     */
    private Integer operateStatus;

    /**
     * 操作状态含义
     */
    private String operateStatusDesc;

    /**
     * 操作人id(客服)
     */
    private Long operatorId;

    /**
     * 回复时间
     */
    private String replyTime;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 供应商id
     */
    private Long supplyId;

    /**
     * 回复人id
     */
    private Long replyOpId;

}
