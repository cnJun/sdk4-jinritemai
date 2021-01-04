package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianOrderAddOrderRemarkResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianOrderAddOrderRemarkRequest implements DoudianRequest<DoudianOrderAddOrderRemarkResponse> {
    private final String method = "order.addOrderRemark";

    /**
     * 父订单ID，后面需带大写字母A
     */
    private String orderId;

    /**
     * 备注内容，最大不得超过60个字符
     */
    private String remark;

    /**
     * 是否加旗标，不填则默认为否
     * true：需要加旗标
     * false：不加旗标
     */
    private Boolean isAddStar = false;

    /**
     * 标星等级，范围0～5
     * 0为灰色旗标，5为红色旗标，数字越大颜色越深
     * 0灰 1紫 2青 3绿 4橙 5红
     */
    private Integer star;

    @Override
    public Class<DoudianOrderAddOrderRemarkResponse> getResponseClass() {
        return DoudianOrderAddOrderRemarkResponse.class;
    }
}
