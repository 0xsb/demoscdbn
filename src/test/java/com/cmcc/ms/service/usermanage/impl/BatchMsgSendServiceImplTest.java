package com.cmcc.ms.service.usermanage.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import junit.framework.Assert;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.usermanage.UsrManageBatchMessageWithBLOBs;
import com.cmcc.ms.service.BaseTestCase;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * @author zhangxu-ws
 */
public class BatchMsgSendServiceImplTest extends BaseTestCase {
    @Autowired
    private BatchMsgSendServiceImpl batchMsgSendServiceImpl;

    /**
     * Run the int deleteUsrManageBatchMessageWithBLOBsById(HashMap<String,Object>) method test.
     *
     * @throws Exception
     */
    @Test
    @Rollback
    public void deleteUsrManageBatchMessageWithBLOBsByIdTest() throws Exception {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("recordId", 1);
        int i = batchMsgSendServiceImpl.deleteUsrManageBatchMessageWithBLOBsById(hm);
        Assert.assertTrue(i > 0);
    }

    /**
     * Run the int saveUserOperation(UsrManageBatchMessageWithBLOBs) method test.
     *
     * @throws Exception
     */
    @Test
    @Rollback
    public void saveUserOperationTest() throws Exception {
        UsrManageBatchMessageWithBLOBs bloBs = new UsrManageBatchMessageWithBLOBs();
        bloBs.setOperateUserName("ldyldy");
        bloBs.setMsgStateCode(1);
        bloBs.setMsgStateName("已发送");
        bloBs.setMsgSendTime(new Date());
        bloBs.setReceiveNum(3);
        bloBs.setOperateTime(new Date());
        bloBs.setReceivePhoneDetail("18867105653");
        bloBs.setReceivePhoneNameDetail("18867105653:华茂");
        bloBs.setMsgContent("测试");
        int i = batchMsgSendServiceImpl.saveUserOperation(bloBs);
        Assert.assertTrue(i > 0);
    }

    /**
     * Run the UsrManageBatchMessageWithBLOBs getUsrManageBatchMessageById(HashMap<String, Object>) method test.
     *
     * @throws Exception
     */
    @Test
    public void getUsrManageBatchMessageByIdTest() throws Exception {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("recordId", 1);
        UsrManageBatchMessageWithBLOBs value = batchMsgSendServiceImpl
                .getUsrManageBatchMessageById(hm);
        Assert.assertNotNull(value);
    }

    /**
     * Run the XSSFWorkbook makeStandardTemplateExcel(HashMap<String, Object>) method test.
     *
     * @throws Exception
     */
    @Test
    public void makeStandardTemplateExcelTest() throws Exception {
        XSSFWorkbook value = batchMsgSendServiceImpl.makeStandardTemplateExcel();
        Assert.assertNotNull(value);
    }

    /**
     * Run the List<UsrManageBatchMessageWithBLOBs> getUsrManageBatchMsgList(PageBounds pb) method test.
     *
     * @throws Exception
     */
    @Test
    public void getUsrManageBatchMsgListTest() throws Exception {
        PageBounds pb = new PageBounds(1, 15);
        List<UsrManageBatchMessageWithBLOBs> list = batchMsgSendServiceImpl
                .getUsrManageBatchMsgList(pb);
        Assert.assertTrue(list.size() > 0);
    }
}
