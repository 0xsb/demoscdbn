package com.cmcc.ms.interceptor;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cmcc.ms.common.utils.SessionUtils;
import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.exception.AuthException;
import com.cmcc.ms.exception.SessionAuthException;
import com.cmcc.ms.exception.SessionTimeoutException;
import com.cmcc.ms.redis.RedisClientTemplate;
import com.cmcc.ms.service.system.SysUsersService;

/**
 * 通用权限拦截器.
 *
 * @author ldy
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    /** The sys users service. */
    @Autowired
    private SysUsersService sysUsersService;

    /** The redis client template. */
    @Autowired
    private RedisClientTemplate redisClientTemplate;

    /**
     * 按钮权限判断<br>
     * SessionTimeOut处理.
     *
     * @param request the request
     * @param response the response
     * @param handler the handler
     * @return true, if successful
     * @throws Exception the exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        byte[] redisFlag = redisClientTemplate.get((request.getSession().getId() + "NOAUTO")
                .getBytes());
        if (redisFlag != null) {
            Object unserialize = new String(redisFlag);
            if ("NOAUTO".equals(unserialize.toString())) {
                redisClientTemplate.del((request.getSession().getId() + "NOAUTO").getBytes());
                redisClientTemplate.del((request.getSession().getId()).getBytes());
                throw new SessionAuthException();
            }
        }
        Object userid = SessionUtils.getAttribute(request, "userid");
        if (userid != null && !StringUtils.isEmpty(userid.toString())) {
            return access(request, userid);
        } else {
            throw new SessionTimeoutException();
        }
    }

    /**
     * 查询用户所有按钮权限</br> 包含则通过，不包含则返回false.
     *
     * @param request the request
     * @param userid the userid
     * @return true, if successful
     * @throws AuthException the auth exception
     */
    private boolean access(HttpServletRequest request, Object userid) throws AuthException {
        String path = request.getServletPath();
        List<SysMenus> menus = sysUsersService
                .selectByPrimaryKey(Integer.valueOf(userid.toString())).getSysRolesManual()
                .getSysMenus();
        Iterator<SysMenus> it = menus.iterator();
        boolean flag = true;// 默认拦截
        while (it.hasNext()) {
            SysMenus menu = it.next();
            String url = parse(path, request);
            String menuUrl = parse(menu.getUrl(), request);
            if (StringUtils.isEmpty(menuUrl)) {
                continue;
            }
            // 如果是按钮，则判断是否包含，包含则通过，不包含则返回false
            String[] split = menuUrl.split("/");
            if (url.startsWith(split[0])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new AuthException();
        }
        return true;
    }

    /**
     * 路径预处理.
     *
     * @param url the url
     * @param request 
     * @return the string
     */
    private String parse(String url, HttpServletRequest request) {
        if (StringUtils.isEmpty(url)) {
            return "";
        }
        if (url.substring(0, 1).endsWith("/")) {
            url = url.substring(1, url.length());
        }
        //设备端口权限特别处理
        if (url.contains("cdnManage/")) {
            String type = request.getParameter("type");
            if (type != null) {
                if (type.contains("device")) {
                    url = url.replaceFirst("cdnManage/", "device");
                } else if (type.contains("port")) {
                    url = url.replaceFirst("cdnManage/", "port");
                } else if (url.contains("Devices")) {
                    url = url.replaceFirst("cdnManage/", "device");
                } else if (url.contains("Ports")) {
                    url = url.replaceFirst("cdnManage/", "port");
                } else {
                    url = url.replaceFirst("cdnManage/", "");
                }
            } else if (url.contains("Devices")) {
                url = url.replaceFirst("cdnManage/", "device");
            } else if (url.contains("Ports")) {
                url = url.replaceFirst("cdnManage/", "port");
            } else {
                url = url.replaceFirst("cdnManage/", "");
            }
        }
        return url;
    }

}
