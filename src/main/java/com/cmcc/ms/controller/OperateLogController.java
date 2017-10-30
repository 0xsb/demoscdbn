package com.cmcc.ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmcc.ms.common.utils.Excel2JsonUtil;
import com.cmcc.ms.entity.system.OperateLog;
import com.cmcc.ms.service.system.impl.OperateLogServiceImpl;
import com.cmcc.ms.service.system.impl.SysExportServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * The Class OperateLogController.
 *
 * @author ldy
 */
@Controller
@RequestMapping(value = "/operateLog")
public class OperateLogController extends BaseController {

    /** The operate log service impl. */
    @Autowired
    private OperateLogServiceImpl operateLogServiceImpl;

    /** The sys export service impl. */
    @Autowired
    private SysExportServiceImpl sysExportServiceImpl;

    /*@Autowired
    private SysUsersService sysUsersService;*/

    /**
     *  统一 查询.
     *
     * @param pageSize the page size
     * @param pageNum the page num
     * @param userName the user name
     * @param beginTime the begin time
     * @param endTime the end time
     * @param source the source
     * @param result the result
     * @param type the type
     * @return the JSON object
     */
    @RequestMapping(value = "/showLogList")
    @ResponseBody
    public JSONObject showOperateLogList(String pageSize, String pageNum, String userName,
                                         @RequestParam(value = "beginTime") String beginTime,
                                         @RequestParam(value = "endTime") String endTime,
                                         @RequestParam(value = "source") String source,
                                         @RequestParam(value = "result") String result,
                                         @RequestParam(value = "type") String type) {
        if ("".equals(pageNum.trim())) {
            pageNum = "1";
        }
        pageSize = "50";
        // ModelAndView mv = new ModelAndView();
        JSONObject jo = new JSONObject();
        PageBounds pb = new PageBounds(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", userName);
        map.put("beginTimesg", beginTime);
        map.put("endTimesg", endTime);
        if (type != null && !"".equals(type)) {
            map.put("type", type);
        }
        if (source != null && !"".equals(source)) {
            map.put("source", source);
        }
        if (result != null && !"".equals(result)) {
            map.put("result", result);
        }
        // 将custom_query表中信息按照分页查询出来
        List<OperateLog> operateLoglist = operateLogServiceImpl.fuzzyQueryByName(map, pb);
        for (int i = 0; i < operateLoglist.size(); i++) {
            OperateLog operateLog = operateLoglist.get(i);
            String oct = operateLog.getOperateContent();
            String[] otcs = oct.split("\\|");
            for (int j = 0; j < otcs.length; j++) {
                if (otcs.length >= 3) {
                    operateLog.setType(otcs[0]);//type
                    operateLog.setSource(otcs[1]);//source
                    operateLog.setResult(otcs[2]);//result
                }

            }
        }
        PageList<OperateLog> operateLoglistPage = (PageList<OperateLog>) operateLoglist;
        int allRecordNumber = operateLoglistPage.getPaginator().getTotalCount();
        int totalPages = (allRecordNumber + Integer.parseInt(pageSize) - 1)
                / Integer.parseInt(pageSize);
        jo.put("allRecordNumber", allRecordNumber);
        jo.put("totalPages", totalPages);
        jo.put("pageNum", pageNum);
        jo.put("userName", userName);
        jo.put("OperateLogList", operateLoglist);
        return jo;
    }

    /**
     * 清空后查询的数据
     *  totalPages 总页数
     *  allRecordNumber 总条数
     *  pageSize 每页条数
     *  currentPage 当前页
     *  userName 用户名
     *  model
     *  operateLoglist 日志.
     *
     * @param pageSize the page size
     * @param currentPage the current page
     * @param model the model
     * @param request the request
     * @return the string
     */
    @RequestMapping(value = "/clearToNull")
    public String clearToNull(Integer pageSize, Integer currentPage, Model model,
                              HttpServletRequest request) {
        if ("".equals(currentPage.toString())) {
            currentPage = 1;
        }
        pageSize = 15;

        PageBounds pb = new PageBounds(currentPage, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        List<OperateLog> operateLoglist = operateLogServiceImpl.fuzzyQueryByName(map, pb);
        int allRecordNumber = operateLogServiceImpl.getFuzzyQuerySize(map);
        double tot = allRecordNumber / (double) pageSize;
        int totalPages = (int) Math.ceil(tot);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("allRecordNumber", allRecordNumber);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("OperateLogList", operateLoglist);
        /*HttpSession session = request.getSession();
        session.setAttribute("OperateLogList", operateLoglist);*/
        /*JSONArray json = new JSONArray();
        json.put(operateLoglist);
        session.setAttribute("jsonOperateLog", json);;*/
        return "index";
    }

    /**
     * 下载检索结果文件.
     *
     * @author Administrator
     * @param pageSize the page size
     * @param pageNum the page num
     * @param userName the user name
     * @param beginTime the begin time
     * @param endTime the end time
     * @param source the source
     * @param result the result
     * @param type the type
     * @param request the request
     * @param response the response
     * @throws Exception the exception
     */
    @RequestMapping(value = "/exportLogList")
    public void downloadToSearch(String pageSize, String pageNum, String userName,
                                 @RequestParam(value = "beginTime") String beginTime,
                                 @RequestParam(value = "endTime") String endTime,
                                 @RequestParam(value = "source") String source,
                                 @RequestParam(value = "result") String result,
                                 @RequestParam(value = "type") String type,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String fileName = "日志";
        response.setContentType("application/x-xls;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + new String((fileName + ".xls").getBytes(), "ISO8859-1"));

        //获取日志集
        JSONObject logsList = showOperateLogList(pageSize, pageNum, userName, beginTime, endTime,
                source, result, type);
        JSONArray optList = (JSONArray) logsList.opt("OperateLogList");

        ServletOutputStream out = response.getOutputStream();
        sysExportServiceImpl.doExport(optList, out, Excel2JsonUtil.mapLogsexp, fileName);
    }
}
