package com.cmcc.ms.service.datashow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.datashow.BusinessTraffic;
import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author zhangxu-ws
 */
public class BusinessTrafficServiceTest extends BaseTestCase {

    @Autowired
    private BusinessTrafficService businessTrafficService;

    /**
     * Run the void insertBusinessTrafficList(List<BusinessTraffic>) method test.
     *
     * @throws Exception
     */
    @Test
    @Rollback
    public void insertBusinessTrafficListTest() throws Exception {
        BusinessTraffic t1 = new BusinessTraffic();
        t1.setBusiness("省际直连");
        BusinessTraffic t2 = new BusinessTraffic();
        t2.setBusiness("免费对等直连");
        BusinessTraffic t3 = new BusinessTraffic();
        t3.setBusiness("付费穿透");
        BusinessTraffic t4 = new BusinessTraffic();
        t4.setBusiness("国际公司客户");
        BusinessTraffic t5 = new BusinessTraffic();
        t5.setBusiness("国际公司客户");
        BusinessTraffic t6 = new BusinessTraffic();
        t5.setBusiness("付费对等直连");
        List<BusinessTraffic> list = new ArrayList<BusinessTraffic>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        businessTrafficService.insertBusinessTrafficList(list);
    }
}
