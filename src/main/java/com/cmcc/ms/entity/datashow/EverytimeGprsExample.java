package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class EverytimeGprsExample.
 */
public class EverytimeGprsExample {
    
    /** The order by clause. */
    protected String orderByClause;

    /** The distinct. */
    protected boolean distinct;

    /** The ored criteria. */
    protected List<Criteria> oredCriteria;

    /**
     * Instantiates a new everytime gprs example.
     */
    public EverytimeGprsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * Sets the order by clause.
     *
     * @param orderByClause the new order by clause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * Gets the order by clause.
     *
     * @return the order by clause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * Sets the distinct.
     *
     * @param distinct the new distinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * Checks if is distinct.
     *
     * @return true, if is distinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * Gets the ored criteria.
     *
     * @return the ored criteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * Or.
     *
     * @param criteria the criteria
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * Or.
     *
     * @return the criteria
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * Creates the criteria.
     *
     * @return the criteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * Creates the criteria internal.
     *
     * @return the criteria
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * Clear.
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * The Class GeneratedCriteria.
     */
    protected abstract static class GeneratedCriteria {
        
        /** The criteria. */
        protected List<Criterion> criteria;

        /**
         * Instantiates a new generated criteria.
         */
        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        /**
         * Checks if is valid.
         *
         * @return true, if is valid
         */
        public boolean isValid() {
            return criteria.size() > 0;
        }

        /**
         * Gets the all criteria.
         *
         * @return the all criteria
         */
        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        /**
         * Gets the criteria.
         *
         * @return the criteria
         */
        public List<Criterion> getCriteria() {
            return criteria;
        }

        /**
         * Adds the criterion.
         *
         * @param condition the condition
         */
        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        /**
         * Adds the criterion.
         *
         * @param condition the condition
         * @param value the value
         * @param property the property
         */
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        /**
         * Adds the criterion.
         *
         * @param condition the condition
         * @param value1 the value 1
         * @param value2 the value 2
         * @param property the property
         */
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        /**
         * And time is null.
         *
         * @return the criteria
         */
        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        /**
         * And time is not null.
         *
         * @return the criteria
         */
        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        /**
         * And time equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        /**
         * And time not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        /**
         * And time greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        /**
         * And time greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        /**
         * And time less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        /**
         * And time less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        /**
         * And time like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        /**
         * And time not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        /**
         * And time in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        /**
         * And time not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        /**
         * And time between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        /**
         * And time not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        /**
         * And tengxun is null.
         *
         * @return the criteria
         */
        public Criteria andTengxunIsNull() {
            addCriterion("tengxun is null");
            return (Criteria) this;
        }

        /**
         * And tengxun is not null.
         *
         * @return the criteria
         */
        public Criteria andTengxunIsNotNull() {
            addCriterion("tengxun is not null");
            return (Criteria) this;
        }

        /**
         * And tengxun equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTengxunEqualTo(Double value) {
            addCriterion("tengxun =", value, "tengxun");
            return (Criteria) this;
        }

        /**
         * And tengxun not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTengxunNotEqualTo(Double value) {
            addCriterion("tengxun <>", value, "tengxun");
            return (Criteria) this;
        }

        /**
         * And tengxun greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTengxunGreaterThan(Double value) {
            addCriterion("tengxun >", value, "tengxun");
            return (Criteria) this;
        }

        /**
         * And tengxun greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTengxunGreaterThanOrEqualTo(Double value) {
            addCriterion("tengxun >=", value, "tengxun");
            return (Criteria) this;
        }

        /**
         * And tengxun less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTengxunLessThan(Double value) {
            addCriterion("tengxun <", value, "tengxun");
            return (Criteria) this;
        }

        /**
         * And tengxun less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTengxunLessThanOrEqualTo(Double value) {
            addCriterion("tengxun <=", value, "tengxun");
            return (Criteria) this;
        }

        /**
         * And tengxun in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTengxunIn(List<Double> values) {
            addCriterion("tengxun in", values, "tengxun");
            return (Criteria) this;
        }

        /**
         * And tengxun not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTengxunNotIn(List<Double> values) {
            addCriterion("tengxun not in", values, "tengxun");
            return (Criteria) this;
        }

        /**
         * And tengxun between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTengxunBetween(Double value1, Double value2) {
            addCriterion("tengxun between", value1, value2, "tengxun");
            return (Criteria) this;
        }

        /**
         * And tengxun not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTengxunNotBetween(Double value1, Double value2) {
            addCriterion("tengxun not between", value1, value2, "tengxun");
            return (Criteria) this;
        }

        /**
         * And aiqiy is null.
         *
         * @return the criteria
         */
        public Criteria andAiqiyIsNull() {
            addCriterion("aiqiy is null");
            return (Criteria) this;
        }

