package com.sdk4.jinritemai;

import com.alibaba.fastjson.JSON;
import com.sdk4.jinritemai.exception.ApiException;
import com.sdk4.jinritemai.model.bean.DoudianProduct;
import com.sdk4.jinritemai.model.bean.DoudianProductGetCateProperty;
import com.sdk4.jinritemai.model.bean.DoudianSku;
import com.sdk4.jinritemai.model.bean.DoudianSpec;
import com.sdk4.jinritemai.model.request.*;
import com.sdk4.jinritemai.model.response.*;
import java.util.List;
import org.testng.annotations.Test;

public class DoudianProductTest extends DoudianClientTest {
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
