package com.sdk4.jinritemai.model.message;

import lombok.Getter;
import lombok.Setter;

/**
 * 确认收货并二次发货成功
 *
 * https://op.jinritemai.com/docs/message-docs/31/240
 */
@Getter
@Setter
public class DoudianRefundExchangeComfirmed211 {
    /**
     * 子订单ID
     */
    private Long sId;

    /**
     * 父订单ID
     */
    private Long pId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 售后单ID
     */
    private Long aftersaleId;

    /**
     * 售后状态，枚举值如下
     */
    private Integer aftersaleStatus;

    /**
     * 售后类型：
     * 0: 退货
     * 1: 售后仅退款
     * 2: 发货前整单退款
     * 3：换货
     */
    private Integer aftersaleType;

    /**
     * 申请退款的金额（含运费）
     */
    private Integer refundAmount;

    /**
     * 申请退的运费金额
     */
    private Integer refundPostAmount;

    /**
     * 申请退款的卡券的数量
     */
    private Integer refundVoucherNum;

    /**
     * 申请售后原因码
     */
    private String reasonCode;

    /**
     * 最近一条操作记录
     */
    private String latestRecord;
}
