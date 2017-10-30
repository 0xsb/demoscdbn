package com.cmcc.ms.interceptor;

import java.net.ConnectException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import redis.clients.jedis.exceptions.JedisConnectionException;

import com.cmcc.ms.exception.ApiTimeoutException;
import com.cmcc.ms.exception.SessionTimeoutException;


/**
 * 描述：拦截noHandler sessiontimeout Exception.
 *
 * @author zhucs
 * @version V1.0.1
 * @date 2015年7月12日 下午1:27:32
 */
public class CmccSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

    /**
     * Do resolve exception.
     *
     * @param request the request
     * @param response the response
     * @param handler the handler
     * @param ex the ex
     * @return the model and view
     * @see org.springframework.web.servlet.handler.SimpleMappingExceptionResolver
     * #doResolveException(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object,
     * java.lang.Exception)
     */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler,
                                              Exception ex) {
        // 截获 NoHandlerFoundException
        if (ex instanceof NoHandlerFoundException || ex instanceof SessionTimeoutException
                || ex instanceof ApiTimeoutException || ex instanceof JedisConnectionException
                || ex instanceof ConnectException || ex instanceof MaxUploadSizeExceededException) {
            ModelAndView result = super.doResolveException(request, response, handler, ex);
            return result;
        } else {// 其他保持原逻辑
            String viewName = determineViewName(ex, request);
            if (viewName != null) {
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getModelAndView(viewName, ex, request);
            } else {
                return null;
            }
        }
    }

    /**
     * Resolve exception.
     *
     * @param request the request
     * @param response the response
     * @param handler the handler
     * @param ex the ex
     * @return the model and view
     * @see org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver#resolveException
     *      (javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse, java.lang.Object,
     *      java.lang.Exception)
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {

        if (shouldApplyTo(request, handler)) {
            // Log exception, both at debug log level and at warn level, if
            // desired.
            if (logger.isDebugEnabled()) {
                logger.debug("Resolving exception from handler [" + handler + "]: " + ex);
            }
            // 截获 NoHandlerFoundException
            if (ex instanceof NoHandlerFoundException) {
                // 异常不打印
                logger.warn("cmccNoHandler:" + requestDescription(request));
            } else if (ex instanceof SessionTimeoutException) {
                logger.warn("cmccSessionTimeOut:" + requestDescription(request));
            } else if (ex instanceof MaxUploadSizeExceededException) {
                logger.warn("cmccMaxUploadSize:" + requestDescription(request));
            } else {// 其他保持原逻辑
                logException(ex, request);
            }
            prepareResponse(ex, response);
            return doResolveException(request, response, handler, ex);
        } else {
            return null;
        }
    }

    /**
     * 描述：组装 访问信息.
     *
     * @param request the request
     * @return String
     */
    private String requestDescription(HttpServletRequest request) {
        StringBuffer buf = new StringBuffer();
        buf.append("{URL:");
        buf.append(request.getRequestURI());
        buf.append(",IP:");
        buf.append(request.getRemoteAddr());
        buf.append("}");
        return buf.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "异常信息";
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver#logException(java.lang.Exception, javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected void logException(Exception ex, HttpServletRequest request) {
        logger.warn("Exception:" + requestDescription(request));
    }

}
