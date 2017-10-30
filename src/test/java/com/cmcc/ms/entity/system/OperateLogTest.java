/**
 * 
 */
package com.cmcc.ms.entity.system;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

/**
 * @author zhangxu-ws
 *
 */
public class OperateLogTest {
    /**
     * method test
     */
    @Test
    public void test() {
        //日誌測試
        OperateLog operateLog = new OperateLog();
        Date date = new Date();
        operateLog
                .setBrowser("Mozilla/5.0 （Windows NT 6.3; Win64; x64） AppleWebKit/537.36 （KHTML, like Gecko） Chrome/58.0.3029.81 Safari/537.36");
        operateLog.setId(Integer.valueOf(10037));
        operateLog.setIpAddr("127.0.0.1");
        operateLog.setOperateContent("adminadmin已登录");
        operateLog.setOperateTime(date);
        operateLog.setReceiveMsg("接受数据");
        operateLog.setSendMsg("发送操作的数据");
        operateLog.setSource("来源");
        operateLog.setType("类型");
        operateLog.setUserId(Integer.valueOf(2));
        assertNotNull(operateLog);
    }
}
