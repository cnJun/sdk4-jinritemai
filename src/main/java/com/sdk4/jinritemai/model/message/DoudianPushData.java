package com.sdk4.jinritemai.model.message;

import com.alibaba.fastjson.JSON;
import com.sdk4.jinritemai.util.DoudianUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianPushData {

    /**
     * 消息种类
     */
    private String tag;

    /**
     * 消息记录ID
     */
    private String msgId;

    /**
     * 消息体具体数据
     */
    private String data;

    public <T> T toObject(Class<T> tClass) {
        if (DoudianUtils.isEmpty(data)) {
            return null;
        }
        return JSON.parseObject(data, tClass);
    }

}
