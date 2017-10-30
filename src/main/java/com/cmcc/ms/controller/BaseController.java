package com.cmcc.ms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author liudongyang-ry
 *	2017年9月20日上午10:09:19
 */
public class BaseController {
    /**
     * 
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handleAndReturnData(HttpServletRequest request,
                                                   HttpServletResponse response, Exception ex) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("excetion", ex.getClass().getSimpleName()+ex.getLocalizedMessage()+ex.toString());
        if(ex.getMessage()!=null){
            data.put("msg", ex.getMessage());
        }else {
            data.put("msg", "服务器繁忙，请稍候重试！");
        }
        data.put("code", 2017);
        data.put("list", null);
//        try {
//            ex.printStackTrace(response.getWriter());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return data;
    }
}
