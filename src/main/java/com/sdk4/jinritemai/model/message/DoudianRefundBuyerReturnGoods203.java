package com.sdk4.jinritemai.model.message;

import lombok.Getter;
import lombok.Setter;

/**
 * 买家退货给卖家消息
 *
 * https://op.jinritemai.com/docs/message-docs/31/118
 */
@Getter
@Setter
public class DoudianRefundBuyerReturnGoods203 {
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
     * 退货物流单号
     */
    private String logistics;

    /**
     * 退货物流提交时间
     */
    private Long returnTime;

    /**
     * 最近一条操作记录
     */
    private String latestRecord;
}