        /**
         * And aiqiy is not null.
         *
         * @return the criteria
         */
        public Criteria andAiqiyIsNotNull() {
            addCriterion("aiqiy is not null");
            return (Criteria) this;
        }

        /**
         * And aiqiy equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAiqiyEqualTo(Double value) {
            addCriterion("aiqiy =", value, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And aiqiy not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAiqiyNotEqualTo(Double value) {
            addCriterion("aiqiy <>", value, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And aiqiy greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAiqiyGreaterThan(Double value) {
            addCriterion("aiqiy >", value, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And aiqiy greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAiqiyGreaterThanOrEqualTo(Double value) {
            addCriterion("aiqiy >=", value, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And aiqiy less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAiqiyLessThan(Double value) {
            addCriterion("aiqiy <", value, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And aiqiy less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAiqiyLessThanOrEqualTo(Double value) {
            addCriterion("aiqiy <=", value, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And aiqiy in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andAiqiyIn(List<Double> values) {
            addCriterion("aiqiy in", values, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And aiqiy not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andAiqiyNotIn(List<Double> values) {
            addCriterion("aiqiy not in", values, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And aiqiy between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andAiqiyBetween(Double value1, Double value2) {
            addCriterion("aiqiy between", value1, value2, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And aiqiy not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andAiqiyNotBetween(Double value1, Double value2) {
            addCriterion("aiqiy not between", value1, value2, "aiqiy");
            return (Criteria) this;
        }

        /**
         * And alibaba is null.
         *
         * @return the criteria
         */
        public Criteria andAlibabaIsNull() {
            addCriterion("alibaba is null");
            return (Criteria) this;
        }

        /**
         * And alibaba is not null.
         *
         * @return the criteria
         */
        public Criteria andAlibabaIsNotNull() {
            addCriterion("alibaba is not null");
            return (Criteria) this;
        }

        /**
         * And alibaba equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAlibabaEqualTo(Double value) {
            addCriterion("alibaba =", value, "alibaba");
            return (Criteria) this;
        }

        /**
         * And alibaba not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAlibabaNotEqualTo(Double value) {
            addCriterion("alibaba <>", value, "alibaba");
            return (Criteria) this;
        }

        /**
         * And alibaba greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAlibabaGreaterThan(Double value) {
            addCriterion("alibaba >", value, "alibaba");
            return (Criteria) this;
        }

        /**
         * And alibaba greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAlibabaGreaterThanOrEqualTo(Double value) {
            addCriterion("alibaba >=", value, "alibaba");
            return (Criteria) this;
        }

        /**
         * And alibaba less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAlibabaLessThan(Double value) {
            addCriterion("alibaba <", value, "alibaba");
            return (Criteria) this;
        }

        /**
         * And alibaba less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andAlibabaLessThanOrEqualTo(Double value) {
            addCriterion("alibaba <=", value, "alibaba");
            return (Criteria) this;
        }

        /**
         * And alibaba in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andAlibabaIn(List<Double> values) {
            addCriterion("alibaba in", values, "alibaba");
            return (Criteria) this;
        }

        /**
         * And alibaba not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andAlibabaNotIn(List<Double> values) {
            addCriterion("alibaba not in", values, "alibaba");
            return (Criteria) this;
        }

        /**
         * And alibaba between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andAlibabaBetween(Double value1, Double value2) {
            addCriterion("alibaba between", value1, value2, "alibaba");
            return (Criteria) this;
        }

        /**
         * And alibaba not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andAlibabaNotBetween(Double value1, Double value2) {
            addCriterion("alibaba not between", value1, value2, "alibaba");
            return (Criteria) this;
        }

        /**
         * And youkutudou is null.
         *
         * @return the criteria
         */
        public Criteria andYoukutudouIsNull() {
            addCriterion("youkutudou is null");
            return (Criteria) this;
        }

