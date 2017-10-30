/**
 * @author ldy
 */
package com.cmcc.ms.listener;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cmcc.ms.common.utils.TimeUtils;
import com.cmcc.ms.redis.RedisClientTemplate;
import com.cmcc.ms.service.system.impl.OperateLogServiceImpl;
import com.mchange.v2.ser.SerializableUtils;


/**
 * session监听.
 *
 * @author ldy
 */
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

    /**
     *  
     * 通过WebApplicationContextUtils 得到Spring容器的实例。根据bean的名称返回bean的实例。 .
     *
     * @param servletContext  ：ServletContext上下文。
     * @param beanName  :要取得的Spring容器中Bean的名称。
     * @return 返回Bean的实例。
     */
    private Object getBeanFromApplication(ServletContext servletContext, String beanName) {
        //通过WebApplicationContextUtils 得到Spring容器的实例。  
        ApplicationContext application = WebApplicationContextUtils
                .getWebApplicationContext(servletContext);
        //返回Bean的实例。  
        return application.getBean(beanName);
    }

    /**
     *  (non-Javadoc).
     *
     * @param event the event
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("userid".equals(event.getName())) {
            Object attribute = event.getSession().getAttribute("userid");
            try {
                ((RedisClientTemplate) this.getBeanFromApplication(event.getSession()
                        .getServletContext(), "redisClientTemplate")).addUserList(SerializableUtils
                        .fromByteArray((byte[]) attribute).toString());
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  (non-Javadoc).
     *
     * @param event the event
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("userNameSession".equals(event.getName())) {
            HttpSession session = event.getSession();
            doOperateLog(session);
            Object attribute = event.getSession().getAttribute("userid");
            try {
                ((RedisClientTemplate) this.getBeanFromApplication(event.getSession()
                        .getServletContext(), "redisClientTemplate"))
                        .del(SerializableUtils.fromByteArray((byte[]) (event.getSession()
                                .getAttribute("userName"))) + "");
                ((RedisClientTemplate) this.getBeanFromApplication(event.getSession()
                        .getServletContext(), "redisClientTemplate")).remUserList(SerializableUtils
                        .fromByteArray((byte[]) attribute).toString());
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            } finally {
                event.getSession().invalidate();
            }
        }
    }

    /**
     * Do operate log.
     *
     * @param session the session
     */
    private void doOperateLog(HttpSession session) {
        OperateLogServiceImpl.insert(session);
    }

    /**
     * Gets the online hour.
     *
     * @param tsp the tsp
     * @return the online hour
     */
    public static float getOnlineHour(Timestamp tsp) {
        return (float) TimeUtils
                .getMinuteDiffByTime(tsp, new Timestamp(System.currentTimeMillis()));
    }

    /**
     *  (non-Javadoc).
     *
     * @param event the event
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    /**
     *  (non-Javadoc).
     *
     * @param se the se
     * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    /**
     *  (non-Javadoc).
     *
     * @param event the event
     * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

    }

}
