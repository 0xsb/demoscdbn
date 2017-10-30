package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cmcc.ms.entity.datashow.IdcWeekExample.Criteria;
import com.cmcc.ms.entity.datashow.IdcWeekExample.Criterion;

/**
 * The class <code>IdcWeekExampleTest</code> contains tests for the class <code>{@link IdcWeekExample}</code>.
 *
 * @author ldy
 */
public class IdcWeekExampleTest {
    /**
     * Run the IdcWeekExample() constructor test.
     *
     * @throws Exception
     *
     */
    @Test
    public void test() {
        IdcWeekExample idcWeekExample = new IdcWeekExample();
        Criteria createCriteria = idcWeekExample.createCriteria();
        String nu = "";
        Integer in=1;
        Double du= 0d;
        idcWeekExample.setOrderByClause(nu);
        idcWeekExample.getOrderByClause();
        idcWeekExample.isDistinct();
        idcWeekExample.setDistinct(false);
        idcWeekExample.or(createCriteria);
        idcWeekExample.getOredCriteria();
        idcWeekExample.or();
        idcWeekExample.clear();
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
        createCriteria.andTrafficinNotBetween(0d,0d);
        createCriteria.andTrafficinBetween(0d,0d);
        createCriteria.andTrafficinIn(new ArrayList<Double>());
        createCriteria.andTrafficinIsNull();
        createCriteria.andIdGreaterThan(0);
        createCriteria.andIdIsNull();
        createCriteria.andTrafficinEqualTo(0d);
        createCriteria.andIdIsNotNull();
        createCriteria.andTrafficinNotIn(new ArrayList<Double>());
        createCriteria.andIdLessThan(0);
        createCriteria.andTrafficinNotIn(new ArrayList<Double>());
        createCriteria.andCreatetimeEqualTo(new Date());
        createCriteria.andTrafficinNotEqualTo(0d);
        createCriteria.andCreatetimeGreaterThan(new Date());
        createCriteria.andIdNotBetween(in, in);
        createCriteria.andTimestrIsNotNull();
        createCriteria.andTrafficinIsNotNull();
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
        createCriteria.andTimestrGreaterThanOrEqualTo(nu);
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
        createCriteria.andCreatetimeIsNotNull();
        createCriteria.andCreatetimeNotEqualTo(new Date());
        createCriteria.andCreatetimeIn(list);
        createCriteria.andCreatetimeNotIn(list);
        createCriteria.andTimestrEqualTo(nu);
        createCriteria.andProvinceIsNull();
        createCriteria.andProvinceIsNotNull();
        createCriteria.andProvinceEqualTo(nu);
        createCriteria.andProvinceGreaterThanOrEqualTo(nu);
        
        Criterion criterion = new  com.cmcc.ms.entity.datashow.IdcWeekExample.Criterion("");
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
        new org.junit.runner.JUnitCore().run(IdcWeekExampleTest.class);
    }
}