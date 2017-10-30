package com.cmcc.ms.common.utils;

import static org.junit.Assert.assertNotNull;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cmcc.ms.service.BaseTestCase;

/**
 * @author chenyouchao
 */
public class BeanToMapUtilTest extends BaseTestCase{
    /**
     * Run the LinkedHashMap<String, String> convertBean(Object) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testConvertBean()
        throws Exception {
        try {
            Object bean = new Object();
            Class<? extends Object> type = bean.getClass();
            LinkedHashMap<String, String> returnMap = BeanToMapUtil.convertBean(bean);
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!"class".equals(propertyName)) {
                    Method readMethod = descriptor.getReadMethod();
                    Object invoke = readMethod.invoke(bean, new Object[0]);
                    if (invoke != null) {
                        returnMap.put(propertyName, invoke.toString());
                    } else {
                        returnMap.put(propertyName, null);
                    }
                }
            }
            assertNotNull(returnMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     /**
      * @throws Exception
      *     if the clean-up fails for some reason
      */
    @Before
    public void setUp()
        throws Exception {
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *         if the clean-up fails for some reason
     *
     */
    @After
    public void tearDown()
        throws Exception {
    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(BeanToMapUtilTest.class);
    }
}