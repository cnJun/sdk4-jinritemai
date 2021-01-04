package com.sdk4.jinritemai.model.bean;

import com.sdk4.jinritemai.model.bean.DoudianOrder.CouponInfo;
import com.sdk4.jinritemai.model.bean.DoudianOrder.PostAddr;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoudianOrderChild {
    /**
     * 父订单ID，带大写字母A
     */
    private String orderId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 该子订单对应的父订单ID
     */
    private String pid;

    /**
     * 子订单状态
     */
    private Integer finalStatus;

    /**
     * 在抖音小程序下单时，买家的抖音小程序ID
     */
    private String openId;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 头图，商品主图第一张
     */
    private String productPic;

    /**
     * 该子订单购买的商品 sku_id
     */
    private Long comboId;

    /**
     * 该子订单所购买的sku的售价
     */
    private Integer comboAmount;

    /**
     * 该子订单所购买的sku的数量
     */
    private Integer comboNum;

    /**
     * 该子订单购买的商品的编码 code
     */
    private String code;

    /**
     * 该子订单所属商品规格描述
     */
    private List<SpecDesc> specDesc;

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
     * 订单类型 (0实物，2普通虚拟，4poi核销，5三方核销，6服务市场)
     */
    private Integer orderType;

    /**
     * 订单预售类型 (1:全款预售订单)
     */
    private Integer preSaleType;

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
    private String postAmount;

    /**
     * 平台优惠券金额 (单位: 分)
     */
    private Integer couponAmount;

    /**
     * 商家优惠券金额 (单位: 分)
     */
    private String shopCouponAmount;

    /**
     * 优惠券id
     */
    private String couponMetaId;

    /**
     * 优惠券详情 (type为优惠券类型，具体如下表所示, credit为优惠金额,单位分)
     */
    private List<CouponInfo> couponInfo;

    /**
     * 子订单实付金额（不包含运费）
     */
    private Integer totalAmount;

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
     * 订单业务类型
     */
    private Integer cBiz;

    /**
     * 是否有退货运费险
     */
    private String isInsurance;

    /**
     * 已废弃，无业务意义
     */
    private String cType;

    /**
     * 已废弃，无业务意义
     */
    private String cosRatio;

    /**
     * 暂无实际意义
     */
    private String userName;

    /**
     * 仓库ID
     */
    private Long warehouseId;

    /**
     * 仓库外部ID
     */
    private String outWarehouseId;

    /**
     * 供应商ID
     */
    private String warehouseSupplier;

    //     shop_full_campaign	[]ShopFullCampaign	该子订单所使用的店铺满减优惠信息

    /**
     * 店铺满减活动ID
     */
    private Long shopCampaignId;

    /**
     * 分摊到该子订单上的满减金额，单位：分
     */
    private String shopFullAmount;

    /**
     * 该子订单所使用的平台满减金额，单位：分
     */
    private String platformFullAmount;

    // platform_full_campaign	[]PlatformFullCampaign	该子订单所使用的平台满减优惠信息

    /**
     * 平台满减活动ID
     */
    private Long platformCampaignId;

    // cost_source	[]CostSource	平台满减分摊详情

    /**
     * 店铺或平台承担的金额，单位：分
     */
    private Integer promotionAmount;

    /**
     * 优惠由谁承担：1-店铺承担，2-平台承担
     */
    private Integer sourceType;

    /**
     * 子订单已发货商品数量
     */
    private Integer shippedNum;

    /**
     * 子订单中的品id列表
     */
    private List<String> itemIds;

    @Getter
    @Setter
    public static class SpecDesc {
        private String name;
        private String value;
    }
}
