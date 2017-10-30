package com.cmcc.ms.controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmcc.ms.entity.datamanager.LocalProvRate;
import com.cmcc.ms.entity.datamanager.LocalProvRateExtendDay;
import com.cmcc.ms.service.datashow.DataManagerService;

/**
 * 
 * @author chenyouchao-yl
 *	2017年10月17日下午5:07:10
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/proAnalysis")
public class ProAnalysisController {

    @Autowired
    DataManagerService dataManagerService;

    /**
     * Select by time.
     *
     * @param date the date
     * @param province the province
     * @return the JSON object
     */
    @RequestMapping("/selectByTime")
    @ResponseBody
    public JSONArray selectByTime(String date, String province) {
        JSONArray obj = new JSONArray();
        if (province != null) {
            if ("全国".equals(province)) {
                List<LocalProvRateExtendDay> list = dataManagerService.selectAllByDate(date);
                obj = JSONArray.fromObject(list);
            } else {
                List<LocalProvRate> list = dataManagerService.selectAll(date, province);
                obj = JSONArray.fromObject(list);
            }
        } else {
            obj = null;
        }
        return obj;
    }

}
