package com.cmcc.ms.service.datashow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.datashow.BaseData;
import com.cmcc.ms.service.BaseTestCase;

/**
 * @author zhangxu-ws
 */
public class ShowDataServiceTest extends BaseTestCase {

    @Autowired
    private ShowDataService showDataService;

    /**
     * Run the boolean deleteAll() method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void deleteAllTest() throws Exception {
        //showDataService.deleteAll();
    }

    /**
     * Run the boolean getBusinessTrafficList(String busBig) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void getBusinessTrafficListTest() throws Exception {
        
        showDataService.getBusinessTrafficList("");
    }

    /**
     * Run the boolean getBusinessTrafficList(String busBig) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void getOverallAnalysisListTest() throws Exception {
        showDataService.getOverallAnalysisList();
    }

    /**
     * Run the boolean getBusinessTrafficList(String busBig) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void insertBaseDataListTest() throws Exception {
        BaseData baseData = new BaseData();
        baseData.setDevName("测试");
        List<BaseData> list = new ArrayList<BaseData>();
        showDataService.insertBaseDataList(list);
    }
}
