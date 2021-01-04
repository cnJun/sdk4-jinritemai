package com.sdk4.jinritemai.model.message;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 交易完成消息
 *
 * https://op.jinritemai.com/docs/message-docs/30/112
 */
@Getter
@Setter
public class DoudianTradeTradeSuccess103 {
    /**
     * 父订单ID
     */
    private Long pId;

    /**
     * 子订单ID列表
     */
    private List<Long> sIds;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 父订单状态，交易完成消息的status值为"5"
     */
    private Integer orderStatus;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 交易完成时间
     */
    private Long completeTime;

    /**
     * 订单业务类型
     */
    private Integer biz;
}
