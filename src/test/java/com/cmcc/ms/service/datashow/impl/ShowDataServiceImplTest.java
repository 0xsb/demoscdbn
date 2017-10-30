package com.cmcc.ms.service.datashow.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.datashow.BaseData;
import com.cmcc.ms.entity.datashow.BaseDataExample;
import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author chenyouchao-yl
 */
public class ShowDataServiceImplTest extends BaseTestCase {

    @Autowired
    private ShowDataServiceImpl showDataServiceImpl;

    /**
     * Run the boolean deleteAll() method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void deleteAllTest() throws Exception {
        BaseDataExample dataExample = new BaseDataExample();
        dataExample.setDistinct(true);
        showDataServiceImpl.deleteAll();
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
        showDataServiceImpl.getBusinessTrafficList("");
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
        showDataServiceImpl.getOverallAnalysisList();
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
        BaseData bd1 = new BaseData();
        bd1.setDevName("dev1");
        bd1.setBandwidth(1024d);
        bd1.setTrafficin(1024d);
        bd1.setTrafficout(1024d);
        bd1.setDevIp("devip1");
        bd1.setPortName("port1");
        bd1.setPortType("1");
        bd1.setProvince("");
        bd1.setBusBig("");
        bd1.setBusSmall("");
        bd1.setPeerDevice("");
        BaseData bd2 = new BaseData();
        bd2.setDevName("dev2");
        bd2.setBandwidth(1024d);
        bd2.setTrafficin(1024d);
        bd2.setTrafficout(1024d);
        bd2.setDevIp("devip2");
        bd2.setPortName("port2");
        bd2.setPortType("2");
        bd2.setProvince("");
        bd2.setBusBig("");
        bd2.setBusSmall("");
        bd2.setPeerDevice("");
        BaseData bd3 = new BaseData();
        bd3.setDevName("dev3");
        bd3.setBandwidth(1024d);
        bd3.setTrafficin(1024d);
        bd3.setTrafficout(1024d);
        bd3.setDevIp("devip3");
        bd3.setPortName("port3");
        bd3.setPortType("3");
        bd3.setProvince("");
        bd3.setBusBig("");
        bd3.setBusSmall("");
        bd3.setPeerDevice("");
        List<BaseData> list = new ArrayList<BaseData>();
        list.add(bd1);
        list.add(bd2);
        list.add(bd3);
        showDataServiceImpl.insertBaseDataList(list);
    }
    /**
     * Run the Double selectSumTrafficin(String busBig) method test.
     */
    public void selectSumTrafficin() {
        String busBig="";
        showDataServiceImpl.selectSumTrafficin(busBig);
    }
}
