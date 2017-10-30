package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.cmcc.ms.entity.datashow.ProvinceOttDayExample.Criteria;
import com.cmcc.ms.entity.datashow.ProvinceOttDayExample.Criterion;

/**
 *
 * @author zhangxu-ws
 */
public class ProvinceOttDayExampleTest {
    /**
     * Run the ProvinceOttDayExample() constructor test.
     *
     * @throws Exception
     *
     */
    @Test
    public void test() {
        ProvinceOttDayExample provinceOttDayExample = new ProvinceOttDayExample();
        Criteria createCriteria = provinceOttDayExample.createCriteria();
        String nu = "";
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
        createCriteria.andProvinceNotLike(nu);
        createCriteria.andProvinceIn(new ArrayList<String>());
        createCriteria.andTrafficoutBetween(0d,0d);
        createCriteria.andTrafficinLessThan(0d);
        createCriteria.andTrafficinBetween(0d,0d);
        createCriteria.andProvinceIsNotNull();
        createCriteria.andProvinceEqualTo(nu);
        createCriteria.andTrafficinIn(new ArrayList<Double>());
        createCriteria.andTrafficinIsNull();
        createCriteria.andIdGreaterThan(0);
        createCriteria.andProvinceLessThan(nu);
        createCriteria.andProvinceIsNull();
        createCriteria.andTrafficoutIsNull();
        createCriteria.andTrafficoutEqualTo(0d);
        createCriteria.andIdIsNotNull();
        createCriteria.andProvinceNotIn(new ArrayList<String>());
        createCriteria.andTrafficoutNotIn(new ArrayList<Double>());
        createCriteria.andProvinceLike(nu);
        createCriteria.andIdLessThan(0);
        createCriteria.andTrafficoutIn(new ArrayList<Double>());
        createCriteria.andProvinceBetween(nu,nu);
        createCriteria.andTrafficinNotIn(new ArrayList<Double>());
        createCriteria.andTrafficinEqualTo(0d);
        createCriteria.andCreatetimeEqualTo(new Date());
        createCriteria.andTrafficoutNotEqualTo(0d);
        createCriteria.andTrafficinNotEqualTo(0d);
        createCriteria.andProvinceGreaterThan(nu);
        createCriteria.andProvinceNotBetween(nu,nu);
        createCriteria.andTrafficoutIsNotNull();
        createCriteria.andTrafficinIsNotNull();
        createCriteria.andProvinceNotEqualTo(nu);
        createCriteria.andTrafficinNotBetween(0d,0d);
        createCriteria.andIdLessThanOrEqualTo(0);
        createCriteria.andProvinceLessThanOrEqualTo(nu);
        createCriteria.andTrafficoutNotBetween(0d,0d);
        createCriteria.andTrafficoutLessThan(0d);
        createCriteria.andIdGreaterThanOrEqualTo(0);
        createCriteria.andTrafficoutGreaterThan(0d);
        createCriteria.andTrafficinGreaterThan(0d);
        createCriteria.andTimestrLessThanOrEqualTo(nu);
        createCriteria.andCreatetimeIsNotNull();
        createCriteria.andCreatetimeNotEqualTo(new Date());
        createCriteria.andTimestrGreaterThan(nu);
        createCriteria.andCreatetimeGreaterThan(new Date());
        createCriteria.andCreatetimeNotBetween(new Date(),new Date());
        createCriteria.andCreatetimeLessThan(new Date());
        createCriteria.andTrafficinGreaterThanOrEqualTo(0d);
        createCriteria.andProvinceGreaterThanOrEqualTo(nu);
        createCriteria.andTrafficoutGreaterThanOrEqualTo(0d);
        createCriteria.andTrafficinLessThanOrEqualTo(0d);
        createCriteria.andTrafficoutLessThanOrEqualTo(0d);
        createCriteria.andTimestrGreaterThanOrEqualTo(nu);
        createCriteria.andCreatetimeLessThanOrEqualTo(new Date());
        createCriteria.andCreatetimeGreaterThanOrEqualTo(new Date());
        createCriteria.andCreatetimeIn(new ArrayList<Date>());
        createCriteria.andTimestrNotLike(nu);
        createCriteria.andTimestrIsNotNull();
        createCriteria.andTimestrLike(nu);
        createCriteria.andTimestrLessThan(nu);
        createCriteria.andCreatetimeNotIn(new ArrayList<Date>());
        createCriteria.andCreatetimeIsNull();
        createCriteria.andTimestrEqualTo(nu);
        createCriteria.andTimestrNotEqualTo(nu);
        createCriteria.andTimestrNotBetween(nu,nu);
        createCriteria.andTimestrNotIn(new ArrayList<String>());
        createCriteria.andCreatetimeBetween(new Date(),new Date());
        createCriteria.andTimestrIsNull();
        createCriteria.andTimestrBetween(nu,nu);
        createCriteria.isValid();
        
        Criterion criterion = new  com.cmcc.ms.entity.datashow.ProvinceOttDayExample.Criterion("");
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
        new org.junit.runner.JUnitCore().run(ProvinceOttDayExampleTest.class);
    }
}
