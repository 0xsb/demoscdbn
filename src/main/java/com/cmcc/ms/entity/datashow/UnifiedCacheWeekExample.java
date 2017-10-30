package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The Class UnifiedCacheWeekExample.
 */
public class UnifiedCacheWeekExample {
    
    /** The order by clause. */
    protected String orderByClause;

    /** The distinct. */
    protected boolean distinct;

    /** The ored criteria. */
    protected List<Criteria> oredCriteria;

    /**
     * Instantiates a new unified cache week example.
     */
    public UnifiedCacheWeekExample() {
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
         * And id is null.
         *
         * @return the criteria
         */
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        /**
         * And id is not null.
         *
         * @return the criteria
         */
        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        /**
         * And id equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        /**
         * And id not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        /**
         * And id greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        /**
         * And id greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        /**
         * And id less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        /**
         * And id less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        /**
         * And id in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        /**
         * And id not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        /**
         * And id between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        /**
         * And id not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        /**
         * And province is null.
         *
         * @return the criteria
         */
        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        /**
         * And province is not null.
         *
         * @return the criteria
         */
        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        /**
         * And province equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        /**
         * And province not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        /**
         * And province greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        /**
         * And province greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        /**
         * And province less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        /**
         * And province less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        /**
         * And province like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        /**
         * And province not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        /**
         * And province in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        /**
         * And province not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        /**
         * And province between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        /**
         * And province not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        /**
         * And trafficin is null.
         *
         * @return the criteria
         */
        public Criteria andTrafficinIsNull() {
            addCriterion("trafficin is null");
            return (Criteria) this;
        }

        /**
         * And trafficin is not null.
         *
         * @return the criteria
         */
        public Criteria andTrafficinIsNotNull() {
            addCriterion("trafficin is not null");
            return (Criteria) this;
        }

        /**
         * And trafficin equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinEqualTo(Double value) {
            addCriterion("trafficin =", value, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficin not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinNotEqualTo(Double value) {
            addCriterion("trafficin <>", value, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficin greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinGreaterThan(Double value) {
            addCriterion("trafficin >", value, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficin greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinGreaterThanOrEqualTo(Double value) {
            addCriterion("trafficin >=", value, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficin less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinLessThan(Double value) {
            addCriterion("trafficin <", value, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficin less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinLessThanOrEqualTo(Double value) {
            addCriterion("trafficin <=", value, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficin in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTrafficinIn(List<Double> values) {
            addCriterion("trafficin in", values, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficin not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTrafficinNotIn(List<Double> values) {
            addCriterion("trafficin not in", values, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficin between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTrafficinBetween(Double value1, Double value2) {
            addCriterion("trafficin between", value1, value2, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficin not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTrafficinNotBetween(Double value1, Double value2) {
            addCriterion("trafficin not between", value1, value2, "trafficin");
            return (Criteria) this;
        }

        /**
         * And trafficout is null.
         *
         * @return the criteria
         */
        public Criteria andTrafficoutIsNull() {
            addCriterion("trafficout is null");
            return (Criteria) this;
        }

        /**
         * And trafficout is not null.
         *
         * @return the criteria
         */
        public Criteria andTrafficoutIsNotNull() {
            addCriterion("trafficout is not null");
            return (Criteria) this;
        }

        /**
         * And trafficout equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutEqualTo(Double value) {
            addCriterion("trafficout =", value, "trafficout");
            return (Criteria) this;
        }

        /**
         * And trafficout not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutNotEqualTo(Double value) {
            addCriterion("trafficout <>", value, "trafficout");
            return (Criteria) this;
        }

        /**
         * And trafficout greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutGreaterThan(Double value) {
            addCriterion("trafficout >", value, "trafficout");
            return (Criteria) this;
        }

        /**
         * And trafficout greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutGreaterThanOrEqualTo(Double value) {
            addCriterion("trafficout >=", value, "trafficout");
            return (Criteria) this;
        }

        /**
         * And trafficout less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutLessThan(Double value) {
            addCriterion("trafficout <", value, "trafficout");
            return (Criteria) this;
        }

        /**
         * And trafficout less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutLessThanOrEqualTo(Double value) {
            addCriterion("trafficout <=", value, "trafficout");
            return (Criteria) this;
        }

        /**
         * And trafficout in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTrafficoutIn(List<Double> values) {
            addCriterion("trafficout in", values, "trafficout");
            return (Criteria) this;
        }

        /**
         * And trafficout not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTrafficoutNotIn(List<Double> values) {
            addCriterion("trafficout not in", values, "trafficout");
            return (Criteria) this;
        }

        /**
         * And trafficout between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTrafficoutBetween(Double value1, Double value2) {
            addCriterion("trafficout between", value1, value2, "trafficout");
            return (Criteria) this;
        }

        /**
         * And trafficout not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTrafficoutNotBetween(Double value1, Double value2) {
            addCriterion("trafficout not between", value1, value2, "trafficout");
            return (Criteria) this;
        }

        /**
         * And createtime is null.
         *
         * @return the criteria
         */
        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        /**
         * And createtime is not null.
         *
         * @return the criteria
         */
        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        /**
         * And createtime equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        /**
         * And createtime not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        /**
         * And createtime greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        /**
         * And createtime greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        /**
         * And createtime less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        /**
         * And createtime less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        /**
         * And createtime in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        /**
         * And createtime not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        /**
         * And createtime between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        /**
         * And createtime not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        /**
         * And timestr is null.
         *
         * @return the criteria
         */
        public Criteria andTimestrIsNull() {
            addCriterion("timestr is null");
            return (Criteria) this;
        }

        /**
         * And timestr is not null.
         *
         * @return the criteria
         */
        public Criteria andTimestrIsNotNull() {
            addCriterion("timestr is not null");
            return (Criteria) this;
        }

        /**
         * And timestr equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimestrEqualTo(String value) {
            addCriterion("timestr =", value, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimestrNotEqualTo(String value) {
            addCriterion("timestr <>", value, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimestrGreaterThan(String value) {
            addCriterion("timestr >", value, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimestrGreaterThanOrEqualTo(String value) {
            addCriterion("timestr >=", value, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimestrLessThan(String value) {
            addCriterion("timestr <", value, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimestrLessThanOrEqualTo(String value) {
            addCriterion("timestr <=", value, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimestrLike(String value) {
            addCriterion("timestr like", value, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTimestrNotLike(String value) {
            addCriterion("timestr not like", value, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTimestrIn(List<String> values) {
            addCriterion("timestr in", values, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTimestrNotIn(List<String> values) {
            addCriterion("timestr not in", values, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTimestrBetween(String value1, String value2) {
            addCriterion("timestr between", value1, value2, "timestr");
            return (Criteria) this;
        }

        /**
         * And timestr not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTimestrNotBetween(String value1, String value2) {
            addCriterion("timestr not between", value1, value2, "timestr");
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
