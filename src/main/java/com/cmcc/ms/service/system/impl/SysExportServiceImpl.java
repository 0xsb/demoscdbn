/**
 * @author ldy
 */
package com.cmcc.ms.service.system.impl;

import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.cmcc.ms.common.utils.TimeUtils;
import com.cmcc.ms.service.system.SysExportService;

/**
 * The Class SysExportServiceImpl.
 *
 * @author ldy
 */
@Service
public class SysExportServiceImpl implements SysExportService {

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.service.system.SysExportService#makeExcelForSuperManager(java.util.List, java.util.LinkedList)
     */
    @Override
    public XSSFWorkbook makeExcelForSuperManager(List<LinkedList<LinkedHashMap<String, Object>>> list,
                                                 LinkedList<String> timeList) {

        XSSFWorkbook wb = new XSSFWorkbook();
        // 结果集/sheet数量
        for (int sheetIndex = 0; sheetIndex < list.size(); sheetIndex++) {
            String excelHeaderStr = "";
            String[] excelHeaderArr;
            Sheet sheet = wb.createSheet();
            // 修改代码 传入时间命名sheet
            if (null == timeList || timeList.size() == 0) {
                wb.setSheetName(sheetIndex, "sheet" + String.valueOf(sheetIndex + 1));
            } else {
                wb.setSheetName(sheetIndex,
                        timeList.get(sheetIndex / (list.size() / timeList.size())) + "(第"
                                + (sheetIndex + 1) + "个)");
            }

            Row row = sheet.createRow((int) 0);
            // 设置单元格格式
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            // 指定当单元格内容显示不下时自动换行
            cellStyle.setWrapText(true);
            // 设置单元格字体
            Font font = wb.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setFontName("宋体");
            font.setFontHeight((short) 200);
            cellStyle.setFont(font);

            cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);//前景颜色
            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//填充方式，前色填充

            // 获取每个结果集
            List<LinkedHashMap<String, Object>> recordList = list.get(sheetIndex);

            if (recordList.size() != 0) {
                LinkedHashMap<String, Object> mapForColumn = recordList.get(0);
                Set<String> keySet = mapForColumn.keySet();
                int columnLength = keySet.size();
                int columnIndex = 0;
                for (String key : mapForColumn.keySet()) {
                    columnIndex++;
                    if (columnIndex < columnLength) {
                        excelHeaderStr += key + ",";
                    } else {
                        excelHeaderStr += key;
                    }

                }

                // 表头赋值
                excelHeaderArr = excelHeaderStr.split(",");
                for (int i = 0; i < excelHeaderArr.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(excelHeaderArr[i].trim());
                    cell.setCellStyle(cellStyle);
                    //sheet.autoSizeColumn(i);
                    sheet.setColumnWidth(i, excelHeaderArr[i].trim().getBytes().length * 400);//根据列名字节码长度设置表头单元格长度
                }

                // 单元格内容赋值
                CellStyle cellStyleRow = wb.createCellStyle();
                //cellStyleRow.setWrapText(true);//内容自动换行
                cellStyleRow.setAlignment(HSSFCellStyle.ALIGN_CENTER);//内容居中
                for (int i = 0; i < recordList.size(); i++) {
                    row = sheet.createRow(i + 1);
                    Map<String, Object> map = recordList.get(i);
                    int j = 0;
                    for (Object obj : map.values()) {
                        Cell createCell = row.createCell(j);
                        createCell.setCellStyle(cellStyleRow);
                        if (obj == null) {
                            createCell.setCellValue("");
                        } else {
                            if (obj instanceof Date) {
                                createCell.setCellValue(TimeUtils.getExportFormatTimetamp(obj));// 设定格式，否则秒后面多个0
                            } else if (obj instanceof Boolean) {
                                createCell.setCellValue((Boolean) obj ? 1 : 0);//
                            } else {
                                createCell.setCellValue(obj.toString());
                            }
                        }
                        j++;
                    }

                }
            }
        }
        return wb;
    }

    //用于资源下载    
    @Override
    public XSSFWorkbook makeExcelForResource(List<LinkedList<LinkedHashMap<String, Object>>> list,
                                             LinkedList<String> sheetsName) {
        XSSFWorkbook wb = new XSSFWorkbook();
        //        CreationHelper helper = wb.getCreationHelper();
        //        ClientAnchor anchor = helper.createClientAnchor();
        // 结果集/sheet数量
        for (int sheetIndex = 0; sheetIndex < list.size(); sheetIndex++) {
            String excelHeaderStr = "";
            String[] excelHeaderArr;
            Sheet sheet = wb.createSheet();
            //            sheet.autoSizeColumn((short)11);//调整12列 图片列
            //            Drawing drawing = sheet.createDrawingPatriarch();
            // 修改代码 传入时间命名sheet
            if (null == sheetsName || sheetsName.size() == 0) {
                wb.setSheetName(sheetIndex, "sheet" + String.valueOf(sheetIndex + 1));
            } else {
                wb.setSheetName(sheetIndex, sheetsName.get(sheetIndex));
            }

            Row row = sheet.createRow((int) 0);
            // 设置单元格格式
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            // 指定当单元格内容显示不下时自动换行
            cellStyle.setWrapText(true);
            // 设置单元格字体
            Font font = wb.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setFontName("宋体");
            font.setFontHeight((short) 200);
            cellStyle.setFont(font);
            cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);//前景颜色
            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//填充方式，前色填充

            // 获取每个结果集
            List<LinkedHashMap<String, Object>> recordList = list.get(sheetIndex);

            if (recordList.size() != 0) {
                LinkedHashMap<String, Object> mapForColumn = recordList.get(0);
                Set<String> keySet = mapForColumn.keySet();
                int columnLength = keySet.size();
                int columnIndex = 0;
                for (String key : mapForColumn.keySet()) {
                    columnIndex++;
                    if (columnIndex < columnLength) {
                        excelHeaderStr += key + ",";
                    } else {
                        excelHeaderStr += key;
                    }

                }

                // 表头赋值
                excelHeaderArr = excelHeaderStr.split(",");
                for (int i = 0; i < excelHeaderArr.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(excelHeaderArr[i].trim());
                    cell.setCellStyle(cellStyle);
                    //sheet.autoSizeColumn(i);
                    sheet.setColumnWidth(i, excelHeaderArr[i].trim().getBytes().length * 400);//根据列名字节码长度设置表头单元格长度
                }

                // 单元格内容赋值
                CellStyle cellStyleRow = wb.createCellStyle();
                //cellStyleRow.setWrapText(true);//内容自动换行
                cellStyleRow.setAlignment(HSSFCellStyle.ALIGN_CENTER);//内容居中
                for (int i = 0; i < recordList.size(); i++) {
                    row = sheet.createRow(i + 1);
                    Map<String, Object> map = recordList.get(i);
                    int j = 0;
                    for (Object obj : map.values()) {
                        Cell createCell = row.createCell(j);
                        createCell.setCellStyle(cellStyleRow);
                        if (obj == null) {
                            createCell.setCellValue("");
                        } else {
                            if (obj instanceof Date) {
                                createCell.setCellValue(TimeUtils.getExportFormatTimetamp(obj));// 设定格式，否则秒后面多个0
                            } else if (obj instanceof Boolean) {
                                createCell.setCellValue((Boolean) obj ? 1 : 0);
                            } else {
                                createCell.setCellValue(obj.toString());
                            }
                            /*else if ("jpeg".equalsIgnoreCase(
                                    FDFSUtil.getExtensionName(String.valueOf(obj)))
                                    || "jpg".equalsIgnoreCase(
                                            FDFSUtil.getExtensionName(String.valueOf(obj)))
                                    || "png".equalsIgnoreCase(
                                            FDFSUtil.getExtensionName(String.valueOf(obj)))) {
                                //判断是否是图片格式   图片则写入excel
                                //设置为图片
                                //   URL url=this.class.getResource("hello.jpg");
                                //    String url="";
                                byte[] picBytes = FDFSUtil.download(String.valueOf(obj));
                                //                                ExportUtil.insertImage(wb, patriarch, picBytes, i + 1, j, 1);
                                // 图片插入坐标  
                                int pictureIdx = wb.addPicture(picBytes, wb.PICTURE_TYPE_PNG);
                                anchor.setRow1(i + 1);
                                anchor.setCol1(j);
                                // 插入图片  
                                Picture pict = drawing.createPicture(anchor, pictureIdx);
                                pict.resize();
                              
                              }*/
                        }
                        j++;
                    }

                }
            }
        }
        return wb;
    }

    @Override
    public void doExport(JSONArray list, OutputStream out, LinkedHashMap<String, String> header,
                         String type) throws Exception {

        XSSFWorkbook book = new XSSFWorkbook();
        // 创建表格样式,设置表头居中
        XSSFCellStyle style = book.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 创建工作表
        XSSFSheet sheet = book.createSheet(type);

        /*  int headerNumber = header.size();
         for (int i = 0; i < headerNumber; i++) {
           sheet.setColumnWidth(0, 5000);
        }*/

        // 这里设定不同表格宽度 例外情况
        sheet.setColumnWidth(0, 2000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 3800);
        sheet.setColumnWidth(4, 3800);
        sheet.setColumnWidth(5, 3800);
        sheet.setColumnWidth(6, 3800);
        sheet.setColumnWidth(7, 3800);
        sheet.setColumnWidth(8, 2000);
        sheet.setColumnWidth(9, 5000);
        sheet.setColumnWidth(10, 4000);
        sheet.setColumnWidth(11, 3800);
        sheet.setColumnWidth(12, 3800);
        sheet.setColumnWidth(13, 3800);
        sheet.setColumnWidth(14, 3800);
        sheet.setColumnWidth(15, 3800);
        sheet.setColumnWidth(16, 3800);

        // 创建表头,并设置表头的信息
        XSSFRow row = sheet.createRow(0);
        boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            XSSFRow createRow = sheet.createRow(i + 1);
            JSONObject json = (JSONObject) list.get(i);
            int j = 0;
            for (Map.Entry<String, String> entry : header.entrySet()) {
                if (flag) {
                    XSSFCell cell = row.createCell(j);
                    cell.setCellValue(entry.getKey());
                    cell.setCellStyle(style);
                } else {
                    if ("status".equals(entry.getValue())) {
                        String str = "";
                        if ("1".equals(json.opt(entry.getValue()).toString())
                                || "0".equals(json.opt(entry.getValue()).toString())) {
                            str = "导入未采集";
                        } else if ("4".equals(json.opt(entry.getValue()).toString())
                                || "5".equals(json.opt(entry.getValue()).toString())) {
                            str = "已删除";
                        } else {
                            str = "导入已采集";
                        }
                        createRow.createCell(j).setCellValue(str);
                    } else if ("snmpVersion".equals(entry.getValue())) {
                        String str = "";
                        if ("1".equals(json.opt(entry.getValue()).toString())) {
                            str = "v1";
                        } else if ("2".equals(json.opt(entry.getValue()).toString())) {
                            str = "v2c";
                        } else {
                            str = "v3";
                        }
                        createRow.createCell(j).setCellValue(str);
                    } else {

                        createRow.createCell(j).setCellValue(
                                "null".equals(json.opt(entry.getValue()) + "") ? "" : json
                                        .opt(entry.getValue()) + "");
                    }
                }
                j++;
            }
            if (flag) {
                i--;
                flag = false;
            }
        }
        book.write(out);
        book.close();
    }

}
