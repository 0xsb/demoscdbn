/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class HttpHelper.
 *
 * @author cloud
 */
@SuppressWarnings("deprecation")
public class HttpHelper {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(HttpHelper.class);

    /** The Constant CHARSET. */
    public static final String CHARSET = "UTF-8";

    /** The http client. */
    private static CloseableHttpClient httpClient = createSSLInsecureClient();

    /** The Constant HTTP_METHOD_GET. */
    public static final String HTTP_METHOD_GET = "GET";

    /** The Constant HTTP_METHOD_POST. */
    public static final String HTTP_METHOD_POST = "POST";

    /** The Constant HTTP_OK. */
    public static final Integer HTTP_OK = 200;

    /** The Constant API_SECRET_NAME. */
    public static final String API_SECRET_NAME = "apiSecret";

    /**
     *  post数据方法.
     *
     * @param url the url
     * @param params the params
     * @param accept the accept
     * @return the string
     */
    public static String invokePost(String url, Map<String, String> params, String accept) {
        log.info("************invokePost********");
        log.info("url:" + url);
        log.info("params:" + params);
        HttpPost method = new HttpPost(url);
        method.addHeader(ConstantUtils.CONTENT_TYPE_NAME, ConstantUtils.CONTENT_TYPE_FORM);
        method.addHeader(ConstantUtils.ACCEPT, accept);
        // 增加两个参数,一个是时间戳，一个是随机数
        params.put("apiKey", PropertiesUtils.findPropertiesKey("apiKey", "/sms.properties"));
        params.put("apiSecret", PropertiesUtils.findPropertiesKey("apiSecret", "/sms.properties"));
        params.put(ConstantUtils.TIMESTAMP, "" + System.currentTimeMillis());
        params.put(ConstantUtils.RANDOM, getRandString());

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        // 生成签名
        String sign = getSign(params);
        nvps.add(new BasicNameValuePair(ConstantUtils.SIGN_NAME, sign));

        for (String key : params.keySet()) {
            String paramValue = params.get(key);
            if (paramValue == null) {

                continue;
            }
            nvps.add(new BasicNameValuePair(key, paramValue));
        }
        String result = "";
        CloseableHttpResponse resp = null;

        try {
            method.setEntity(new UrlEncodedFormEntity(nvps, CHARSET));
            resp = httpClient.execute(method);
            HttpEntity entity = resp.getEntity();
            result = EntityUtils.toString(entity, CHARSET);
        } catch (Exception e) {
            try {
                if (resp != null) {

                    resp.close();
                }
            } catch (IOException e1) {
                log.error("close resp error", e1);
            }
            log.error("httpclient invoke error", e);
        }

        return result;
    }

    /**
     * Builds the get url.
     *
     * @param url the url
     * @param params the params
     * @return the string
     */
    // 创建使用get方法时的请求URL
    private static String buildGetUrl(String url, Map<String, String> params) {

        // 增加两个参数,一个是时间戳，一个是随机数
        params.put(ConstantUtils.TIMESTAMP, "" + System.currentTimeMillis());
        params.put(ConstantUtils.RANDOM, getRandString());
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        // 生成签名
        String sign = getSign(params);
        for (String key : params.keySet()) {
            String paramValue = params.get(key);
            if (paramValue == null) {

                continue;
            }
            nvps.add(new BasicNameValuePair(key, paramValue));
        }
        nvps.add(new BasicNameValuePair(ConstantUtils.SIGN_NAME, sign));
        String paramString = URLEncodedUtils.format(nvps, "utf-8");
        return url + "?" + paramString;
    }

    /**
     * Gets the rand string.
     *
     * @return the rand string
     */
    private static String getRandString() {
        return DigestUtils.md5Hex(UUID.randomUUID().toString());
    }

    /**
     *  get数据方法.
     *
     * @param url the url
     * @param params the params
     * @param accept the accept
     * @return the string
     */
    public static String invokeGet(String url, Map<String, String> params, String accept) {
        log.info("*********invokeGet*********");
        log.info("url:" + url);
        log.info("params:" + params);
        String requestUrl = buildGetUrl(url, params);
        log.info("request url:" + requestUrl);
        HttpGet method = new HttpGet(requestUrl);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(1000).setSocketTimeout(5000).build();//设置请求和传输超时时间
        method.setConfig(requestConfig);
        method.addHeader(ConstantUtils.CONTENT_TYPE_NAME, ConstantUtils.CONTENT_TYPE_FORM);
        method.addHeader(ConstantUtils.ACCEPT, accept);
        CloseableHttpResponse resp = null;
        String result = null;
        try {
            resp = httpClient.execute(method);
            HttpEntity entity = resp.getEntity();
            result = EntityUtils.toString(entity, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (resp != null) {

                    resp.close();
                }
            } catch (IOException e1) {
                log.error("close resp error", e1);
            }
            log.error("httpclient invoke error", e);
        }

        return result;
    }

    /**
     * Gets the sign.
     *
     * @param paramMap the param map
     * @return the sign
     */
    // 生成签名的方法
    private static String getSign(Map<String, String> paramMap) {

        // 对参数名进行字典排序
        String[] keyArray = paramMap.keySet().toArray(new String[0]);
        Arrays.sort(keyArray);

        String secret = paramMap.get(API_SECRET_NAME);
        paramMap.remove(API_SECRET_NAME);
        // 拼接有序的参数名-值串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(secret);
        for (Object key : keyArray) {
            String value = paramMap.get(key);
            if (value == null) {

                continue;
            }
            stringBuilder.append(key).append("=").append(paramMap.get(key));
        }
        stringBuilder.append(secret);
        String codes = stringBuilder.toString();
        log.info("sign_str:" + codes);
        String sign = DigestUtils.md5Hex(codes).toUpperCase();
        log.info("sign:" + sign);
        return sign;
    }

    /**
     * 创建一个SSL信任所有证书的httpClient对象.
     *
     * @return the closeable http client
     */
    public static CloseableHttpClient createSSLInsecureClient() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null,
                    new TrustStrategy() {
                        // 默认信任所有证书
                        public boolean isTrusted(X509Certificate[] arg0, String arg1)
                                throws CertificateException {
                            return true;
                        }
                    }).build();
            // AllowAllHostnameVerifier: 这种方式不对主机名进行验证，验证功能被关闭，是个空操作(域名验证)
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        //如果创建失败，就创建一个默认的Http的连接
        return HttpClients.createDefault();
    }

}
