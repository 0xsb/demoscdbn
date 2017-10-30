package com.cmcc.ms.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmcc.ms.common.utils.SessionUtils;
import com.cmcc.ms.common.utils.StringUtil;
import com.cmcc.ms.common.utils.TimeUtils;
import com.cmcc.ms.entity.query.AdminHistoryData;
import com.cmcc.ms.entity.query.AdminHistoryDataExample;
import com.cmcc.ms.entity.query.CustomQueryInfo;
import com.cmcc.ms.mapper.AdminHistoryDataMapper;
import com.cmcc.ms.service.system.impl.SysCustomQueryRecordServiceImpl;
import com.cmcc.ms.service.system.impl.SysCustomQueryServiceImpl;
import com.cmcc.ms.service.system.impl.SysExportServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 导出Controller.
 *
 * @author ldy
 */
@Controller
@RequestMapping(value = "/export")
public class ExportController extends BaseController {

    /** The admin history data mapper. */
    @Autowired
    private AdminHistoryDataMapper adminHistoryDataMapper;

    /** The sys export service impl. */
    @Autowired
    private SysExportServiceImpl sysExportServiceImpl;

    /** The sys custom query service impl. */
    @Autowired
    private SysCustomQueryServiceImpl sysCustomQueryServiceImpl;

    /** The sys custom query record service impl. */
    @Autowired
    private SysCustomQueryRecordServiceImpl sysCustomQueryRecordServiceImpl;

