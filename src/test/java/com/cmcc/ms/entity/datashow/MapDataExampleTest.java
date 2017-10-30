package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cmcc.ms.entity.datashow.MapDataExample.Criteria;
import com.cmcc.ms.entity.datashow.MapDataExample.Criterion;

/**
 * @author zhangxu-ws
 */
public class MapDataExampleTest {
    /**
     * Run the mapDataExample() constructor test.
     * @throws Exception
     *
     */
    @Test
    public void test() {
        MapDataExample mapDataExample = new MapDataExample();
        Criteria createCriteria = mapDataExample.createCriteria();
        String nu = "";
        Integer in=1;
        Double du= 0d;
        mapDataExample.setOrderByClause(nu);
        mapDataExample.getOrderByClause();
        mapDataExample.isDistinct();
        mapDataExample.setDistinct(false);
        mapDataExample.or(createCriteria);
        mapDataExample.getOredCriteria();
        mapDataExample.or();
        mapDataExample.clear();
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
        createCriteria.andIdGreaterThan(0);
        createCriteria.andIdIsNull();
        createCriteria.andIdIsNotNull();
        createCriteria.andIdLessThan(0);
        createCriteria.andCreatetimeEqualTo(new Date());
        createCriteria.andCreatetimeGreaterThan(new Date());
        createCriteria.andIdNotBetween(in, in);
        createCriteria.andTimestrIsNotNull();
        createCriteria.andIdNotEqualTo(in);
        createCriteria.andIdLessThanOrEqualTo(0);
        createCriteria.andIdGreaterThanOrEqualTo(0);
        createCriteria.andTimestrLessThanOrEqualTo(nu);
        createCriteria.andTimestrGreaterThan(nu);
        createCriteria.andCreatetimeGreaterThan(new Date());
        createCriteria.andCreatetimeNotBetween(new Date(),new Date());
        createCriteria.andCreatetimeLessThan(new Date());
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
        createCriteria.andCreatetimeIsNotNull();
        createCriteria.andCreatetimeNotEqualTo(new Date());
        createCriteria.andCreatetimeIn(list);
        createCriteria.andCreatetimeNotIn(list);
        createCriteria.andTimestrEqualTo(nu);
        createCriteria.andProvinceIsNull();
        createCriteria.andProvinceIsNotNull();
        createCriteria.andProvinceEqualTo(nu);
        createCriteria.andProvinceNotEqualTo(nu);
        createCriteria.andProvinceGreaterThan(nu);
        createCriteria.andProvinceGreaterThanOrEqualTo(nu);
        createCriteria.andProvinceLessThan(nu);
        createCriteria.andProvinceLessThanOrEqualTo(nu);
        createCriteria.andProvinceLike(nu);
        createCriteria.andProvinceNotLike(nu);
        createCriteria.andProvinceIn(new ArrayList<String>());
        createCriteria.andProvinceNotIn(new ArrayList<String>());
        createCriteria.andProvinceBetween(nu, nu);
        createCriteria.andProvinceNotBetween(nu, nu);
        createCriteria.andUCdnIsNull();
        createCriteria.andUCdnIsNotNull();
        createCriteria.andUCdnEqualTo(du);
        createCriteria.andUCdnNotEqualTo(du);
        createCriteria.andUCdnGreaterThan(du);
        createCriteria.andUCdnGreaterThanOrEqualTo(du);
        createCriteria.andUCdnLessThan(du);
        createCriteria.andUCdnLessThanOrEqualTo(du);
        createCriteria.andUCdnIn(new ArrayList<Double>());
        createCriteria.andUCdnNotIn(new ArrayList<Double>());
        createCriteria.andUCdnBetween(du, du);
        createCriteria.andUCdnNotBetween(du, du);
        createCriteria.andIdcIsNull();
        createCriteria.andIdcIsNotNull();
        createCriteria.andIdcEqualTo(du);
        createCriteria.andIdcNotEqualTo(du);
        createCriteria.andIdcGreaterThan(du);
        createCriteria.andIdcGreaterThanOrEqualTo(du);
        createCriteria.andIdcLessThan(du);
        createCriteria.andIdcLessThanOrEqualTo(du);
        createCriteria.andIdcIn(new ArrayList<Double>());
        createCriteria.andIdcNotIn(new ArrayList<Double>());
        createCriteria.andIdcBetween(du, du);
        createCriteria.andIdcNotBetween(du, du);
        createCriteria.andUCacheIsNull();
        createCriteria.andUCacheIsNotNull();
        createCriteria.andUCacheEqualTo(du);
        createCriteria.andUCacheNotEqualTo(du);
        createCriteria.andUCacheGreaterThan(du);
        createCriteria.andUCacheGreaterThanOrEqualTo(du);
        createCriteria.andUCacheLessThan(du);
        createCriteria.andUCacheLessThanOrEqualTo(du);
        createCriteria.andUCacheIn(new ArrayList<Double>());
        createCriteria.andUCacheNotIn(new ArrayList<Double>());
        createCriteria.andUCacheBetween(du, du);
        createCriteria.andUCacheNotBetween(du, du);
        createCriteria.andPCacheIsNull();
        createCriteria.andPCacheIsNotNull();
        createCriteria.andPCacheEqualTo(du);
        createCriteria.andPCacheNotEqualTo(du);
        createCriteria.andPCacheGreaterThan(du);
        createCriteria.andPCacheGreaterThanOrEqualTo(du);
        createCriteria.andPCacheGreaterThanOrEqualTo(du);
        createCriteria.andPCacheLessThan(du);
        createCriteria.andPCacheLessThanOrEqualTo(du);
        createCriteria.andPCacheIn(new ArrayList<Double>());
        createCriteria.andPCacheNotIn(new ArrayList<Double>());
        createCriteria.andPCacheBetween(du, du);
        createCriteria.andPCacheNotBetween(du, du);
        createCriteria.andPOttIsNull();
        createCriteria.andPOttIsNotNull();
        createCriteria.andPOttEqualTo(du);
        createCriteria.andPOttNotEqualTo(du);
        createCriteria.andPOttGreaterThan(du);
        createCriteria.andPOttGreaterThanOrEqualTo(du);
        createCriteria.andPOttLessThan(du);
        createCriteria.andPOttLessThanOrEqualTo(du);
        createCriteria.andPOttIn(new ArrayList<Double>());
        createCriteria.andPOttNotIn(new ArrayList<Double>());
        createCriteria.andPOttBetween(du, du);
        createCriteria.andPOttNotBetween(du, du);
       
        Criterion criterion = new  com.cmcc.ms.entity.datashow.MapDataExample.Criterion("");
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
        new org.junit.runner.JUnitCore().run(MapDataExampleTest.class);
    }
}
