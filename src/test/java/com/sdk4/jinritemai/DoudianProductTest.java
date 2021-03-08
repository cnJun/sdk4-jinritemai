package com.sdk4.jinritemai;

import com.alibaba.fastjson.JSON;
import com.sdk4.jinritemai.exception.ApiException;
import com.sdk4.jinritemai.model.bean.DoudianProduct;
import com.sdk4.jinritemai.model.bean.DoudianProductGetCateProperty;
import com.sdk4.jinritemai.model.bean.DoudianSku;
import com.sdk4.jinritemai.model.bean.DoudianSpec;
import com.sdk4.jinritemai.model.request.*;
import com.sdk4.jinritemai.model.response.*;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.List;
import java.util.Map;

public class DoudianProductTest extends DoudianClientTest {
    @Test
    public void testProductAddV2ByGeneralRequest() throws ApiException {
        Map<String, Object> spuParamMap = Maps.newHashMap();
        spuParamMap.put("brand_id", ""); //fixme: 填写正确的品牌
        spuParamMap.put("category_leaf_id", "22370");
        spuParamMap.put("commit", "true");
        spuParamMap.put("delivery_delay_day", "2");
        spuParamMap.put("description", "https://sf6-ttcdn-tos.pstatp.com/obj/temai/2d5bb85c2e7f919f403ed6372a8ddc9fwww800-800");
        spuParamMap.put("discount_price", "9999");
        spuParamMap.put("freight_id", "0");
        spuParamMap.put("market_price", "9999");
        spuParamMap.put("mobile", "13400000001");
        spuParamMap.put("name", "[测试] 测试商品，不要上架");
        spuParamMap.put("out_product_id", "test-only");
        spuParamMap.put("pay_type", "1");
        spuParamMap.put("pic", "https://sf6-ttcdn-tos.pstatp.com/obj/temai/2d5bb85c2e7f919f403ed6372a8ddc9fwww800-800");
        spuParamMap.put("presell_type", "0");
        spuParamMap.put("product_format", "0|11642^419596|17周岁以下^419597|不对称^419598|短裤^419599|树脂固色^419600|原创^419601|71%(含)-80%(含)^419602|^419603|低腰^419604|哈伦裤^419605|桑蚕丝^419606|^419607|超薄");
        spuParamMap.put("product_id", "test-wj");
        spuParamMap.put("product_type", "0");
        spuParamMap.put("recommend_remark", "test only - 不哟啊");
        spuParamMap.put("reduce_type", "2");
        spuParamMap.put("remark", "test only");
        spuParamMap.put("spec_name", "颜色-尺码");
        spuParamMap.put("spec_pic", "https://sf6-ttcdn-tos.pstatp.com/obj/temai/2d5bb85c2e7f919f403ed6372a8ddc9fwww800-800");
        spuParamMap.put("spec_prices", "[{\"price\":9999,\"spec_detail_name1\":\"亮白\",\"spec_detail_name2\":\"A/S\",\"stock_num\":11}]");
        spuParamMap.put("specs", "颜色|亮白^尺码|A/S");
        spuParamMap.put("supply_7day_return", "1");
        spuParamMap.put("weight", "1");
        spuParamMap.put("weight_unit", "0");
        DoudianGeneralRequest<DoudianProductAddV2Response> request = new DoudianGeneralRequest<>();
        request.setResponseClass(DoudianProductAddV2Response.class);
        request.setMethod("product.addV2");
        request.setParamJson(spuParamMap);

        DoudianProductAddV2Response response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("ProductAddV2失败:" + response.getMessage());
        } else {
            System.out.println(JSON.toJSONString(response.getData()));
        }
    }

    @Test
    public void testGetCatePropertyByGeneralRequest() throws ApiException {
        DoudianGeneralRequest<DoudianProductGetCatePropertyResponse> generalRequest = new DoudianGeneralRequest<>();
        generalRequest.setMethod("product.getCateProperty");
        generalRequest.setResponseClass(DoudianProductGetCatePropertyResponse.class);
        Map<String, Object> objectObjectMap = Maps.newHashMap();
        objectObjectMap.put("category_leaf_id", "20716");
        generalRequest.setParamJson(objectObjectMap);
        DoudianProductGetCatePropertyResponse response = getClient().execute(generalRequest);
        if (!response.isSuccess()) {
            System.err.println("根据商品分类获取对应的属性列表失败:" + response.getMessage());
        } else {
            List<DoudianProductGetCateProperty> properties = response.getData();
            System.out.println(JSON.toJSONString(properties));
        }
    }

    @Test
    public void testGetCateProperty() throws ApiException {
        DoudianProductGetCatePropertyRequest request = new DoudianProductGetCatePropertyRequest();
        request.setCategoryLeafId("20716");
        DoudianProductGetCatePropertyResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("根据商品分类获取对应的属性列表失败:" + response.getMessage());
        } else {
            List<DoudianProductGetCateProperty> properties = response.getData();
            System.out.println(JSON.toJSONString(properties));
        }
    }

    @Test
    public void testProductDetail() throws ApiException {
        DoudianProductDetailRequest request = new DoudianProductDetailRequest();
        request.setProductId(3453347975240268172L);
        DoudianProductDetailResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("获取商品详情失败:" + response.getMessage());
        } else {
            DoudianProduct product = response.getData();
            System.out.println(JSON.toJSONString(product));
        }
    }

    @Test
    public void testProductList() throws ApiException {
        DoudianProductListRequest request = new DoudianProductListRequest();
        DoudianProductListResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("获取商品列表失败:" + response.getMessage());
        } else {
            for (DoudianProduct product : response.getData().getPageData()) {
                System.out.println(JSON.toJSONString(product));
            }
        }
    }

    @Test
    public void testProductAdd() throws ApiException {
        DoudianProductAddRequest request = new DoudianProductAddRequest();
        request.setName("米奇牛仔裤");
        request.setPic("https://sf6-ttcdn-tos.pstatp.com/obj/temai/2d5bb85c2e7f919f403ed6372a8ddc9fwww800-800");
        request.setDescription("https://sf6-ttcdn-tos.pstatp.com/obj/temai/2d5bb85c2e7f919f403ed6372a8ddc9fwww800-800");
        request.setMarketPrice(10000);
        request.setDiscountPrice(10000);
        request.setMobile("13400000001");
        request.setWeight("110");
        request.setProductFormat("{\"货号\":\"KZZL025\",\"适用季节\":\"冬季\"}");
        request.setPayType(1);
        request.setSpecId("134794584");
        request.setCategoryLeafId("20597");
        DoudianProductAddResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("添加商品失败:" + response.getMessage());
        } else {
            System.out.println("添加商品成功:" + response.getData().getProductId());
        }
    }

    @Test
    public void testProductEdit() throws ApiException {
        DoudianProductEditRequest request = new DoudianProductEditRequest();
        request.setProductId(1L);
        request.setName("米奇牛仔裤");
        request.setPic("https://sf6-ttcdn-tos.pstatp.com/obj/temai/2d5bb85c2e7f919f403ed6372a8ddc9fwww800-800");
        request.setDescription("https://sf6-ttcdn-tos.pstatp.com/obj/temai/2d5bb85c2e7f919f403ed6372a8ddc9fwww800-800");
        request.setMarketPrice(10000);
        request.setDiscountPrice(10000);
        request.setMobile("13400000001");
        request.setWeight("110");
        request.setProductFormat("{\"货号\":\"KZZL025\",\"适用季节\":\"冬季\"}");
        request.setPayType(1);
        request.setSpecId("134794584");
        request.setCategoryLeafId("20597");
        DoudianProductEditResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("编辑商品失败:" + response.getMessage());
        } else {
            System.out.println("编辑商品成功");
        }
    }

    @Test
    public void testProductDel() throws ApiException {
        DoudianProductDelRequest request = new DoudianProductDelRequest();
        request.setProductId(1L);
        DoudianProductDelResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("删除商品失败:" + response.getMessage());
        } else {
            System.out.println("删除商品成功");
        }
    }

    @Test
    public void testSpecAdd() throws ApiException {
        DoudianSpecAddRequest request = new DoudianSpecAddRequest();
        request.setSpecs("颜色|白色,红色,蓝色^尺码|S,M,L");
        request.setName("规格2021-1");
        DoudianSpecAddResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("添加规格失败:" + response.getMessage());
        } else {
            System.out.println("添加规格成功");
        }
    }

    @Test
    public void testSpecDetail() throws ApiException {
        DoudianSpecSpecDetailRequest request = new DoudianSpecSpecDetailRequest();
        request.setId(115584464L);
        DoudianSpecSpecDetailResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("获取规格详情失败:" + response.getMessage());
        } else {
            for (DoudianSpec spec : response.getData()) {
                System.out.println(JSON.toJSONString(spec));
            }
        }
    }

    @Test
    public void testSpecList() throws ApiException {
        DoudianSpecListRequest request = new DoudianSpecListRequest();
        DoudianSpecListResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("获取规格列表失败:" + response.getMessage());
        } else {
            for (DoudianSpec spec : response.getData()) {
                System.out.println(JSON.toJSONString(spec));
            }
        }
    }

    @Test
    public void testSpecDel() throws ApiException {
        DoudianSpecDelRequest request = new DoudianSpecDelRequest();
        request.setId(145957862L);
        DoudianSpecDelResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("删除规格失败:" + response.getMessage());
        } else {
            System.out.println("删除规格成功");
        }
    }

    @Test
    public void testSkuAdd() throws ApiException {
        DoudianSkuAddRequest request = new DoudianSkuAddRequest();
        request.setProductId(3453183170894243915L);
        request.setSpecId(115584464L);
        request.setSpecDetailIds("981648008|981648010");
        request.setStockNum(1);
        request.setPrice(10100);
        DoudianSkuAddResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("添加SKU失败:" + response.getMessage());
        } else {
            System.out.println("添加SKU成功");
        }
    }

    @Test
    public void testSkuList() throws ApiException {
        DoudianSkuListRequest request = new DoudianSkuListRequest();
        request.setProductId(3453347975240268174L);
        DoudianSkuListResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("获取商品sku列表失败:" + response.getMessage());
        } else {
            for (DoudianSku sku : response.getData()) {
                System.out.println(JSON.toJSONString(sku));
            }
        }
    }

}
