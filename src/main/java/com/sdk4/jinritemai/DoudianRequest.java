package com.sdk4.jinritemai;

import com.alibaba.fastjson.annotation.JSONField;

public interface DoudianRequest<T extends DoudianResponse> {
    @JSONField(serialize = false)
    String getMethod();

    @JSONField(serialize = false)
    Class<T> getResponseClass();
}
