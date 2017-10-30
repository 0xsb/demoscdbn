/**
 * 
 */
package com.cmcc.ms.service.system;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import junit.framework.Assert;
import net.sf.json.JSONArray;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.common.utils.Excel2JsonUtil;
import com.cmcc.ms.service.BaseTestCase;

/**
 * @author chenyouchao-yl
 *
 */
public class SysExportServiceTest extends BaseTestCase {

    @Autowired
    private SysExportService sysExportService;

    /**
     * Run the void doExport(JSONArray,OutputStream,LinkedHashMap<String,String>,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void doExportTest() {
        JSONArray list = new JSONArray();
        try {
            LinkedHashMap<String, String> header = Excel2JsonUtil.mapV3exp;
            String type = "导出测试";
            sysExportService.doExport(list, System.out, header, type);
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
        LinkedList<String> sheetsName = new LinkedList<String>();
        sheetsName.add("设备excel测试");
        java.util.List<LinkedList<LinkedHashMap<String, Object>>> list = new ArrayList<LinkedList<LinkedHashMap<String, Object>>>();
        XSSFWorkbook resource = sysExportService.makeExcelForResource(list, sheetsName);
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
        LinkedList<String> timeList = new LinkedList<String>();
        timeList.add("Excel测试");
        java.util.List<LinkedList<LinkedHashMap<String, Object>>> list = new ArrayList<LinkedList<LinkedHashMap<String, Object>>>();
        XSSFWorkbook resource = sysExportService.makeExcelForSuperManager(list, timeList);
        Assert.assertNotNull(resource);
    }
}