        /**
         * And youkutudou is not null.
         *
         * @return the criteria
         */
        public Criteria andYoukutudouIsNotNull() {
            addCriterion("youkutudou is not null");
            return (Criteria) this;
        }

        /**
         * And youkutudou equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andYoukutudouEqualTo(Double value) {
            addCriterion("youkutudou =", value, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And youkutudou not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andYoukutudouNotEqualTo(Double value) {
            addCriterion("youkutudou <>", value, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And youkutudou greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andYoukutudouGreaterThan(Double value) {
            addCriterion("youkutudou >", value, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And youkutudou greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andYoukutudouGreaterThanOrEqualTo(Double value) {
            addCriterion("youkutudou >=", value, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And youkutudou less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andYoukutudouLessThan(Double value) {
            addCriterion("youkutudou <", value, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And youkutudou less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andYoukutudouLessThanOrEqualTo(Double value) {
            addCriterion("youkutudou <=", value, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And youkutudou in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andYoukutudouIn(List<Double> values) {
            addCriterion("youkutudou in", values, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And youkutudou not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andYoukutudouNotIn(List<Double> values) {
            addCriterion("youkutudou not in", values, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And youkutudou between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andYoukutudouBetween(Double value1, Double value2) {
            addCriterion("youkutudou between", value1, value2, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And youkutudou not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andYoukutudouNotBetween(Double value1, Double value2) {
            addCriterion("youkutudou not between", value1, value2, "youkutudou");
            return (Criteria) this;
        }

        /**
         * And baidu is null.
         *
         * @return the criteria
         */
        public Criteria andBaiduIsNull() {
            addCriterion("baidu is null");
            return (Criteria) this;
        }

        /**
         * And baidu is not null.
         *
         * @return the criteria
         */
        public Criteria andBaiduIsNotNull() {
            addCriterion("baidu is not null");
            return (Criteria) this;
        }

        /**
         * And baidu equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBaiduEqualTo(Double value) {
            addCriterion("baidu =", value, "baidu");
            return (Criteria) this;
        }

        /**
         * And baidu not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBaiduNotEqualTo(Double value) {
            addCriterion("baidu <>", value, "baidu");
            return (Criteria) this;
        }

        /**
         * And baidu greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBaiduGreaterThan(Double value) {
            addCriterion("baidu >", value, "baidu");
            return (Criteria) this;
        }

        /**
         * And baidu greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBaiduGreaterThanOrEqualTo(Double value) {
            addCriterion("baidu >=", value, "baidu");
            return (Criteria) this;
        }

        /**
         * And baidu less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBaiduLessThan(Double value) {
            addCriterion("baidu <", value, "baidu");
            return (Criteria) this;
        }

        /**
         * And baidu less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBaiduLessThanOrEqualTo(Double value) {
            addCriterion("baidu <=", value, "baidu");
            return (Criteria) this;
        }

        /**
         * And baidu in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBaiduIn(List<Double> values) {
            addCriterion("baidu in", values, "baidu");
            return (Criteria) this;
        }

        /**
         * And baidu not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBaiduNotIn(List<Double> values) {
            addCriterion("baidu not in", values, "baidu");
            return (Criteria) this;
        }

        /**
         * And baidu between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBaiduBetween(Double value1, Double value2) {
            addCriterion("baidu between", value1, value2, "baidu");
            return (Criteria) this;
        }

        /**
         * And baidu not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBaiduNotBetween(Double value1, Double value2) {
            addCriterion("baidu not between", value1, value2, "baidu");
            return (Criteria) this;
        }

        /**
         * And leshi is null.
         *
         * @return the criteria
         */
        public Criteria andLeshiIsNull() {
            addCriterion("leshi is null");
            return (Criteria) this;
        }

        /**
         * And leshi is not null.
         *
         * @return the criteria
         */
        public Criteria andLeshiIsNotNull() {
            addCriterion("leshi is not null");
            return (Criteria) this;
        }

