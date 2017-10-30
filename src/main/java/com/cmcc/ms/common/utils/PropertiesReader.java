/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;


/**
 * 加载资源文件.
 *
 * @author shixin.zhang
 */
public class PropertiesReader {

    /** The instance. */
    private static PropertiesReader instance = new PropertiesReader();

    /** The log. */
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Instantiates a new properties reader.
     */
    private PropertiesReader() {

    }

    /**
     * Gets the single instance of PropertiesReader.
     *
     * @return single instance of PropertiesReader
     */
    public static PropertiesReader getInstance() {
        return instance;
    }

    /**
     * 获取配置文件中的值.
     *
     * @param fileName            properties文件路径,不需要带后缀，只需要文件名即可
     * @param key            对应要获取key的值
     * @return the value
     * @throws MissingResourceException the missing resource exception
     * @throws java.util.MissingResourceException the java.util. missing resource exception
     */
    public String getValue(String fileName, String key) throws MissingResourceException {
        final ResourceBundle res = ResourceBundle.getBundle(fileName);

        String value = "";
        try {
            value = res.getString(key);
        } catch (MissingResourceException e) {
            throw e;
        }
        return value;
    }

    /**
     * 发送消息.
     *
     * @param url the url
     * @param destAddr the dest addr
     * @param sourceAddr the source addr
     * @param message the message
     * @param needReceipt the need receipt
     * @param apiKey the api key
     * @param secretKey the secret key
     * @param receiptNotificationURL the receipt notification URL
     * @return the string
     */
    public String postCode(String url, String destAddr, String sourceAddr, String message,
                           String needReceipt, String apiKey, String secretKey,
                           String receiptNotificationURL) {
        JSONObject obj = new JSONObject();
        String responseInfo = "";
        try {
            obj.put("destAddr", destAddr);
            obj.put("sourceAddr", sourceAddr);
            obj.put("message", message);
            obj.put("needReceipt", Integer.parseInt(needReceipt));
            obj.put("apiKey", apiKey);
            obj.put("secretKey", secretKey);
            obj.put("receiptNotificationURL", receiptNotificationURL);
            responseInfo = this.postURL(obj.toString(), url);
            return responseInfo;
        } catch (Exception e) {
            log.info("postCode error:" + e.getMessage());
        }

        return "";
    }

    /**
     * 发送消息.
     *
     * @param fetionUrl the fetion url
     * @param tel the tel
     * @param batchId the batch id
     * @param context the context
     * @param signature the signature
     * @param type the type
     * @return the string
     */
    public String postCode(String fetionUrl, String tel, String batchId, String context,
                           String signature, int type) {
        String url = fetionUrl;
        String responseInfo = "";
        try {
            responseInfo = this.postURL("batchId=" + batchId + "&mobile=" + tel + "&type=" + type
                    + "&content=" + context + "&signature=" + signature, url);
            return responseInfo;
        } catch (Exception e) {
            log.info("postCode error:" + e.getMessage());
        }

        return "";
    }

    /**
     * Post URL.
     *
     * @param commString the comm string
     * @param address the address
     * @return the string
     * @throws Exception the exception
     */
    public String postURL(String commString, String address) throws Exception {
        String responseResult = "";
        URL url = null;
        OutputStreamWriter ow = null;
        BufferedReader rd = null;
        HttpURLConnection urlConn = null;
        try {
            /* 得到url地址的URL类 */
            url = new URL(address);
            /* 获得打开需要发送的url连接 */
            urlConn = (HttpURLConnection) url.openConnection();
            /* 设置连接超时时间 */
            urlConn.setConnectTimeout(30000);
            /* 设置读取响应超时时间 */
            urlConn.setReadTimeout(60000);
            /* 设置post发送方式 */
            urlConn.setRequestMethod("POST");
            /* 发送commString */
            urlConn.setDoOutput(true);
            urlConn.setDoInput(true);
            urlConn.setRequestProperty("Content-Type", "application/json");
            OutputStream out = urlConn.getOutputStream();
            ow = new OutputStreamWriter(out, "UTF-8");
            // out.write(commString.getBytes());
            // out.flush();
            // out.close();
            ow.write(commString);
            ow.flush();
            /* 发送完毕 获取返回流，解析流数据 */
            rd = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = rd.read()) > -1) {
                sb.append((char) ch);
            }
            responseResult = sb.toString().trim();
            // System.out.println(responseResult);
            log.info("__________________________");
            log.info("send sms return info:" + responseResult);
            log.info("__________________________");
            /* 解析完毕关闭输入流 */
            rd.close();
            /* 返回响应内容 */
            return responseResult;
        } catch (Exception e) {
            /* 异常处理 */
            log.error(e.getMessage());
            throw e;
        } finally {
            if (urlConn != null) {
                /* 关闭URL连接 */
                urlConn.disconnect();
            }
            if (rd != null) {
                rd.close();
            }
            if (ow != null) {
                ow.close();
            }
        }
    }

}
