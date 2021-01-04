package com.sdk4.jinritemai.util;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class WebUtils {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static boolean ignoreSSLCheck = true;
    private static boolean ignoreHostCheck = true;

    public static String buildRequestUrl(String url, String... queries) {
        if (queries != null && queries.length > 0) {
            StringBuilder newUrl = new StringBuilder(url);
            boolean hasQuery = url.contains("?");
            boolean hasPrepend = url.endsWith("?") || url.endsWith("&");
            for (String q : queries) {
                if (DoudianUtils.isEmpty(q)) {
                    continue;
                }
                if (!hasPrepend) {
                    if (hasQuery) {
                        newUrl.append('&');
                    } else {
                        newUrl.append('?');
                        hasQuery = true;
                    }
                }
                newUrl.append(q);
                hasPrepend = false;
            }
            return newUrl.toString();
        }
        return url;
    }

    public static String buildQuery(Map<String, String> params, String charset) throws IOException {
        if (params != null && !params.isEmpty()) {
            StringBuilder query = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (DoudianUtils.isNotEmpty(key) && DoudianUtils.isNotEmpty(value)) {
                    query.append(key).append("=").append(URLEncoder.encode(value, charset)).append('&');
                }
            }
            if (query.length() > 0) {
                query.setLength(query.length() - 1);
            }
            return query.toString();
        }
        return null;
    }

    public static HttpResponseData doPost(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout) throws IOException {
        return doPost(url, params, charset, connectTimeout, readTimeout, null, null);
    }

    public static HttpResponseData doPost(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout, Map<String, String> headerMap, Proxy proxy) throws IOException {
        String ctype = "application/x-www-form-urlencoded;charset=" + charset;
        String query = buildQuery(params, charset);
        byte[] content = new byte[0];
        if (query != null) {
            content = query.getBytes(charset);
        }

        return _doPost(url, ctype, content, connectTimeout, readTimeout, headerMap, proxy);
    }

    private static HttpResponseData _doPost(String url, String ctype, byte[] content, int connectTimeout, int readTimeout, Map<String, String> headerMap, Proxy proxy) throws IOException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        HttpResponseData data = new HttpResponseData();

        try {
            conn = getConnection(new URL(url), "POST", ctype, headerMap, proxy);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            out = conn.getOutputStream();
            out.write(content);
            data.setBody(getResponseAsString(conn));
            data.setHeaders(conn.getHeaderFields());
        } finally {
            if (out != null) {
                out.close();
            }

            if (conn != null) {
                conn.disconnect();
            }
        }

        return data;
    }

    private static HttpURLConnection getConnection(URL url, String method, String ctype, Map<String, String> headerMap, Proxy proxy) throws IOException {
        HttpURLConnection conn;
        if (proxy == null) {
            conn = (HttpURLConnection) url.openConnection();
        } else {
            conn = (HttpURLConnection) url.openConnection(proxy);
        }
        if (conn instanceof HttpsURLConnection) {
            HttpsURLConnection connHttps = (HttpsURLConnection) conn;
            if (ignoreSSLCheck) {
                try {
                    SSLContext ctx = SSLContext.getInstance("TLS");
                    ctx.init(null, new TrustManager[]{new TrustAllTrustManager()}, new SecureRandom());
                    connHttps.setSSLSocketFactory(ctx.getSocketFactory());
                    connHttps.setHostnameVerifier((hostname, session) -> true);
                } catch (Exception e) {
                    throw new IOException(e.toString());
                }
            } else if (ignoreHostCheck) {
                connHttps.setHostnameVerifier((hostname, session) -> true);
            }
            conn = connHttps;
        }
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Host", url.getHost());
        conn.setRequestProperty("Accept", "text/xml,text/javascript");
        conn.setRequestProperty("User-Agent", "sdk4-jinritemai-sdk-java");
        conn.setRequestProperty("Content-Type", ctype);
        if (headerMap != null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (DoudianUtils.isNotEmpty(key) && DoudianUtils.isNotEmpty(value)) {
                    conn.setRequestProperty(key, value);
                }
            }
        }
        return conn;
    }

    protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
        String charset = getResponseCharset(conn.getContentType());
        if (conn.getResponseCode() < 400) {
            String contentEncoding = conn.getContentEncoding();
            return "gzip".equalsIgnoreCase(contentEncoding) ? getStreamAsString(new GZIPInputStream(conn.getInputStream()), charset)
                    : getStreamAsString(conn.getInputStream(), charset);
        } else {
            if (conn.getResponseCode() == 400) {
                InputStream error = conn.getErrorStream();
                if (error != null) {
                    return getStreamAsString(error, charset);
                }
            }
            throw new IOException(conn.getResponseCode() + " " + conn.getResponseMessage());
        }
    }

    public static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            Reader reader = new InputStreamReader(stream, charset);
            StringBuilder response = new StringBuilder();
            final char[] buff = new char[1024];
            int read;
            while ((read = reader.read(buff)) > 0) {
                response.append(buff, 0, read);
            }
            return response.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public static String getResponseCharset(String ctype) {
        String charset = DEFAULT_CHARSET;
        if (!DoudianUtils.isEmpty(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2 && DoudianUtils.isNotEmpty(pair[1])) {
                        charset = pair[1].trim();
                    }
                    break;
                }
            }
        }
        return charset;
    }

    public static class TrustAllTrustManager implements X509TrustManager {
        public TrustAllTrustManager() {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
    }

    public static class HttpResponseData {
        private String body;
        private Map<String, List<String>> headers;

        public HttpResponseData() {
        }

        public String getBody() {
            return this.body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Map<String, List<String>> getHeaders() {
            return this.headers;
        }

        public void setHeaders(Map<String, List<String>> headers) {
            this.headers = headers;
        }
    }

}