        /**
         * And leshi equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLeshiEqualTo(Double value) {
            addCriterion("leshi =", value, "leshi");
            return (Criteria) this;
        }

        /**
         * And leshi not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLeshiNotEqualTo(Double value) {
            addCriterion("leshi <>", value, "leshi");
            return (Criteria) this;
        }

        /**
         * And leshi greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLeshiGreaterThan(Double value) {
            addCriterion("leshi >", value, "leshi");
            return (Criteria) this;
        }

        /**
         * And leshi greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLeshiGreaterThanOrEqualTo(Double value) {
            addCriterion("leshi >=", value, "leshi");
            return (Criteria) this;
        }

        /**
         * And leshi less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLeshiLessThan(Double value) {
            addCriterion("leshi <", value, "leshi");
            return (Criteria) this;
        }

        /**
         * And leshi less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLeshiLessThanOrEqualTo(Double value) {
            addCriterion("leshi <=", value, "leshi");
            return (Criteria) this;
        }

        /**
         * And leshi in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andLeshiIn(List<Double> values) {
            addCriterion("leshi in", values, "leshi");
            return (Criteria) this;
        }

        /**
         * And leshi not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andLeshiNotIn(List<Double> values) {
            addCriterion("leshi not in", values, "leshi");
            return (Criteria) this;
        }

        /**
         * And leshi between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andLeshiBetween(Double value1, Double value2) {
            addCriterion("leshi between", value1, value2, "leshi");
            return (Criteria) this;
        }

        /**
         * And leshi not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andLeshiNotBetween(Double value1, Double value2) {
            addCriterion("leshi not between", value1, value2, "leshi");
            return (Criteria) this;
        }

        /**
         * And mangguo is null.
         *
         * @return the criteria
         */
        public Criteria andMangguoIsNull() {
            addCriterion("mangguo is null");
            return (Criteria) this;
        }

        /**
         * And mangguo is not null.
         *
         * @return the criteria
         */
        public Criteria andMangguoIsNotNull() {
            addCriterion("mangguo is not null");
            return (Criteria) this;
        }

        /**
         * And mangguo equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMangguoEqualTo(Double value) {
            addCriterion("mangguo =", value, "mangguo");
            return (Criteria) this;
        }

        /**
         * And mangguo not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMangguoNotEqualTo(Double value) {
            addCriterion("mangguo <>", value, "mangguo");
            return (Criteria) this;
        }

        /**
         * And mangguo greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMangguoGreaterThan(Double value) {
            addCriterion("mangguo >", value, "mangguo");
            return (Criteria) this;
        }

        /**
         * And mangguo greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMangguoGreaterThanOrEqualTo(Double value) {
            addCriterion("mangguo >=", value, "mangguo");
            return (Criteria) this;
        }

        /**
         * And mangguo less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMangguoLessThan(Double value) {
            addCriterion("mangguo <", value, "mangguo");
            return (Criteria) this;
        }

        /**
         * And mangguo less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMangguoLessThanOrEqualTo(Double value) {
            addCriterion("mangguo <=", value, "mangguo");
            return (Criteria) this;
        }

        /**
         * And mangguo in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andMangguoIn(List<Double> values) {
            addCriterion("mangguo in", values, "mangguo");
            return (Criteria) this;
        }

        /**
         * And mangguo not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andMangguoNotIn(List<Double> values) {
            addCriterion("mangguo not in", values, "mangguo");
            return (Criteria) this;
        }

        /**
         * And mangguo between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andMangguoBetween(Double value1, Double value2) {
            addCriterion("mangguo between", value1, value2, "mangguo");
            return (Criteria) this;
        }

        /**
         * And mangguo not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andMangguoNotBetween(Double value1, Double value2) {
            addCriterion("mangguo not between", value1, value2, "mangguo");
            return (Criteria) this;
        }

        /**
         * And souhu is null.
         *
         * @return the criteria
         */
        public Criteria andSouhuIsNull() {
            addCriterion("souhu is null");
            return (Criteria) this;
        }

        /**
         * And souhu is not null.
         *
         * @return the criteria
         */
        public Criteria andSouhuIsNotNull() {
            addCriterion("souhu is not null");
            return (Criteria) this;
        }

