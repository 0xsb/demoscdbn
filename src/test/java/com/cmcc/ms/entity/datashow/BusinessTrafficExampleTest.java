package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cmcc.ms.entity.datashow.BusinessTrafficExample.Criteria;
import com.cmcc.ms.entity.datashow.BusinessTrafficExample.Criterion;

/**
 *
 * @author zhangxu-ws
 */
public class BusinessTrafficExampleTest {
    /**
     * Run the BusinessTrafficExample() constructor test.
     *
     * @throws Exception
     *
     */
    @Test
    public void test() {
        BusinessTrafficExample businessTrafficExample = new BusinessTrafficExample();
        Criteria createCriteria = businessTrafficExample.createCriteria();
        String nu = "";
        Integer in=1;
        Double du= 0d;
        businessTrafficExample.setOrderByClause(nu);
        businessTrafficExample.getOrderByClause();
        businessTrafficExample.isDistinct();
        businessTrafficExample.setDistinct(false);
        businessTrafficExample.or(createCriteria);
        businessTrafficExample.getOredCriteria();
        businessTrafficExample.or();
        businessTrafficExample.clear();
        List<Date> list = new ArrayList<Date>();
        list.add(new Date());
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
        createCriteria.andTrafficinNotBetween(0d,0d);
        createCriteria.andTrafficinBetween(0d,0d);
        createCriteria.andNameIsNotNull();
        createCriteria.andNameEqualTo(nu);
        createCriteria.andTrafficinIn(new ArrayList<Double>());
        createCriteria.andTrafficinIsNull();
        createCriteria.andIdGreaterThan(0);
        createCriteria.andBusinessLessThan(nu);
        createCriteria.andIdIsNull();
        createCriteria.andTrafficinEqualTo(0d);
        createCriteria.andIdIsNotNull();
        createCriteria.andNameNotIn(new ArrayList<String>());
        createCriteria.andTrafficinNotIn(new ArrayList<Double>());
        createCriteria.andNameLike(nu);
        createCriteria.andIdLessThan(0);
        createCriteria.andNameBetween(nu,nu);
        createCriteria.andTrafficinNotIn(new ArrayList<Double>());
        createCriteria.andCreatetimeEqualTo(new Date());
        createCriteria.andTrafficinNotEqualTo(0d);
        createCriteria.andCreatetimeGreaterThan(new Date());
        createCriteria.andNameNotBetween(nu,nu);
        createCriteria.andIdNotBetween(in, in);
        createCriteria.andTimestrIsNotNull();
        createCriteria.andTrafficinIsNotNull();
        createCriteria.andNameNotEqualTo(nu);
        createCriteria.andIdNotEqualTo(in);
        createCriteria.andIdLessThanOrEqualTo(0);
        createCriteria.andTrafficinLessThanOrEqualTo(0d);
        createCriteria.andIdGreaterThanOrEqualTo(0);
        createCriteria.andTrafficinGreaterThan(0d);
        createCriteria.andTimestrLessThanOrEqualTo(nu);
        createCriteria.andTimestrGreaterThan(nu);
        createCriteria.andCreatetimeGreaterThan(new Date());
        createCriteria.andCreatetimeNotBetween(new Date(),new Date());
        createCriteria.andCreatetimeLessThan(new Date());
        createCriteria.andTrafficinGreaterThanOrEqualTo(0d);
        createCriteria.andBusinessGreaterThanOrEqualTo(nu);
        createCriteria.andBusinessLessThanOrEqualTo(nu);
        createCriteria.andBusinessBetween(nu, nu);
        createCriteria.andBusinessEqualTo(nu);
        createCriteria.andBusinessGreaterThan(nu);
        createCriteria.andTimestrGreaterThanOrEqualTo(nu);
        createCriteria.andBusinessIn(new ArrayList<String>());
        createCriteria.andBusinessIsNotNull();
        createCriteria.andBusinessIsNull();
        createCriteria.andBusinessLike(nu);
        createCriteria.andBusinessNotBetween(nu, nu);
        createCriteria.andBusinessNotEqualTo(nu);
        createCriteria.andBusinessNotIn(new ArrayList<String>());
        createCriteria.andBusinessNotLike(nu);
        createCriteria.andCreatetimeLessThanOrEqualTo(new Date());
        createCriteria.andCreatetimeGreaterThanOrEqualTo(new Date());
        createCriteria.andTimestrNotLike(nu);
        createCriteria.andTimestrIsNotNull();
        createCriteria.andTimestrLike(nu);
        createCriteria.andTimestrLessThan(nu);
        createCriteria.andCreatetimeIsNull();
        createCriteria.andTimestrNotEqualTo(nu);
        createCriteria.andTimestrNotBetween(nu,nu);
        createCriteria.andTimestrNotIn(new ArrayList<String>());
        createCriteria.andCreatetimeBetween(new Date(),new Date());
        createCriteria.andTimestrIsNull();
        createCriteria.andTimestrBetween(nu,nu);
        createCriteria.isValid();
        createCriteria.andTrafficinLessThan(du);
        createCriteria.andTrafficinNotIn(new ArrayList<Double>());
        createCriteria.andNameIn(new ArrayList<String>());
        createCriteria.andCreatetimeIsNotNull();
        createCriteria.andCreatetimeNotEqualTo(new Date());
        createCriteria.andCreatetimeIn(list);
        createCriteria.andCreatetimeNotIn(list);
        createCriteria.andTimestrEqualTo(nu);
        createCriteria.andNameLessThanOrEqualTo(nu);
        createCriteria.andNameLessThan(nu);
        createCriteria.andNameGreaterThanOrEqualTo(nu);
        createCriteria.andNameGreaterThan(nu);
        createCriteria.andNameIsNull();
        createCriteria.addCriterionForJDBCDate(nu, list, nu);
        
        Criterion criterion = new  com.cmcc.ms.entity.datashow.BusinessTrafficExample.Criterion("");
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
        new org.junit.runner.JUnitCore().run(BusinessTrafficExampleTest.class);
    }
}
