package com.sdk4.jinritemai;

import com.alibaba.fastjson.JSON;
import com.sdk4.jinritemai.exception.ApiException;
import com.sdk4.jinritemai.model.bean.DoudianAddressArea;
import com.sdk4.jinritemai.model.bean.DoudianAddressCity;
import com.sdk4.jinritemai.model.bean.DoudianAddressProvince;
import com.sdk4.jinritemai.model.bean.DoudianOrderLogisticsCompany;
import com.sdk4.jinritemai.model.request.*;
import com.sdk4.jinritemai.model.response.*;
import org.testng.annotations.Test;

public class DoudianLogisticsTest extends DoudianClientTest {
    @Test
    public void testOrderLogisticsCompanyList() throws ApiException {
        DoudianOrderLogisticsCompanyListRequest request = new DoudianOrderLogisticsCompanyListRequest();
        DoudianOrderLogisticsCompanyListResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("获取快递公司列表失败:" + response.getMessage());
        } else {
            for (DoudianOrderLogisticsCompany logisticsCompany : response.getData()) {
                System.out.println(JSON.toJSONString(logisticsCompany));
            }
        }
    }

    @Test
    public void testOrderLogisticsAdd() throws ApiException {
        DoudianOrderLogisticsAddRequest request = new DoudianOrderLogisticsAddRequest();
        request.setOrderId("4736605172296524197A");
        request.setLogisticsId(15L);
        request.setCompany("中通快递");
        request.setLogisticsCode("75417914223203");
        DoudianOrderLogisticsAddResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("发货失败:" + response.getMessage());
        } else {
            System.out.println("发货成功");
        }
    }

    @Test
    public void testOrderLogisticsEdit() throws ApiException {
        DoudianOrderLogisticsEditRequest request = new DoudianOrderLogisticsEditRequest();
        request.setOrderId("4736605172296524197A");
        request.setLogisticsId(15L);
        request.setCompany("中通快递");
        request.setLogisticsCode("75417914223203");
        DoudianOrderLogisticsEditResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("修改发货物流失败:" + response.getMessage());
        } else {
            System.out.println("修改发货物流成功");
        }
    }

    @Test
    public void testAddress() throws ApiException {
        DoudianAddressProvinceListRequest request = new DoudianAddressProvinceListRequest();
        DoudianAddressProvinceListResponse response = getClient().execute(request);
        for (DoudianAddressProvince province : response.getData()) {
            System.out.println(province.getProvinceId() + "," + province.getProvince());
            DoudianAddressCityListRequest cityListRequest = new DoudianAddressCityListRequest();
            cityListRequest.setProvinceId(province.getProvinceId());
            DoudianAddressCityListResponse cityListResponse = getClient().execute(cityListRequest);
            for (DoudianAddressCity city : cityListResponse.getData()) {
                System.out.println("  " + city.getCityId() + "," + city.getCity());
                DoudianAddressAreaListRequest areaListRequest = new DoudianAddressAreaListRequest();
                areaListRequest.setCityId(city.getCityId());
                DoudianAddressAreaListResponse areaListResponse = getClient().execute(areaListRequest);
                for (DoudianAddressArea area : areaListResponse.getData()) {
                    System.out.println("    " + area.getAreaId() + "," + area.getArea());
                }
            }
        }
    }
}
