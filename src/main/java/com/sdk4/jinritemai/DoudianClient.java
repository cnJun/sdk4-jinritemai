package com.sdk4.jinritemai;

import com.sdk4.jinritemai.exception.ApiException;
import com.sdk4.jinritemai.model.bean.DoudianAccessToken;

public interface DoudianClient {

    /**
     * 设置授权
     *
     * @param accessToken
     */
    void setAccessToken(DoudianAccessToken accessToken);

    /**
     * 获取授权
     *
     * @return
     */
    DoudianAccessToken getAccessToken();

    /**
     * 刷新授权
     *
     * @param refreshToken
     * @return
     */
    DoudianAccessToken getAccessToken(String refreshToken);

    /**
     * 使用code换取授权
     *
     * @param code
     * @return
     */
    DoudianAccessToken codeToToken(String code);

    /**
     * 抖店 Client（自用型应用不需要传 access token）
     *
     * @param request
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T extends DoudianResponse> T execute(DoudianRequest<T> request) throws ApiException;

    /**
     * 抖店 Client
     *
     * @param request
     * @param accessToken
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T extends DoudianResponse> T execute(DoudianRequest<T> request, String accessToken) throws ApiException;


    <T extends DoudianResponse> T execute(DoudianGeneralRequest<T> request) throws ApiException;

    <T extends DoudianResponse> T execute(DoudianGeneralRequest<T> request, String accessToken)
            throws ApiException;
}
