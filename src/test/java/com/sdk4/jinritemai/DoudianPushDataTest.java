package com.sdk4.jinritemai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdk4.jinritemai.model.message.*;
import com.sdk4.jinritemai.util.DoudianUtils;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

public class DoudianPushDataTest extends DoudianClientTest {

    @Test
    public void testParse103() {
        DoudianPushResult result = new DoudianPushResult();
        DoudianPushMessage pushMessage = getMessage("103");
        if (!pushMessage.isSuccess()) {
            result.setCode(40041);
            result.setMsg("解析推送数据失败");
        } else if (DoudianUtils.isEmpty(pushMessage.getData())) {
            result.setCode(40041);
            result.setMsg("解析推送数据为空");
        } else {
            List<DoudianPushData> pushDataList = pushMessage.getData();
            // 推送地址添加后，平台会立即Post一条"[{"tag":"0","msg_id":"0","data":"2020-09-10T16:27:56.52842897+08:00"}]"的测试消息，
            // 必须返回{"code":0,"msg":"success"}
            if (pushDataList.size() == 1 && "0".equals(pushDataList.get(0).getTag())) {
                result.setCode(0);
                result.setMsg("success");
            } else {
                // 业务处理
                for (DoudianPushData pushData : pushDataList) {
                    if ("100".equals(pushData.getTag())) {
                        DoudianTradeTradeCreate100 tradeCreate100 = pushData.toObject(DoudianTradeTradeCreate100.class);
                        // 具体业务处理
                        System.out.println(JSON.toJSONString(tradeCreate100, true));
                    } else if ("103".equals(pushData.getTag())) {
                        DoudianTradeTradeSuccess103 tradeSuccess103 = pushData.toObject(DoudianTradeTradeSuccess103.class);
                        // 具体业务处理
                        System.out.println(JSON.toJSONString(tradeSuccess103, true));
                    }
                }
                if (true) {
                    // 接收处理成功
                    result.setCode(0);
                    result.setMsg("success");
                } else {
                    // 接收处理失败
                    result.setCode(40044);
                    result.setMsg("接收处理失败消息");
                }
            }
        }
    }

    private DoudianPushMessage getMessage(String name) {
        Properties prop = loadMessage("103");
        JSONObject header = JSON.parseObject(prop.getProperty("req_header"));
        DoudianPushMessage pushMessage = new DoudianPushMessage();
        pushMessage.setAppId(header.getString("app-id"));
        pushMessage.setEventSign(header.getString("event-sign"));
        pushMessage.setBody(prop.getProperty("req_body"));
        return pushMessage;
    }
}
