package com.cmcc.ms.service.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.common.utils.Excel2JsonUtil;
import com.cmcc.ms.service.BaseTestCase;

/**
 * @author chenyouchao-yl
 */
public class SysExportServiceImplTest extends BaseTestCase {
    @Autowired
    private SysExportServiceImpl sysExportServiceImpl;

    /**
     * Run the void doExport(JSONArray,OutputStream,LinkedHashMap<String,String>,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void doExportTest() throws Exception{
        JSONArray list = new JSONArray();
        JSONObject json1 = new JSONObject();
        json1.put("test", "null");
        json1.put("status", "1");
        json1.put("snmpVersion", "1");
        JSONObject json2 = new JSONObject();
        json2.put("status", "2");
        json2.put("snmpVersion", "2");
        JSONObject json3 = new JSONObject();
        json3.put("status", "3");
        json3.put("snmpVersion", "3");
        JSONObject json4 = new JSONObject();
        json4.put("status", "4");
        JSONObject json5 = new JSONObject();
        json5.put("status", "5");
        list.add(json1);
        list.add(json2);
        list.add(json3);
        list.add(json4);
        list.add(json5);
        try {
            LinkedHashMap<String, String> header = Excel2JsonUtil.mapV3exp;
            String type = "导出测试";
            sysExportServiceImpl.doExport(list, System.out, header, type);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Run the void makeExcelForResource(List<LinkedList<LinkedHashMap<String, Object>>> list,
                                             LinkedList<String> sheetsName) method test.
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void makeExcelForResourceTest() {
        LinkedHashMap<String,Object> linkedHashMap = new LinkedHashMap<String, Object>();
        linkedHashMap.put("excel1", "");
        linkedHashMap.put("excel2", null);
        linkedHashMap.put("excel3", new Date());
        linkedHashMap.put("excel4", true);
        LinkedList<LinkedHashMap<String,Object>> linkedList = new LinkedList<LinkedHashMap<String,Object>>();
        linkedList.add(linkedHashMap);
        LinkedList<String> sheetsName = new LinkedList<String>();
        sheetsName.add("设备excel测试");
        List<LinkedList<LinkedHashMap<String, Object>>> list = new ArrayList<LinkedList<LinkedHashMap<String, Object>>>();
        list.add(linkedList);
        XSSFWorkbook resource = sysExportServiceImpl.makeExcelForResource(list, sheetsName);
        Assert.assertNotNull(resource);
    }

    /**
     * Run the void makeExcelForSuperManager(List<LinkedList<LinkedHashMap<String, Object>>> list,
                                             LinkedList<String> timeList) method test.
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void makeExcelForSuperManagerTest() {
        LinkedHashMap<String,Object> linkedHashMap = new LinkedHashMap<String, Object>();
        linkedHashMap.put("excela", "");
        linkedHashMap.put("excelb", null);
        linkedHashMap.put("exceld", new Date());
        linkedHashMap.put("excele", true);
        LinkedList<LinkedHashMap<String,Object>> linkedList = new LinkedList<LinkedHashMap<String,Object>>();
        linkedList.add(linkedHashMap);
        LinkedList<String> timeList = new LinkedList<String>();
        timeList.add("Excel测试");
        List<LinkedList<LinkedHashMap<String, Object>>> list = new ArrayList<LinkedList<LinkedHashMap<String, Object>>>();
        list.add(linkedList);
        XSSFWorkbook resource = sysExportServiceImpl.makeExcelForSuperManager(list, timeList);
        Assert.assertNotNull(resource);
    }
}
