/*
 * Project: test
 * 
 * File Created at 2017年7月4日
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

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;

import com.cmcc.ms.exception.ExcelException;

/**
 * The Class POIExcelUtil.
 *
 * @author bobo
 * @version 
 * @Type POIExcelUtil.java
 * @Desc 
 * @date 2017年7月4日 上午10:20:39
 */
public class POIExcelUtil {

    /** The Constant fieldMap. */
    public static final LinkedHashMap<String, String> FIELDMAP;

    /** The Constant SHEET_NAME. */
    public static final String SHEET_NAME = "基础资源数据_国际";

    static {
        FIELDMAP = new LinkedHashMap<String, String>();
        FIELDMAP.put("省份", "province");
        FIELDMAP.put("设备名称", "devName");
        FIELDMAP.put("设备IP", "devIp");
        FIELDMAP.put("端口名称", "portName");
        FIELDMAP.put("端口类型", "portType");
        FIELDMAP.put("业务大类", "busBig");
        FIELDMAP.put("业务小类", "busSmall");
        FIELDMAP.put("对端设备", "peerDevice");
        FIELDMAP.put("带宽(bps)", "bandwidth");
        FIELDMAP.put("入流量(bps)", "trafficin");
        FIELDMAP.put("出流量(bps)", "trafficout");
    }

    /**
     * List to excel.
     *
     * @param <T> the generic type
     * @param list the list
     * @param fieldMap the field map
     * @param sheetName the sheet name
     * @param out the out
     * @throws ExcelException the excel exception
     */
    @SuppressWarnings("resource")
    public static <T> void listToExcel(List<T> list, LinkedHashMap<String, String> fieldMap,
                                       String sheetName, OutputStream out) throws ExcelException {

        if (list.size() == 0) {
            throw new ExcelException("数据源中没有任何数据");
        }

        //创建工作簿并发送到OutputStream指定的地方  
        XSSFWorkbook wb;
        try {
            wb = new XSSFWorkbook();
            //2.创建相应的工作表，并向其中填充数据  
            XSSFSheet sheet = wb.createSheet(sheetName);
            fillSheet(sheet, list, fieldMap);

            wb.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
            //如果是ExcelException，则直接抛出  
            if (e instanceof ExcelException) {
                throw (ExcelException) e;

                //否则将其它异常包装成ExcelException再抛出  
            } else {
                throw new ExcelException("导出Excel失败");
            }
        }

    }

    /**
     *  
     *
     * @param <T> the generic type
     * @param list      数据源
     * @param fieldMap      类的英文属性和Excel中的中文列名的对应关系
     * @param sheetName the sheet name
     * @param response  使用response可以导出到浏览器
     * @throws ExcelException the excel exception
     * @MethodName  : listToExcel
     * @Description : 导出Excel（导出到浏览器，可以自定义工作表的大小）
     */
    public static <T> void listToExcel(List<T> list, LinkedHashMap<String, String> fieldMap,
                                       String sheetName, HttpServletResponse response)
            throws ExcelException {

        //设置默认文件名为当前时间：年月日时分秒  
        String fileName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()).toString();

        //设置response头信息  
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8"); //改成输出excel文件  
        response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xlsx");

