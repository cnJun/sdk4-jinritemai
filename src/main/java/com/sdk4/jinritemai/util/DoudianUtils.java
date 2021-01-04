package com.sdk4.jinritemai.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.sdk4.jinritemai.model.message.DoudianPushMessage;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

public class DoudianUtils {
    static SerializeConfig JSON_SERIAL_CONFIG = new SerializeConfig();

    static {
        JSON_SERIAL_CONFIG.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
    }

    public static String createParamJson(Object object) {
        return JSON.toJSONString(toStringSortMap(object));
    }

    public static Map<String, String> toStringSortMap(Object object) {
        if (object == null) {
            return new HashMap<>(0);
        }
        Map<String, String> result = new LinkedHashMap<>();
        JSONObject map = (JSONObject) JSONObject.toJSON(object, JSON_SERIAL_CONFIG);
        String[] keys = map.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        for (String key : keys) {
            Object valueObj = map.get(key);
            String value = valueObj == null ? null : valueObj.toString();
            if (isEmpty(key) || isEmpty(value)) {
                continue;
            }
            result.put(key, value);

        }
        return result;
    }

    public static String signTopRequest(Map<String, String> params, String secret, String signMethod) throws IOException {
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        StringBuilder query = new StringBuilder();
        query.append(secret);
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            String value = params.get(key);
            if (isNotEmpty(key) && isNotEmpty(value)) {
                query.append(key).append(value);
            }
        }
        query.append(secret);
        byte[] bytes;
        if ("hmac-sha256".equals(signMethod)) {
            bytes = encryptHMACSHA256(query.toString(), secret);
        } else {
            bytes = encryptMD5(query.toString());
        }
        return byte2hex(bytes);
    }

    public static byte[] encryptMD5(String data) throws IOException {
        return encryptMD5(data.getBytes("UTF-8"));
    }

    public static byte[] encryptMD5(byte[] data) throws IOException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(data);
            return bytes;
        } catch (GeneralSecurityException var3) {
            throw new IOException(var3.toString());
        }
    }

    private static byte[] encryptHMACSHA256(String data, String secret) throws IOException {
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            byte[] bytes = mac.doFinal(data.getBytes("UTF-8"));
            return bytes;
        } catch (GeneralSecurityException var5) {
            throw new IOException(var5.toString());
        }
    }

    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();

        for (int i = 0; i < bytes.length; ++i) {
            String hex = Integer.toHexString(bytes[i] & 255);
            if (hex.length() == 1) {
                sign.append("0");
            }

            sign.append(hex.toLowerCase());
        }

        return sign.toString();
    }

    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static String getTimeString(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }

    public static int returnAnyGreaterThanZero(Integer... numbers) {
        for (Integer n : numbers) {
            if (n != null && n > 0) {
                return n.intValue();
            }
        }
        return 0;
    }

    public static DoudianPushMessage getPushMessage(HttpServletRequest request) {
        DoudianPushMessage pushMessage = new DoudianPushMessage();
        pushMessage.setAppId(request.getHeader("app-id"));
        pushMessage.setEventSign(request.getHeader("event-sign"));
        try {
            pushMessage.setBody(getStreamAsString(request.getInputStream(), "UTF-8"));
            if (isEmpty(pushMessage.getAppId())) {
                pushMessage.setError("app-id不能为空");
            } else if (isEmpty(pushMessage.getEventSign())) {
                pushMessage.setError("event-sign不能为空");
            }
        } catch (IOException e) {
            e.printStackTrace();
            pushMessage.setError("获取推送数据失败");
        }
        return pushMessage;
    }

    public static boolean checkPushMessage(DoudianPushMessage pushMessage, String appSecret) {
        StringBuilder str = new StringBuilder();
        str.append(pushMessage.getAppId());
        str.append(pushMessage.getBody());
        str.append(appSecret);
        try {
            String md5 = byte2hex(encryptMD5(str.toString()));
            return md5.equalsIgnoreCase(pushMessage.getEventSign());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        Reader reader = new InputStreamReader(stream, charset);
        StringBuilder response = new StringBuilder();
        final char[] buff = new char[1024];
        int read;
        while ((read = reader.read(buff)) > 0) {
            response.append(buff, 0, read);
        }
        return response.toString();
    }

}
