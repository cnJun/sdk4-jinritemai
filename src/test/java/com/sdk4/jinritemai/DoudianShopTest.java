package com.sdk4.jinritemai;

import com.sdk4.jinritemai.exception.ApiException;
import com.sdk4.jinritemai.model.bean.DoudianShopBrand;
import com.sdk4.jinritemai.model.bean.DoudianShopCategory;
import com.sdk4.jinritemai.model.request.DoudianShopBrandListRequest;
import com.sdk4.jinritemai.model.request.DoudianShopGetShopCategoryRequest;
import com.sdk4.jinritemai.model.response.DoudianShopBrandListResponse;
import com.sdk4.jinritemai.model.response.DoudianShopGetShopCategoryResponse;
import org.testng.annotations.Test;

import java.util.List;

public class DoudianShopTest extends DoudianClientTest {
    /**
     * 获取店铺的已授权品牌列表：https://op.jinritemai.com/docs/api-docs/13/54
     *
     * @throws ApiException
     */
    @Test
    public void testShopBrandList() throws ApiException {
        DoudianShopBrandListRequest request = new DoudianShopBrandListRequest();
        DoudianShopBrandListResponse response = getClient().execute(request);
        if (response.isSuccess()) {
            List<DoudianShopBrand> shopBrandList = response.getData();
            System.out.println("获取品牌信息：" + shopBrandList.size());
        } else {
            System.out.println("获取失败：" + response.getMessage());
        }
    }

    /**
     * 获取店铺后台供商家发布商品的类目：https://op.jinritemai.com/docs/api-docs/13/234
     *
     * @throws ApiException
     */
    @Test
    public void testShopGetShopCategory() throws ApiException {
        getShopCategoryChildren(0L);
    }

    public DoudianShopGetShopCategoryResponse getShopCategoryChildren(Long cid) throws ApiException {
        DoudianShopGetShopCategoryRequest request = new DoudianShopGetShopCategoryRequest();
        request.setCid(cid);
        DoudianShopGetShopCategoryResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.out.println("获取失败：" + response.getMessage());
        } else {
            for (DoudianShopCategory shopCategory : response.getData()) {
                System.out.print(repeat(" ", (shopCategory.getLevel() - 1) * 2));
                System.out.println(shopCategory.getId() + "," + shopCategory.getName());
                getShopCategoryChildren(shopCategory.getId());
            }
        }
        return response;
    }

    String repeat(String s, int repeat) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            str.append(s);
        }
        return str.toString();
    }
}
