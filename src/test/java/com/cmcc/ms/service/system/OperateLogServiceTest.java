package com.cmcc.ms.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmcc.ms.entity.system.OperateLog;
import com.cmcc.ms.service.BaseTestCase;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 *
 * @author zhangxu-ws
 */
public class OperateLogServiceTest extends BaseTestCase {
    @Autowired
    private OperateLogService operateLogService;

    /**
     * method fuzzyQueryByNameTest
     */
    @Test
    public void fuzzyQueryByNameTest() {
        PageBounds pb = new PageBounds(1, 15);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "ldyldy");
        map.put("beginTimesg", "1997-01-01");
        map.put("endTimesg", "2027-01-01");
        List<OperateLog> fuzzyQueryByName = operateLogService.fuzzyQueryByName(map, pb);
        Assert.assertTrue(fuzzyQueryByName.size() > 0);
    }

    /**
     * method getFuzzyQuerySizeTest
     */
    @Test
    public void getFuzzyQuerySizeTest() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "ldyldy");
        int fuzzyQuerySize = operateLogService.getFuzzyQuerySize(map);
        Assert.assertTrue(fuzzyQuerySize > 0);
    }
}
