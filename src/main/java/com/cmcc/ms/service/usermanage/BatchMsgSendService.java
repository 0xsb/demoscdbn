/*
 * Project: cmcciwms
 * 
 * File Created at 2016年11月7日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cmcc.ms.service.usermanage;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cmcc.ms.entity.usermanage.UsrManageBatchMessageWithBLOBs;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


/**
 * The Interface BatchMsgSendService.
 *
 * @author huamao
 * @version 
 * @Type BatchMsgSendService.java
 * @Desc 
 * @date 2016年11月7日 下午4:02:29
 */
public interface BatchMsgSendService {

    /**
     * Gets the usr manage batch msg list.
     *
     * @param pb the pb
     * @return the usr manage batch msg list
     */
    //获取群发列表
    List<UsrManageBatchMessageWithBLOBs> getUsrManageBatchMsgList(PageBounds pb);

    /**
     * Gets the usr manage batch message by id.
     *
     * @param hm the hm
     * @return the usr manage batch message by id
     */
    //根据id获取发送详情
    UsrManageBatchMessageWithBLOBs getUsrManageBatchMessageById(HashMap<String, Object> hm);

    /**
     * Save user operation.
     *
     * @param usrManageBatchMessageWithBLOBs the usr manage batch message with BLO bs
     * @return the int
     */
    // 记录操作
    int saveUserOperation(UsrManageBatchMessageWithBLOBs usrManageBatchMessageWithBLOBs);

    /**
     * Delete usr manage batch message with BLO bs by id.
     *
     * @param hm the hm
     * @return the int
     */
    // 删除短信(数据库更新 状态字段码  -100)
    int deleteUsrManageBatchMessageWithBLOBsById(HashMap<String, Object> hm);

    /**
     * Make standard template excel.
     *
     * @return the XSSF workbook
     */
    //标准模板excel
    public XSSFWorkbook makeStandardTemplateExcel();

}
