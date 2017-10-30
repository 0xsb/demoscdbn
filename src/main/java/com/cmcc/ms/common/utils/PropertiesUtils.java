/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;


/**
 * 对属性文件操作的工具类 获取，新增，修改 注意： 以下方法读取属性文件会缓存问题,在修改属性文件时，不起作用， 　InputStream in =
 * PropertiesUtils.class.getResourceAsStream("/config.properties"); 　解决办法：
 * 　String savePath =
 * PropertiesUtils.class.getResource("/config.properties").getPath();
 * 
 * @author zhucs
 */
public class PropertiesUtils {

    /**
     * 获取属性文件的数据 根据key获取值.
     *
     * @param key the key
     * @param path the path
     * @return the string
     */
    public static String findPropertiesKey(String key, String path) {

        try {
            Properties prop = getProperties(path);
            return prop.getProperty(key);
        } catch (Exception e) {
            return "";
        }

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Properties prop = new Properties();
        InputStream in = PropertiesUtils.class.getResourceAsStream("/config.properties");
        try {
            prop.load(in);
            Iterator<Entry<Object, Object>> itr = prop.entrySet().iterator();
            while (itr.hasNext()) {
                Entry<Object, Object> e = (Entry<Object, Object>) itr.next();
                System.err.println((e.getKey().toString() + "" + e.getValue().toString()));
            }
        } catch (Exception e) {

        }
    }

    /**
     * 返回　Properties.
     *
     * @param path the path
     * @return the properties
     */
    public static Properties getProperties(String path) {
        Properties prop = new Properties();
        String savePath = PropertiesUtils.class.getResource(path).getPath();
        // 以下方法读取属性文件会缓存问题
        // InputStream in = PropertiesUtils.class
        // .getResourceAsStream("/config.properties");
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(savePath));
            prop.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    /**
     * 写入properties信息.
     *
     * @param key            名称
     * @param value            值
     * @param p the p
     */
    public static void modifyProperties(String key, String value, String p) {
        FileOutputStream outputFile = null;
        try {
            // 从输入流中读取属性列表（键和元素对）
            Properties prop = getProperties(p);
            prop.setProperty(key, value);
            String path = PropertiesUtils.class.getResource("/redisschedule.properties").getPath();
            outputFile = new FileOutputStream(path);
            prop.store(outputFile, "modify");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputFile != null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
