/**
 * @author ldy
 */
package com.cmcc.ms.service.system;

import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.sf.json.JSONArray;


/**
 * The Interface SysExportService.
 */
public interface SysExportService {

    /**
     * Make excel for super manager.
     *
     * @param list the list
     * @param timeList the time list
     * @return the HSSF workbook
     */
    public XSSFWorkbook makeExcelForSuperManager(List<LinkedList<LinkedHashMap<String, Object>>> list,
                                                 LinkedList<String> timeList);

    /**
     * 资源申请excel 下载.
     *
     * @param list the list
     * @param excelName the excel name
     * @return the XSSF workbook
     */
    public XSSFWorkbook makeExcelForResource(List<LinkedList<LinkedHashMap<String, Object>>> list,
                                             LinkedList<String> excelName);

    /**
     * Do export.
     *
     * @param list the list
     * @param out the out
     * @param header the header
     * @param type the type
     * @throws Exception the exception
     */
    public void doExport(JSONArray list,OutputStream out,LinkedHashMap<String, String> header,String type) throws Exception;
    
}
