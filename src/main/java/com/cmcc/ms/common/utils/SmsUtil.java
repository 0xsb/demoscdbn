/*
 * 
 */
package com.cmcc.ms.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *  
 *
 * @author  Lishunli
 * @version 1.0
 * @Project cmcciw
 * @Description: 短信工具类
 * @date 2016年4月21日 下午3:17:29
 */
public class SmsUtil {

    /** The log. */
    public static Logger log = LoggerFactory.getLogger(SmsUtil.class);

    /** The Constant PROPERTIY_NAME. */
    public static final String PROPERTIY_NAME = "sms"; //短信属性文件名称

    /** The instance util. */
    private static SmsUtil instanceUtil = null;

    /**
     * Instantiates a new sms util.
     */
    private SmsUtil() {
        super();
    }

    // 单类模式创建工具类实类
    /**
     * Instance.
     *
     * @return the sms util
     */
    public static SmsUtil instance() {
        if (instanceUtil == null) {
            instanceUtil = new SmsUtil();
        }
        return instanceUtil;
    }

    /**
     * Gets the sms.
     *
     * @param tel the tel
     * @param context the context
     */
    public void getSms(String tel, String context) {
        PropertiesReader propertiesReader = PropertiesReader.getInstance();
        try {
            if (!tel.isEmpty()) {
                String url = propertiesReader.getValue(PROPERTIY_NAME, "sms.url");
                String sourceAddr = propertiesReader.getValue(PROPERTIY_NAME, "sms.sourceAddr");
                String needReceipt = propertiesReader.getValue(PROPERTIY_NAME, "sms.needReceipt");
                String apiKey = propertiesReader.getValue(PROPERTIY_NAME, "sms.apiKey");
                String secretKey = propertiesReader.getValue(PROPERTIY_NAME, "sms.secretKey");
                String receiptNotificationURL = propertiesReader.getValue(PROPERTIY_NAME,
                        "sms.receiptNotificationURL");
                propertiesReader.postCode(url, tel, sourceAddr, context, needReceipt, apiKey,
                        secretKey, receiptNotificationURL);
            }
        } catch (Exception e) {
            System.out.println("_____________________");
            System.out.println(e.getMessage());
            System.out.println("_____________________");

            e.printStackTrace();
        }

    }

    /**
     * 调用fetion.sms.url 短信接口
     *
     * @param tel the tel
     * @param context the context
     * @return the string
     */
    public static synchronized String sendAppCodeByFetion(String tel, String context) {
        PropertiesReader propertiesReader = PropertiesReader.getInstance();
        String result = "";
        try {
            if (!tel.isEmpty()) {
                String fetionUrl = propertiesReader.getValue(PROPERTIY_NAME, "fetion.sms.url");
                String batchId = propertiesReader.getValue(PROPERTIY_NAME, "fetion.sms.batchId");
                String signature = propertiesReader
                        .getValue(PROPERTIY_NAME, "fetion.sms.signature");
                int type = Integer.parseInt(propertiesReader.getValue(PROPERTIY_NAME,
                        "fetion.sms.type"));
                result = propertiesReader.postCode(fetionUrl, tel, batchId, context, signature,
                        type);
            }
        } catch (Exception e) {
            System.out.println("_____________________");
            System.out.println(e.getMessage());
            System.out.println("_____________________");
        }
        return result;
    }

    /**
     * 调用sms.url 短信接口
     *
     * @param tel the tel
     * @param context the context
     * @return the string
     */
    public static String sendAppCodeBysms(String tel, String context) {
        PropertiesReader propertiesReader = PropertiesReader.getInstance();
        String result = "";
        try {
            if (!tel.isEmpty()) {
                String url = propertiesReader.getValue(PROPERTIY_NAME, "sms.url");
                String sourceAddr = propertiesReader.getValue(PROPERTIY_NAME, "sms.sourceAddr");
                String needReceipt = propertiesReader.getValue(PROPERTIY_NAME, "sms.needReceipt");
                String apiKey = propertiesReader.getValue(PROPERTIY_NAME, "sms.apiKey");
                String secretKey = propertiesReader.getValue(PROPERTIY_NAME, "sms.secretKey");
                String receiptNotificationURL = propertiesReader.getValue(PROPERTIY_NAME,
                        "sms.receiptNotificationURL");
                result = propertiesReader.postCode(url, tel, sourceAddr, context, needReceipt,
                        apiKey, secretKey, receiptNotificationURL);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
