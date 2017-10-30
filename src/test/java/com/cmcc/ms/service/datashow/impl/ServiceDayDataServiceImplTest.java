package com.cmcc.ms.service.datashow.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.datashow.IdcDay;
import com.cmcc.ms.entity.datashow.ProvinceCacheDay;
import com.cmcc.ms.entity.datashow.ProvinceOttDay;
import com.cmcc.ms.entity.datashow.UnifiedCacheDay;
import com.cmcc.ms.entity.datashow.UnifiedCdnDay;
import com.cmcc.ms.service.BaseTestCase;

/**
 * @author chenyouchao-yl
 */
public class ServiceDayDataServiceImplTest extends BaseTestCase {
    @Autowired
    private ServiceDayDataServiceImpl serviceDayDataServiceImpl;

    /**
     * Run the void addCDNList(List<UnifiedCdnDay>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void addCDNListTest() throws Exception {
        UnifiedCdnDay cdnDay = new UnifiedCdnDay();
        cdnDay.setProvince("安徽");
        cdnDay.setTimestr("测试");
        cdnDay.setTrafficin(193.5);
        cdnDay.setTrafficout(32.88);
        cdnDay.setCreatetime(new Date());
        List<UnifiedCdnDay> list = new ArrayList<UnifiedCdnDay>();
        list.add(cdnDay);
        serviceDayDataServiceImpl.addCDNList(list);
    }

    /**
     * Run the void addIDCiList(List<IdcDay>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void addIDCiListTest() throws Exception {
        IdcDay idcDay = new IdcDay();
        idcDay.setProvince("安徽");
        idcDay.setTimestr("测试");
        idcDay.setTrafficin(884.64);
        idcDay.setTrafficout(119.67);
        idcDay.setCreatetime(new Date());
        List<IdcDay> list = new ArrayList<IdcDay>();
        list.add(idcDay);
        serviceDayDataServiceImpl.addIDCiList(list);
    }

    /**
     * Run the void addOTTList(List<ProvinceOttDay>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void addOTTListTest() throws Exception {
        ProvinceOttDay pod = new ProvinceOttDay();
        pod.setProvince("安徽");
        pod.setTimestr("测试");
        pod.setTrafficin(84.64);
        pod.setTrafficout(19.67);
        pod.setCreatetime(new Date());
        List<ProvinceOttDay> list = new ArrayList<ProvinceOttDay>();
        list.add(pod);
        serviceDayDataServiceImpl.addOTTList(list);
    }

    /**
     * Run the void addProvinceCacheList(List<ProvinceCacheDay>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void addProvinceCacheListTest() throws Exception {
        ProvinceCacheDay pcd = new ProvinceCacheDay();
        pcd.setProvince("安徽");
        pcd.setTimestr("测试");
        pcd.setTrafficin(84.64);
        pcd.setTrafficout(11.67);
        pcd.setCreatetime(new Date());
        List<ProvinceCacheDay> list = new ArrayList<ProvinceCacheDay>();
        list.add(pcd);
        serviceDayDataServiceImpl.addProvinceCacheList(list);
    }

    /**
     * Run the void addUnfiedCacheList(List<UnifiedCacheDay>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void addUnfiedCacheListTest() throws Exception {
        UnifiedCacheDay ucd = new UnifiedCacheDay();
        ucd.setProvince("安徽");
        ucd.setTimestr("测试");
        ucd.setTrafficin(43.88);
        ucd.setTrafficout(14.83);
        ucd.setCreatetime(new Date());
        List<UnifiedCacheDay> list = new ArrayList<UnifiedCacheDay>();
        list.add(ucd);
        serviceDayDataServiceImpl.addUnfiedCacheList(list);
        ;
    }

    /**
     * Run the void findNewCDNList(Date) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void findNewCDNListTest() throws Exception {
        serviceDayDataServiceImpl.findNewCDNList(new Date());
    }

    /**
     * Run the void findNewIDCiList(Date) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void findNewIDCiListTest() throws Exception {
        serviceDayDataServiceImpl.findNewIDCiList(new Date());
    }

    /**
     * Run the void findNewOTTList(Date) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void findNewOTTListTest() throws Exception {
        serviceDayDataServiceImpl.findNewOTTList(new Date());
    }

    /**
     * Run the void findNewProvinceCacheList(Date) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void findNewProvinceCacheListTest() throws Exception {
        serviceDayDataServiceImpl.findNewProvinceCacheList(new Date());
    }

    /**
     * Run the void findNewUnfiedCacheList(Date) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void findNewUnfiedCacheListTest() throws Exception {
        serviceDayDataServiceImpl.findNewUnfiedCacheList(new Date());
    }

    /**
     * Run the void findNewUnfiedCacheList(Date) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void selectMaxCreatetimeTest() throws Exception {
        serviceDayDataServiceImpl.selectMaxCreatetime();
    }
}
