package com.cmcc.ms.service.datashow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.datashow.OverallAnalysis;
import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author zhangxu-ws
 */
public class OverallAnalysisServiceTest extends BaseTestCase {

    @Autowired
    private OverallAnalysisService overallAnalysisService;

    /**
     * Run the void insertOverAnalysisList(List<OverallAnalysis>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void insertOverAnalysisListTest() throws Exception {
        OverallAnalysis asl = new OverallAnalysis();
        asl.setName("省际直连");
        OverallAnalysis aml = new OverallAnalysis();
        aml.setName("免费对等直连");
        OverallAnalysis afl = new OverallAnalysis();
        afl.setName("付费穿透");
        OverallAnalysis agk = new OverallAnalysis();
        agk.setName("国际公司客户");
        OverallAnalysis afz = new OverallAnalysis();
        afz.setName("付费对等直连");
        List<OverallAnalysis> list = new ArrayList<OverallAnalysis>();
        list.add(asl);
        list.add(aml);
        list.add(agk);
        list.add(afz);
        list.add(afl);
        overallAnalysisService.insertOverAnalysisList(list);
    }

    /**
     * Run the void selectOAList() method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void selectOAListTest() throws Exception {
        overallAnalysisService.selectOAList();
    }
}
