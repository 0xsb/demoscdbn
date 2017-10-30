package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;

import org.junit.Test;

import com.cmcc.ms.entity.datashow.BaseDataExample.Criteria;
import com.cmcc.ms.entity.datashow.BaseDataExample.Criterion;

/**
 *
 * @author zhangxu-ws
 */
public class BaseDataExampleTest {
    /**
     * Run the BaseDataExample() constructor test.
     */
    @Test
    public void test() {
        BaseDataExample baseDataExample = new BaseDataExample();
        Criteria createCriteria = baseDataExample.createCriteria();
        String nu = "";
        Double de=2d;
        createCriteria.andIdNotIn(new ArrayList<String>());
        createCriteria.getCriteria();
        createCriteria.andIdBetween(nu,nu);
        createCriteria.andIdIsNull();
        createCriteria.andIdEqualTo(nu);
        createCriteria.andIdIn(new ArrayList<String>());
        createCriteria.andIdNotEqualTo(nu);
        createCriteria.andIdNotBetween(nu,nu);
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
        createCriteria.andIdGreaterThan(nu);
        createCriteria.andProvinceLessThan(nu);
        createCriteria.andProvinceIsNull();
        createCriteria.andTrafficoutIsNull();
        createCriteria.andTrafficoutEqualTo(0d);
        createCriteria.andIdIsNotNull();
        createCriteria.andProvinceNotIn(new ArrayList<String>());
        createCriteria.andTrafficoutNotIn(new ArrayList<Double>());
        createCriteria.andProvinceLike(nu);
        createCriteria.andIdLessThan(nu);
        createCriteria.andTrafficoutIn(new ArrayList<Double>());
        createCriteria.andProvinceBetween(nu,nu);
        createCriteria.andTrafficinNotIn(new ArrayList<Double>());
        createCriteria.andTrafficinEqualTo(0d);
        createCriteria.andDevIpEqualTo(nu);
        createCriteria.andTrafficoutNotEqualTo(0d);
        createCriteria.andTrafficinNotEqualTo(0d);
        createCriteria.andProvinceGreaterThan(nu);
        createCriteria.andProvinceNotBetween(nu,nu);
        createCriteria.andTrafficoutIsNotNull();
        createCriteria.andTrafficinIsNotNull();
        createCriteria.andProvinceNotEqualTo(nu);
        createCriteria.andTrafficinNotBetween(0d,0d);
        createCriteria.andIdLessThanOrEqualTo(nu);
        createCriteria.andProvinceLessThanOrEqualTo(nu);
        createCriteria.andTrafficoutNotBetween(0d,0d);
        createCriteria.andTrafficoutLessThan(0d);
        createCriteria.andIdGreaterThanOrEqualTo(nu);
        createCriteria.andTrafficoutGreaterThan(0d);
        createCriteria.andTrafficinGreaterThan(0d);
        createCriteria.andBusBigLessThanOrEqualTo(nu);
        createCriteria.andBusBigIsNotNull();
        createCriteria.andBusBigNotEqualTo(nu);
        createCriteria.andDevIpGreaterThan(nu);
        createCriteria.andBusBigGreaterThan(nu);
        createCriteria.andDevIpNotBetween(nu,nu);
        createCriteria.andBusBigLessThan(nu);
        createCriteria.andTrafficinGreaterThanOrEqualTo(0d);
        createCriteria.andProvinceGreaterThanOrEqualTo(nu);
        createCriteria.andTrafficoutGreaterThanOrEqualTo(0d);
        createCriteria.andTrafficinLessThanOrEqualTo(0d);
        createCriteria.andTrafficoutLessThanOrEqualTo(0d);
        createCriteria.andBusBigGreaterThanOrEqualTo(nu);
        createCriteria.andBusSmallLessThanOrEqualTo(nu);
        createCriteria.andBandwidthGreaterThanOrEqualTo(de);
        createCriteria.andIdNotLike(nu);
        createCriteria.andDevIpIsNotNull();
        createCriteria.andIdLike(nu);
        createCriteria.andIdLessThan(nu);
        createCriteria.andDevNameNotIn(new ArrayList<String>());
        createCriteria.andDevNameIsNull();
        createCriteria.andIdLessThanOrEqualTo(nu);
        createCriteria.andIdEqualTo(nu);
        createCriteria.andBusBigNotBetween(nu,nu);
        createCriteria.andIdNotIn(new ArrayList<String>());
        createCriteria.andIdNotBetween(nu,nu);
        createCriteria.andDevIpIsNull();
        createCriteria.andIdBetween(nu,nu);
        createCriteria.isValid();
        
        Criterion criterion = new  com.cmcc.ms.entity.datashow.BaseDataExample.Criterion("");
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
        new org.junit.runner.JUnitCore().run(BaseDataExampleTest.class);
    }
}
