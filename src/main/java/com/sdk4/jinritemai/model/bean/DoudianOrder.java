package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单信息
 */
@Getter
@Setter
public class DoudianOrder {
    /**
     * 父订单ID，带大写字母A
     */
    private String orderId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 在抖音小程序下单时，买家的抖音小程序ID
     */
    private String openId;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 订单类型 (0实物，2普通虚拟，4poi核销，5三方核销，6服务市场)
     */
    private Integer orderType;

    /**
     * 子订单列表
     */
    private List<DoudianOrderChild> child;

    /**
     * 父订单已发货商品数量
     */
    private Integer shippedNum;

    /**
     * 父订单已发货包裹信息
     */
    private List<Logistics> logisticsList;

    /**
     * 子订单数量
     */
    private Integer childNum;

    /**
     * 收件人地址
     */
    private PostAddr postAddr;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 收件人姓名
     */
    private String postReceiver;

    /**
     * 收件人电话
     */
    private String postTel;

    /**
     * 买家备注
     */
    private String buyerWords;

    /**
     * 卖家备注
     */
    private String sellerWords;

    /**
     * 物流公司ID
     */
    private Long logisticsId;

    /**
     * 物流单号
     */
    private String logisticsCode;

    /**
     * 发货时间。未发货时为"0"，已发货返回秒级时间戳
     */
    private String logisticsTime;

    /**
     * 收货时间。未收货时为"0"，已发货返回秒级时间戳
     */
    private String receiptTime;

    /**
     * 订单创建时间，例如 "1512553757"
     */
    private String createTime;

    /**
     * 订单更新时间
     */
    private String updateTime;

    /**
     * 订单最晚发货时间，例如 1512553887
     */
    private String expShipTime;

    /**
     * 订单取消原因
     */
    private String cancelReason;

    /**
     * 支付类型 (0：货到付款，1：微信，2：支付宝）
     */
    private Integer payType;

    /**
     * 支付时间 (pay_type为0货到付款时, 此字段为空)，例如"2018-06-01 12:00:00"
     */
    private String payTime;

    /**
     * 邮费金额 (单位: 分)
     */
    private Integer postAmount;

    /**
     * 平台优惠券金额 (单位: 分)
     */
    private Integer couponAmount;

    /**
     * 商家优惠券金额 (单位: 分)
     */
    private Integer shopCouponAmount;

    /**
     * 优惠券id
     */
    private String couponMetaId;

    /**
     * 优惠券详情 (type为优惠券类型，具体如下表所示, credit为优惠金额,单位分)
     */
    private List<CouponInfo> couponInfo;

    /**
     * 订单实付金额（包含运费）
     */
    private Integer orderTotalAmount;

    /**
     * 是否评价 :1已评价，0未评价
     */
    private String isComment;

    /**
     * 催单次数
     */
    private Integer urgeCnt;

    /**
     * 订单APP渠道
     */
    private String bType;

    /**
     * 订单来源类型
     */
    private Integer subBType;

    /**
     * 物流单号
     */
    private Integer cBiz;

    /**
     * 是否有退货运费险
     */
    private String isInsurance;

    /**
     * 已废弃，无业务意义
     */
    @Deprecated
    private String cType;

    /**
     * 已废弃，无业务意义
     */
    @Deprecated
    private String cosRatio;

    /**
     * 暂无实际意义
     */
    private String userName;

    @Setter
    @Getter
    public static class Logistics {
        /**
         * 包裹ID
         */
        private String packId;

        /**
         * 包裹中已发货商品数量
         */
        private Integer shippedNum;

        /**
         * 包裹的物流公司ID
         */
        private String logisticsCompanyId;

        /**
         * 包裹的物流单号
         */
        private String logisticsCode;

        /**
         * 包裹的发货时间
         */
        private String logisticsTime;

        /**
         * 包裹中已发货的子订单列表
         */
        private List<DoudianOrderChild> shippedOrderList;

        /**
         * 已发货子订单号
         */
        private String shippedOrderId;

        /**
         * 已发货子订单中，已发货的品ID列表
         */
        private String shippedItemIds;

        /**
         * 已发货子订单的sku数量
         */
        private Integer skuNum;
    }

    @Getter
    @Setter
    public static class PostAddr {
        /**
         * 省份
         */
        private IdName province;

        /**
         * 城市
         */
        private IdName city;

        /**
         * 县区
         */
        private IdName town;

        /**
         * 详情地址
         */
        private String detail;
    }

    @Getter
    @Setter
    public static class IdName {
        private Long id;
        private String name;
    }

    @Getter
    @Setter
    public static class CouponInfo {
        /**
         * 优惠券批次号
         */
        private Long id;

        /**
         * 优惠券名称
         */
        private String name;

        /**
         * 优惠券描述
         */
        private String description;

        /**
         * 满减/直减券金额(单位分)
         */
        private Integer credit;

        /**
         * 优惠券类型
         */
        private Integer type;

        /**
         * 折扣券折扣
         */
        private Integer discount;

        /**
         * 支付类型 (0：货到付款，1：微信，2：支付宝）
         */
        private Integer payType;
    }
}