    /**
     * Export forsuper manager judge.
     *
     * @param request the request
     * @param response the response
     * @param queryName the query name
     * @param querySql the query sql
     * @return the string
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    @RequestMapping(value = "/exportForsuperManagerJudge", produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String exportForsuperManagerJudge(HttpServletRequest request,
                                             HttpServletResponse response, String queryName,
                                             String querySql) throws UnsupportedEncodingException {

        querySql = StringUtil.toDBC(querySql);
        String[] sqlArr = querySql.trim().split(";");
        String sqlFormatErr;
        String executeSqlErrInfo;
        String executeSqlNullInfo;
        LinkedList<LinkedHashMap<String, Object>> list = null;
        // 用于判断所有 验证和查询 过程中 是否有某个过程出错
        for (int i = 0; i < sqlArr.length; i++) {
            String trimSql = sqlArr[i].trim();
            // 格式判断
            if ("".equals(trimSql)) {
                sqlFormatErr = sqlArr[i] + "\r\n 错误:" + StringUtil.ILLEGAL_SQL_INFO;
                return sqlFormatErr;
            }
            // 判断sql只允许查询-true
            if (StringUtil.checkSqlForselect(trimSql)) {
                // 符合
                try {
                    list = sysCustomQueryServiceImpl.superManagerSelect(trimSql);
                    if (list.size() == 0) {
                        executeSqlNullInfo = "[第" + String.valueOf(i + 1) + "个查询结果集为空]";// 结果集为空时
                                                                                        // mybatis不能返回结果，因此有提示
                        return executeSqlNullInfo;
                    }
                } catch (Exception e) {
                    String[] executeSqlErrInfoArr = e.getMessage().trim().split("###");
                    executeSqlErrInfo = "[第" + String.valueOf(i + 1) + "个查询出错]"
                            + executeSqlErrInfoArr[1];
                    return StringUtil.xssCodeShow(executeSqlErrInfo);
                }
                // 不符合
            } else {
                return StringUtil.SELECT_WARN_INFO;
            }
        }

        return "ok";
    }

    /**
     * Export forsuper manager.
     *
     * @param request the request
     * @param response the response
     * @param queryName the query name
     * @param querySql the query sql
     * @param saveOrNot the save or not
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    @RequestMapping(value = "/exportForsuperManager")
    public void exportForsuperManager(HttpServletRequest request, HttpServletResponse response,
                                      String queryName, String querySql, String saveOrNot)
            throws UnsupportedEncodingException {

        List<LinkedList<LinkedHashMap<String, Object>>> allRecordList = new LinkedList<LinkedList<LinkedHashMap<String, Object>>>();
        querySql = StringUtil.toDBC(querySql);
        String[] sqlArr = querySql.trim().split(";");
        LinkedList<LinkedHashMap<String, Object>> list = null;
        for (int i = 0; i < sqlArr.length; i++) {
            String trimSql = sqlArr[i].trim();
            list = sysCustomQueryServiceImpl.superManagerSelect(trimSql);
            allRecordList.add(list);
        }
        XSSFWorkbook wb = sysExportServiceImpl.makeExcelForSuperManager(allRecordList, null);
        String fileName = "excel文件";
        try {
            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                fileName = fileName.replaceAll(" ", "");
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器下载
            } else {
                fileName = URLEncoder.encode(fileName, "utf-8");// 谷歌或者其他浏览器的下载
            }
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        OutputStream ouputStream;
        try {
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 判断并保存记录
        CustomQueryInfo customQueryInfo = new CustomQueryInfo();
        customQueryInfo.setQueryName(queryName);
        customQueryInfo.setQuerySql(querySql);
        customQueryInfo.setCreateTime(TimeUtils.getSysCurrentTime());
        // session中获取
        customQueryInfo.setUserId(Integer.parseInt(SessionUtils.getAttribute(request, "userid")
                .toString()));
        // 保存该查询记录
        if ("save".equals(saveOrNot)) {
            sysCustomQueryRecordServiceImpl.saveCustomQueryRecord(customQueryInfo);
        }
    }

    /**
     * Custom query list.
     *
     * @param pageSize the page size
     * @param pageNum the page num
     * @return the JSON object
     */
    @RequestMapping(value = "/customQueryList")
    @ResponseBody
    public JSONObject customQueryList(String pageSize, String pageNum) {
        if (pageSize == null || "".equals(pageNum)) {
            pageNum = "1";
        }
        pageSize = "20";
        JSONObject cjo = new JSONObject();
        PageBounds pb = new PageBounds(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        // 将custom_query表中信息按照分页查询出来
        List<CustomQueryInfo> list = sysCustomQueryRecordServiceImpl.getAllCustomQueryRecord(pb);
        int listSize = sysCustomQueryRecordServiceImpl.getCustomQueryRecordSize();
        int totalPages = (listSize + Integer.parseInt(pageSize) - 1) / Integer.parseInt(pageSize);
        try {
            cjo.put("totalPages", totalPages);
            cjo.put("pageNum", pageNum);
            cjo.put("CustomQueryList", list);
            //Object opt = cjo.opt("CustomQueryList");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cjo;

    }

    /**
     * 历史数据.
     *
     * @param pageSize the page size
     * @param pageNum the page num
     * @return the JSON object
     */
    @RequestMapping(value = "/adminHistoryData")
    @ResponseBody
    public JSONObject adminHistoryData(String pageSize, String pageNum) {

        if (pageSize == null || "".equals(pageNum)) {
            pageNum = "1";
        }
        pageSize = "20";
        JSONObject ajo = new JSONObject();
        AdminHistoryDataExample adminHistoryDataExample = new AdminHistoryDataExample();
        adminHistoryDataExample.setOrderByClause("UPADATE_TIME DESC");
        List<AdminHistoryData> adminHistoryDataList = adminHistoryDataMapper.selectByExample(
                adminHistoryDataExample,
                new PageBounds(new Integer(pageNum), new Integer(pageSize)));

        PageList<AdminHistoryData> pageList = (PageList<AdminHistoryData>) adminHistoryDataList;
        int listSize = pageList.getPaginator().getTotalCount();
        int totalPages = (listSize + Integer.parseInt(pageSize) - 1) / Integer.parseInt(pageSize);

        try {
            ajo.put("adminHistoryDataList", adminHistoryDataList);
            ajo.put("totalPages", totalPages);
            ajo.put("pageNum", pageNum);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ajo;

    }

}
