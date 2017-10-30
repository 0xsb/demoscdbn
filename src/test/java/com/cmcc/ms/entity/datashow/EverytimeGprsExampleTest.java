package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cmcc.ms.entity.datashow.EverytimeGprsExample.Criteria;
import com.cmcc.ms.entity.datashow.EverytimeGprsExample.Criterion;

/**
 *
 * @author zhangxu-ws
 */
public class EverytimeGprsExampleTest {
    /**
     * Run the void clear() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void test() {
        EverytimeGprsExample everytimeGprsExample = new EverytimeGprsExample();
        Criteria createCriteria = everytimeGprsExample.createCriteria();
        String nu = "";
        Integer in=1;
        Double du= 0d;
        everytimeGprsExample.setOrderByClause(nu);
        everytimeGprsExample.getOrderByClause();
        everytimeGprsExample.isDistinct();
        everytimeGprsExample.setDistinct(false);
        everytimeGprsExample.or(createCriteria);
        everytimeGprsExample.getOredCriteria();
        everytimeGprsExample.or();
        everytimeGprsExample.clear();
        List<Date> list = new ArrayList<Date>();
        list.add(new Date());
        createCriteria.andAiqiyNotIn(new ArrayList<Double>());
        createCriteria.getCriteria();
        createCriteria.andAiqiyEqualTo(du);
        createCriteria.andAiqiyGreaterThan(du);
        createCriteria.andAiqiyGreaterThanOrEqualTo(du);
        createCriteria.andAiqiyIn(new ArrayList<Double>());
        createCriteria.andAiqiyIsNotNull();
        createCriteria.andAiqiyBetween(du, du);
        createCriteria.getAllCriteria();
        createCriteria.addCriterion(nu);
        createCriteria.addCriterion(nu, in, nu);
        createCriteria.addCriterion(nu, in, nu, nu);
        createCriteria.andTimeIsNull();
        createCriteria.andTimeIsNotNull();
        createCriteria.andTimeEqualTo(nu);
        createCriteria.andTimeNotEqualTo(nu);
        createCriteria.andTimeGreaterThan(nu);
        createCriteria.andTimeGreaterThanOrEqualTo(nu);
        createCriteria.andTimeLessThan(nu);
        createCriteria.andTimeLessThanOrEqualTo(nu);
        createCriteria.andTimeLike(nu);
        createCriteria.andTimeNotLike(nu);
        createCriteria.andTimeIn(new ArrayList<String>());
        createCriteria.andTimeNotIn(new ArrayList<String>());
        createCriteria.andTimeBetween(nu, nu);
        createCriteria.andTimeNotBetween(nu, nu);
        createCriteria.andTengxunIsNull();
        createCriteria.andTengxunIsNotNull();
        createCriteria.andTengxunEqualTo(du);
        createCriteria.andTengxunNotEqualTo(du);
        createCriteria.andTengxunGreaterThan(du);
        createCriteria.andTengxunGreaterThanOrEqualTo(du);
        createCriteria.andTengxunLessThan(du);
        createCriteria.andTengxunLessThanOrEqualTo(du);
        createCriteria.andTengxunIn(new ArrayList<Double>());
        createCriteria.andTengxunNotIn(new ArrayList<Double>());
        createCriteria.andTengxunBetween(du, du);
        createCriteria.andTengxunNotBetween(du, du);
        createCriteria.andAiqiyIsNull();
        createCriteria.andAiqiyNotEqualTo(du);
        createCriteria.andAiqiyLessThan(du);
        createCriteria.andAiqiyLessThanOrEqualTo(du);
        createCriteria.andAiqiyNotBetween(du, du);
        createCriteria.andAlibabaIsNull();
        createCriteria.andAlibabaIsNotNull();
        createCriteria.andAlibabaEqualTo(du);
        createCriteria.andAlibabaNotEqualTo(du);
        createCriteria.andAlibabaGreaterThan(du);
        createCriteria.andAlibabaGreaterThanOrEqualTo(du);
        createCriteria.andAlibabaLessThan(du);
        createCriteria.andAlibabaLessThanOrEqualTo(du);
        createCriteria.andAlibabaIn(new ArrayList<Double>());
        createCriteria.andAlibabaNotIn(new ArrayList<Double>());
        createCriteria.andAlibabaBetween(du, du);
        createCriteria.andAlibabaNotBetween(du, du);
        createCriteria.andYoukutudouIsNull();
        createCriteria.andYoukutudouIsNotNull();
        createCriteria.andYoukutudouEqualTo(du);
        createCriteria.andYoukutudouNotEqualTo(du);
        createCriteria.andYoukutudouGreaterThan(du);
        createCriteria.andYoukutudouGreaterThanOrEqualTo(du);
        createCriteria.andYoukutudouLessThan(du);
        createCriteria.andYoukutudouLessThanOrEqualTo(du);
        createCriteria.andYoukutudouIn(new ArrayList<Double>());
        createCriteria.andYoukutudouNotIn(new ArrayList<Double>());
        createCriteria.andYoukutudouBetween(du, du);
        createCriteria.andYoukutudouNotBetween(du, du);
        createCriteria.andBaiduIsNull();
        createCriteria.andBaiduIsNotNull();
        createCriteria.andBaiduEqualTo(du);
        createCriteria.andBaiduNotEqualTo(du);
        createCriteria.andBaiduGreaterThan(du);
        createCriteria.andBaiduGreaterThanOrEqualTo(du);
        createCriteria.andBaiduLessThan(du);
        createCriteria.andBaiduLessThanOrEqualTo(du);
        createCriteria.andBaiduIn(new ArrayList<Double>());
        createCriteria.andBaiduNotIn(new ArrayList<Double>());
        createCriteria.andBaiduBetween(du, du);
        createCriteria.andBaiduNotBetween(du, du);
        createCriteria.andLeshiIsNull();
        createCriteria.andLeshiIsNotNull();
        createCriteria.andLeshiEqualTo(du);
        createCriteria.andLeshiNotEqualTo(du);
        createCriteria.andLeshiGreaterThan(du);
        createCriteria.andLeshiLessThan(du);
        createCriteria.andLeshiLessThanOrEqualTo(du);
        createCriteria.andLeshiIn(new ArrayList<Double>());
        createCriteria.andLeshiNotIn(new ArrayList<Double>());
        createCriteria.andLeshiBetween(du, du);
        createCriteria.andLeshiNotBetween(du, du);
        createCriteria.andMangguoIsNull();
        createCriteria.andMangguoIsNotNull();
        createCriteria.andMangguoEqualTo(du);
        createCriteria.andMangguoNotEqualTo(du);
        createCriteria.andMangguoGreaterThan(du);
        createCriteria.andMangguoGreaterThanOrEqualTo(du);
        createCriteria.andMangguoLessThanOrEqualTo(du);
        createCriteria.andMangguoIn(new ArrayList<Double>());
        createCriteria.andMangguoNotIn(new ArrayList<Double>());
        createCriteria.andMangguoBetween(du, du);
        createCriteria.andMangguoNotBetween(du, du);
        createCriteria.andSouhuIsNull();
        createCriteria.andSouhuIsNotNull();
        createCriteria.andSouhuEqualTo(du);
        createCriteria.andSouhuNotEqualTo(du);
        createCriteria.andSouhuGreaterThanOrEqualTo(du);
        createCriteria.andSouhuLessThan(du);
        createCriteria.andSouhuLessThanOrEqualTo(du);
        createCriteria.andSouhuIn(new ArrayList<Double>());
        createCriteria.andSouhuNotIn(new ArrayList<Double>());
        createCriteria.andSouhuBetween(du, du);
        createCriteria.andSouhuNotBetween(du, du);
        createCriteria.andXinlangIsNull();
        createCriteria.andXinlangIsNotNull();
        createCriteria.andXinlangEqualTo(du);
        createCriteria.andXinlangNotEqualTo(du);
        createCriteria.andXinlangGreaterThan(du);
        createCriteria.andXinlangGreaterThanOrEqualTo(du);
        createCriteria.andXinlangLessThan(du);
        createCriteria.andXinlangLessThanOrEqualTo(du);
        createCriteria.andXinlangIn(new ArrayList<Double>());
        createCriteria.andXinlangNotIn(new ArrayList<Double>());
        createCriteria.andXinlangBetween(du, du);
        createCriteria.andXinlangNotBetween(du, du);
        createCriteria.andJinshanIsNull();
        createCriteria.andJinshanEqualTo(du);
        createCriteria.andJinshanNotEqualTo(du);
        createCriteria.andJinshanGreaterThan(du);
        createCriteria.andJinshanGreaterThanOrEqualTo(du);
        createCriteria.andJinshanLessThan(du);
        createCriteria.andJinshanLessThanOrEqualTo(du);
        createCriteria.andJinshanIn(new ArrayList<Double>());
        createCriteria.andJinshanNotIn(new ArrayList<Double>());
        createCriteria.andJinshanBetween(du, du);
        createCriteria.andJinshanNotBetween(du, du);
        createCriteria.andJinshanIsNotNull();
        
        
        Criterion criterion = new  com.cmcc.ms.entity.datashow.EverytimeGprsExample.Criterion("");
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
        new org.junit.runner.JUnitCore().run(EverytimeGprsExampleTest.class);
    }
}
