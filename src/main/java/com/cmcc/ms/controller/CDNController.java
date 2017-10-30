/*
 * Project: cmcciwms
 * 
 * File Created at 2016年11月2日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cmcc.ms.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cmcc.ms.common.utils.BeanToMapUtil;
import com.cmcc.ms.common.utils.Excel2JsonUtil;
import com.cmcc.ms.common.utils.HttpHelper;
import com.cmcc.ms.common.utils.PropertiesUtils;
import com.cmcc.ms.common.utils.SessionUtils;
import com.cmcc.ms.common.utils.StringUtil;
import com.cmcc.ms.entity.resource.ResourceBean;
import com.cmcc.ms.entity.resource.ResourceDevices;
import com.cmcc.ms.entity.resource.ResourcePorts;
import com.cmcc.ms.entity.system.OperateLog;
import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.service.system.impl.OperateLogServiceImpl;
import com.cmcc.ms.service.system.impl.SysExportServiceImpl;

/**
 * The Class CDNController.
 *
 * @author ldy
 * @version 
 * @date 2017年5月26日 下午3:58:43
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/cdnManage")
public class CDNController extends BaseController {

    /** The log. */
    private static Logger log = LoggerFactory.getLogger(CDNController.class);

    /** The size. */
    private static int size = Integer.parseInt(PropertiesUtils.findPropertiesKey("SIZE",
            "/resetPwdConfig.properties"));

    /** The sys export service impl. */
    @Autowired
    private SysExportServiceImpl sysExportServiceImpl;

    /** The operate log service impl. */
    @Autowired
    private OperateLogServiceImpl operateLogServiceImpl;

    /**
     * 导出标准模板.
     *
     * @param request the request
     * @param response the response
     * @param type the type
     */
    @RequestMapping(value = "/downloadTemp")
    public void downloadTemp(HttpServletRequest request, HttpServletResponse response, String type) {
        String fileName = new String();
        if (type == null || "".equals(type)) {
            fileName = "SNMP V1 V2 设备信息录入模板";
        } else if ("device_v2".equals(type)) {
            fileName = "SNMP V1 V2 设备信息录入模板";
        } else if ("device_v3".equals(type)) {
            fileName = "SNMP V3 设备录入模板";
        } else {
            fileName = "端口信息录入模板";
        }
        InputStream inStream = null;
        try {
            inStream = new FileInputStream(request.getSession().getServletContext()
                    .getRealPath("/")
                    + "/temp/" + fileName + ".xlsx");
            fileName = getBrowerVersion(request, response, fileName);
            // 循环取出流中的数据
            byte[] b = new byte[1024];
            int len;
            while ((len = inStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 上传文件.
     *
     * @param request the request
     * @param file the file
     * @param type the type
     * @param roleId the role id
     * @param menuName the menu name
     * @return the JSON object
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONObject judgeFileFormat(HttpServletRequest request,
                                      MultipartFile file,
                                      @RequestParam(value = "type", required = true) String type,
                                      @RequestParam(value = "roleId", required = true) Integer roleId,
                                      @RequestParam(value = "menuName", required = true) String menuName) {
        try {
            LinkedHashMap<String, Object> excel2json = Excel2JsonUtil.excel2json(file, type,
                    roleId, menuName, request);
            return JSONObject.fromObject(excel2json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    /**
     * 导入设备端口.
     *
     * @param request the request
     * @param type the type
     * @return the string
     */
    @RequestMapping(value = "/import", method = RequestMethod.GET)
    @ResponseBody
    public String importDeviceOrPort(HttpServletRequest request, String type) {
        Object object = SessionUtils.getAttribute(request, "userid");
        if (object != null) {
            HashMap<String, String> param = new LinkedHashMap<String, String>();
            @SuppressWarnings("unchecked")
            List<LinkedHashMap<String, String>> listData = (List<LinkedHashMap<String, String>>) SessionUtils
                    .getAttribute(request, "checkedData" + type + object.toString());
            if (listData.size() > 0 && JSONArray.fromObject(listData) != null) {
                param.put("json", JSONArray.fromObject(listData).toString());
            }
            String url = PropertiesUtils.findPropertiesKey("URL", "/resetPwdConfig.properties");
            String typeStr = "";
            if (type.contains("device")) {
                typeStr = "设备";
                url += "resourceImportDevice";
            } else {
                typeStr = "端口";
                url += "resourceImportPort";
            }
            HashMap<String, String> ret = returnMsg(param, url, typeStr);
            // 导入后返回message
            String returnMsg = ret.get("msg");
            // 导入返回的json
            String resJson = ret.get("res");
            // 获取用户id
            String userId = SessionUtils.getAttribute(request, "userid").toString();
            // 获取用户名
            String userName = SessionUtils.getAttribute(request, "userName").toString();
            // 设置
            String content = "导入" + typeStr;
            // 创建日志对象
            OperateLog operateLog = new OperateLog();
            // 设置日志记录操作的用户Id
            operateLog.setUserId(Integer.valueOf(userId));
            // 设置日志记录操作的用户
            operateLog.setUserName(userName);
            // 设置记录操作过程的数据
            operateLog.setOperateContent(content);
            operateLog.setReceiveMsg(resJson);
            operateLog.setSendMsg(JSONArray.fromObject(listData).toString());
            operateLogServiceImpl.saveUserOperation(operateLog, request);
            return returnMsg;
        }
        return "请求超时";
    }

    /**
     * 更新设备端口.
     *
     * @param request the request
     * @param type the type
     * @param json the json
     * @return the string
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateDeviceOrPort(HttpServletRequest request, String type, String json) {
        Object object = SessionUtils.getAttribute(request, "userid");
        if (object != null) {
            HashMap<String, String> param = new LinkedHashMap<String, String>();
            if (StringUtil.isNotNUll(json)) {
                param.put("json", json);
            }
            String url = PropertiesUtils.findPropertiesKey("URL", "/resetPwdConfig.properties");
            String typeStr = "";
            if (type.contains("device")) {
                typeStr = "设备";
                url += "resourceUpdateDevice";
            } else {
                typeStr = "端口";
                url += "resourceUpdatePort";
            }
            HashMap<String, String> ret = returnMsg(param, url, typeStr);
            // 导入后返回message
            String returnMsg = ret.get("msg");
            // 导入返回的json
            String resJson = ret.get("res");
            // 获取用户名
            String userId = SessionUtils.getAttribute(request, "userid").toString();
            // 获取用户名
            String userName = SessionUtils.getAttribute(request, "userName").toString();
            // 设置
            String receiveMsg = "更新" + typeStr;
            // 创建日志对象
            OperateLog operateLog = new OperateLog();
            // 设置日志记录操作的用户Id
            operateLog.setUserId(Integer.valueOf(userId));
            // 设置日志记录操作的用户
            operateLog.setUserName(userName);
            // 设置日志记录发送信息
            operateLog.setSendMsg(param.get("json"));
            // 设置日志记录返回信息
            operateLog.setReceiveMsg(resJson);
            // 设置记录操作过程的数据
            operateLog.setOperateContent(receiveMsg);
            operateLogServiceImpl.saveUserOperation(operateLog, request);
            return returnMsg;

        }
        return "请求超时";
    }

    /**
     * 删除设备端口.
     *
     * @param request the request
     * @param type the type
     * @param json the json
     * @return the string
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delDeviceOrPort(HttpServletRequest request, String type, String json) {
        Object object = SessionUtils.getAttribute(request, "userid");
        if (object != null) {
            HashMap<String, String> param = new LinkedHashMap<String, String>();
            if (StringUtil.isNotNUll(json)) {
                param.put("json", json);
            }
            String url = PropertiesUtils.findPropertiesKey("URL", "/resetPwdConfig.properties");
            String typeStr = "";
            if (type.contains("device")) {
                typeStr = "设备";
                url += "resourceDeleteDevice";
            } else {
                typeStr = "端口";
                url += "resourceDeletePort";
            }
            HashMap<String, String> ret = returnMsg(param, url, typeStr);
            // 导入后返回message
            String returnMsg = ret.get("msg");
            // 导入返回的json
            String resJson = ret.get("res");
            // 获取用户名
            String userId = SessionUtils.getAttribute(request, "userid").toString();
            // 获取用户名
            String userName = SessionUtils.getAttribute(request, "userName").toString();
            // 设置日志内容
            String content = "删除" + typeStr;
            // 创建日志对象
            OperateLog operateLog = new OperateLog();
            // 设置日志记录操作的用户Id
            operateLog.setUserId(Integer.valueOf(userId));
            // 设置日志记录操作的用户
            operateLog.setUserName(userName);
            // 设置日志记录接受信息
            operateLog.setReceiveMsg(resJson);
            // 设置日志记录发送信息
            operateLog.setSendMsg(param.get("json"));
            // 设置记录操作过程的数据
            operateLog.setOperateContent(content);
            operateLog.setOperateTime(new Date());
            operateLogServiceImpl.saveUserOperation(operateLog, request);
            return returnMsg;
        }
        return "请求超时";
    }

    /**
     * 解析响应数据状态.
     *
     * @param param the param
     * @param url the url
     * @param type the type
     * @return the hash map
     */
    private HashMap<String, String> returnMsg(HashMap<String, String> param, String url, String type) {
        HashMap<String, String> map = new LinkedHashMap<String, String>();
        String code = "";
        if (param.get("json") != null) {
            // String invokePost = HttpHelper.invokePost(url, param, accptType);
            @SuppressWarnings("unchecked")
            List<LinkedHashMap<String, String>> list = (List<LinkedHashMap<String, String>>) JSONArray
                    .toList(JSONArray.fromObject(param.get("json").replaceAll("\\＂", "\"")),
                            new LinkedHashMap<String, String>(), new JsonConfig());
            String invokePost = Excel2JsonUtil.getInvokePost(list, url,
                    new HashMap<String, String>(), size);
            String resStr = invokePost;
            map.put("res", resStr);
            if (invokePost != null && !"".equals(invokePost.trim())) {
                int indexOf = invokePost.indexOf("[");
                if (indexOf != -1) {
                    invokePost = invokePost.substring(invokePost.indexOf("["));
                    JSONArray fromObject = JSONArray.fromObject(invokePost);
                    if (fromObject.size() == 0) {
                        map.put("msg", "服务异常：[" + resStr + "]");
                        return map;
                    }
                    for (int i = 0; i < fromObject.size(); i++) {
                        JSONObject json = (JSONObject) fromObject.get(i);
                        Object opt = json.opt("错误代码");
                        if (opt != null) {
                            String res = opt.toString();
                            if ("0".equals(res)) {
                                code += type + json.opt(type + "名称") + "操作成功</br>";
                            } else if ("1".equals(res)) {
                                code += type + json.opt(type + "名称") + "为资源表中已存在该设备或者端口资源</br> ";
                            } else if ("2".equals(res)) {
                                code += type + json.opt(type + "名称") + "资源表中不存在该设备或者端口资源</br> ";
                            } else if ("3".equals(res)) {
                                code += type + json.opt(type + "名称") + "SNMP探测设备不可达</br> ";
                            } else if ("4".equals(res)) {
                                code += type + json.opt(type + "名称") + "SNMP探测设备不存在该端口资源</br> ";
                            } else if ("5".equals(res)) {
                                code += type + json.opt(type + "名称") + "SNMP采集端口信息失败(无数据)</br> ";
                            } else if ("6".equals(res)) {
                                code += type + json.opt(type + "名称") + "未知</br> ";
                            } else if ("21".equals(res)) {
                                code += type + json.opt(type + "名称") + "资源数据不完整</br> ";
                            } else if ("22".equals(res)) {
                                code += type + json.opt(type + "名称") + "操作代码有误</br> ";
                            } else if ("23".equals(res)) {
                                code += type + json.opt(type + "名称") + "资源已经存在</br> ";
                            } else if ("24".equals(res)) {
                                code += type + json.opt(type + "名称") + "资源与数据库不匹配</br> ";
                            } else if ("99".equals(res)) {
                                code += type + json.opt(type + "名称") + "内部错误（包括数据库、脚本等异常报错</br>） ";
                            } else {
                                code += type + json.opt(type + "名称") + "未解析的错误代码：" + code
                                        + "</br> ";
                            }
                        } else {
                            map.put("msg", "未获取到有效错误代码");
                            return map;
                        }
                    }
                    map.put("msg", code);
                    return map;
                } else {
                    map.put("msg", "服务异常:[" + resStr + "]");
                    return map;
                }
            } else {
                map.put("msg", "服务异常:未返回有效数据！");
                return map;
            }
        } else {
            map.put("msg", "参数异常");
            return map;
        }
    }

    /**
     * 清空导入设备端口.
     *
     * @param request the request
     * @param type the type
     * @return the string
     */
    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    @ResponseBody
    public String clearDeviceOrPort(HttpServletRequest request, String type) {
        SessionUtils.setAttribute(request,
                "checkedData" + type + SessionUtils.getAttribute(request, "userid"), null);
        return "success";
    }

    /**
     * 检索设备Lsit.
     *
     * @param devices the devices
     * @param request the request
     * @param response the response
     * @return the string
     */

    @RequestMapping(value = "/deviceList", method = RequestMethod.POST)
    @ResponseBody
    public String devicesList(ResourceDevices devices, HttpServletRequest request,
                              HttpServletResponse response) {
        String url = PropertiesUtils.findPropertiesKey("URL", "/resetPwdConfig.properties")
                + "resourceDeviceList";
        boolean flag = false;
        flag = getFlag(devices.getProvince(), request, flag);
        if (flag) {
            String invokeGet = HttpHelper.invokeGet(url, BeanToMapUtil.convertBean(devices),
                    PropertiesUtils.findPropertiesKey("ACCPTTYPE", "/resetPwdConfig.properties"));
            log.info(invokeGet + "==返回==");
            return doReturn(invokeGet);
        } else {
            return null;
        }
    }

    /**
     * @param invokeGet
     * @return
     */
    private String doReturn(String invokeGet) {
        if (invokeGet != null && !"".equals(invokeGet.trim()) && invokeGet.indexOf("[") != -1) {
            return invokeGet;
        } else {
            log.error("脚本返回信息有误！");
            return "{\"totalCount\":0,\"pageCount\":1,\"list\":[],\"msg\":\"脚本返回信息有误\"}";
        }
    }

    /**
     * Gets the flag.
     *
     * @param pro the pro
     * @param request the request
     * @param flag the flag
     * @return the flag
     */
    private boolean getFlag(String pro, HttpServletRequest request, boolean flag) {
        if (StringUtil.isNotNUll(pro)) {
            @SuppressWarnings("unchecked")
            List<SysMenus> menus = (List<SysMenus>) SessionUtils.getAttribute(request,
                    SessionUtils.getAttribute(request, "roleid") + "province");
            if (menus != null) {
                for (int i = 0; i < menus.size(); i++) {
                    if (menus.get(i).getImg().equals(pro)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 检索端口List.
     *
     * @param ports the ports
     * @param request the request
     * @param response the response
     * @return the string
     */
    @RequestMapping(value = "/portList", method = RequestMethod.POST)
    @ResponseBody
    public String portsList(ResourcePorts ports, HttpServletRequest request,
                            HttpServletResponse response) {
        String url = PropertiesUtils.findPropertiesKey("URL", "/resetPwdConfig.properties")
                + "resourcePortList";
        boolean flag = false;
        flag = getFlag(ports.getProvince(), request, flag);
        if (flag) {
            String invokeGet = HttpHelper.invokeGet(url, BeanToMapUtil.convertBean(ports),
                    PropertiesUtils.findPropertiesKey("ACCPTTYPE", "/resetPwdConfig.properties"));
            log.info(invokeGet + "==返回==");
            return doReturn(invokeGet);
        } else {
            return null;
        }
    }

    /**
     * 端口导出.
     *
     * @param ports            端口
     * @param request the request
     * @param response the response
     * @throws Exception the exception
     */

    @RequestMapping(value = "/exportPortsList", method = RequestMethod.GET)
    public void exportPortsList(ResourcePorts ports, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        //Object object = SessionUtils.getAttribute(request, "userid");
        String[] split = (request.getQueryString().split("&"))[0].split("=");
        ports.setPageSize(split[1]);
        ports.setPageNum("1");
        String fileName = "端口";
        // 设置响应头
        fileName = getBrowerVersion(request, response, fileName);
        String type = "端口";
        String portsList = portsList(ports, request, response);
        JSONObject fromObject = JSONObject.fromObject(portsList);
        ServletOutputStream out = response.getOutputStream();
        if (fromObject != null) {
            JSONArray opt = (JSONArray) fromObject.opt("list");

            if (opt != null) {
                LinkedHashMap<String, String> mapPort = Excel2JsonUtil.mapPortexp;
                if (mapPort.size() > 0) {
                    sysExportServiceImpl.doExport(opt, out, mapPort, type);
                }
            }

        }
    }

    /**
     * *.
     *
     * @param ids            端口id
     * @param response the response
     * @param request the request
     * @throws Exception             批量导出端口的
     */
    @RequestMapping(value = "/exportSelPortsList", method = RequestMethod.GET)
    public void exportSelPortsList(@RequestParam(value = "ids[]", required = true) Long[] ids,
                                   HttpServletResponse response, HttpServletRequest request)
            throws Exception {
        doExpList(request, ids, response, "端口", "resourcePortList", Excel2JsonUtil.mapPortexp);
    }

    /**
     * *
     * 导出设备报表.
     *
     * @param devices the devices
     * @param response the response
     * @param request the request
     * @throws Exception the exception
     */

    @RequestMapping(value = "/exportDevicesList", method = RequestMethod.GET)
    public void exportDevicesList(ResourceDevices devices, HttpServletResponse response,
                                  HttpServletRequest request) throws Exception {
        //Object object = SessionUtils.getAttribute(request, "userid");
        String[] split = (request.getQueryString().split("&"))[0].split("=");
        devices.setPageSize(split[1]);
        devices.setPageNum("1");
        String fileName = "设备";
        fileName = getBrowerVersion(request, response, fileName);
        String type = "设备";
        String devicesList = devicesList(devices, request, response);
        JSONObject fromObject = JSONObject.fromObject(devicesList);
        ServletOutputStream out = response.getOutputStream();
        if (fromObject != null) {
            JSONArray opt = (JSONArray) fromObject.opt("list");
            if (opt != null) {
                LinkedHashMap<String, String> mapV3exp = Excel2JsonUtil.mapV3exp;
                if (opt.size() > 0) {
                    sysExportServiceImpl.doExport(opt, out, mapV3exp, type);
                }
            }
        }

    }

    /**
     * Export sel devices list.
     *
     * @param ids            设备id
     * @param response the response
     * @param request the request
     * @throws Exception             批量导出设备的
     */
    @RequestMapping(value = "/exportSelDevicesList", method = RequestMethod.GET)
    public void exportSelDevicesList(@RequestParam(value = "ids[]", required = true) Long[] ids,
                                     HttpServletResponse response, HttpServletRequest request)
            throws Exception {
        doExpList(request, ids, response, "设备", "resourceDeviceList", Excel2JsonUtil.mapV3exp);
    }

    /**
     * Do exp list.
     * @param request 
     *
     * @param ids the ids
     * @param response the response
     * @param fileName the file name
     * @param type the type
     * @param map the map
     * @throws UnsupportedEncodingException the unsupported encoding exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws Exception the exception
     */
    private void doExpList(HttpServletRequest request, Long[] ids, HttpServletResponse response,
                           String fileName, String type, LinkedHashMap<String, String> map)
            throws UnsupportedEncodingException, IOException, Exception {
        fileName = getBrowerVersion(request, response, fileName);
        JSONArray opt = new JSONArray();
        ServletOutputStream out = response.getOutputStream();
        if (ids.length > 0) {
            for (int j = 0; j < ids.length; j++) {
                ResourceBean posts = new ResourceBean();
                posts.setId(ids[j]);
                String url = PropertiesUtils.findPropertiesKey("URL", "/resetPwdConfig.properties")
                        + type;
                String invokeGet = HttpHelper.invokeGet(url, BeanToMapUtil.convertBean(posts),
                        PropertiesUtils
                                .findPropertiesKey("ACCPTTYPE", "/resetPwdConfig.properties"));
                JSONObject fromObject = JSONObject.fromObject(invokeGet);
                if (fromObject != null) {
                    JSONArray optSel = (JSONArray) fromObject.opt("list");
                    if (optSel != null) {
                        opt.addAll(optSel);
                    }
                }
            }
        }
        if (opt.size() > 0) {
            sysExportServiceImpl.doExport(opt, out, map, fileName);
        }
    }

    /**
     * @param request
     * @param response
     * @param fileName
     * @return
     * @throws UnsupportedEncodingException
     */
    private String getBrowerVersion(HttpServletRequest request, HttpServletResponse response,
                                    String fileName) throws UnsupportedEncodingException {
        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
            fileName = fileName.replaceAll(" ", "");
            fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器下载
        } else {
            fileName = URLEncoder.encode(fileName, "utf-8");// 谷歌或者其他浏览器的下载
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        return fileName;
    }

}