        /**
         * And souhu equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andSouhuEqualTo(Double value) {
            addCriterion("souhu =", value, "souhu");
            return (Criteria) this;
        }

        /**
         * And souhu not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andSouhuNotEqualTo(Double value) {
            addCriterion("souhu <>", value, "souhu");
            return (Criteria) this;
        }

        /**
         * And souhu greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andSouhuGreaterThan(Double value) {
            addCriterion("souhu >", value, "souhu");
            return (Criteria) this;
        }

        /**
         * And souhu greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andSouhuGreaterThanOrEqualTo(Double value) {
            addCriterion("souhu >=", value, "souhu");
            return (Criteria) this;
        }

        /**
         * And souhu less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andSouhuLessThan(Double value) {
            addCriterion("souhu <", value, "souhu");
            return (Criteria) this;
        }

        /**
         * And souhu less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andSouhuLessThanOrEqualTo(Double value) {
            addCriterion("souhu <=", value, "souhu");
            return (Criteria) this;
        }

        /**
         * And souhu in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andSouhuIn(List<Double> values) {
            addCriterion("souhu in", values, "souhu");
            return (Criteria) this;
        }

        /**
         * And souhu not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andSouhuNotIn(List<Double> values) {
            addCriterion("souhu not in", values, "souhu");
            return (Criteria) this;
        }

        /**
         * And souhu between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andSouhuBetween(Double value1, Double value2) {
            addCriterion("souhu between", value1, value2, "souhu");
            return (Criteria) this;
        }

        /**
         * And souhu not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andSouhuNotBetween(Double value1, Double value2) {
            addCriterion("souhu not between", value1, value2, "souhu");
            return (Criteria) this;
        }

        /**
         * And xinlang is null.
         *
         * @return the criteria
         */
        public Criteria andXinlangIsNull() {
            addCriterion("xinlang is null");
            return (Criteria) this;
        }

        /**
         * And xinlang is not null.
         *
         * @return the criteria
         */
        public Criteria andXinlangIsNotNull() {
            addCriterion("xinlang is not null");
            return (Criteria) this;
        }

        /**
         * And xinlang equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andXinlangEqualTo(Double value) {
            addCriterion("xinlang =", value, "xinlang");
            return (Criteria) this;
        }

        /**
         * And xinlang not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andXinlangNotEqualTo(Double value) {
            addCriterion("xinlang <>", value, "xinlang");
            return (Criteria) this;
        }

        /**
         * And xinlang greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andXinlangGreaterThan(Double value) {
            addCriterion("xinlang >", value, "xinlang");
            return (Criteria) this;
        }

        /**
         * And xinlang greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andXinlangGreaterThanOrEqualTo(Double value) {
            addCriterion("xinlang >=", value, "xinlang");
            return (Criteria) this;
        }

        /**
         * And xinlang less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andXinlangLessThan(Double value) {
            addCriterion("xinlang <", value, "xinlang");
            return (Criteria) this;
        }

        /**
         * And xinlang less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andXinlangLessThanOrEqualTo(Double value) {
            addCriterion("xinlang <=", value, "xinlang");
            return (Criteria) this;
        }

        /**
         * And xinlang in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andXinlangIn(List<Double> values) {
            addCriterion("xinlang in", values, "xinlang");
            return (Criteria) this;
        }

        /**
         * And xinlang not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andXinlangNotIn(List<Double> values) {
            addCriterion("xinlang not in", values, "xinlang");
            return (Criteria) this;
        }

        /**
         * And xinlang between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andXinlangBetween(Double value1, Double value2) {
            addCriterion("xinlang between", value1, value2, "xinlang");
            return (Criteria) this;
        }

        /**
         * And xinlang not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andXinlangNotBetween(Double value1, Double value2) {
            addCriterion("xinlang not between", value1, value2, "xinlang");
            return (Criteria) this;
        }

        /**
         * And jinshan is null.
         *
         * @return the criteria
         */
        public Criteria andJinshanIsNull() {
            addCriterion("jinshan is null");
            return (Criteria) this;
        }

        /**
         * And jinshan is not null.
         *
         * @return the criteria
         */
        public Criteria andJinshanIsNotNull() {
            addCriterion("jinshan is not null");
            return (Criteria) this;
        }

