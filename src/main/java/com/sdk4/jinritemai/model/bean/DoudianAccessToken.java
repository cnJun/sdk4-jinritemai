package com.sdk4.jinritemai.model.bean;

import com.sdk4.jinritemai.util.DoudianUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoudianAccessToken {
    /**
     * 用于调用API的access_token
     */
    private String accessToken;

    /**
     * access_token接口调用凭证超时时间，单位（秒），默认有效期：7天
     */
    private Integer expiresIn;

    /**
     * 授权作用域，使用逗号,分隔。预留字段
     */
    private String scope;

    /**
     * 店铺ID
     */
    private String shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 用于刷新access_token的刷新令牌（有效期：14 天）
     */
    private String refreshToken;

    private String error;

    private Exception exception;

    private Long expire;

    public boolean isSuccess() {
        return DoudianUtils.isEmpty(error);
    }

    public boolean isValid() {
        return isSuccess() && DoudianUtils.isNotEmpty(accessToken) && expire != null && System.currentTimeMillis() < expire;
    }
}
