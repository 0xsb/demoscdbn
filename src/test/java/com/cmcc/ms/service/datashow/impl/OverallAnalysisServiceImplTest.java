package com.cmcc.ms.service.datashow.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.datashow.OverallAnalysis;
import com.cmcc.ms.mapper.OverallAnalysisMapper;
import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author chenyouchao-yl
 */
public class OverallAnalysisServiceImplTest extends BaseTestCase {
    
    /** The overall analysis mapper. */
    @Autowired
    private OverallAnalysisMapper overallAnalysisMapper;
    
    @Autowired
    private OverallAnalysisServiceImpl overallAnalysisServiceImpl;

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
        overallAnalysisServiceImpl.insertOverAnalysisList(list);
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
        overallAnalysisServiceImpl.selectOAList();
        overallAnalysisServiceImpl.selectOAList();
    }
}
