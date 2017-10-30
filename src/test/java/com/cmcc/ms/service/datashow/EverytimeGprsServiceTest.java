package com.cmcc.ms.service.datashow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.datashow.EverytimeGprs;
import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author zhangxu-ws
 */
public class EverytimeGprsServiceTest extends BaseTestCase {

    @Autowired
    private EverytimeGprsService everytimeGprsService;

    /**
     * Run the void insertEverytimeList(List<EverytimeGprs>) method test.
     *
     * @throws Exception
     */
    @Test
    @Rollback
    public void insertEverytimeListTest() throws Exception {
        EverytimeGprs gprs = new EverytimeGprs();
        gprs.setAiqiy(0.13306741214175);
        gprs.setAlibaba(0.11507196934687522);
        gprs.setBaidu(0.00046171974329170003);
        gprs.setJinshan(0.025667859009499902);
        gprs.setLeshi(0.0);
        gprs.setMangguo(0.02);
        gprs.setSouhu(0.0010075742927916);
        gprs.setTengxun(0.02);
        gprs.setTime("01:00:00");
        gprs.setXinlang(0.010309419433);
        gprs.setYoukutudou(0.0333626495540001);
        List<EverytimeGprs> list = new ArrayList<EverytimeGprs>();
        list.add(gprs);
        everytimeGprsService.insertEverytimeList(list);
    }

    /**
     * Run the void selectAll() method test.
     *
     * @throws Exception
     */
    @Test
    @Rollback
    public void selectAllTest() throws Exception {
        everytimeGprsService.selectAll();
    }
}
