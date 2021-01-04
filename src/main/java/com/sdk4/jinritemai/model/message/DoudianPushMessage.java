package com.sdk4.jinritemai.model.message;

import com.alibaba.fastjson.JSON;
import com.sdk4.jinritemai.util.DoudianUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DoudianPushMessage {

    /**
     * 对应开发者后台的app_key
     */
    private String appId;

    /**
     * 防伪签名，可通过该字段值判断消息是否伪造
     * 签名生成方法：MD5(app_id+msg_body+app_secret) ; 其中msg_body是消息体的内容字符串。
     */
    private String eventSign;

    /**
     * 消息体
     */
    private String body;

    /**
     * 错误信息
     */
    private String error;

    public boolean isSuccess() {
        return DoudianUtils.isEmpty(error);
    }

    public List<DoudianPushData> getData() {
        if (DoudianUtils.isEmpty(body)) {
            return new ArrayList<>(0);
        }
        return JSON.parseArray(jsonString(body), DoudianPushData.class);
    }

    private static String jsonString(String oldJson) {
        char[] temp = oldJson.toCharArray();
        int n = temp.length;
        for (int i = 0; i < n; i++) {
            if (temp[i] == ':' && temp[i + 1] == '"') {
                for (int j = i + 2; j < n; j++) {
                    if (temp[j] == '"') {
                        if (temp[j + 1] != ',' && temp[j + 1] != '}') {
                            temp[j] = '\15';
                        } else if (temp[j + 1] == ',' || temp[j + 1] == '}') {
                            break;
                        }
                    }
                }
            }
        }
        String newJson = new String(temp);
        newJson = newJson.replace("\15", "\\\"");
        return newJson;
    }

}
