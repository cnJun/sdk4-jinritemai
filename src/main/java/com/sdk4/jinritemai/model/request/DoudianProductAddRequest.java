package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianProductAddResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianProductAddRequest implements DoudianRequest<DoudianProductAddResponse> {
    private final String method = "product.add";

    /**
     * 外部商品id，接入方的商品id，需为数字字符串，max = int64
     */
    private String outProductId;

    /**
     * 商品名称，最多30个字符，不能含emoj表情
     */
    private String name;

    /**
     * 商品轮播图，多张图片用 "|" 分开，第一张图为主图，最多5张，至少600x600，大小不超过1M
     */
    private String pic;

    /**
     * 商品描述，目前只支持图片。多张图片用 "|" 分开。不能用其他网站的文本粘贴，这样会出现css样式不兼容
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
     * 老类目ID，一级分类id（三个分类级别请确保从属正确）
     */
    private String firstCid;

    /**
     * 老类目ID，二级分类id
     */
    private String secondCid;

    /**
     * 老类目ID，三级分类id
     */
    private String thirdCid;

    /**
     * 规格id, 要先创建商品通用规格, 如颜色-尺寸
     */
    private String specId;

    /**
     * 主规格id, 如颜色-尺寸, 颜色就是主规格, 颜色如黑,白,黄,它们的id|图片url
     */
    private String specPic;

    /**
     * 客服号码
     */
    private String mobile;

    /**
     * 商品重量 (单位:克)。范围: 10克 - 9999990克
     */
    private String weight;

    /**
     * 属性名称|属性值之间用|分隔, 多组之间用^分开
     */
    private String productFormat;

    /**
     * 支付方式，必填，0-货到付款，1-在线支付，2-二者都支持
     */
    private Integer payType;

    /**
     * 商家推荐语，不能含emoj表情
     */
    private String recommendRemark;

    /**
     * 品牌id (请求店铺授权品牌接口获取) (效果即为商品详情页面中的品牌字段)
     */
    private Long brandId;

    /**
     * 预售类型，1-全款预售，0-非预售，2-阶梯库存，默认0
     */
    private Integer presellType;

    /**
     * 预售结束后，几天发货，可以选择2-30
     */
    private String presellDelay;

    /**
     * 预售结束时间，格式2020-02-21 18:54:27，最多支持设置距离当前30天
     */
    private String presellEndTime;

    /**
     * 承诺发货时间，单位是天，可选值为: 2、3、5、7、10、15
     */
    private String deliveryDelayDay;

    /**
     * 商品创建和编辑操作支持设置质检报告链接,多个图片以逗号分隔
     */
    private String qualityReport;

    /**
     * 商品创建和编辑操作支持设置品类资质链接,多个图片以逗号分隔
     */
    private String classQuality;

    /**
     * 新类目的叶子类目id，可通过接口/shop/getShopCategory获取
     */
    private String categoryLeafId;

    @Override
    public Class<DoudianProductAddResponse> getResponseClass() {
        return DoudianProductAddResponse.class;
    }
}
