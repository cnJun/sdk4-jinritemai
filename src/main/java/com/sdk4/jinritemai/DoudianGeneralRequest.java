package com.sdk4.jinritemai;

import lombok.Data;

import java.util.Map;

@Data
public class DoudianGeneralRequest<T extends DoudianResponse> {

    private String method;
    private Map<String, Object> paramJson;
    private Class<T> responseClass;
}
