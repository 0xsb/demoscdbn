/*
 * Project: demoms
 * 
 * File Created at 2017年6月29日
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cmcc.ms.common.utils.JSONUtils;
import com.cmcc.ms.common.utils.POIExcelUtil;
import com.cmcc.ms.common.utils.PropertiesUtils;
import com.cmcc.ms.entity.datashow.BusinessTraffic;
import com.cmcc.ms.entity.datashow.CpLogo;
import com.cmcc.ms.entity.datashow.IdcDay;
import com.cmcc.ms.entity.datashow.IdcWeek;
import com.cmcc.ms.entity.datashow.MapData;
import com.cmcc.ms.entity.datashow.OverallAnalysis;
import com.cmcc.ms.entity.datashow.ProvinceCacheDay;
import com.cmcc.ms.entity.datashow.ProvinceCacheWeek;
import com.cmcc.ms.entity.datashow.ProvinceOttDay;
import com.cmcc.ms.entity.datashow.ProvinceOttWeek;
import com.cmcc.ms.entity.datashow.UnifiedCacheDay;
import com.cmcc.ms.entity.datashow.UnifiedCacheWeek;
import com.cmcc.ms.entity.datashow.UnifiedCdnDay;
import com.cmcc.ms.entity.datashow.UnifiedCdnWeek;
import com.cmcc.ms.exception.ExcelException;
import com.cmcc.ms.redis.RedisClientTemplate;
import com.cmcc.ms.service.datashow.BusinessTrafficService;
import com.cmcc.ms.service.datashow.CPLogoService;
import com.cmcc.ms.service.datashow.MapDataService;
import com.cmcc.ms.service.datashow.OverallAnalysisService;
import com.cmcc.ms.service.datashow.ServiceDayDataService;
import com.cmcc.ms.service.datashow.ServiceWeekDataService;
import com.cmcc.ms.service.datashow.ShowDataService;

// TODO: Auto-generated Javadoc
/**
 * 数据汇总controller.
 *
 * @author bobo
 * @version 
 * @Type ExcelConrtoller.java
 * @Desc 
 * @date 2017年6月29日 上午10:27:18
 */
@Controller
@RequestMapping("/data")
public class ShowDataController extends BaseController {

    /** The log. */
    private transient Logger log = LoggerFactory.getLogger(this.getClass());

    /** The show data service. */
    @Autowired
    private ShowDataService showDataService;

    /** The overall analysis service. */
    @Autowired
    private OverallAnalysisService overallAnalysisService;

    /** The business traffic service. */
    @Autowired
    private BusinessTrafficService businessTrafficService;

    /** The service day data service. */
    @Autowired
    private ServiceDayDataService serviceDayDataService;

    /** The service week data service. */
    @Autowired
    private ServiceWeekDataService serviceWeekDataService;

    /** The map data service. */
    @Autowired
    private MapDataService mapDataService;
    
    /** The jedis. */
    @Autowired
    private RedisClientTemplate jedis;
    
    /** The cp logo service. */
    @Autowired
    private CPLogoService cpLogoService;

    //    @Autowired
    //    private EverytimeGprsService everytimeService;

    /** The path. */
    String path = "C:\\Users\\bobo\\Documents\\csdn\\time.xlsx";

    /**
     * 返回日报数据.
     *
     * @return the map
     */
    @RequestMapping("showdaydata")
    @ResponseBody
    public Map<String, Object> showDayData() {
        Date createtime = serviceDayDataService.selectMaxCreatetime();
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<UnifiedCdnDay> cdnList = serviceDayDataService.findNewCDNList(createtime);
        map.put("CDN", cdnList);
        List<IdcDay> idcList = serviceDayDataService.findNewIDCiList(createtime);
        map.put("IDC", idcList);
        List<ProvinceOttDay> ottList = serviceDayDataService.findNewOTTList(createtime);
        map.put("POTT", ottList);
        List<ProvinceCacheDay> provinceCacheList = serviceDayDataService
                .findNewProvinceCacheList(createtime);
        map.put("PCache", provinceCacheList);
        List<UnifiedCacheDay> unfiedCacheList = serviceDayDataService
                .findNewUnfiedCacheList(createtime);
        map.put("Cache", unfiedCacheList);
        return map;
    }

