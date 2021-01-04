package com.sdk4.jinritemai.model.request;

import com.sdk4.jinritemai.DoudianRequest;
import com.sdk4.jinritemai.model.response.DoudianSkuAddResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianSkuAddRequest implements DoudianRequest<DoudianSkuAddResponse> {
    private final String method = "sku.add";

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 业务方自己的sku_id，唯一 需为数字字符串，max = int64
     */
    private String outSkuId;

    /**
     * 规格id，依赖/spec/list接口的返回
     */
    private Long specId;

    /**
     * 子规格id,最多3级,如 100041|150041|160041 （ 女款|白色|XL）
     */
    private String specDetailIds;

    /**
     * 库存 (必须大于0)
     */
    private Integer stockNum;

    /**
     * 阶梯库存(必须大于0)，仅限presell_type=2时可传入
     */
    private Integer stepStockNum;

    /**
     * 售价 (单位 分)
     */
    private Integer price;

    /**
     * 结算价格 (单位 分)
     */
    private Integer settlementPrice;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 外部仓库ID，需要注意，如果设置了此参数，该sku类型会变成区域库存类，原来的全国库存数据会被覆盖
     */
    private String outWarehouseId;

    /**
     * 供应商ID
     */
    private String supplierId;

    @Override
    public Class<DoudianSkuAddResponse> getResponseClass() {
        return DoudianSkuAddResponse.class;
    }
}
