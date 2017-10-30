package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cmcc.ms.entity.datashow.OverallAnalysisExample.Criteria;
import com.cmcc.ms.entity.datashow.OverallAnalysisExample.Criterion;

/**
 * @author zhangxu-ws
 */
public class OverallAnalysisExampleTest {
    /**
     * Run the OverallAnalysisExample() constructor test.
     *
     * @throws Exception
     *
     */
    @Test
    public void test() {
        OverallAnalysisExample overallAnalysisExample = new OverallAnalysisExample();
        Criteria createCriteria = overallAnalysisExample.createCriteria();
        String nu = "";
        Integer in=1;
        Double du= 0d;
        ArrayList<Integer> listInteger = new ArrayList<Integer>();
        listInteger.add(in);
        overallAnalysisExample.setOrderByClause(nu);
        overallAnalysisExample.getOrderByClause();
        overallAnalysisExample.isDistinct();
        overallAnalysisExample.setDistinct(false);
        overallAnalysisExample.or(createCriteria);
        overallAnalysisExample.getOredCriteria();
        overallAnalysisExample.or();
        overallAnalysisExample.clear();
        List<Date> listDate = new ArrayList<Date>();
        listDate.add(new Date());
        createCriteria.andIdNotIn(new ArrayList<Integer>());
        createCriteria.getCriteria();
        createCriteria.andIdBetween(0,0);
        createCriteria.andIdIsNull();
        createCriteria.andIdEqualTo(0);
        createCriteria.andIdIn(new ArrayList<Integer>());
        createCriteria.andTimestrIn(new ArrayList<String>());
        createCriteria.andIdNotEqualTo(0);
        createCriteria.andIdNotBetween(0,0);
        createCriteria.getAllCriteria();
        createCriteria.andNameNotLike(nu);
        createCriteria.andTrafficinsNotBetween(du, du);
        createCriteria.andTrafficinsBetween(du, du);
        createCriteria.andNameIsNotNull();
        createCriteria.andNameEqualTo(nu);
        createCriteria.andTrafficinsIn(new ArrayList<Double>());
        createCriteria.andTrafficinsIsNull();
        createCriteria.andIdGreaterThan(0);
        createCriteria.andIdIsNull();
        createCriteria.andIdIsNotNull();
        createCriteria.andNameNotIn(new ArrayList<String>());
        createCriteria.andTrafficinsNotIn(new ArrayList<Double>());
        createCriteria.andNameLike(nu);
        createCriteria.andIdLessThan(0);
        createCriteria.andNameBetween(nu,nu);
        createCriteria.andTrafficinsNotIn(new ArrayList<Double>());
        createCriteria.andTrafficinsNotEqualTo(du);
        createCriteria.andNameNotBetween(nu,nu);
        createCriteria.andIdNotBetween(in, in);
        createCriteria.andTimestrIsNotNull();
        createCriteria.andTrafficinsIsNotNull();
        createCriteria.andNameNotEqualTo(nu);
        createCriteria.andIdNotEqualTo(in);
        createCriteria.andIdLessThanOrEqualTo(0);
        createCriteria.andTrafficinsLessThanOrEqualTo(du);
        createCriteria.andIdGreaterThanOrEqualTo(0);
        createCriteria.andTrafficinsGreaterThan(du);
        createCriteria.andTrafficinsGreaterThanOrEqualTo(du);
        createCriteria.andTimestrLessThanOrEqualTo(nu);
        createCriteria.andTimestrGreaterThan(nu);
        createCriteria.andTimestrGreaterThanOrEqualTo(nu);
        createCriteria.andTimestrNotLike(nu);
        createCriteria.andTimestrIsNotNull();
        createCriteria.andTimestrLike(nu);
        createCriteria.andTimestrLessThan(nu);
        createCriteria.andTimestrNotEqualTo(nu);
        createCriteria.andTimestrNotBetween(nu,nu);
        createCriteria.andTimestrNotIn(new ArrayList<String>());
        createCriteria.andTimestrIsNull();
        createCriteria.andTimestrBetween(nu,nu);
        createCriteria.isValid();
        createCriteria.andTimestrEqualTo(nu);
        createCriteria.andNameLessThanOrEqualTo(nu);
        createCriteria.andNameLessThan(nu);
        createCriteria.andNameGreaterThanOrEqualTo(nu);
        createCriteria.andNameGreaterThan(nu);
        createCriteria.andNameIsNull();
        createCriteria.addCriterionForJDBCDate(nu, listDate, nu);
        createCriteria.addCriterionForJDBCDate(nu, new Date(), nu);
        createCriteria.addCriterionForJDBCDate(nu, new Date(), new Date(), nu);
        createCriteria.andNameIn(new ArrayList<String>());
        createCriteria.andPortsIsNull();
        createCriteria.andPortsIsNotNull();
        createCriteria.andPortsEqualTo(in);
        createCriteria.andPortsNotEqualTo(in);
        createCriteria.andPortsGreaterThan(in);
        createCriteria.andPortsGreaterThanOrEqualTo(in);
        createCriteria.andPortsLessThan(in);
        createCriteria.andPortsLessThanOrEqualTo(in);
        createCriteria.andPortsIn(listInteger);
        createCriteria.andPortsNotIn(listInteger);
        createCriteria.andPortsBetween(in, in);
        createCriteria.andBandwidthIsNull();
        createCriteria.andBandwidthIsNotNull();
        createCriteria.andBandwidthEqualTo(du);
        createCriteria.andBandwidthNotEqualTo(du);
        createCriteria.andBandwidthGreaterThan(du);
        createCriteria.andBandwidthGreaterThanOrEqualTo(du);
        createCriteria.andBandwidthLessThan(du);
        createCriteria.andBandwidthLessThanOrEqualTo(du);
        createCriteria.andBandwidthIn(new ArrayList<Double>());
        createCriteria.andBandwidthNotIn(new ArrayList<Double>());
        createCriteria.andBandwidthBetween(du, du);
        createCriteria.andBandwidthNotBetween(du, du);
        createCriteria.andTrafficinsEqualTo(du);
        createCriteria.andTrafficinsLessThan(du);
        createCriteria.andTrafficoutsIsNull();
        createCriteria.andTrafficoutsIsNotNull();
        createCriteria.andTrafficoutsEqualTo(du);
        createCriteria.andTrafficoutsNotEqualTo(du);
        createCriteria.andTrafficoutsGreaterThan(du);
        createCriteria.andTrafficoutsGreaterThanOrEqualTo(du);
        createCriteria.andTrafficoutsLessThan(du);
        createCriteria.andTrafficoutsLessThanOrEqualTo(du);
        createCriteria.andTrafficoutsIn(new ArrayList<Double>());
        createCriteria.andTrafficoutsNotIn(new ArrayList<Double>());
        createCriteria.andTrafficoutsBetween(du, du);
        createCriteria.andTrafficoutsNotBetween(du, du);
        createCriteria.andCreattimeIsNull();
        createCriteria.andCreattimeIsNotNull();
        createCriteria.andCreattimeEqualTo(new Date());
        createCriteria.andCreattimeNotEqualTo(new Date());
        createCriteria.andCreattimeGreaterThan(new Date());
        createCriteria.andCreattimeGreaterThanOrEqualTo(new Date());
        createCriteria.andCreattimeLessThan(new Date());
        createCriteria.andCreattimeLessThanOrEqualTo(new Date());
        createCriteria.andCreattimeIn(listDate);
        createCriteria.andCreattimeNotIn(listDate);
        createCriteria.andCreattimeBetween(new Date(), new Date());
        createCriteria.andCreattimeNotBetween(new Date(), new Date());
        
        Criterion criterion = new  com.cmcc.ms.entity.datashow.OverallAnalysisExample.Criterion("");
        criterion.getCondition();
        criterion.getTypeHandler();
        criterion.isNoValue();
        criterion.isListValue();
        criterion.isSingleValue();
        criterion.isBetweenValue();
        criterion.getSecondValue();
        criterion.getValue();
    }
    
    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(OverallAnalysisExampleTest.class);
    }
}
