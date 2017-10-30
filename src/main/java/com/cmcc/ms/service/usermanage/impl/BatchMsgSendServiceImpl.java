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
package com.cmcc.ms.service.usermanage.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.atomikos.icatch.jta.UserTransactionManager;
import com.cmcc.ms.entity.usermanage.UsrManageBatchMessageWithBLOBs;
import com.cmcc.ms.mapper.UsrManageBatchMessageMapper;
import com.cmcc.ms.service.usermanage.BatchMsgSendService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


/**
 * The Class BatchMsgSendServiceImpl.
 *
 * @author huamao
 * @version 
 * @Type BatchMsgSendServiceImpl.java
 * @Desc 
 * @date 2016年11月7日 下午4:02:45
 */
@Service
public class BatchMsgSendServiceImpl implements BatchMsgSendService {

    /** The usr manage batch message mapper ms. */
    private UsrManageBatchMessageMapper usrManageBatchMessageMapperMs;

    /** The transaction manager. */
    // 事务
    @Resource(name = "atomikosTransactionManager")
    private UserTransactionManager transactionManager;

    /**
     * Sets the stat appunit data detail mapper ms.
     *
     * @param session the new stat appunit data detail mapper ms
     */
    @Resource(name = "sqlSessionCmcciwms")
    public void setStatAppunitDataDetailMapperMs(SqlSession session) {
        this.usrManageBatchMessageMapperMs = session.getMapper(UsrManageBatchMessageMapper.class);
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.usermanage.BatchMsgSendService#getUsrManageBatchMsgList(com.github.miemiedev.mybatis.paginator.domain.PageBounds)
     */
    @Override
    public List<UsrManageBatchMessageWithBLOBs> getUsrManageBatchMsgList(PageBounds pb) {

        List<UsrManageBatchMessageWithBLOBs> usrManageBatchMessageWithBLOBsList = usrManageBatchMessageMapperMs
                .getListForShow(pb);
        return usrManageBatchMessageWithBLOBsList;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.usermanage.BatchMsgSendService#saveUserOperation(com.cmcc.ms.entity.usermanage.UsrManageBatchMessageWithBLOBs)
     */
    @Override
    public int saveUserOperation(UsrManageBatchMessageWithBLOBs usrManageBatchMessageWithBLOBs) {

        int insertSelective = 0;
        try {
            transactionManager.begin();
            insertSelective = usrManageBatchMessageMapperMs
                    .insertSelective(usrManageBatchMessageWithBLOBs);
            transactionManager.commit();
        } catch (NotSupportedException | SystemException | SecurityException
                | IllegalStateException | HeuristicMixedException | HeuristicRollbackException
                | javax.transaction.RollbackException e) {
            e.printStackTrace();
            try {
                transactionManager.rollback();
            } catch (IllegalStateException | SecurityException | SystemException e1) {
                e1.printStackTrace();
            }
        }
        return insertSelective;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.usermanage.BatchMsgSendService#getUsrManageBatchMessageById(java.util.HashMap)
     */
    @Override
    public UsrManageBatchMessageWithBLOBs getUsrManageBatchMessageById(HashMap<String, Object> hm) {
        UsrManageBatchMessageWithBLOBs usrManageBatchMessageWithBLOBs = usrManageBatchMessageMapperMs
                .getUsrManageBatchMsgById(hm);
        return usrManageBatchMessageWithBLOBs;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.usermanage.BatchMsgSendService#deleteUsrManageBatchMessageWithBLOBsById(java.util.HashMap)
     */
    @Override
    public int deleteUsrManageBatchMessageWithBLOBsById(HashMap<String, Object> hm) {
        int deleteSelective = 0;
        try {
            transactionManager.begin();
            deleteSelective = usrManageBatchMessageMapperMs.updateUsrManageBatchMsgById(hm);
            transactionManager.commit();
        } catch (NotSupportedException | SystemException | SecurityException
                | IllegalStateException | HeuristicMixedException | HeuristicRollbackException
                | javax.transaction.RollbackException e) {
            e.printStackTrace();
            try {
                transactionManager.rollback();
            } catch (IllegalStateException | SecurityException | SystemException e1) {
                e1.printStackTrace();
            }
        }
        return deleteSelective;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.usermanage.BatchMsgSendService#makeStandardTemplateExcel()
     */
    @Override
    public XSSFWorkbook makeStandardTemplateExcel() {

        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();
        // 设置单元格格式
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 指定当单元格内容显示不下时自动换行
        cellStyle.setWrapText(true);
        // 单元格内容赋值
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("13800138000");
        cell.setCellStyle(cellStyle);
        sheet.autoSizeColumn(0);

        Cell cell2 = row.createCell(1);
        cell2.setCellValue("中国移动客服");
        cell2.setCellStyle(cellStyle);
        sheet.autoSizeColumn(1);

        Cell cell3 = row.createCell(2);
        cell3.setCellValue("模版说明：请参照A1 B1单元格的样式和内容填写模版，每行输入一个用户的信息，A列为用户手机号码，B列为用户姓名。 "
                + "注意：1 不要为excel设置行列标题。 2 从第一行第一列 A1 开始填写，"
                + "删除 1380013800和 中国移动客服，否则将会导入此号码。3 请不要重复多次输入同一个手机号，" + "将可能造成导入失败。");
        cell3.setCellStyle(cellStyle);
        sheet.autoSizeColumn(2);

        return wb;

    }

}
