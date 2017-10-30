package com.cmcc.ms.service.datashow.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.datashow.MapData;
import com.cmcc.ms.service.BaseTestCase;

/**
 * @author zhangxu-ws
 */
public class MapDataServiceImplTest extends BaseTestCase {
    @Autowired
    private MapDataServiceImpl mapDataServiceImpl;

    /**
     * Run the addMapDataiList() method test.
     *
     */
    @Test
    @Rollback
    public void addMapDataiListTest() {
        MapData data = new MapData();
        data.setIdc(884.64);
        data.setpCache(17.61);
        data.setpOtt(406.39);
        data.setProvince("安徽");
        data.setTimestr("测试");
        data.setuCache(43.88);
        data.setuCdn(193.5);
        data.setCreatetime(new Date());
        List<MapData> list = new ArrayList<MapData>();
        list.add(data);
        mapDataServiceImpl.addMapDataiList(list);
    }

    /**
     * Run the findMapDataByTime(Date date) method test.
     *
     */
    /*@Test
    @Rollback
    public void findMapDataByTimeTest(){
        mapDataServiceImpl.findMapDataByTime(new Date());
    }*/
    /**
     * Run the selectMaxCreatetime() method test.
     *
     */
    @Test
    @Rollback
    public void selectMaxCreatetimeTest() {
        mapDataServiceImpl.selectMaxCreatetime();
    }
}
