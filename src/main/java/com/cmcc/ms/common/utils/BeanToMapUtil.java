/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;


/**
 * 对象转换为Map.
 *
 * @author ldy
 */
public class BeanToMapUtil {

    /**
     * 将一个 JavaBean 对象转化为一个 Map.
     *
     * @param bean            要转化的JavaBean 对象
     * @return 转化出来的 Map 对象
     */
    public static LinkedHashMap<String, String> convertBean(Object bean) {
        try {
            Class<? extends Object> type = bean.getClass();
            LinkedHashMap<String, String> returnMap = new LinkedHashMap<String, String>();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);

            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!"class".equals(propertyName)) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result.toString());
                    } else {
                        returnMap.put(propertyName, null);
                    }
                }
            }
            return returnMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
