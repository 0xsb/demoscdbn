/*
 * 
 */
package com.cmcc.ms.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * 获取spring容器，以访问容器中定义的其他bean.
 */
public class SpringContextUtil implements ApplicationContextAware {

    /** The application context. */
    // Spring应用上下文环境
    private ApplicationContext applicationContext;

    /** The application contextsta. */
    private static ApplicationContext applicationContextsta;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境.
     *
     * @param applicationContext the new application context
     * @throws BeansException the beans exception
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        setApplicationContextSta();
    }

    /**
     * Sets the application context sta.
     */
    private void setApplicationContextSta() {
        applicationContextsta = applicationContext;
    }

    /**
     * Gets the application context.
     *
     * @return the application context
     */
    public ApplicationContext getApplicationContext() {
        return SpringContextUtil.applicationContextsta;
    }

    /**
     * 获取对象 这里重写了bean方法，起主要作用.
     *
     * @param beanId the bean id
     * @return  Object 一个以所给名字注册的bean的实例
     * @throws BeansException the beans exception
     */
    public Object getBean(String beanId) throws BeansException {
        return SpringContextUtil.applicationContextsta.getBean(beanId);
    }
}
