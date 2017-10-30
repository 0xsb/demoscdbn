/**
 * @author ldy
 */
package com.cmcc.ms.service.system.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.cmcc.ms.common.utils.SessionUtils;
import com.cmcc.ms.common.utils.SpringContextUtil;
import com.cmcc.ms.entity.system.OperateLog;
import com.cmcc.ms.mapper.OperateLogMapper;
import com.cmcc.ms.service.system.OperateLogService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mchange.v2.ser.SerializableUtils;

/**
 * The Class OperateLogServiceImpl.
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {

    /** The operate log mapper. */
    private OperateLogMapper operateLogMapper;

    /**
     * Sets the custom query info mapper.
     *
     * @param session the new custom query info mapper
     */
    // cmcciwms
    @Resource(name = "sqlSessionCmcciwms")
    public void setCustomQueryInfoMapper(SqlSession session) {
        this.operateLogMapper = session.getMapper(OperateLogMapper.class);
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.service.system.OperateLogService#fuzzyQueryByName(java.util.Map, com.github.miemiedev.mybatis.paginator.domain.PageBounds)
     */
    @Override
    public List<OperateLog> fuzzyQueryByName(Map<String, Object> map, PageBounds pb) {
        return operateLogMapper.fuzzyQueryOperateLogListByName(map, pb);
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.service.system.OperateLogService#getFuzzyQuerySize(java.util.Map)
     */
    @Override
    public int getFuzzyQuerySize(Map<String, Object> map) {
        return operateLogMapper.getFuzzyQuerySize(map);
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.service.system.OperateLogService#saveUserOperation
     * (com.cmcc.hy.opp.cmcciw.entity.OperateLog, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public int saveUserOperation(OperateLog operateLog, HttpServletRequest request) {
        operateLog.setOperateTime(new Date());
        if (request != null) {
            String agent = request.getHeader("user-agent");
            operateLog.setBrowser(agent);
            operateLog.setIpAddr(request.getRemoteAddr());
            operateLog.setUserId(SessionUtils.getAttrForInt(request, "userid"));
        }
        return operateLogMapper.insert(operateLog);
    }

    /**
     * 向session存入用户浏览器信息
     * @param request
     */
    public void saveBroInfo(HttpServletRequest request) {
        if (request != null) {
            String agent = request.getHeader("user-agent");
            String remoteAddr = request.getRemoteAddr();
            SessionUtils.setAttribute(request,
                    "agent" + SessionUtils.getAttrForInt(request, "userid"), agent);
            SessionUtils.setAttribute(request,
                    "remoteAddr" + SessionUtils.getAttrForInt(request, "userid"), remoteAddr);
        }
    }

    /**
     * 日志记录
     * @param session
     */
    public static void insert(HttpSession session) {
        // 取得登录的用户名   
        String username = (String) doSerializable(session.getAttribute("userName"));
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateContent(username + "已退出");
        operateLog.setUserName(username);
        operateLog.setBrowser((String) doSerializable(session.getAttribute("agent"
                + doSerializable(session.getAttribute("userid")))));
        operateLog.setIpAddr((String) doSerializable(session.getAttribute("remoteAddr"
                + doSerializable(session.getAttribute("userid")))));
        operateLog.setUserId((Integer) doSerializable(session.getAttribute("userid")));
        operateLog.setOperateTime(new Date());
        OperateLogMapper staOperateLogMapper = (OperateLogMapper) new SpringContextUtil()
                .getBean("operateLogMapper");
        staOperateLogMapper.insert(operateLog);
    }

    /**
     * 反序列
     * @param session
     */
    private static Object doSerializable(Object value) {
        Object fromByteArray = null;
        try {
            if (value != null) {
                fromByteArray = SerializableUtils.fromByteArray((byte[]) value);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return fromByteArray;
    }

    //导出
    @Override
    public void export(JSONArray list, OutputStream out) throws Exception {

        //创建工作簿
        HSSFWorkbook book = new HSSFWorkbook();
        //创建表格样式,设置表头居中
        HSSFCellStyle style = book.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //创建工作表
        HSSFSheet sheet = book.createSheet("日志");
        sheet.setColumnWidth(0, 2000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 28000);
        sheet.setColumnWidth(3, 3800);
        sheet.setColumnWidth(4, 3800);
        sheet.setColumnWidth(5, 3800);
        sheet.setColumnWidth(6, 7800);
        sheet.setRightToLeft(true);

        //创建表头,并设置表头的信息
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("操作类型");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("来源");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("用户姓名");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("操作详情");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("操作时间");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("结果");
        cell.setCellStyle(style);

        @SuppressWarnings("unused")
        HSSFRow createRow = null;
        for (int i = 0; i < list.size(); i++) {
            createRow = sheet.createRow(i + 1);
            JSONObject json = (JSONObject) list.get(i);
            System.out.println(json);
            /* createRow.createCell(0).setCellValue(log.getId());
             createRow.createCell(1).setCellValue(log.getIpAddr());
             createRow.createCell(2).setCellValue(log.getBrowser());
             createRow.createCell(3).setCellValue(log.getUserName());
             createRow.createCell(4).setCellValue(log.getUserName()); 
             createRow.createCell(5).setCellValue(log.getOperateTime());
             createRow.createCell(6).setCellValue(log.getOperateContent());*/
        }
        book.write(out);
        book.close();

    }

}