        /**
         * And jinshan equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andJinshanEqualTo(Double value) {
            addCriterion("jinshan =", value, "jinshan");
            return (Criteria) this;
        }

        /**
         * And jinshan not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andJinshanNotEqualTo(Double value) {
            addCriterion("jinshan <>", value, "jinshan");
            return (Criteria) this;
        }

        /**
         * And jinshan greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andJinshanGreaterThan(Double value) {
            addCriterion("jinshan >", value, "jinshan");
            return (Criteria) this;
        }

        /**
         * And jinshan greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andJinshanGreaterThanOrEqualTo(Double value) {
            addCriterion("jinshan >=", value, "jinshan");
            return (Criteria) this;
        }

        /**
         * And jinshan less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andJinshanLessThan(Double value) {
            addCriterion("jinshan <", value, "jinshan");
            return (Criteria) this;
        }

        /**
         * And jinshan less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andJinshanLessThanOrEqualTo(Double value) {
            addCriterion("jinshan <=", value, "jinshan");
            return (Criteria) this;
        }

        /**
         * And jinshan in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andJinshanIn(List<Double> values) {
            addCriterion("jinshan in", values, "jinshan");
            return (Criteria) this;
        }

        /**
         * And jinshan not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andJinshanNotIn(List<Double> values) {
            addCriterion("jinshan not in", values, "jinshan");
            return (Criteria) this;
        }

        /**
         * And jinshan between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andJinshanBetween(Double value1, Double value2) {
            addCriterion("jinshan between", value1, value2, "jinshan");
            return (Criteria) this;
        }

        /**
         * And jinshan not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andJinshanNotBetween(Double value1, Double value2) {
            addCriterion("jinshan not between", value1, value2, "jinshan");
            return (Criteria) this;
        }
    }

    /**
     * The Class Criteria.
     */
    public static class Criteria extends GeneratedCriteria {

        /**
         * Instantiates a new criteria.
         */
        protected Criteria() {
            super();
        }
    }

    /**
     * The Class Criterion.
     */
    public static class Criterion {
        
        /** The condition. */
        private String condition;

        /** The value. */
        private Object value;

        /** The second value. */
        private Object secondValue;

        /** The no value. */
        private boolean noValue;

        /** The single value. */
        private boolean singleValue;

        /** The between value. */
        private boolean betweenValue;

        /** The list value. */
        private boolean listValue;

        /** The type handler. */
        private String typeHandler;

        /**
         * Gets the condition.
         *
         * @return the condition
         */
        public String getCondition() {
            return condition;
        }

        /**
         * Gets the value.
         *
         * @return the value
         */
        public Object getValue() {
            return value;
        }

        /**
         * Gets the second value.
         *
         * @return the second value
         */
        public Object getSecondValue() {
            return secondValue;
        }

        /**
         * Checks if is no value.
         *
         * @return true, if is no value
         */
        public boolean isNoValue() {
            return noValue;
        }

        /**
         * Checks if is single value.
         *
         * @return true, if is single value
         */
        public boolean isSingleValue() {
            return singleValue;
        }

        /**
         * Checks if is between value.
         *
         * @return true, if is between value
         */
        public boolean isBetweenValue() {
            return betweenValue;
        }

        /**
         * Checks if is list value.
         *
         * @return true, if is list value
         */
        public boolean isListValue() {
            return listValue;
        }

        /**
         * Gets the type handler.
         *
         * @return the type handler
         */
        public String getTypeHandler() {
            return typeHandler;
        }

        /**
         * Instantiates a new criterion.
         *
         * @param condition the condition
         */
        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        /**
         * Instantiates a new criterion.
         *
         * @param condition the condition
         * @param value the value
         * @param typeHandler the type handler
         */
        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        /**
         * Instantiates a new criterion.
         *
         * @param condition the condition
         * @param value the value
         */
        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        /**
         * Instantiates a new criterion.
         *
         * @param condition the condition
         * @param value the value
         * @param secondValue the second value
         * @param typeHandler the type handler
         */
        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        /**
         * Instantiates a new criterion.
         *
         * @param condition the condition
         * @param value the value
         * @param secondValue the second value
         */
        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