    /**
     * 返回地图数据.
     *
     * @return the map
     */
    @RequestMapping("showmapdata")
    @ResponseBody
    public Map<String, Object> showMapData() {
        Date createtime = mapDataService.selectMaxCreatetime();
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<MapData> list = mapDataService.findMapDataByTime(createtime);
        map.put("mapData", list);
        String updateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createtime);
        map.put("updateTime", updateTime);
        return map;
    }

    //    /**
    //     * 返回分时数据
    //     * @return
    //     */
    //    @RequestMapping("showeverytime")
    //    @ResponseBody
    //    public Map<String,Object> showEverytime(){
    //        HashMap<String, Object> map = new HashMap<String, Object>();
    //        List<EverytimeGprs> list = everytimeService.selectAll();
    //        map.put("yesterday", list);
    //        map.put("today", list);
    //        return map;
    //    }

    /**
     * 返回周报数据.
     *
     * @return the map
     */
    @RequestMapping("showweekdata")
    @ResponseBody
    public Map<String, Object> showWeekData() {
        Date createtime = serviceWeekDataService.selectMaxCreatetime();
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<UnifiedCdnWeek> cdnList = serviceWeekDataService.findNewCDNList(createtime);
        map.put("CDN", cdnList);
        List<IdcWeek> idcList = serviceWeekDataService.findNewIDCiList(createtime);
        map.put("IDC", idcList);
        List<ProvinceOttWeek> ottList = serviceWeekDataService.findNewOTTList(createtime);
        map.put("POTT", ottList);
        List<ProvinceCacheWeek> provinceCacheList = serviceWeekDataService
                .findNewProvinceCacheList(createtime);
        map.put("PCache", provinceCacheList);
        List<UnifiedCacheWeek> unfiedCacheList = serviceWeekDataService
                .findNewUnfiedCacheList(createtime);
        map.put("Cache", unfiedCacheList);
        long time = createtime.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endtime = format.format(createtime);
        createtime.setTime(time - 7 * 60 * 60 * 24 * 1000);
        String begintime = format.format(createtime);
        map.put("endtime", endtime);
        map.put("begintime", begintime);
        return map;
    }

    /**
     * 导入日报数据.
     */
    @RequestMapping("importshowdaydata")
    public void importShowDayData() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("省份", "province");
        map.put("入-平均值", "trafficin");
        map.put("出-平均值", "trafficout");
        try {
            File file = new File(path);
            List<UnifiedCdnDay> unifiedCdnDayList = POIExcelUtil.excelToList(file, "统建CDN（日）",
                    UnifiedCdnDay.class, map);
            List<IdcDay> idcDayList = POIExcelUtil.excelToList(file, "IDC（日）", IdcDay.class, map);
            List<UnifiedCacheDay> unifiedCacheDayList = POIExcelUtil.excelToList(file,
                    "统建Cache（日）", UnifiedCacheDay.class, map);
            List<ProvinceCacheDay> provinceCacheDayList = POIExcelUtil.excelToList(file,
                    "省建Cache（日）", ProvinceCacheDay.class, map);
            List<ProvinceOttDay> provinceOttDayList = POIExcelUtil.excelToList(file, "省建OTT（日）",
                    ProvinceOttDay.class, map);
            serviceDayDataService.addCDNList(unifiedCdnDayList);
            serviceDayDataService.addIDCiList(idcDayList);
            serviceDayDataService.addOTTList(provinceOttDayList);
            serviceDayDataService.addProvinceCacheList(provinceCacheDayList);
            serviceDayDataService.addUnfiedCacheList(unifiedCacheDayList);
        } catch (ExcelException e) {
            e.printStackTrace();
            log.info("数据导入失败");
        }
    }

    /**
     * 导入地图柱状图数据.
     */
    @RequestMapping("importmapdata")
    public void importMapData() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("省份", "province");
        map.put("统建CDN", "uCdn");
        map.put("IDC", "idc");
        map.put("统建Cache", "uCache");
        map.put("省建Cache", "pCache");
        map.put("省建OTT", "pOtt");
        try {
            File file = new File(path);
            List<MapData> list = POIExcelUtil.excelToList(file, "地图数据", MapData.class, map);
            mapDataService.addMapDataiList(list);
        } catch (ExcelException e) {
            e.printStackTrace();
            log.info("数据导入失败");
        }
    }

    //    /**
    //     * 导入分时数据
    //     */
    //    @RequestMapping("imporeverytime")
    //    public void importEverytimeGprs(){
    //        LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
    //        map.put("时间", "time");
    //        map.put("腾讯", "tenxun");
    //        map.put("爱奇艺", "aiqiy");
    //        map.put("阿里巴巴", "alibaba");
    //        map.put("优酷土豆网", "youkutudou");
    //        map.put("百度", "baidu");
    //        map.put("乐视", "leshi");
    //        map.put("芒果TV", "mangguo");
    //        map.put("搜狐", "shouhu");
    //        map.put("新浪", "xinlang");
    //        map.put("金山网络", "jinshan");
    //        try {   
    //            File file = new File(path);
    //            List<EverytimeGprs> list = POIExcelUtil.excelToListTime(file, "sheet1", EverytimeGprs.class, map);
    //            everytimeService.insertEverytimeList(list);
    //        } catch (ExcelException e) {
    //            e.printStackTrace();
    //            log.info("分时数据导入失败");
    //        }
    //    }

    /**
     * 导入周报数据.
     */
    @RequestMapping("importshowweekdata")
    public void importShowWeekData() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("省份", "province");
        map.put("入-平均值", "trafficin");
        map.put("出-平均值", "trafficout");
        try {
            File file = new File(path);
            List<UnifiedCdnWeek> unifiedCdnWeekList = POIExcelUtil.excelToList(file, "统建CDN（周）",
                    UnifiedCdnWeek.class, map);
            List<IdcWeek> idcWeekList = POIExcelUtil
                    .excelToList(file, "IDC（周）", IdcWeek.class, map);
            List<UnifiedCacheWeek> unifiedCacheWeekList = POIExcelUtil.excelToList(file,
                    "统建Cache（周）", UnifiedCacheWeek.class, map);
            List<ProvinceCacheWeek> provinceCacheWeekList = POIExcelUtil.excelToList(file,
                    "省建Cache（周）", ProvinceCacheWeek.class, map);
            List<ProvinceOttWeek> provinceOttWeekList = POIExcelUtil.excelToList(file, "省建OTT（周）",
                    ProvinceOttWeek.class, map);
            serviceWeekDataService.addCDNList(unifiedCdnWeekList);
            serviceWeekDataService.addIDCiList(idcWeekList);
            serviceWeekDataService.addOTTList(provinceOttWeekList);
            serviceWeekDataService.addProvinceCacheList(provinceCacheWeekList);
            serviceWeekDataService.addUnfiedCacheList(unifiedCacheWeekList);
        } catch (ExcelException e) {
            e.printStackTrace();
            log.info("周报数据导入失败");
        }
    }

    /**
     * 导入excel并处理数据.
     *
     * @param request the request
     * @param file the file
     */
    @RequestMapping(value = "/imoprtExcel", method = RequestMethod.GET)
    public void importExcel(HttpServletRequest request, MultipartFile file) {
        //保存国际公司整体分析的数据
        List<OverallAnalysis> overallAnalysisList = showDataService.getOverallAnalysisList();
        overallAnalysisService.insertOverAnalysisList(overallAnalysisList);
        //国际公司个业务流量分析
        List<BusinessTraffic> list1 = showDataService.getBusinessTrafficList("付费穿透");
        businessTrafficService.insertBusinessTrafficList(list1);
        List<BusinessTraffic> list2 = showDataService.getBusinessTrafficList("付费对等直连");
        businessTrafficService.insertBusinessTrafficList(list2);
        List<BusinessTraffic> list3 = showDataService.getBusinessTrafficList("国际公司客户");
        addOthers(list3, "国际公司客户");
        businessTrafficService.insertBusinessTrafficList(list3);
        List<BusinessTraffic> list4 = showDataService.getBusinessTrafficList("免费对等直连");
        addOthers(list4, "免费对等直连");
        businessTrafficService.insertBusinessTrafficList(list4);
        boolean deleteAll = showDataService.deleteAll();
        if (deleteAll) {
            log.info("basedata删除成功");
        } else {
            log.info("basedata删除失败");
        }
    }

    /**
     * 寻找json文件返回数据.
     *
     * @param req the req
     * @param child the child
     * @param name the name
     * @return the JSON object
     */
    @RequestMapping(value = "showdatajson", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject showWLNRJson(HttpServletRequest req, String child, String name) {
        JSONObject jsonObject = null;
        Date time = Calendar.getInstance().getTime();
        String filename = new SimpleDateFormat("yyyy-MM-dd").format(time);
        Map<String, String> map = getJsonByFile(filename, child, name, req);
        String json = map.get("json");
        try {
            jsonObject = JSONUtils.toJSONObject(json);
        } catch (Exception e) {
            log.error(child + "/" + child + ".json" + "数据有误");
            map = getJsonByFile(lastDate(filename), child, name, req);
            log.error("获取最近可用的数据,数据日期为" + filename);
            jsonObject = JSONUtils.toJSONObject(map.get("json"));
            jsonObject.put("time", map.get("time"));
            return jsonObject;
        }
        if ("ysdt".equals(name)) {
            JSONArray array = changeYSDT(JSONUtils.toJSONArray(jsonObject.get("ysdt")));
            jsonObject.put("ysdt", array);
        }
        //        if ("ssllfx".equals(name)) {
        //            jsonObject = changeSSLLFX(jsonObject, map.get("time"), req);
        //        }
        if ("fsll".equals(name)) {
            jsonObject = changeFSLL(jsonObject, map.get("time"), req);
        }
        if ("lldt".equals(name)) {
            jsonObject = changeLLDT(jsonObject, map.get("time"), req);
        }
        if ("llys".equals(name)) {
            JSONArray array = addDefaultProvince(JSONUtils.toJSONArray(jsonObject.get("llys")));
            array = changeLLYS(req,array);
            jsonObject.put("llys", array);
        }
        jsonObject.put("time", getUpdateTime());
        return jsonObject;
    }
    
    /**
     * Gets the name and logo url.
     *
     * @param req the req
     * @param child the child
     * @param name the name
     * @return the name and logo url
     */
    @RequestMapping("getNameAndUrl")
    @ResponseBody
    public JSONArray getgetNameAndUrl(HttpServletRequest req, String child, String name){
        JSONObject jsonObject = showWLNRJson(req, child, name);
        Object object = jsonObject.get(name);
        JSONObject tempJson = JSONObject.fromObject(object);
        @SuppressWarnings("unchecked")
        Set<String> keySet = tempJson.keySet();
        List<CpLogo> list = cpLogoService.selectAll();
        JSONArray nameAndUrl = new JSONArray();
        for (String string : keySet) {
            for (CpLogo cpLogo : list) {
                if (cpLogo.getNamestr().equals(string)) {
                  Object tempObj = tempJson.get(string);
                  JSONObject nameAndUrlObj = JSONObject.fromObject(tempObj);
                  nameAndUrlObj.put("chinese", cpLogo.getCpChinese());
                  nameAndUrlObj.put("name", cpLogo.getNamestr());
                  String logoUrl = cpLogo.getLogoUrl();
                  nameAndUrlObj.put("url", "".equals(logoUrl)||null==logoUrl?"NULL":logoUrl);
                  nameAndUrl.add(nameAndUrlObj);
                }
            }
        }
        return nameAndUrl;
    }
    
    /**
     * Change LLYS.
     *
     * @param req the req
     * @param llysJsonArr the llys json arr
     * @return the JSON array
     */
    @SuppressWarnings("unchecked")
    private JSONArray changeLLYS(HttpServletRequest req,JSONArray llysJsonArr){
        JSONObject ssandfzJsonObj = showWLNRJson(req,"map9","ssandfz");
        Object object = ssandfzJsonObj.get("ssandfz");
        Set<String> keySet = JSONObject.fromObject(object).keySet();
        List<CpLogo> list = cpLogoService.selectAll();
        ArrayList<String> cplist = new ArrayList<String>();
        for (String cpStr : keySet) {
            for (CpLogo cpLogo : list) {
                if (cpLogo.getNamestr().equals(cpStr)) {
                    cplist.add(cpLogo.getCpChinese());
                }
            }
        }
        JSONArray okJSONArr = new JSONArray();
        for (String string : cplist) {
            for (Object tempObj : llysJsonArr) {
                JSONObject fromObject = JSONObject.fromObject(tempObj);
                if (fromObject.get("name").equals(string)) {
                    okJSONArr.add(fromObject);
                }
            }
        }
        return okJSONArr;
    }
    
    
    /**
     * addDefaultProvince.
     *
     * @param jsonArray the json array
     * @return the JSON array
     */
    @SuppressWarnings("unchecked")
    private JSONArray addDefaultProvince(JSONArray jsonArray){
        JSONArray modelArray = new JSONArray();
        String temp = PropertiesUtils.findPropertiesKey("defaultProvinceJsonArray",
                "/jsonModel.properties");
        Iterator<Object> jsonit = jsonArray.iterator();
        while (jsonit.hasNext()) {
            JSONArray tempArray = JSONUtils.toJSONArray(temp);
            JSONObject json = (JSONObject) jsonit.next();
            Iterator<Object> tempit = tempArray.iterator();
            if (!json.containsKey("value")) {
                json.put("value", tempArray);
                continue;
            }
            JSONArray array = JSONUtils.toJSONArray(json.get("value"));
            while (tempit.hasNext()) {
                JSONObject ob = (JSONObject) tempit.next();
                String tempName = (String) ob.get("name");
                Iterator<Object> iterator = array.iterator();
                while (iterator.hasNext()) {
                    JSONObject province = (JSONObject) iterator.next();
                    String name = (String) province.get("name");
                    if (name.trim().equals(tempName.trim())) {
                        ob.put("value", province.get("value"));
                        break;
                    }
                }
            }
            json.put("value", tempArray);
            modelArray.add(json);
        }
        return modelArray;
    }

    /**
     * 添加others的BusinessTraffic对象.
     *
     * @param list the list
     * @param busBig the bus big
     * @return the list
     */
    private List<BusinessTraffic> addOthers(List<BusinessTraffic> list, String busBig) {
        Double sumTrafficin = showDataService.selectSumTrafficin(busBig);
        Double tenSum = 0d;
        for (BusinessTraffic businessTraffic : list) {
            tenSum += businessTraffic.getTrafficin();
        }
        double otherSum = sumTrafficin - tenSum;
        BusinessTraffic businessTraffic = new BusinessTraffic();
        businessTraffic.setName("others");
        businessTraffic.setTrafficin(otherSum);
        businessTraffic.setCreatetime(list.get(0).getCreatetime());
        businessTraffic.setBusiness(busBig);
        list.add(businessTraffic);
        return list;
    }

    /**
     * 读取项目下的json文件数据.
     *
     * @param filename the filename
     * @param child the child
     * @param name the name
     * @param req the req
     * @return the json by file
     */
    private Map<String, String> getJsonByFile(String filename, String child, String name,
                                              HttpServletRequest req) {
        String prefix = PropertiesUtils
                .findPropertiesKey("DataJSON.url", "/DataJSONUrl.properties");
        String path = prefix + filename + "/" + child + "/" + name + ".json";
        if ("DataJSON/".equals(prefix)) {
            path = req.getServletContext().getRealPath(path);
        }
        String json = "";
        try {
            File file = new File(path);
            int n = 0;
            while (!file.exists()) {
                n++;
                filename = lastDate(filename);
                path = prefix + filename + "/" + child + "/" + name + ".json";
                if ("DataJSON/".equals(prefix)) {
                    path = req.getServletContext().getRealPath(path);
                }
                file = new File(path);
                if (n > 100) {
                    log.error(filename + "日" + child + name + "数据没有找到");
                    break;
                }
            }
            log.info("输出" + filename + "日" + child + "下的" + name + "的数据");
            //            FileInputStream in = new FileInputStream(file);
            // size  为字串的长度 ，这里一次性读完
            //            int size = in.available();
            //            byte[] buffer = new byte[size];
            //            in.read(buffer);
            //            json = new String(buffer, "utf-8");
            //            in.close();
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
            BufferedReader reader = new BufferedReader(isr);
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {
                // 显示行号  
                json += tempString;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.info("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("json", json);
        map.put("time", filename);
        return map;
    }

    /**
     * 日期回退一天.
     *
     * @param filename the filename
     * @return the string
     */
    private String lastDate(String filename) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            calendar.setTime(format.parse(filename));
            calendar.add(Calendar.DATE, -1);
            Date date = calendar.getTime();
            filename = format.format(date);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return filename;
    }

    /**
     * 往拥塞地图里面添加默认值为0的省份.
     *
     * @param jsonArray the json array
     * @return the JSON array
     */
    @SuppressWarnings("unchecked")
    private JSONArray changeYSDT(JSONArray jsonArray) {
        String lldtCPName = PropertiesUtils.findPropertiesKey("lldtCPName", "/jsonModel.properties");
        JSONArray cpName = JSONUtils.toJSONArray(lldtCPName);
        JSONArray modelArray = new JSONArray();
        String temp = PropertiesUtils.findPropertiesKey("defaultProvinceJsonArray",
                "/jsonModel.properties");
        JSONArray tempArray1 = JSONUtils.toJSONArray(temp);
        boolean flag = true;
        for (int i = 0; i < cpName.size(); i++) {
            for (int j = 0; j < jsonArray.size(); j++) {
                JSONObject tempObj = JSONUtils.toJSONObject(jsonArray.get(j));
                if (tempObj.get("name").toString().trim().equals(cpName.get(i))) {
                    modelArray.add(tempObj);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                JSONObject obj = new JSONObject();
                obj.put("name", cpName.get(i));
                obj.put("value", tempArray1);
                modelArray.add(obj);
            }
            flag = true;
        }
        Iterator<Object> jsonit = modelArray.iterator();
        while (jsonit.hasNext()) {
            JSONArray tempArray = JSONUtils.toJSONArray(temp);
            JSONObject json = (JSONObject) jsonit.next();
            Iterator<Object> tempit = tempArray.iterator();
            if (!json.containsKey("value")) {
                json.put("value", tempArray);
                continue;
            }
            JSONArray array = JSONUtils.toJSONArray(json.get("value"));
            while (tempit.hasNext()) {
                JSONObject ob = (JSONObject) tempit.next();
                String tempName = (String) ob.get("name");
                Iterator<Object> iterator = array.iterator();
                while (iterator.hasNext()) {
                    JSONObject province = (JSONObject) iterator.next();
                    String name = (String) province.get("name");
                    if (name.trim().equals(tempName.trim())) {
                        ob.put("value", province.get("value"));
                        break;
                    }
                }
            }
            json.put("value", tempArray);
        }
        return modelArray;
    }

    /**
     * 实时流量分析两日数据总和.
     *
     * @param jsonObject the json object
     * @param filename the filename
     * @param req the req
     * @return the JSON object
     */
    /*   private JSONObject changeSSLLFX(JSONObject jsonObject, String filename, HttpServletRequest req) {
           Map<String, String> map = getJsonByFile(lastDate(filename), "gjll", "ssllfx", req);
           String json = map.get("json");
           JSONObject jsonObj = JSONUtils.toJSONObject(json);
           JSONObject yesObj = JSONUtils.toJSONObject(jsonObj.get("ssllfx"));
           JSONObject todayObj = JSONUtils.toJSONObject(jsonObject.get("ssllfx"));
           String temp = PropertiesUtils.findPropertiesKey("ssllfxModel", "/jsonModel.properties");
           JSONArray array = JSONUtils.toJSONArray(temp);
           for (int i = 0; i < 24; i++) {
               yesObj.put("y" + i, yesObj.get(String.valueOf(i)));
               yesObj.remove(String.valueOf(i));
           }
           for (int i = 0; i < 24; i++) {
               if (todayObj.containsKey(String.valueOf(i))) {
                   yesObj.put("t" + i, todayObj.get(String.valueOf(i)));
               } else {
                   yesObj.put("t" + i, array);
               }
           }
           jsonObj.put("ssllfx", yesObj);
           return jsonObj;
       }*/

    /**
     * 分时流量两日数据总和.
     *
     * @param jsonObject the json object
     * @param filename the filename
     * @param req the req
     * @return the JSON object
     */
    private JSONObject changeFSLL(JSONObject jsonObject, String filename, HttpServletRequest req) {
//        Map<String, String> map = getJsonByFile(lastDate(filename), "hlwll", "fsll", req);
//        String json = map.get("json");
//        JSONObject jsonObj = JSONUtils.toJSONObject(json);
//        JSONArray yesArray = JSONUtils.toJSONArray(jsonObj.get("fsll"));
        JSONArray todayArray = JSONUtils.toJSONArray(jsonObject.get("fsll"));
//        String temp = PropertiesUtils.findPropertiesKey("fsllModel", "/jsonModel.properties");
        String arr = PropertiesUtils.findPropertiesKey("fsllCPName", "/jsonModel.properties");
        JSONArray nameArr = JSONUtils.toJSONArray(arr);
        JSONArray allArray = new JSONArray();
        for (int i = 0; i < todayArray.size(); i++) {
            JSONObject tempFS = JSONUtils.toJSONObject(todayArray.get(i));
            for (int j = 0; j < nameArr.size(); j++) {
                String name = (String) nameArr.get(j);
                if (!tempFS.containsKey(name)) {
                    tempFS.put(name, 0);
                }
            }
            allArray.add(tempFS);
        }
//        for (int i = 0; i < todayArray.size(); i++) {
//            JSONObject tempFS = JSONUtils.toJSONObject(todayArray.get(i));
//            tempFS.put("time", "t" + tempFS.get("time"));
//            for (int j = 0; j < nameArr.size(); j++) {
//                if (!tempFS.containsKey(nameArr.get(j))) {
//                    tempFS.put(nameArr.get(j), 0);
//                }
//            }
//            allArray.add(tempFS);
//        }
//        for (int i = todayArray.size(); i < 24; i++) {
//            JSONObject tempObj = JSONUtils.toJSONObject(temp);
//            tempObj.put("time", "t" + i);
//            allArray.add(tempObj);
//        }
        jsonObject.put("fsll", allArray);
        return jsonObject;
    }

    /**
     * 流量地图加入没有的省份和公司.
     *
     * @param jsonObject the json object
     * @param filename the filename
     * @param req the req
     * @return the JSON object
     */
    private JSONObject changeLLDT(JSONObject jsonObject, String filename, HttpServletRequest req) {
        JSONArray lldtArray = JSONUtils.toJSONArray(jsonObject.get("lldt"));
        String lldtModel = PropertiesUtils.findPropertiesKey("lldtModel", "/jsonModel.properties");
        JSONArray modelArray = JSONUtils.toJSONArray(lldtModel);
        for (int i = 0; i < lldtArray.size(); i++) {
            JSONObject lldtObj = JSONUtils.toJSONObject(lldtArray.get(i));
            String lProvince = (String) lldtObj.get("name");
            for (int j = 0; j < modelArray.size(); j++) {
                JSONObject modelObj = JSONUtils.toJSONObject(modelArray.get(j));
                String mProvince = (String) modelObj.get("name");
                if (lProvince.equals(mProvince)) {
                    @SuppressWarnings("unchecked")
                    Set<Map.Entry<String, Object>> entrySet = lldtObj.entrySet();
                    for (Entry<String, Object> entry : entrySet) {
                        modelObj.put(entry.getKey(), entry.getValue());
                    }
                    modelArray.set(j, modelObj);
                }
            }
        }
        jsonObject.put("lldt", modelArray);
        return jsonObject;
    }
    
//    /**
//     * 流量地图加入没有的省份和公司(动态优化版).
//     *
//     * @param jsonObject the json object
//     * @param filename the filename
//     * @param req the req
//     * @return the JSON object
//     */
//    private JSONObject changeLLDT(JSONObject jsonObject, String filename, HttpServletRequest req) {
//        JSONArray lldtArray = JSONUtils.toJSONArray(jsonObject.get("lldt"));
//        String lldtProvinceModel = PropertiesUtils.findPropertiesKey("lldtProvinceModel", "/jsonModel.properties");
//        JSONArray modelArray = JSONUtils.toJSONArray(lldtProvinceModel);
//        JSONObject maxObj = new JSONObject();
//        for (int i = 1; i < lldtArray.size(); i++) {   
//            JSONObject lldtObj = JSONUtils.toJSONObject(lldtArray.get(i));
//            @SuppressWarnings("unchecked")
//            Set<Map.Entry<String, Object>> entrySet =lldtObj.entrySet();
//            for (Entry<String, Object> entry : entrySet) {
//                if (!maxObj.containsKey(entry.getKey())) {
//                    maxObj.put(entry.getKey(), 0);
//                }
//            }
//        }
//        maxObj.remove("name");
//        JSONArray jsonArray = new JSONArray();
//        for (int i = 0; i < modelArray.size(); i++) {
//            JSONObject modelObj = JSONUtils.toJSONObject(modelArray.get(i));
//            @SuppressWarnings("unchecked")
//            Set<Map.Entry<String, Object>> entrySet = maxObj.entrySet();
//            for (Entry<String, Object> entry : entrySet) {
//                modelObj.put(entry.getKey(), 0);
//            }
//            jsonArray.add(modelObj);
//        }
//        JSONArray tempArray = new JSONArray();
//        for (int i = 0; i < lldtArray.size(); i++) {
//            JSONObject lldtObj = JSONUtils.toJSONObject(lldtArray.get(i));
//            String lProvince = (String) lldtObj.get("name");
//            for (int j = 0; j < jsonArray.size(); j++) {
//                JSONObject modelObj = JSONUtils.toJSONObject(jsonArray.get(j));
//                String mProvince = (String) modelObj.get("name");
//                if (lProvince.equals(mProvince)) {
//                    @SuppressWarnings("unchecked")
//                    Set<Map.Entry<String, Object>> entrySet = lldtObj.entrySet();
//                    for (Entry<String, Object> entry : entrySet) {
//                        modelObj.put(entry.getKey(), entry.getValue());
//                    }
//                    tempArray.add(modelObj);
//                }
//            }
//        }
//        jsonObject.put("lldt", tempArray);
//        return jsonObject;
//    }

    /**
     * Gets the update time.
     *
     * @return the update time
     */
    private static String getUpdateTime() {
        //        Date nowTime = new Date();
        //        long chaTime = nowTime.getTime()-time.getTime();
        //        if (chaTime/1000>60*5) {
        //            int cha = (int) (chaTime/(1000*60));
        //            Long ltime = time.getTime()+Long.valueOf(cha*(1000*5));
        //            time.setTime(ltime);
        //        }
        //        return time;
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());

        int i;
        if (Integer.parseInt(time.substring(time.length() - 1)) >= 5) {
            i = 5;
        } else {
            i = 0;
        }
        time = time.substring(0, time.length() - 1);
        time = time + i;
        return time;

    }

   /**
    * Test json.
    *
    * @return the JSON object
    */
    @RequestMapping("/test")
    @ResponseBody
    public JSONObject testJson(){
        JSONObject testJson = null;
        String string = jedis.get("testJson");
        String numStr = jedis.get("num");
        if (null == numStr ||"".equals(numStr)) {
            numStr = "0";
        }
        int num = Integer.parseInt(numStr);
        if (null==string) {
            testJson = new JSONObject();
        }else{
            testJson = JSONUtils.toJSONObject(string);
        }
        JSONObject jsonData = (JSONObject) testJson.get("ssllfx");
        if (null==jsonData) {
            jsonData = new JSONObject();
        }
        String testModel = PropertiesUtils.findPropertiesKey("testModel", "/jsonModel.properties");
        String xzhouModel = PropertiesUtils.findPropertiesKey("xzhouModel", "/jsonModel.properties");
        JSONArray xzhou = JSONUtils.toJSONArray(xzhouModel);
        JSONArray jsonArray = JSONUtils.toJSONArray(testModel);
        JSONArray data = new JSONArray();
        for (Object object : jsonArray)     {
            JSONObject obj = JSONUtils.toJSONObject(object);                                                   
            obj.put("trafficins", new Random().nextInt(500));
            data.add(obj);
        }
        if (num == 280) {
            num = 0;
            jsonData = new JSONObject();
        }
        String key = xzhou.getString(num);
        jsonData.put(key, data);
        num ++;
        testJson.put("ssllfx", jsonData);
        testJson.put("xzhou", xzhou);
        jedis.set("testJson", testJson.toString());
        jedis.set("num", num+"");
        return testJson;
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年6月29日 bobo creat
 */
