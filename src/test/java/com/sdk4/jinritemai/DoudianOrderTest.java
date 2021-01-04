package com.sdk4.jinritemai;

import com.alibaba.fastjson.JSON;
import com.sdk4.jinritemai.exception.ApiException;
import com.sdk4.jinritemai.model.bean.DoudianOrder;
import com.sdk4.jinritemai.model.request.*;
import com.sdk4.jinritemai.model.response.*;
import org.testng.annotations.Test;

public class DoudianOrderTest extends DoudianClientTest {

    @Test
    public void testOrderList() throws ApiException {
        DoudianOrderListRequest request = new DoudianOrderListRequest();
        request.setStartTime("2020-12-01 00:00:00");
        request.setEndTime("2020-12-31 00:00:00");

        DoudianOrderListResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("获取订单列表失败:" + response.getMessage());
        } else {
            DoudianPage<DoudianOrder> page = response.getData();
            for (DoudianOrder order : page.getPageData()) {
                System.out.println(JSON.toJSONString(order));
            }
        }
    }

    @Test
    public void testOrderDetail() throws ApiException {
        DoudianOrderDetailRequest request = new DoudianOrderDetailRequest();
        request.setOrderId("4736605172296554197A");
        DoudianOrderDetailResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("获取订单详情失败:" + response.getMessage());
        } else {
            DoudianPage<DoudianOrder> page = response.getData();
            for (DoudianOrder order : page.getPageData()) {
                System.out.println(JSON.toJSONString(order));
            }
        }
    }

    @Test
    public void testOrderStockUp() throws ApiException {
        DoudianOrderStockUpRequest request = new DoudianOrderStockUpRequest();
        request.setOrderId("4736605172296554197A");
        DoudianOrderStockUpResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("确认货到付款订单失败:" + response.getMessage());
        } else {
            System.out.println("确认货到付款订单成功");
        }
    }

    @Test
    public void testOrderCancel() throws ApiException {
        DoudianOrderCancelRequest request = new DoudianOrderCancelRequest();
        request.setOrderId("4736605172296554197A");
        DoudianOrderCancelResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("取消货到付款订单失败:" + response.getMessage());
        } else {
            System.out.println("取消货到付款订单成功");
        }
    }

    @Test
    public void testOrderServiceList() throws ApiException {
        DoudianOrderServiceListRequest request = new DoudianOrderServiceListRequest();
        DoudianOrderServiceListResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("获取服务请求列表失败:" + response.getMessage());
        } else {
            System.out.println("获取服务请求列表成功");
        }
    }

    @Test
    public void testOrderReplyService() throws ApiException {
        DoudianOrderReplyServiceRequest request = new DoudianOrderReplyServiceRequest();
        request.setId("1");
        request.setReply("回复信息");
        DoudianOrderReplyServiceResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("回复失败:" + response.getMessage());
        } else {
            System.out.println("回复成功");
        }
    }

    @Test
    public void testOrderAddOrderRemark() throws ApiException {
        DoudianOrderAddOrderRemarkRequest request = new DoudianOrderAddOrderRemarkRequest();
        request.setOrderId("4736605172296554197A");
        request.setRemark("sh订单");
        request.setIsAddStar(true);
        request.setStar(1);
        DoudianOrderAddOrderRemarkResponse response = getClient().execute(request);
        if (!response.isSuccess()) {
            System.err.println("添加订单备注失败:" + response.getMessage());
        } else {
            System.out.println("添加订单备注成功");
        }
    }

}
