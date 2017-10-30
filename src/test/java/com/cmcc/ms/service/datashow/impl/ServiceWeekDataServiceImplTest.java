package com.cmcc.ms.service.datashow.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.datashow.IdcWeek;
import com.cmcc.ms.entity.datashow.ProvinceCacheWeek;
import com.cmcc.ms.entity.datashow.ProvinceOttWeek;
import com.cmcc.ms.entity.datashow.UnifiedCacheWeek;
import com.cmcc.ms.entity.datashow.UnifiedCdnWeek;
import com.cmcc.ms.service.BaseTestCase;

/**
 * @author chenyouchao-yl
 */
public class ServiceWeekDataServiceImplTest extends BaseTestCase {
    @Autowired
    private ServiceWeekDataServiceImpl serviceWeekDataServiceImpl;

    /**
     *Run the void addCDNList(List<UnifiedCdnDay>) method test.
     */
    @Test
    @Rollback
    public void addCDNListTest() throws Exception {

        UnifiedCdnWeek ucw = new UnifiedCdnWeek();
        ucw.setProvince("安徽");
        ucw.setTimestr("测试");
        ucw.setTrafficin(193.5);
        ucw.setTrafficout(32.88);
        ucw.setCreatetime(new Date());
        List<UnifiedCdnWeek> list = new ArrayList<UnifiedCdnWeek>();
        list.add(ucw);
        serviceWeekDataServiceImpl.addCDNList(list);

    }

    /**
     *Run the void addCDNList(List<UnifiedCdnDay>) method test.
     */
    @Test
    @Rollback
    public void addIDCiListTest() throws Exception {

        IdcWeek idw = new IdcWeek();
        idw.setProvince("安徽");
        idw.setTimestr("测试");
        idw.setTrafficin(884.64);
        idw.setTrafficout(119.67);
        idw.setCreatetime(new Date());
        List<IdcWeek> list = new ArrayList<IdcWeek>();
        list.add(idw);
        serviceWeekDataServiceImpl.addIDCiList(list);
        ;

    }

    /**
     *Run the void addOTTList(List<ProvinceOttWeek>) method test.
     */
    @Test
    @Rollback
    public void addOTTListTest() throws Exception {

        ProvinceOttWeek pow = new ProvinceOttWeek();
        pow.setProvince("安徽");
        pow.setTimestr("测试");
        pow.setTrafficin(884.64);
        pow.setTrafficout(119.67);
        pow.setCreatetime(new Date());
        List<ProvinceOttWeek> list = new ArrayList<ProvinceOttWeek>();
        list.add(pow);
        serviceWeekDataServiceImpl.addOTTList(list);
        ;

    }

    /**
     *Run the void addProvinceCacheList(List<ProvinceCacheWeek>) method test.
     */
    @Test
    @Rollback
    public void addProvinceCacheListTest() throws Exception {

        ProvinceCacheWeek pcw = new ProvinceCacheWeek();
        pcw.setProvince("安徽");
        pcw.setTimestr("测试");
        pcw.setTrafficin(17.61);
        pcw.setTrafficout(1.59);
        pcw.setCreatetime(new Date());
        List<ProvinceCacheWeek> list = new ArrayList<ProvinceCacheWeek>();
        list.add(pcw);
        serviceWeekDataServiceImpl.addProvinceCacheList(list);
        ;

    }

    /**
     *Run the void addProvinceCacheList(List<ProvinceCacheWeek>) method test.
     */
    @Test
    @Rollback
    public void addUnfiedCacheListTest() throws Exception {

        UnifiedCacheWeek ucw = new UnifiedCacheWeek();
        ucw.setProvince("安徽");
        ucw.setTimestr("测试");
        ucw.setTrafficin(43.88);
        ucw.setTrafficout(14.83);
        ucw.setCreatetime(new Date());
        List<UnifiedCacheWeek> list = new ArrayList<UnifiedCacheWeek>();
        list.add(ucw);
        serviceWeekDataServiceImpl.addUnfiedCacheList(list);
        ;

    }

    /**
     *Run the void findNewCDNList() method test.
     */
    @Test
    @Rollback
    public void findNewCDNListTest() throws Exception {
        serviceWeekDataServiceImpl.findNewCDNList(new Date());
    }

    /**
     *Run the void findNewIDCiList() method test.
     */
    @Test
    @Rollback
    public void findNewIDCiListTest() throws Exception {
        serviceWeekDataServiceImpl.findNewIDCiList(new Date());
    }

    /**
     *Run the void findNewOTTList() method test.
     */
    @Test
    @Rollback
    public void findNewOTTListTest() throws Exception {
        serviceWeekDataServiceImpl.findNewOTTList(new Date());
    }

    /**
     *Run the void findNewProvinceCacheList() method test.
     */
    @Test
    @Rollback
    public void findNewProvinceCacheListTest() throws Exception {
        serviceWeekDataServiceImpl.findNewProvinceCacheList(new Date());
    }

    /**
     *Run the void findNewUnfiedCacheList() method test.
     */
    @Test
    @Rollback
    public void findNewUnfiedCacheListTest() throws Exception {
        serviceWeekDataServiceImpl.findNewUnfiedCacheList(new Date());
    }

    /**
     *Run the void findNewUnfiedCacheList() method test.
     */
    @Test
    public void selectMaxCreatetimeTest() throws Exception {
        serviceWeekDataServiceImpl.selectMaxCreatetime();
    }
}
