/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.service.system.SysMenusService;

/**
 * Created by ldy on 2016/11/29.
 */
@Component
public class Excel2JsonUtil {

    /** The log. */
    private static Logger log = LoggerFactory.getLogger(Excel2JsonUtil.class);

    /** The menus service. */
    @Autowired
    private SysMenusService menusService;

    /** The excel 2 json util. */
    private static Excel2JsonUtil excel2JsonUtil;

    /**
     * Gets the excel 2 json util.
     *
     * @return the excel 2 json util
     */
    public static Excel2JsonUtil getExcel2JsonUtil() {
        return excel2JsonUtil;
    }

    /**
     * Sets the excel 2 json util.
     *
     * @param excel2JsonUtil the new excel 2 json util
     */
    public static void setExcel2JsonUtil(Excel2JsonUtil excel2JsonUtil) {
        Excel2JsonUtil.excel2JsonUtil = excel2JsonUtil;
    }

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        setExcel2JsonUtil(this);
        getExcel2JsonUtil().menusService = this.menusService;

    }

    /** The map V 2. */
    public static LinkedHashMap<String, String> mapV2 = new LinkedHashMap<>();

    /** The map V 3. */
    public static LinkedHashMap<String, String> mapV3 = new LinkedHashMap<>();

    /** The map V 3 exp. */
    public static LinkedHashMap<String, String> mapV3exp = new LinkedHashMap<>();

    /** The map port. */
    public static LinkedHashMap<String, String> mapPort = new LinkedHashMap<>();

    /** The map portexp. */
    public static LinkedHashMap<String, String> mapPortexp = new LinkedHashMap<>();

    /** The map logsexp. */
    public static LinkedHashMap<String, String> mapLogsexp = new LinkedHashMap<>();

    /** The idcdolist. */
    public static LinkedList<String> IDCDOLIST = new LinkedList<String>();

    /** The idcuplist. */
    public static LinkedList<String> IDCUPLIST = new LinkedList<String>();

    /** The tcdnslist. */
    public static LinkedList<String> TCDNSLIST = new LinkedList<String>();

    /** The scdnslist. */
    public static LinkedList<String> SCDNSLIST = new LinkedList<String>();

    /** The scachelist. */
    public static LinkedList<String> SCACHELIST = new LinkedList<String>();

    /** The versionlist. */
    public static LinkedList<String> VERSIONLIST = new LinkedList<String>();

    /** The accpt type. */
    private static String accptType = PropertiesUtils.findPropertiesKey("ACCPTTYPE",
            "/resetPwdConfig.properties");

    /** The size. */
    private static int size = Integer.parseInt(PropertiesUtils.findPropertiesKey("SIZE",
            "/resetPwdConfig.properties"));

    /** The reg dev name. */
    private static String regDevName = "^[\\w\\d_-]+$";

    static {
        mapV2.put("校验", "check");
        mapV2.put("设备状态", "deviceState");
        mapV2.put("省份", "province");
        mapV2.put("设备名称", "deviceName");
        mapV2.put("设备IP", "IP");
        mapV2.put("所属机房", "labs");
        mapV2.put("设备类型", "deviceType");
        mapV2.put("SNMP版本", "snmpVersion");
        mapV2.put("SNMP端口", "snmpPort");
        mapV2.put("SNMP团体字", "snmpRaid");
        mapV2.put("备注", "description");

        mapV3.put("校验", "check");
        mapV3.put("设备状态", "deviceState");
        mapV3.put("省份", "province");
        mapV3.put("设备名称", "deviceName");
        mapV3.put("设备IP", "IP");
        mapV3.put("所属机房", "labs");
        mapV3.put("设备类型", "deviceType");
        mapV3.put("SNMP版本", "snmpVersion");
        mapV3.put("SNMP端口", "snmpPort");
        mapV3.put("SNMPv3安全名称", "snmpSaveName");
        mapV3.put("SNMPv3安全级别", "snmpv3SaveLevel");
        mapV3.put("SNMPv3认证协议", "snmpv3Protocol");
        mapV3.put("SNMPv3认证口令", "snmpv3Command");
        mapV3.put("SNMPv3加密协议", "snmpv3Encryp");
        mapV3.put("SNMPv3私有密钥", "snmpv3EncrypCode");
        mapV3.put("备注", "description");
        // mapV3.put("SNMP团体字", "snmpRaid");

        // mapV3exp.put("校验", "check");
        // mapV3exp.put("设备ID", "id");
        mapV3exp.put("省份", "province");
        mapV3exp.put("设备名称", "name");
        mapV3exp.put("设备IP", "ipAddr");
        mapV3exp.put("所属机房", "room");
        mapV3exp.put("设备类型", "type");
        mapV3exp.put("设备状态", "status");
        mapV3exp.put("SNMP版本", "snmpVersion");
        mapV3exp.put("SNMP端口", "snmpPort");
        mapV3exp.put("SNMP团体字", "snmpCommunity");
        mapV3exp.put("SNMPv3安全名称", "snmpv3Securityname");
        mapV3exp.put("SNMPv3安全级别", "snmpv3Securitylevel");
        mapV3exp.put("SNMPv3认证协议", "snmpv3Authprotocol");
        mapV3exp.put("SNMPv3认证口令", "snmpv3Authpassphrase");
        mapV3exp.put("SNMPv3加密协议", "snmpv3Privprotocol");
        mapV3exp.put("SNMPv3私有密钥", "snmpv3Privpassphrase");
        mapV3exp.put("备注", "description");
        mapV3exp.put("上传时间", "lastmodifiedTimeView");

        mapPort.put("校验", "check");
        mapPort.put("端口状态", "portState");
        mapPort.put("省份", "province");
        mapPort.put("设备名称", "deviceName");
        mapPort.put("设备IP", "IP");
        mapPort.put("端口名称", "portName");
        mapPort.put("端口类型", "portType");
        mapPort.put("业务大类", "service");
        mapPort.put("业务小类", "serviceSuper");
        mapPort.put("对端设备", "pearDevice");
        mapPort.put("备注", "description");

        //mapPortexp.put("校验", "check");
        //mapPortexp.put("端口ID", "id");
        //mapPortexp.put("设备ID", "deviceid");
        //mapPortexp.put("端口状态", "portState");
        mapPortexp.put("省份", "province");
        mapPortexp.put("设备名称", "devicesName");
        mapPortexp.put("设备IP", "devicesIp");
        mapPortexp.put("端口名称", "name");
        mapPortexp.put("端口类型", "type");
        mapPortexp.put("端口状态", "status");
        mapPortexp.put("业务大类", "service1View");
        mapPortexp.put("业务小类", "service2View");
        mapPortexp.put("对端设备", "peerDevice");
        mapPortexp.put("上传时间", "lastmodifiedTimeView");

        //日志导出excel字段设置
        mapLogsexp.put("ID", "userId");
        mapLogsexp.put("操作类型", "type");
        mapLogsexp.put("来源", "source");
        mapLogsexp.put("用户姓名", "userName");
        mapLogsexp.put("操作详情", "operateContent");
        mapLogsexp.put("结果", "result");
        mapLogsexp.put("操作时间", "operateTimeShow");

        IDCUPLIST.add("骨干出口");
        IDCUPLIST.add("省际出口");
        IDCUPLIST.add("省网出口");
        IDCUPLIST.add("城域网出口");

        IDCDOLIST.add("腾讯");
        IDCDOLIST.add("百度");
        IDCDOLIST.add("阿里巴巴");
        IDCDOLIST.add("苹果");
        IDCDOLIST.add("新浪");
        IDCDOLIST.add("360");
        IDCDOLIST.add("小米科技");
        IDCDOLIST.add("爱奇艺");
        IDCDOLIST.add("优酷土豆网");
        IDCDOLIST.add("京东");
        IDCDOLIST.add("搜狐");
        IDCDOLIST.add("网易");
        IDCDOLIST.add("搜狗");
        IDCDOLIST.add("酷狗网");
        IDCDOLIST.add("PPS");
        IDCDOLIST.add("乐视");
        IDCDOLIST.add("欢聚时代（YY/多玩）");
        IDCDOLIST.add("迅雷在线");
        IDCDOLIST.add("酷我音乐");
        IDCDOLIST.add("美团网");
        IDCDOLIST.add("凤凰网");
        IDCDOLIST.add("美图网");
        IDCDOLIST.add("风行网");
        IDCDOLIST.add("芒果TV");
        IDCDOLIST.add("暴风影音");
        IDCDOLIST.add("东方财富网");
        IDCDOLIST.add("唯品会");
        IDCDOLIST.add("中国网络电视台");
        IDCDOLIST.add("PPTV聚力");
        IDCDOLIST.add("酷6网");
        IDCDOLIST.add("大众点评网");
        IDCDOLIST.add("汽车之家");
        IDCDOLIST.add("58同城");
        IDCDOLIST.add("口碑网");
        IDCDOLIST.add("bilibili");
        IDCDOLIST.add("同花顺金融服务网");
        IDCDOLIST.add("4399小游戏");
        IDCDOLIST.add("中国工商银行");
        IDCDOLIST.add("携程旅行网");
        IDCDOLIST.add("兴业银行");
        IDCDOLIST.add("蘑菇街");
        IDCDOLIST.add("虾米音乐网");
        IDCDOLIST.add("苏宁易购");
        IDCDOLIST.add("卓越亚马逊");
        IDCDOLIST.add("去哪儿网");
        IDCDOLIST.add("易车网");
        IDCDOLIST.add("知乎");
        IDCDOLIST.add("聚美优品");
        IDCDOLIST.add("豆瓣");
        IDCDOLIST.add("中国建设银行");
        IDCDOLIST.add("驴妈妈网站");
        IDCDOLIST.add("1号店");
        IDCDOLIST.add("招商银行");
        IDCDOLIST.add("人人网");
        IDCDOLIST.add("大智慧");
        IDCDOLIST.add("当当网");
        IDCDOLIST.add("中国农业银行");
        IDCDOLIST.add("沪江网");
        IDCDOLIST.add("广发证券");
        IDCDOLIST.add("百合网");
        IDCDOLIST.add("途牛旅游网");
        IDCDOLIST.add("国泰君安");
        IDCDOLIST.add("交通银行");
        IDCDOLIST.add("中国银行");
        IDCDOLIST.add("中国民生银行");
        IDCDOLIST.add("银联");
        IDCDOLIST.add("浦发银行");
        IDCDOLIST.add("中国光大银行");
        IDCDOLIST.add("广发银行");
        IDCDOLIST.add("猎聘网");
        IDCDOLIST.add("斗鱼");
        IDCDOLIST.add("金山网络");
        IDCDOLIST.add("猫扑");
        IDCDOLIST.add("驾考宝典");
        IDCDOLIST.add("中关村在线");
        IDCDOLIST.add("盛大");
        IDCDOLIST.add("蚂蜂窝");
        IDCDOLIST.add("微软");
        IDCDOLIST.add("游娱网");
        IDCDOLIST.add("完美世界");
        IDCDOLIST.add("巨人网络");
        IDCDOLIST.add("18183手游网");
        IDCDOLIST.add("游民星空");
        IDCDOLIST.add("高德官网");
        IDCDOLIST.add("今日头条");
        IDCDOLIST.add("优视科技");
        IDCDOLIST.add("华为");
        IDCDOLIST.add("滴滴出行");
        IDCDOLIST.add("墨迹");
        IDCDOLIST.add("掌阅公司网站");
        IDCDOLIST.add("陌陌官网");
        IDCDOLIST.add("豌豆荚手机精灵");
        IDCDOLIST.add("宜搜搜索");
        IDCDOLIST.add("科大讯飞");
        IDCDOLIST.add("有道");
        IDCDOLIST.add("中国天气网");
        IDCDOLIST.add("易视腾科技有限公司");
        IDCDOLIST.add("国美");
        IDCDOLIST.add("联想");
        IDCDOLIST.add("三星电子");

        TCDNSLIST.add("上联出口");
        TCDNSLIST.add("Cache");
        TCDNSLIST.add("CACHE");
        TCDNSLIST.add("CDN");
        TCDNSLIST.add("cdn");
        TCDNSLIST.add("OTT CDN");
        TCDNSLIST.add("ott cdn");
        TCDNSLIST.add("OTTCDN");
        TCDNSLIST.add("ottcdn");
        TCDNSLIST.add("其他");

        SCDNSLIST.add("上联出口");
        SCDNSLIST.add("OTT CDN");
        SCDNSLIST.add("ott cdn");
        SCDNSLIST.add("OTTCDN");
        SCDNSLIST.add("ottcdn");
        SCDNSLIST.add("其他");

        SCACHELIST.add("上联出口");
        SCACHELIST.add("Cache");
        SCACHELIST.add("CACHE");
        SCACHELIST.add("其他");

        VERSIONLIST.add("v1");
        VERSIONLIST.add("v2c");
        VERSIONLIST.add("v3");
    }

    /**
     * 解决思路：采用Apache的POI的API来操作Excel，读取内容后保存到List中，再将List转Json（推荐Linked，增删快，与Excel表顺序保持一致）
     * 
     *          Sheet表1  ————>    List1<Map<列头，列值>>
     *          Sheet表2  ————>    List2<Map<列头，列值>>
     * 
     * 步骤1：根据Excel版本类型创建对于的Workbook以及CellSytle
     * 步骤2：遍历每一个表中的每一行的每一列
     * 步骤3：一个sheet表就是一个Json，多表就多Json，对应一个 List
     *       一个sheet表的一行数据就是一个 Map
     *       一行中的一列，就把当前列头为key，列值为value存到该列的Map中.
     *
     * @param file  SSM框架下用户上传的Excel文件
     * @param type the type
     * @param roleId the role id
     * @param menuName the menu name
     * @param request the request
     * @return Map  一个线性HashMap，以Excel的sheet表顺序，并以sheet表明作为key，sheet表转换json后的字符串作为value
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @SuppressWarnings("resource")
    public static LinkedHashMap<String, Object> excel2json(MultipartFile file, String type,
                                                           Integer roleId, String menuName,
                                                           HttpServletRequest request)
            throws IOException {
        // 返回的map
        LinkedHashMap<String, Object> excelMap = new LinkedHashMap<>();
        // 菜单集合
        LinkedList<String> menusList = new LinkedList<String>();
        List<SysMenus> menusByRoleId = excel2JsonUtil.menusService.getMenusByRoleId(roleId);
        int menuType = 0;
        if ("device_v2".equals(type)) {
            menuType = -3;
        } else {
            menuType = -5;
        }
        if (menuName != null && "全国".equals(menuName.trim())) {
            // 添加全国
            for (Iterator<SysMenus> iterator = menusByRoleId.iterator(); iterator.hasNext();) {
                SysMenus sysMenus = (SysMenus) iterator.next();
                if (sysMenus.getType() == menuType) {
                    menusList.add(sysMenus.getImg());
                }
            }
        } else if (menuName != null) {
            // 添加指定省份
            menu: for (Iterator<SysMenus> iterator = menusByRoleId.iterator(); iterator.hasNext();) {
                SysMenus sysMenus = (SysMenus) iterator.next();
                if (sysMenus.getType() == menuType && sysMenus.getImg() != null
                        && sysMenus.getImg().equals(menuName.trim())) {
                    menusList.add(sysMenus.getImg());
                    break menu;
                }
            }
        } else {
            excelMap.put("error", "没有指定录入数据所属省份");
            return excelMap;
        }

        // Excel列的样式，主要是为了解决Excel数字科学计数的问题
        CellStyle cellStyle;
        // 根据Excel构成的对象
        Workbook wb;
        // 如果是2007及以上版本，则使用想要的Workbook以及CellStyle
        if (file.getOriginalFilename().endsWith("xlsx")) {
            wb = new XSSFWorkbook(file.getInputStream());
            XSSFDataFormat dataFormat = (XSSFDataFormat) wb.createDataFormat();
            cellStyle = wb.createCellStyle();
            // 设置Excel列的样式为文本
            cellStyle.setDataFormat(dataFormat.getFormat("@"));
        } else {
            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
            wb = new HSSFWorkbook(fs);
            HSSFDataFormat dataFormat = (HSSFDataFormat) wb.createDataFormat();
            cellStyle = wb.createCellStyle();
            // 设置Excel列的样式为文本
            cellStyle.setDataFormat(dataFormat.getFormat("@"));
        }

        // sheet表个数
        // 遍历每一个sheet
        for (int i = 0; i < 1; i++) {
            Sheet sheet = wb.getSheetAt(i);
            // 一个sheet表对于一个List
            LinkedList<LinkedHashMap<String, String>> listData = new LinkedList<LinkedHashMap<String, String>>();

            // 将第一行的列值作为正个json的key
            String[] cellNames;
            // 取第一行列的值作为key
            Row fisrtRow = sheet.getRow(0);
            // 如果第一行就为空，则是空sheet表，该表跳过
            if (null == fisrtRow) {
                continue;
            }
            // 得到第一行有多少列
            int curCellNum = fisrtRow.getLastCellNum();
            // 根据第一行的列数来生成列头数组
            cellNames = new String[curCellNum];
            // 单独处理第一行，取出第一行的每个列值放在数组中，就得到了整张表的JSON的key
            for (int m = 0; m < curCellNum; m++) {
                Cell cell = fisrtRow.getCell(m);
                // 设置该列的样式是字符串
                cell.setCellStyle(cellStyle);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                // 取得该列的字符串值
                cellNames[m] = cell.getStringCellValue().trim();
            }
            // 从第二行起遍历每一行
            int rowNum = sheet.getLastRowNum();
            LinkedHashMap<String, String> errStr = new LinkedHashMap<String, String>();
            if (rowNum < 2) {
                errStr.put("msg", "请上传有效模版！");
            } else if (rowNum > 201) {
                errStr.put("msg", "单次最多支持200条信息导入");
            }
            ArrayList<String> devicesList = new ArrayList<String>();
            ArrayList<String> ipsList = new ArrayList<String>();
            ArrayList<String> portsList = new ArrayList<String>();
            flag: for (int j = 1; j <= rowNum; j++) {
                // 一行数据对于一个Map
                LinkedHashMap<String, String> rowMap = new LinkedHashMap<String, String>();
                // 取得某一行
                Row row = sheet.getRow(j);
                int cellNum = sheet.getRow(0).getLastCellNum();
                //每一行校验数据缓存
                String portsNameStr = "";
                String portsIPStr = "";
                String cp2 = "";
                String cp3 = "";
                String cpp = "";
                // 遍历每一列
                for (int k = 0; k < cellNum; k++) {
                    Cell cell = row.getCell(k);
                    String stringValue = new String();
                    if (cell != null) {
                        cell.setCellStyle(cellStyle);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        stringValue = cell.getStringCellValue().replaceAll(" ", "");
                    } else if (cellNames.length <= k) {
                        continue;
                    } else {
                        stringValue = "";
                    }
                    if (j == 1 && (stringValue.trim()).startsWith("请")) {
                        continue flag;
                    }
                    if (cell == null || "".equals(stringValue.trim())) {
                        if ("省份".equals(cellNames[k].trim())) {
                            if (j == 2 || j == 1) {
                                errMsg(cellNames, j, errStr, k, "为非有效省份");
                            }
                        } else {
                            errMsg(cellNames, j, errStr, k, "数据为空");
                        }
                        break flag;
                    } else {
                        cell.setCellStyle(cellStyle);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String stringCellValue = cell.getStringCellValue().replaceAll(" ", "");
                        if (cellNames.length <= k) {
                            continue;
                        }
                        // 保存该单元格的数据到该行中
                        if ("device_v2".equals(type)) {
                            //==============device_v2==============//
                            if ("省份".equals(cellNames[k].trim()) && null != stringCellValue
                                    && StringUtil.isNotNUll(stringCellValue)) {
                                //省份校验
                                if (menusList.contains(stringCellValue.trim())) {
                                    cp2 = stringCellValue.trim();
                                    rowMap.put(mapV2.get(cellNames[k]), stringCellValue.trim());
                                } else {
                                    errMsg(cellNames, j, errStr, k, "为非有效省份");
                                    break flag;
                                }
                            } else if ("设备名称".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //校验设备名称
                                if (!stringCellValue.trim().matches(regDevName)) {
                                    errMsg(cellNames, j, errStr, k,
                                            "输入有误" + System.getProperty("line.separator", "\n")
                                                    + " 合法的设备名称仅支持 半角的大小写字母、数字、短横杠- 和下划线_ ");
                                    break flag;
                                }
                                if (devicesList.contains(stringCellValue.trim())) {
                                    errMsg(cellNames, j, errStr, k, "输入有误，设备名称重复");
                                    break flag;
                                }
                                devicesList.add(stringCellValue.trim());
                                rowMap.put(mapV2.get(cellNames[k]), stringCellValue.trim());
                            } else if ("设备IP".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //校验IP地址
                                if (ipsList.contains(stringCellValue.trim())) {
                                    errMsg(cellNames, j, errStr, k, "输入有误，存在设备IP重复");
                                    break flag;
                                }
                                ipsList.add(stringCellValue.trim());
                                if (stringCellValue
                                        .trim()
                                        .matches(
                                                "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))")) {
                                    rowMap.put(mapV2.get(cellNames[k]), stringCellValue.trim());
                                } else {
                                    errMsg(cellNames, j, errStr, k, "为非有效IP");
                                    break flag;
                                }
                            } else if ("所属机房".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //校验所属机房
                                rowMap.put(mapV2.get(cellNames[k]), stringCellValue.trim());
                            } else if ("设备类型".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //校验设备类型
                                boolean judgeExl = StringUtil.judgeExl(stringCellValue.trim(), cp2,
                                        "driver");
                                if (!judgeExl) {
                                    errMsg(cellNames, j, errStr, k, "填写不符合规则");
                                    break flag;
                                }
                                rowMap.put(mapV2.get(cellNames[k]), stringCellValue.trim());
                            } else if ("SNMP版本".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //校验SNMP版本
                                if (!VERSIONLIST.contains(stringCellValue.trim())) {
                                    errMsg(cellNames, j, errStr, k, "填写不符合规则");
                                    break flag;
                                }
                                rowMap.put(mapV2.get(cellNames[k]), stringCellValue.trim());
                            } else if ("SNMP端口".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //校验SNMP端口
                                if (Integer.parseInt(stringCellValue.trim()) > 0
                                        && Integer.parseInt(stringCellValue.trim()) <= 65535) {
                                    rowMap.put(mapV2.get(cellNames[k]), stringCellValue.trim());
                                } else {
                                    errMsg(cellNames, j, errStr, k, "非有效端口号");
                                    break flag;
                                }
                            } else if ("SNMP团体字".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //校验SNMP团体字
                                rowMap.put(mapV2.get(cellNames[k]), stringCellValue.trim());
                            } else {
                                errMsg(cellNames, j, errStr, k, "为空");
                                break flag;
                            }
                        } else if ("device_v3".equals(type)) {
                            //============device_v3============//
                            if ("省份".equals(cellNames[k].trim()) && null != stringCellValue
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //省份
                                if (menusList.contains(stringCellValue.trim())) {
                                    cp3 = stringCellValue.trim();
                                    rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                                } else {
                                    errMsg(cellNames, j, errStr, k, "为非有效省份");
                                    break flag;
                                }
                            } else if ("设备名称".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //设备名称
                                if (!stringCellValue.trim().matches(regDevName)) {
                                    errMsg(cellNames, j, errStr, k,
                                            "输入有误" + System.getProperty("line.separator", "\n")
                                                    + " 合法的设备名称仅支持 半角的大小写字母、数字、短横杠- 和下划线_ ");
                                    break flag;
                                }
                                if (devicesList.contains(stringCellValue.trim())) {
                                    errMsg(cellNames, j, errStr, k, "输入有误，设备名称重复");
                                    break flag;
                                }
                                devicesList.add(stringCellValue.trim());
                                rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                            } else if ("设备IP".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //IP地址
                                if (ipsList.contains(stringCellValue.trim())) {
                                    errMsg(cellNames, j, errStr, k, "输入有误，设备IP重复");
                                    break flag;
                                }
                                ipsList.add(stringCellValue.trim());
                                if (stringCellValue
                                        .trim()
                                        .matches(
                                                "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))")) {
                                    rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                                } else {
                                    errMsg(cellNames, j, errStr, k, "为非有效IP");
                                    break flag;
                                }
                            } else if ("所属机房".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //所属机房
                                rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                            } else if ("设备类型".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //设备类型
                                boolean judgeExl = StringUtil.judgeExl(stringCellValue.trim(), cp3,
                                        "driver");
                                if (!judgeExl) {
                                    errMsg(cellNames, j, errStr, k, "填写不符合规则");
                                    break flag;
                                }
                                rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                            } else if ("SNMP版本".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //SNMP版本
                                if (!VERSIONLIST.contains(stringCellValue.trim())) {
                                    errMsg(cellNames, j, errStr, k, "填写不符合规则");
                                    break flag;
                                }
                                rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                            } else if ("SNMP端口".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //SNMP端口
                                if (Integer.parseInt(stringCellValue.trim()) > 0
                                        && Integer.parseInt(stringCellValue.trim()) < 65535) {
                                    rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                                } else {
                                    errMsg(cellNames, j, errStr, k, "非有效端口号");
                                    break flag;
                                }
                            } else if ("SNMPv3安全名称".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //SNMPv3安全名称
                                rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                            } else if ("SNMPv3安全级别".equals(cellNames[k].trim())) {
                                //SNMPv3安全级别
                                rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                            } else if ("SNMPv3认证协议".equals(cellNames[k].trim())) {
                                //SNMPv3认证协议
                                if ("authNoPriv".trim().equals(rowMap.get(mapV3.get("SNMPv3安全级别")))
                                        || "authPriv".equals(rowMap.get(mapV3.get("SNMPv3安全级别"))
                                                .trim())) {
                                    if (stringCellValue != null
                                            && StringUtil.isNotNUll(stringCellValue.trim())
                                            && ("MD5".equals(stringCellValue.trim()) || "SHA"
                                                    .equals(cell.getStringCellValue().trim()))) {
                                        rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                                    } else {
                                        errMsg(cellNames, j, errStr, k, "填写非法,请按照实际情况选择：MD5，SHA");
                                        break flag;
                                    }
                                } else {
                                    rowMap.put(mapV3.get(cellNames[k]), "");
                                }
                            } else if ("SNMPv3认证口令".equals(cellNames[k].trim())) {
                                //SNMPv3认证口令
                                if ("authNoPriv".trim().equals(rowMap.get(mapV3.get("SNMPv3安全级别")))
                                        || "authPriv".equals(rowMap.get(mapV3.get("SNMPv3安全级别"))
                                                .trim())) {
                                    if (stringCellValue != null
                                            && StringUtil.isNotNUll(stringCellValue.trim())) {
                                        rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                                    } else {
                                        errMsg(cellNames, j, errStr, k, "填写非法");
                                        break flag;
                                    }
                                } else {
                                    rowMap.put(mapV3.get(cellNames[k]), "");
                                }
                            } else if ("SNMPv3加密协议".equals(cellNames[k].trim())) {
                                //SNMPv3加密协议
                                if ("authPriv".equals(rowMap.get(mapV3.get("SNMPv3安全级别")).trim())) {
                                    if (stringCellValue != null
                                            && StringUtil.isNotNUll(stringCellValue.trim())
                                            && ("DES".equals(stringCellValue.trim()) || "AES"
                                                    .equals(cell.getStringCellValue().trim()))) {
                                        rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                                    } else {
                                        errMsg(cellNames, j, errStr, k, "填写非法,请按照实际情况选择：DES，AES");
                                        break flag;
                                    }
                                } else {
                                    rowMap.put(mapV3.get(cellNames[k]), "");
                                }
                            } else if ("SNMPv3私有密钥".equals(cellNames[k].trim())) {
                                //SNMPv3私有密钥
                                if ("authPriv".equals(rowMap.get(mapV3.get("SNMPv3安全级别")).trim())) {
                                    if (stringCellValue != null
                                            && StringUtil.isNotNUll(stringCellValue.trim())) {
                                        rowMap.put(mapV3.get(cellNames[k]), stringCellValue.trim());
                                    } else {
                                        errMsg(cellNames, j, errStr, k, "填写非法");
                                        break flag;
                                    }
                                } else {
                                    rowMap.put(mapV3.get(cellNames[k]), "");
                                }
                            } else {
                                errMsg(cellNames, j, errStr, k, "为空");
                                break flag;
                            }
                        } else if ("port".equals(type)) {
                            //===============port==============//
                            if ("省份".equals(cellNames[k].trim()) && null != stringCellValue
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //省份
                                if (menusList.contains(stringCellValue.trim())) {
                                    cpp = stringCellValue.trim();
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else {
                                    errMsg(cellNames, j, errStr, k, "为非有效省份");
                                    break flag;
                                }
                            } else if ("设备名称".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //设备名称
                                if (!stringCellValue.trim().matches(regDevName)) {
                                    errMsg(cellNames, j, errStr, k,
                                            "输入有误" + System.getProperty("line.separator", "\n")
                                                    + "合法的设备名称仅支持 半角的大小写字母、数字、短横杠- 和下划线_");
                                    break flag;
                                }
                                portsNameStr += stringCellValue.trim();
                                rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                            } else if ("设备IP".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //IP地址
                                if (stringCellValue
                                        .trim()
                                        .matches(
                                                "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))")) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else {
                                    errMsg(cellNames, j, errStr, k, "为非有效IP");
                                    break flag;
                                }
                                portsIPStr += stringCellValue.trim();
                            } else if ("端口名称".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //端口名称
                                portsNameStr += stringCellValue.trim();
                                portsIPStr += stringCellValue.trim();
                                if (portsList.contains(portsNameStr)
                                        || portsList.contains(portsIPStr)) {
                                    errMsg(cellNames, j, errStr, k, "同一台设备端口重复");
                                    break flag;
                                }
                                portsList.add(portsNameStr);
                                portsList.add(portsIPStr);
                                rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                            } else if ("端口类型".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //端口类型
                                rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                            } else if ("业务大类".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //业务大类
                                boolean judgeExl = StringUtil.judgeExl(stringCellValue.trim(), cpp,
                                        "port");
                                if (!judgeExl) {
                                    errMsg(cellNames, j, errStr, k, "填写不符合规则");
                                    break flag;
                                }
                                rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                            } else if ("业务小类".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //业务小类
                                String trim = rowMap.get(mapPort.get("业务大类")).trim();
                                if ("CACHE".equals(stringCellValue.trim())) {
                                    stringCellValue = "Cache";
                                }
                                if ("省网上联".equals(trim) && "无".equals(stringCellValue.trim())) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("省际直连".equals(trim)
                                        && menusList.contains(stringCellValue.trim())) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("三方出口".equals(trim)) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("IDC".equals(trim)
                                        && (IDCDOLIST.contains(stringCellValue.trim()) || IDCUPLIST
                                                .contains(stringCellValue.trim()))) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("ICP直连".equals(trim)
                                        && IDCDOLIST.contains(stringCellValue.trim())) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("统建内容网络".equals(trim)
                                        && TCDNSLIST.contains(stringCellValue.trim())) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("省建CDN".equals(trim)
                                        && SCDNSLIST.contains(stringCellValue.trim())) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("省建Cache".equals(trim)
                                        && SCACHELIST.contains(stringCellValue.trim())) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("第三方CDN".equals(trim)) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("固网用户".equals(trim)) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("手机用户".equals(trim)
                                        && "无".equals(stringCellValue.trim())) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("收费客户".equals(trim)) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("免费直连".equals(trim)) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("付费直连".equals(trim)) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else if ("付费穿透".equals(trim)) {
                                    rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                                } else {
                                    errMsg(cellNames, j, errStr, k, "业务大类－业务小类对应关系不符合规则");
                                    break flag;
                                }
                            } else if ("对端设备".equals(cellNames[k].trim())
                                    && stringCellValue != null
                                    && StringUtil.isNotNUll(stringCellValue.trim())) {
                                //对端设备
                                rowMap.put(mapPort.get(cellNames[k]), stringCellValue.trim());
                            } else {
                                errMsg(cellNames, j, errStr, k, "为空");
                                break flag;
                            }
                        } else {
                            errStr.put("msg", "请上传有效模版！");
                        }
                    }
                }
                // 保存该行的数据到该表的List中
                listData.add(rowMap);
            }
            JSONArray array = new JSONArray();
            String time = "";
            if (errStr.size() == 0) {
                String url = PropertiesUtils.findPropertiesKey("URL", "/resetPwdConfig.properties");
                if (type.contains("device")) {
                    url += "resourceCheckDevice";
                } else {
                    url += "resourceCheckPort";
                }
                HashMap<String, String> param = new LinkedHashMap<String, String>();
                long startTime = System.currentTimeMillis(); //获取开始时间
                String invokePost = getInvokePost(listData, url, param, size);
                long endTime = System.currentTimeMillis(); //获取结束时间
                time = "程序运行时间： " + (endTime - startTime) + "ms";
                log.info(time);
                String invokeStr = invokePost;
                log.info(invokePost + "=========响应数据========");
                if (invokePost != null && !"".equals(invokePost.trim())
                        && invokePost.indexOf("[") != -1) {
                    invokePost = invokePost.substring(invokePost.indexOf("["));
                    array = JSONArray.fromObject(invokePost);
                    boolean check = true;
                    if (array.size() > 0) {
                        for (int l = 0; l < array.size(); l++) {
                            JSONObject object = JSONObject.fromObject(array.get(l));
                            String string = object.optString("错误代码");
                            if ("0".equals(string)) {
                                object.put("check", "正常无错误");
                            } else {
                                if ("1".equals(string)) {
                                    object.put("check", "资源表中已存在该设备或者端口资源");
                                } else if ("2".equals(string)) {
                                    object.put("check", "资源表中不存在该设备或者端口资源");
                                } else if ("3".equals(string)) {
                                    object.put("check", "SNMP探测设备不可达");
                                } else if ("4".equals(string)) {
                                    object.put("check", "SNMP探测设备不存在该端口资源");
                                } else if ("5".equals(string)) {
                                    object.put("check", "SNMP采集端口信息失败(无数据)");
                                } else if ("6".equals(string)) {
                                    object.put("check", "设备名称与数据库中已存在名称不匹配");
                                } else if ("7".equals(string)) {
                                    object.put("check", "未知");
                                } else if ("8".equals(string)) {
                                    object.put("check", "未知");
                                } else if ("99".equals(string)) {
                                    object.put("check", "内部错误（包括数据库、脚本等异常报错）");
                                } else {
                                    object.put("check", "未知");
                                }
                                check = false;
                            }
                            if ("port".equals(type)) {
                                for (int j = 0; j < listData.size(); j++) {
                                    LinkedHashMap<String, String> linkedHashMap = listData.get(j);
                                    if ((linkedHashMap.get("deviceName").trim()).equals(object
                                            .optString("设备名称").trim())
                                            && (linkedHashMap.get("portName").trim()).equals(object
                                                    .optString("端口名称").trim())) {
                                        linkedHashMap.put("check", object.optString("check"));
                                        linkedHashMap.put("pearDevice", object.optString("对端设备"));
                                    } else if (linkedHashMap.get("check") == null
                                            || "".equals(linkedHashMap.get("check").trim())) {
                                        linkedHashMap.put("check", "调用未返回有效结果");
                                    }
                                }
                            } else {
                                for (int j = 0; j < listData.size(); j++) {
                                    LinkedHashMap<String, String> linkedHashMap = listData.get(j);
                                    if ((linkedHashMap.get("deviceName").trim()).equals(object
                                            .optString("设备名称").trim())) {
                                        linkedHashMap.put("check", object.optString("check"));
                                    } else if (linkedHashMap.get("check") == null
                                            || "".equals(linkedHashMap.get("check").trim())) {
                                        linkedHashMap.put("check", "调用未返回有效结果");
                                    }
                                }
                            }
                        }
                    } else {
                        errStr.put("msg", " 响应数据发现未知错误：" + invokeStr);
                        check = false;
                    }
                    if (check) {
                        SessionUtils
                                .setAttribute(
                                        request,
                                        "checkedData" + type
                                                + SessionUtils.getAttribute(request, "userid"),
                                        listData);
                    }
                    excelMap.put("checked", check + "");
                } else {
                    errStr.put("msg", " 网络异常或服务器未响应或发现未知错误：" + invokeStr);
                    excelMap.put("checked", false + "");
                }
            }
            // 将该sheet表的表名为key，List转为json后的字符串为Value进行存储
            excelMap.put("data", listData);
            excelMap.put("error", errStr);
            excelMap.put("time", time);
        }

        //log.info("excel2json方法结束....");

        return excelMap;
    }

    /**
     * 获取校验结果JSON串
     * 此方法为分片处理实现.
     *
     * @param listData the list data
     * @param url the url
     * @param param the param
     * @param size the size
     * @return the invoke post
     */
    public static String getInvokePost(List<LinkedHashMap<String, String>> listData, String url,
                                       HashMap<String, String> param, int size) {
        JSONArray resJson = new JSONArray();
        if (listData.size() > size) {
            LinkedList<List<LinkedHashMap<String, String>>> sliceList = StringUtil.sliceList(
                    listData, size);
            for (int i = 0; i < sliceList.size(); i++) {
                param.put("json", JSONArray.fromObject(sliceList.get(i)).toString());
                String invokePost = HttpHelper.invokePost(url, param, accptType);
                try {
                    invokePost = invokePost.substring(invokePost.indexOf("["));
                    JSONArray fromObject = JSONArray.fromObject(invokePost);
                    resJson.addAll(fromObject);
                } catch (Exception e) {
                    return invokePost;
                }

            }
            return resJson.toString();
        } else {
            param.put("json", JSONArray.fromObject(listData).toString());
            String invokePost = HttpHelper.invokePost(url, param, accptType);
            return invokePost;
        }
    }

    /**
     * Err msg.
     *
     * @param cellNames the cell names
     * @param j the j
     * @param errStr the err str
     * @param k the k
     * @param str the str
     */
    private static void errMsg(String[] cellNames, int j, LinkedHashMap<String, String> errStr,
                               int k, String str) {
        errStr.put("msg", "第" + (1 + j) + "行第" + (1 + k) + "列" + cellNames[k].trim() + "错误（" + str
                + "）请参照模版要求填写正确的" + cellNames[k].trim());
    }
}
