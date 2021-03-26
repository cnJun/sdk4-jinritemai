package com.sdk4.jinritemai;

import com.alibaba.fastjson.JSON;
import com.sdk4.jinritemai.exception.ApiException;
import com.sdk4.jinritemai.model.bean.DoudianAccessToken;
import com.sdk4.jinritemai.model.response.DoudianAccessTokenResponse;
import com.sdk4.jinritemai.util.DoudianUtils;
import com.sdk4.jinritemai.util.WebUtils;
import com.sdk4.jinritemai.util.WebUtils.HttpResponseData;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DefaultDoudianClient implements DoudianClient {
    protected String serverUrl;
    protected String appKey;
    protected String appSecret;
    protected String signMethod;
    protected int connectTimeout;
    protected int readTimeout;
    private String version;
    DoudianAccessToken accessToken;

    public DefaultDoudianClient(String serverUrl, String appKey, String appSecret) {
        this.signMethod = "hmac-sha256";
        this.connectTimeout = 15000;
        this.readTimeout = 30000;
        this.version = "2";
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.serverUrl = serverUrl;
    }

    @Override
    public void setAccessToken(DoudianAccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public DoudianAccessToken getAccessToken() {
        String url = String.format("%s/oauth2/access_token?app_id=%s&app_secret=%s&grant_type=authorization_self",
                serverUrl,
                appKey,
                appSecret);
        return createAccessToken(url);
    }

    @Override
    public DoudianAccessToken getAccessToken(String refreshToken) {
        String url = String.format("%s/oauth2/refresh_token?app_id=%s&app_secret=%s&grant_type=refresh_token&refresh_token=%s",
                serverUrl,
                appKey,
                appSecret,
                refreshToken);
        return createAccessToken(url);
    }

    @Override
    public DoudianAccessToken codeToToken(String code) {
        String url = String.format("%s/oauth2/access_token?app_id=%s&app_secret=%s&code=%s&grant_type=authorization_code",
                serverUrl,
                appKey,
                appSecret,
                code);
        return createAccessToken(url);
    }

    DoudianAccessToken createAccessToken(String url) {
        DoudianAccessToken accessToken;
        try {
            HttpResponseData data = WebUtils.doPost(url, new HashMap<>(0), "UTF-8", connectTimeout, readTimeout);
            DoudianAccessTokenResponse response = JSON.parseObject(data.getBody(), DoudianAccessTokenResponse.class);
            if (response.isSuccess()) {
                accessToken = response.getData();
                if (accessToken.getExpiresIn() != null) {
                    accessToken.setExpire(System.currentTimeMillis() + (accessToken.getExpiresIn() * 1000) - 60000);
                }
            } else {
                accessToken = new DoudianAccessToken();
                accessToken.setError(DoudianUtils.isEmpty(response.getMessage()) ? response.getErrNo() + "" : response.getMessage());
            }
        } catch (IOException e) {
            accessToken = new DoudianAccessToken();
            accessToken.setError("获取accessToken失败");
            accessToken.setException(e);
        }
        return accessToken;
    }

    @Override
    public <T extends DoudianResponse> T execute(DoudianGeneralRequest<T> request)
            throws ApiException {
        makeSureTokenExist();
        makeSureTokenValid(request.getResponseClass());
        return execute(request.getMethod(),
                DoudianUtils.createParamJson(request.getParamJson()),
                request.getResponseClass(),
                accessToken.getAccessToken());
    }

    @Override
    public <T extends DoudianResponse> T execute(DoudianGeneralRequest<T> request, String accessToken)
            throws ApiException {
        return execute(request.getMethod(),
                DoudianUtils.createParamJson(request.getParamJson()),
                request.getResponseClass(),
                accessToken);
    }

    private <T extends DoudianResponse> T execute(String method,
                                                  String paramJson,
                                                  Class<T> responseClass,
                                                  String accessToken)
            throws ApiException {
        Map<String, String> params = new HashMap<>();
        params.put("method", method);
        params.put("app_key", appKey);
        params.put("param_json", paramJson);
        params.put("timestamp", DoudianUtils.getTimeString(new Date()));
        params.put("v", version);

        try {
            params.put("sign", DoudianUtils.signTopRequest(params, appSecret, signMethod));
            params.put("sign_method", signMethod);
            params.put("access_token", accessToken);

            String url = createUrl(serverUrl, method);
            String query = WebUtils.buildQuery(params, "UTF-8");
            String fullUrl = WebUtils.buildRequestUrl(url, query);
            HttpResponseData data = WebUtils
                    .doPost(fullUrl, new HashMap<>(0), "UTF-8", connectTimeout, readTimeout);
            System.out.println("doudian request: " + fullUrl);
            System.out.println("doudian response: " + data.getBody());
            return JSON.parseObject(data.getBody(), responseClass);
        } catch (IOException e) {
            throw new ApiException("API_CALL_ERROR", "接口调用失败", e);
        }
    }

    @Override
    public <T extends DoudianResponse> T execute(DoudianRequest<T> request) throws ApiException {
        if (accessToken == null) {
            accessToken = getAccessToken();
        }
        if (!accessToken.isValid()) {
            accessToken = DoudianUtils.isEmpty(accessToken.getRefreshToken()) ? getAccessToken() : getAccessToken(accessToken.getRefreshToken());
        }
        if (!accessToken.isValid()) {
            try {
                T response = request.getResponseClass().newInstance();
                response.setErrNo(4444);
                response.setMessage("access token is invalid");
            } catch (Exception e) {
                throw new ApiException("API_CALL_ERROR", "接口调用失败", e);
            }
        }
        return execute(request, accessToken.getAccessToken());
    }

    @Override
    public <T extends DoudianResponse> T execute(DoudianRequest<T> request, String accessToken) throws ApiException {
        String paramJson = DoudianUtils.createParamJson(request);

        Map<String, String> params = new HashMap<>();
        params.put("method", request.getMethod());
        params.put("app_key", appKey);
        params.put("param_json", paramJson);
        params.put("timestamp", DoudianUtils.getTimeString(new Date()));
        params.put("v", version);

        try {
            params.put("sign", DoudianUtils.signTopRequest(params, appSecret, signMethod));
            params.put("sign_method", signMethod);
            params.put("access_token", accessToken);

            String url = createUrl(serverUrl, request.getMethod());
            String query = WebUtils.buildQuery(params, "UTF-8");
            String fullUrl = WebUtils.buildRequestUrl(url, new String[]{query});
            HttpResponseData data = WebUtils.doPost(fullUrl, new HashMap<>(0), "UTF-8", connectTimeout, readTimeout);
            System.out.println(fullUrl);
            System.out.println(data.getBody());
            return JSON.parseObject(data.getBody(), request.getResponseClass());
        } catch (IOException e) {
            throw new ApiException("API_CALL_ERROR", "接口调用失败", e);
        }
    }

    private <T extends DoudianResponse> void makeSureTokenValid(Class<T> resClass)
            throws ApiException {
        if (!accessToken.isValid()) {
            try {
                T response = resClass.newInstance();
                response.setErrNo(4444);
                response.setMessage("access token is invalid");
            } catch (Exception e) {
                throw new ApiException("API_CALL_ERROR", "接口调用失败", e);
            }
        }
    }

    private void makeSureTokenExist() {
        if (accessToken == null) {
            accessToken = getAccessToken();
        }
        if (!accessToken.isValid()) {
            accessToken = DoudianUtils.isEmpty(accessToken.getRefreshToken()) ? getAccessToken()
                    : getAccessToken(accessToken.getRefreshToken());
        }
    }

    static String createUrl(String baseUrl, String method) {
        StringBuilder url = new StringBuilder();
        if (DoudianUtils.isNotEmpty(baseUrl)) {
            url.append(baseUrl);
            if (!baseUrl.endsWith("/")) {
                url.append('/');
            }
        }
        if (DoudianUtils.isNotEmpty(method)) {
            url.append(method.replace('.', '/'));
        }
        return url.toString();
    }

}
