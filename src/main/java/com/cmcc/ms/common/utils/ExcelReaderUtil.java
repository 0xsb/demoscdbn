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
package com.cmcc.ms.common.utils;

import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;


/**
 * The Class ExcelReaderUtil.
 *
 * @author huamao
 * @version 
 * @Type ExcelReaderUtil.java
 * @Desc 
 * @date 2016年11月2日 下午4:55:01
 */
public class ExcelReaderUtil {
    /*private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;
    
    *//**
      * 读取Excel表格表头的内容.
      *
      * @param cell the cell
      * @return String 表头内容的数组
      */
    /*
    public String[] readExcelTitle(InputStream is) {
     try {
         fs = new POIFSFileSystem(is);
         wb = new HSSFWorkbook(fs);
     } catch (IOException e) {
         e.printStackTrace();
     }
     sheet = wb.getSheetAt(0);
     row = sheet.getRow(0);
     // 标题总列数
     int colNum = row.getPhysicalNumberOfCells();
     System.out.println("colNum:" + colNum);
     String[] title = new String[colNum];
     for (int i = 0; i < colNum; i++) {
         //title[i] = getStringCellValue(row.getCell((short) i));
         title[i] = getCellFormatValue(row.getCell((short) i));
     }
     return title;
    }
    
    *//**
      * 读取Excel数据内容
      * @param InputStream
      * @return Map 包含单元格数据内容的Map对象
      */
    /*
    public Map<Integer, String> readExcelContent(InputStream is) {
     Map<Integer, String> content = new HashMap<Integer, String>();
     String str = "";
     try {
         fs = new POIFSFileSystem(is);
         wb = new HSSFWorkbook(fs);
     } catch (IOException e) {
         e.printStackTrace();
     }
     sheet = wb.getSheetAt(0);
     // 得到总行数
     int rowNum = sheet.getLastRowNum();
     row = sheet.getRow(0);
     int colNum = row.getPhysicalNumberOfCells();
     // 正文内容应该从第二行开始,第一行为表头的标题
     for (int i = 1; i <= rowNum; i++) {
         row = sheet.getRow(i);
         int j = 0;
         while (j < colNum) {
             // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
             // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
             // str += getStringCellValue(row.getCell((short) j)).trim() +
             // "-";
             str += getCellFormatValue(row.getCell((short) j)).trim() + "    ";
             j++;
         }
         content.put(i, str);
         str = "";
     }
     return content;
    }
    
    *//**
      * 获取单元格数据内容为字符串类型的数据
      * 
      * @param cell Excel单元格
      * @return String 单元格数据内容
      */
    /*
    private String getStringCellValue(HSSFCell cell) {
     String strCell = "";
     switch (cell.getCellType()) {
         case HSSFCell.CELL_TYPE_STRING:
             strCell = cell.getStringCellValue();
             break;
         case HSSFCell.CELL_TYPE_NUMERIC:
             strCell = String.valueOf(cell.getNumericCellValue());
             break;
         case HSSFCell.CELL_TYPE_BOOLEAN:
             strCell = String.valueOf(cell.getBooleanCellValue());
             break;
         case HSSFCell.CELL_TYPE_BLANK:
             strCell = "";
             break;
         default:
             strCell = "";
             break;
     }
     if ("".equals(strCell) || strCell == null) {
         return "";
     }
     if (cell == null) {
         return "";
     }
     return strCell;
    }
    
    *//**
      * 获取单元格数据内容为日期类型的数据
      * 
      * @param cell
      *            Excel单元格
      * @return String 单元格数据内容
      */
    /*
    private String getDateCellValue(HSSFCell cell) {
     String result = "";
     try {
         int cellType = cell.getCellType();
         if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
             Date date = cell.getDateCellValue();
             result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-"
                     + date.getDate();
         } else if (cellType == HSSFCell.CELL_TYPE_STRING) {
             String date = getStringCellValue(cell);
             result = date.replaceAll("[年月]", "-").replace("日", "").trim();
         } else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
             result = "";
         }
     } catch (Exception e) {
         System.out.println("日期格式不正确!");
         e.printStackTrace();
     }
     return result;
    }
    
    *//**
      * 根据HSSFCell类型设置数据
      * @param cell
      * @return
      */
    /*
    public static String getCellFormatValue(HSSFCell cell) {
     String cellvalue = "";
     DecimalFormat df = new DecimalFormat("#");
     if (cell != null) {
         // 判断当前Cell的Type
         switch (cell.getCellType()) {
             // 如果当前Cell的Type为NUMERIC-- 手机号码转字符串
             case HSSFCell.CELL_TYPE_NUMERIC:
                 cellvalue = df.format(cell.getNumericCellValue()).toString();
                 break;
    
             case HSSFCell.CELL_TYPE_FORMULA:
                 break;
             // 如果当前Cell的Type为STRIN
             case HSSFCell.CELL_TYPE_STRING:
                 // 取得当前的Cell字符串
                 cellvalue = cell.getRichStringCellValue().getString();
                 break;
             // 默认的Cell值
             default:
                 cellvalue = " ";
         }
     } else {
         cellvalue = "";
     }
     return cellvalue;
    
    }*/

    /**获取单元格数据
     * 根据HSSFCell类型 设置数据
     * @param cell
     * @return
     */
    public static String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        DecimalFormat df = new DecimalFormat("#");
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC-- 手机号码转字符串
                case HSSFCell.CELL_TYPE_NUMERIC:
                    cellvalue = df.format(cell.getNumericCellValue

                    ()).toString();
                    break;
                case HSSFCell.CELL_TYPE_FORMULA:
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

    /**
     * 
     * @param args
     */
    /*    public static void main(String[] args) {
        try {
            // 对读取Excel表格标题测试
            //            InputStream is = new FileInputStream("d:\\test.xls");
            ExcelReaderUtil excelReader = new ExcelReaderUtil();
            //            String[] title = excelReader.readExcelTitle(is);
            //            System.out.println("获得Excel表格的标题:");
            //            for (String s : title) {
            //                System.out.print(s + " ");
            //            }
    
            // 对读取Excel表格内容测试
            InputStream is2 = new FileInputStream("d:\\test.xls");
            Map<Integer, String> map = excelReader.readExcelContent(is2);
            System.out.println("获得Excel表格的内容:");
            for (int i = 1; i <= map.size(); i++) {
                System.out.println(map.get(i));
            }
    
        } catch (FileNotFoundException e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        }
    }*/
}