        //创建工作簿并发送到浏览器  
        try {

            OutputStream out = response.getOutputStream();
            listToExcel(list, fieldMap, sheetName, out);

        } catch (Exception e) {
            e.printStackTrace();

            //如果是ExcelException，则直接抛出  
            if (e instanceof ExcelException) {
                throw (ExcelException) e;

                //否则将其它异常包装成ExcelException再抛出  
            } else {
                throw new ExcelException("导出Excel失败");
            }
        }
    }

    /**
     *  
     *
     * @param <T> the generic type
     * @param in                    ：承载着Excel的输入流
     * @param sheetName the sheet name
     * @param entityClass       ：List中对象的类型（Excel中的每一行都要转化为该类型的对象）
     * @param fieldMap          ：Excel中的中文列头和类的英文属性的对应关系Map
     * @return                      ：List
     * @throws ExcelException the excel exception
     * @MethodName          : excelToList
     * @Description             : 将Excel转化为List
     */
    public static <T> List<T> excelToList(InputStream in, String sheetName, Class<T> entityClass,
                                          LinkedHashMap<String, String> fieldMap)
            throws ExcelException {
        //定义要返回的list  
        List<T> resultList = new ArrayList<T>();
        try {

            //根据Excel数据源创建WorkBook  
            Workbook wb = WorkbookFactory.create(in);
            //获取工作表                   
            Sheet sheet = wb.getSheet(sheetName);

            //获取工作表的有效行数  
            int realRows = 0;
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                int nullCols = 0;
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell currentCell = row.getCell(j);
                    if (currentCell == null || "".equals(POIExcelUtil.getValue(currentCell))) {
                        nullCols++;
                    }
                }

                if (nullCols == row.getLastCellNum()) {
                    break;
                } else {
                    realRows++;
                }
            }

            //如果Excel中没有数据则提示错误  
            if (realRows <= 1) {
                throw new ExcelException("Excel文件中没有任何数据");
            }

            Row firstRow = sheet.getRow(0);

            String[] excelFieldNames = new String[firstRow.getLastCellNum()];

            //获取Excel中的列名  
            for (int i = 0; i < firstRow.getLastCellNum(); i++) {
                excelFieldNames[i] = getValue(firstRow.getCell(i));
            }

            //判断需要的字段在Excel中是否都存在  
            boolean isExist = true;
            List<String> excelFieldList = Arrays.asList(excelFieldNames);
            for (String cnName : fieldMap.keySet()) {
                if (!excelFieldList.contains(cnName)) {
                    isExist = false;
                    break;
                }
            }

            //如果有列名不存在，则抛出异常，提示错误  
            if (!isExist) {
                throw new ExcelException("Excel中缺少必要的字段，或字段名称有误");
            }

            //将列名和列号放入Map中,这样通过列名就可以拿到列号  
            LinkedHashMap<String, Integer> colMap = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < excelFieldNames.length; i++) {
                colMap.put(excelFieldNames[i], firstRow.getCell(i).getColumnIndex());
            }

            //将sheet转换为list  
            for (int i = 1; i < realRows; i++) {
                //新建要转换的对象  
                T entity = entityClass.newInstance();

                //给对象中的字段赋值  
                for (Entry<String, String> entry : fieldMap.entrySet()) {
                    //获取中文字段名  
                    String cnNormalName = entry.getKey();
                    //获取英文字段名  
                    String enNormalName = entry.getValue();
                    //根据中文字段名获取列号  
                    int col = colMap.get(cnNormalName);

                    //获取当前单元格中的内容  
                    String content = getValue(sheet.getRow(i).getCell(col));

                    //给对象赋值  
                    setFieldValueByName(enNormalName, content, entity);
                }

                resultList.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //如果是ExcelException，则直接抛出  
            if (e instanceof ExcelException) {
                throw (ExcelException) e;

                //否则将其它异常包装成ExcelException再抛出  
            } else {
                e.printStackTrace();
                throw new ExcelException("导入Excel失败");
            }
        }

        return resultList;

    }

    /**
     * Excel to list.
     *
     * @param <T> the generic type
     * @param file the file
     * @param sheetName the sheet name
     * @param entityClass the entity class
     * @param fieldMap the field map
     * @return the list
     * @throws ExcelException the excel exception
     */
    public static <T> List<T> excelToList(File file, String sheetName, Class<T> entityClass,
                                          LinkedHashMap<String, String> fieldMap)
            throws ExcelException {
        //定义要返回的list  
        List<T> resultList = new ArrayList<T>();
        try {

            //根据Excel数据源创建WorkBook 
            FileInputStream in = new FileInputStream(file);
            Workbook wb = WorkbookFactory.create(in);
            //获取工作表                   
            Sheet sheet = wb.getSheet(sheetName);

            //获取工作表的有效行数  
            int realRows = 0;
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                int nullCols = 0;
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell currentCell = row.getCell(j);
                    if (currentCell == null || "".equals(getValue(currentCell))) {
                        nullCols++;
                    }
                }

                if (nullCols == row.getLastCellNum()) {
                    break;
                } else {
                    realRows++;
                }
            }

            //如果Excel中没有数据则提示错误  
            if (realRows <= 1) {
                throw new ExcelException("Excel文件中没有任何数据");
            }

            Row firstRow = sheet.getRow(0);

            String[] excelFieldNames = new String[firstRow.getLastCellNum()];

            //获取Excel中的列名  
            for (int i = 0; i < firstRow.getLastCellNum(); i++) {
                excelFieldNames[i] = getValue(firstRow.getCell(i));
            }

            //判断需要的字段在Excel中是否都存在  
            boolean isExist = true;
            List<String> excelFieldList = Arrays.asList(excelFieldNames);
            for (String cnName : fieldMap.keySet()) {
                if (!excelFieldList.contains(cnName)) {
                    isExist = false;
                    break;
                }
            }

            //如果有列名不存在，则抛出异常，提示错误  
            if (!isExist) {
                throw new ExcelException("Excel中缺少必要的字段，或字段名称有误");
            }

            //将列名和列号放入Map中,这样通过列名就可以拿到列号  
            LinkedHashMap<String, Integer> colMap = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < excelFieldNames.length; i++) {
                colMap.put(excelFieldNames[i], firstRow.getCell(i).getColumnIndex());
            }

            //将sheet转换为list  
            for (int i = 1; i < realRows; i++) {
                //新建要转换的对象  
                T entity = entityClass.newInstance();

                //给对象中的字段赋值  
                for (Entry<String, String> entry : fieldMap.entrySet()) {
                    //获取中文字段名  
                    String cnNormalName = entry.getKey();
                    //获取英文字段名  
                    String enNormalName = entry.getValue();
                    //根据中文字段名获取列号  
                    int col = colMap.get(cnNormalName);

                    //获取当前单元格中的内容  
                    String content = getValue(sheet.getRow(i).getCell(col));

                    //给对象赋值  
                    setFieldValueByName(enNormalName, content, entity);
                }

                resultList.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //如果是ExcelException，则直接抛出  
            if (e instanceof ExcelException) {
                throw (ExcelException) e;

                //否则将其它异常包装成ExcelException再抛出  
            } else {
                e.printStackTrace();
                throw new ExcelException("导入Excel失败");
            }
        }

        return resultList;

    }

    /**
     * Excel to list time.
     *
     * @param <T> the generic type
     * @param file the file
     * @param sheetName the sheet name
     * @param entityClass the entity class
     * @param fieldMap the field map
     * @return the list
     * @throws ExcelException the excel exception
     */
    public static <T> List<T> excelToListTime(File file, String sheetName, Class<T> entityClass,
                                              LinkedHashMap<String, String> fieldMap)
            throws ExcelException {
        //定义要返回的list  
        List<T> resultList = new ArrayList<T>();
        try {

            //根据Excel数据源创建WorkBook 
            FileInputStream in = new FileInputStream(file);
            Workbook wb = WorkbookFactory.create(in);
            //获取工作表                   
            Sheet sheet = wb.getSheet(sheetName);

            //获取工作表的有效行数  
            int realRows = 0;
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                int nullCols = 0;
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell currentCell = row.getCell(j);
                    if (currentCell == null || "".equals(getValue(currentCell))) {
                        nullCols++;
                    }
                }

                if (nullCols == row.getLastCellNum()) {
                    break;
                } else {
                    realRows++;
                }
            }

            //如果Excel中没有数据则提示错误  
            if (realRows <= 1) {
                throw new ExcelException("Excel文件中没有任何数据");
            }

            Row firstRow = sheet.getRow(0);

            String[] excelFieldNames = new String[firstRow.getLastCellNum()];

            //获取Excel中的列名  
            for (int i = 0; i < firstRow.getLastCellNum(); i++) {
                excelFieldNames[i] = getValue(firstRow.getCell(i));
            }

            //判断需要的字段在Excel中是否都存在  
            boolean isExist = true;
            List<String> excelFieldList = Arrays.asList(excelFieldNames);
            for (String cnName : fieldMap.keySet()) {
                if (!excelFieldList.contains(cnName)) {
                    isExist = false;
                    break;
                }
            }

            //如果有列名不存在，则抛出异常，提示错误  
            if (!isExist) {
                throw new ExcelException("Excel中缺少必要的字段，或字段名称有误");
            }

            //将列名和列号放入Map中,这样通过列名就可以拿到列号  
            LinkedHashMap<String, Integer> colMap = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < excelFieldNames.length; i++) {
                colMap.put(excelFieldNames[i], firstRow.getCell(i).getColumnIndex());
            }

            //将sheet转换为list  
            for (int i = 1; i < realRows; i++) {
                //新建要转换的对象  
                T entity = entityClass.newInstance();

                //给对象中的字段赋值  
                for (Entry<String, String> entry : fieldMap.entrySet()) {
                    //获取中文字段名  
                    String cnNormalName = entry.getKey();
                    //获取英文字段名  
                    String enNormalName = entry.getValue();
                    //根据中文字段名获取列号  
                    int col = colMap.get(cnNormalName);

                    //获取当前单元格中的内容  
                    String content = getValueTime(sheet.getRow(i).getCell(col));

                    //给对象赋值  
                    setFieldValueByName(enNormalName, content, entity);
                }

                resultList.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //如果是ExcelException，则直接抛出  
            if (e instanceof ExcelException) {
                throw (ExcelException) e;

                //否则将其它异常包装成ExcelException再抛出  
            } else {
                e.printStackTrace();
                throw new ExcelException("导入Excel失败");
            }
        }

        return resultList;

    }

    /**
     *  
     *
     * @param fieldName  字段名
     * @param fieldValue    字段值
     * @param o 对象
     * @throws Exception the exception
     * @MethodName  : setFieldValueByName
     * @Description : 根据字段名给对象的字段赋值
     */
    private static void setFieldValueByName(String fieldName, Object fieldValue, Object o)
            throws Exception {

        Field field = getFieldByName(fieldName, o.getClass());
        if (field != null) {
            field.setAccessible(true);
            //获取字段类型  
            Class<?> fieldType = field.getType();

            //根据字段类型给字段赋值  
            if (String.class == fieldType) {
                field.set(o, String.valueOf(fieldValue));
            } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                field.set(o, Integer.parseInt(fieldValue.toString()));
            } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                field.set(o, Long.valueOf(fieldValue.toString()));
            } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                field.set(o, Float.valueOf(fieldValue.toString()));
            } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                field.set(o, Short.valueOf(fieldValue.toString()));
            } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                field.set(o, Double.valueOf(fieldValue.toString()));
            } else if (Character.TYPE == fieldType) {
                if ((fieldValue != null) && (fieldValue.toString().length() > 0)) {
                    field.set(o, Character.valueOf(fieldValue.toString().charAt(0)));
                }
            } else if (Date.class == fieldType) {
                field.set(o,
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fieldValue.toString()));
            } else {
                field.set(o, fieldValue);
            }
        } else {
            throw new ExcelException(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
        }
    }

    /**
     *  
     *
     * @param fieldName 字段名
     * @param clazz 包含该字段的类
     * @return 字段
     * @MethodName  : getFieldByName
     * @Description : 根据字段名获取字段
     */
    private static Field getFieldByName(String fieldName, Class<?> clazz) {
        //拿到本类的所有字段  
        Field[] selfFields = clazz.getDeclaredFields();

        //如果本类中存在该字段，则返回  
        for (Field field : selfFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        //否则，查看父类中是否存在此字段，如果有则返回  
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && superClazz != Object.class) {
            return getFieldByName(fieldName, superClazz);
        }

        //如果本类和父类都没有，则返回空  
        return null;
    }

    /**
     * Gets the value.
     *
     * @param cell the cell
     * @return the value
     */
    //解决excel类型问题，获得数值  
    private static String getValue(Cell cell) {
        String value = "";
        if (null == cell) {
            return value;
        }
        switch (cell.getCellType()) {
        //数值型  
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    //如果是date类型则 ，获取该cell的date值  
                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    value = format.format(date);
                    ;
                } else {// 纯数字  
                    BigDecimal big = new BigDecimal(cell.getNumericCellValue());
                    value = big.toString();
                    //解决1234.0  去掉后面的.0  
                    if (null != value && !"".equals(value.trim())) {
                        String[] item = value.split("[.]");
                        if (1 < item.length && "0".equals(item[1])) {
                            value = item[0];
                        }
                    }
                }
                break;
            //字符串类型   
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue().toString();
                break;
            // 公式类型  
            case Cell.CELL_TYPE_FORMULA:
                //读公式计算值  
                value = String.valueOf(cell.getNumericCellValue());
                if ("NaN".equals(value)) {// 如果获取的数据值为非法值,则转换为获取字符串  
                    value = cell.getStringCellValue().toString();
                }
                break;
            // 布尔类型  
            case Cell.CELL_TYPE_BOOLEAN:
                value = " " + cell.getBooleanCellValue();
                break;
            // 空值  
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            // 故障  
            case Cell.CELL_TYPE_ERROR:
                value = "";
                break;
            default:
                value = cell.getStringCellValue().toString();
        }
        if ("null".endsWith(value.trim())) {
            value = "";
        }
        return value;
    }

    /**
     * Gets the value time.
     *
     * @param cell the cell
     * @return the value time
     */
    //解决excel类型问题，获得数值  
    private static String getValueTime(Cell cell) {
        String value = "";
        if (null == cell) {
            return value;
        }
        switch (cell.getCellType()) {
        //数值型  
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    //如果是date类型则 ，获取该cell的date值  
                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                    value = format.format(date);
                    ;
                } else {// 纯数字  
                    BigDecimal big = new BigDecimal(cell.getNumericCellValue());
                    value = big.toString();
                    //解决1234.0  去掉后面的.0  
                    if (null != value && !"".equals(value.trim())) {
                        String[] item = value.split("[.]");
                        if (1 < item.length && "0".equals(item[1])) {
                            value = item[0];
                        }
                    }
                }
                break;
            //字符串类型   
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue().toString();
                break;
            // 公式类型  
            case Cell.CELL_TYPE_FORMULA:
                //读公式计算值  
                value = String.valueOf(cell.getNumericCellValue());
                if ("NaN".equals(value)) {// 如果获取的数据值为非法值,则转换为获取字符串  
                    value = cell.getStringCellValue().toString();
                }
                break;
            // 布尔类型  
            case Cell.CELL_TYPE_BOOLEAN:
                value = " " + cell.getBooleanCellValue();
                break;
            // 空值  
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            // 故障  
            case Cell.CELL_TYPE_ERROR:
                value = "";
                break;
            default:
                value = cell.getStringCellValue().toString();
        }
        if ("null".endsWith(value.trim())) {
            value = "";
        }
        return value;
    }

    /**
     *  
     *
     * @param <T> the generic type
     * @param sheet     工作表
     * @param list  数据源
     * @param fieldMap 中英文字段对应关系的Map
     * @throws Exception the exception
     * @MethodName  : fillSheet
     * @Description : 向工作表中填充数据
     */
    private static <T> void fillSheet(XSSFSheet sheet, List<T> list,
                                      LinkedHashMap<String, String> fieldMap) throws Exception {

        //定义存放英文字段名和中文字段名的数组  
        String[] enFields = new String[fieldMap.size()];
        String[] cnFields = new String[fieldMap.size()];

        //填充数组  
        int count = 0;
        for (Entry<String, String> entry : fieldMap.entrySet()) {
            enFields[count] = entry.getKey();
            cnFields[count] = entry.getValue();
            count++;
        }
        //填充表头  
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < cnFields.length; i++) {
            XSSFCell cell = row.createCell(i, 0);
            cell.setCellValue(cnFields[i]);
        }

        //填充内容  
        int rowNo = 1;
        for (int index = 0; index < list.size(); index++) {
            //获取单个对象  
            XSSFRow xssfRow = sheet.createRow(rowNo);
            T item = list.get(index);
            for (int i = 0; i < enFields.length; i++) {
                Object objValue = getFieldValueByNameSequence(enFields[i], item);
                String fieldValue = objValue == null ? "" : objValue.toString();
                XSSFCell cell = xssfRow.createCell(i);
                cell.setCellValue(fieldValue);
            }

            rowNo++;
        }

    }

    /**
     *  
     *
     * @param fieldNameSequence  带路径的属性名或简单属性名
     * @param o 对象
     * @return  属性值
     * @throws Exception the exception
     * @MethodName  : getFieldValueByNameSequence
     * @Description :
     * 根据带路径或不带路径的属性名获取属性值 
     * 即接受简单属性名，如userName等，又接受带路径的属性名，如student.department.name等 
     *  
     */
    private static Object getFieldValueByNameSequence(String fieldNameSequence, Object o)
            throws Exception {

        Object value = null;

        //将fieldNameSequence进行拆分  
        String[] attributes = fieldNameSequence.split("\\.");
        if (attributes.length == 1) {
            value = getFieldValueByName(fieldNameSequence, o);
        } else {
            //根据属性名获取属性对象  
            Object fieldObj = getFieldValueByName(attributes[0], o);
            String subFieldNameSequence = fieldNameSequence.substring(fieldNameSequence
                    .indexOf(".") + 1);
            value = getFieldValueByNameSequence(subFieldNameSequence, fieldObj);
        }
        return value;

    }

    /**
     *  
     *
     * @param fieldName 字段名
     * @param o 对象
     * @return  字段值
     * @throws Exception the exception
     * @MethodName  : getFieldValueByName
     * @Description : 根据字段名获取字段值
     */
    private static Object getFieldValueByName(String fieldName, Object o) throws Exception {

        Object value = null;
        Field field = getFieldByName(fieldName, o.getClass());

        if (field != null) {
            field.setAccessible(true);
            value = field.get(o);
        } else {
            throw new ExcelException(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
        }

        return value;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月4日 bobo creat
 */
