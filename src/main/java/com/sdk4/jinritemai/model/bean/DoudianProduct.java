package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品信息
 */
@Getter
@Setter
public class DoudianProduct {
    /**
     * 商品ID，整型格式
     */
    private Long productId;

    /**
     * 商品ID，字符串格式
     */
    private String productIdStr;

    /**
     * 商品外部ID
     */
    private Long outProductId;

    /**
     * open应用id （废弃）
     */
    private Long openUserId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 详情html
     */
    private String description;

    /**
     * 划线价，单位分
     */
    private Integer marketPrice;

    /**
     * 售价，单位分
     */
    private Integer discountPrice;

    /**
     * 商品上下架状态：0上架 1下架 2已删除
     */
    private Integer status;

    /**
     * 规格id
     */
    private Integer specId;

    /**
     * 商品审核状态：1未提审 2审核中 3审核通过 4审核驳回 5封禁
     */
    private Integer checkStatus;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 一级类目
     */
    private Long firstCid;

    /**
     * 二级类目
     */
    private Long secondCid;

    /**
     * 三级类目
     */
    private Long thirdCid;

    /**
     * 支持的支付方式：0货到付款 1在线支付 2两者都支持
     */
    private Integer payType;

    /**
     * 商家推荐语
     */
    private String recommendRemark;

    /**
     * 预售类型，1-全款预售，0-非预售，2-阶梯库存，默认0
     */
    private String presellType;

    /**
     * 扩展字段
     */
    private String extra;

    /**
     * 已废弃，无业务意义
     */
    @Deprecated
    private Integer isCreate;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 商品主图
     */
    private List<String> pic;

    /**
     * 属性名称|属性值之间用|分隔, 多组之间用^分开
     */
    private String productFormat;

    /**
     * 规格图片
     */
    private List<SpecPic> specPics;

    /**
     * sku详情
     */
    private List<SpecPrice> specPrices;

    private List<Spec> specs;

    /**
     * 头图，主图第一张
     */
    private String img;

    /**
     * 新类目的详情
     */
    private CategoryDetail categoryDetail;

    /**
     * 规格图片
     */
    @Getter
    @Setter
    public static class SpecPic {
        /**
         * 子规格ID，比如“颜色-尺寸”这个规格组里的“颜色”里的“白色”对应的ID
         */
        private Long specDetailId;

        /**
         * 规格图片url
         */
        private String pic;
    }

    /**
     * sku详细信息
     */
    @Getter
    @Setter
    public static class SpecPrice {
        /**
         * skuID
         */
        private Long skuId;

        /**
         * sku外部
         */
        private Long outSkuId;

        /**
         * 上述sku所使用的子规格ID，比如“白色”、“大”、“女式”的ID
         */
        private List<Long> specDetailIds;

        /**
         * sku库存
         */
        private Integer stockNum;

        /**
         * sku售价
         */
        private Integer price;

        /**
         * 商家外部编码
         */
        private String code;
    }

    @Getter
    @Setter
    public static class Spec {
        private Long id;
        private Long specId;
        private String name;
        private Long pid;

        /**
         * 是否是叶子ID，0不是 1是
         */
        private Integer isLeaf;

        private List<SpecValue> values;
    }

    @Getter
    @Setter
    public static class SpecValue {
        private Long id;
        private Long specId;
        private String name;
        private String pid;
        private Integer isLeaf;
        private Integer status;
    }

    @Getter
    @Setter
    public static class CategoryDetail {
        /**
         * 一级类目ID
         */
        private Long firstCid;

        /**
         * 二级类目ID
         */
        private Long secondCid;

        /**
         * 三级类目ID
         */
        private Long thirdCid;

        /**
         * 四级类目ID
         */
        private Long fourthCid;

        /**
         * 一级类目名称
         */
        private String firstCname;

        /**
         * 二级类目名称
         */
        private String secondCname;

        /**
         * 三级类目名称
         */
        private String thirdCname;

        /**
         * 四级类目名称
         */
        private String fourthCname;
    }
}
