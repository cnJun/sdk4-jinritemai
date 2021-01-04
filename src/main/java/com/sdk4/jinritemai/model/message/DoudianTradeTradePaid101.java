package com.sdk4.jinritemai.model.message;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单支付/确认消息
 *
 * https://op.jinritemai.com/docs/message-docs/30/110
 */
@Getter
@Setter
public class DoudianTradeTradePaid101 {
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
     * 订单创建时间
     */
    private Long createTime;

    /**
     * 父订单状态，订单支付消息的status值为"2"
     */
    private Integer orderStatus;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 订单业务类型
     */
    private Integer biz;
}
