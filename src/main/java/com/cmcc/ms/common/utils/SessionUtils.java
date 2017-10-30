/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.io.IOException;
import java.io.NotSerializableException;

import javax.servlet.http.HttpServletRequest;

import com.mchange.v2.ser.SerializableUtils;


/**
 * sessionutils 序列化value.
 *
 * @author zhucs
 */
public class SessionUtils {

    /**
     * 设值.
     *
     * @param request the request
     * @param name the name
     * @param value the value
     */
    public static void setAttribute(HttpServletRequest request, String name, Object value) {
        try {
            request.getSession().setAttribute(name, SerializableUtils.toByteArray(value));
        } catch (NotSerializableException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取值.
     *
     * @param request the request
     * @param name the name
     * @return the attribute
     */
    public static Object getAttribute(HttpServletRequest request, String name) {
        Object value = request.getSession(true).getAttribute(name);
        if (value != null) {
            try {
                return SerializableUtils.fromByteArray((byte[]) value);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 取值.
     *
     * @param request the request
     * @param name the name
     * @return Integer
     */
    public static Integer getAttrForInt(HttpServletRequest request, String name) {
        try {
            return Integer.valueOf(String.valueOf(getAttribute(request, name)));
        } catch (Exception e) {
            return 0;
        }
    }
}
