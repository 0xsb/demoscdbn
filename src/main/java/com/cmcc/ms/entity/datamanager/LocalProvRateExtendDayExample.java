package com.cmcc.ms.entity.datamanager;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalProvRateExtendDayExample.
 */
public class LocalProvRateExtendDayExample {
    
    /** The order by clause. */
    protected String orderByClause;

    /** The distinct. */
    protected boolean distinct;

    /** The ored criteria. */
    protected List<Criteria> oredCriteria;

    /**
     * Instantiates a new local prov rate extend day example.
     */
    public LocalProvRateExtendDayExample() {
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
         * And local prov R is null.
         *
         * @return the criteria
         */
        public Criteria andLocalProvRIsNull() {
            addCriterion("local_prov_r is null");
            return (Criteria) this;
        }

        /**
         * And local prov R is not null.
         *
         * @return the criteria
         */
        public Criteria andLocalProvRIsNotNull() {
            addCriterion("local_prov_r is not null");
            return (Criteria) this;
        }

        /**
         * And local prov R equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLocalProvREqualTo(Float value) {
            addCriterion("local_prov_r =", value, "localProvR");
            return (Criteria) this;
        }

        /**
         * And local prov R not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLocalProvRNotEqualTo(Float value) {
            addCriterion("local_prov_r <>", value, "localProvR");
            return (Criteria) this;
        }

        /**
         * And local prov R greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLocalProvRGreaterThan(Float value) {
            addCriterion("local_prov_r >", value, "localProvR");
            return (Criteria) this;
        }

        /**
         * And local prov R greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLocalProvRGreaterThanOrEqualTo(Float value) {
            addCriterion("local_prov_r >=", value, "localProvR");
            return (Criteria) this;
        }

        /**
         * And local prov R less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLocalProvRLessThan(Float value) {
            addCriterion("local_prov_r <", value, "localProvR");
            return (Criteria) this;
        }

        /**
         * And local prov R less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLocalProvRLessThanOrEqualTo(Float value) {
            addCriterion("local_prov_r <=", value, "localProvR");
            return (Criteria) this;
        }

        /**
         * And local prov R in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andLocalProvRIn(List<Float> values) {
            addCriterion("local_prov_r in", values, "localProvR");
            return (Criteria) this;
        }

        /**
         * And local prov R not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andLocalProvRNotIn(List<Float> values) {
            addCriterion("local_prov_r not in", values, "localProvR");
            return (Criteria) this;
        }

        /**
         * And local prov R between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andLocalProvRBetween(Float value1, Float value2) {
            addCriterion("local_prov_r between", value1, value2, "localProvR");
            return (Criteria) this;
        }

        /**
         * And local prov R not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andLocalProvRNotBetween(Float value1, Float value2) {
            addCriterion("local_prov_r not between", value1, value2, "localProvR");
            return (Criteria) this;
        }

        /**
         * And month on month is null.
         *
         * @return the criteria
         */
        public Criteria andMonthOnMonthIsNull() {
            addCriterion("month_on_month is null");
            return (Criteria) this;
        }

        /**
         * And month on month is not null.
         *
         * @return the criteria
         */
        public Criteria andMonthOnMonthIsNotNull() {
            addCriterion("month_on_month is not null");
            return (Criteria) this;
        }

        /**
         * And month on month equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMonthOnMonthEqualTo(Float value) {
            addCriterion("month_on_month =", value, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And month on month not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMonthOnMonthNotEqualTo(Float value) {
            addCriterion("month_on_month <>", value, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And month on month greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMonthOnMonthGreaterThan(Float value) {
            addCriterion("month_on_month >", value, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And month on month greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMonthOnMonthGreaterThanOrEqualTo(Float value) {
            addCriterion("month_on_month >=", value, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And month on month less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMonthOnMonthLessThan(Float value) {
            addCriterion("month_on_month <", value, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And month on month less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andMonthOnMonthLessThanOrEqualTo(Float value) {
            addCriterion("month_on_month <=", value, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And month on month in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andMonthOnMonthIn(List<Float> values) {
            addCriterion("month_on_month in", values, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And month on month not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andMonthOnMonthNotIn(List<Float> values) {
            addCriterion("month_on_month not in", values, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And month on month between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andMonthOnMonthBetween(Float value1, Float value2) {
            addCriterion("month_on_month between", value1, value2, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And month on month not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andMonthOnMonthNotBetween(Float value1, Float value2) {
            addCriterion("month_on_month not between", value1, value2, "monthOnMonth");
            return (Criteria) this;
        }

        /**
         * And day on day is null.
         *
         * @return the criteria
         */
        public Criteria andDayOnDayIsNull() {
            addCriterion("day_on_day is null");
            return (Criteria) this;
        }

        /**
         * And day on day is not null.
         *
         * @return the criteria
         */
        public Criteria andDayOnDayIsNotNull() {
            addCriterion("day_on_day is not null");
            return (Criteria) this;
        }

        /**
         * And day on day equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDayOnDayEqualTo(Float value) {
            addCriterion("day_on_day =", value, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And day on day not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDayOnDayNotEqualTo(Float value) {
            addCriterion("day_on_day <>", value, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And day on day greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDayOnDayGreaterThan(Float value) {
            addCriterion("day_on_day >", value, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And day on day greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDayOnDayGreaterThanOrEqualTo(Float value) {
            addCriterion("day_on_day >=", value, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And day on day less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDayOnDayLessThan(Float value) {
            addCriterion("day_on_day <", value, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And day on day less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDayOnDayLessThanOrEqualTo(Float value) {
            addCriterion("day_on_day <=", value, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And day on day in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDayOnDayIn(List<Float> values) {
            addCriterion("day_on_day in", values, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And day on day not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDayOnDayNotIn(List<Float> values) {
            addCriterion("day_on_day not in", values, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And day on day between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDayOnDayBetween(Float value1, Float value2) {
            addCriterion("day_on_day between", value1, value2, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And day on day not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDayOnDayNotBetween(Float value1, Float value2) {
            addCriterion("day_on_day not between", value1, value2, "dayOnDay");
            return (Criteria) this;
        }

        /**
         * And datestr is null.
         *
         * @return the criteria
         */
        public Criteria andDatestrIsNull() {
            addCriterion("dateStr is null");
            return (Criteria) this;
        }

        /**
         * And datestr is not null.
         *
         * @return the criteria
         */
        public Criteria andDatestrIsNotNull() {
            addCriterion("dateStr is not null");
            return (Criteria) this;
        }

        /**
         * And datestr equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDatestrEqualTo(String value) {
            addCriterion("dateStr =", value, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDatestrNotEqualTo(String value) {
            addCriterion("dateStr <>", value, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDatestrGreaterThan(String value) {
            addCriterion("dateStr >", value, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDatestrGreaterThanOrEqualTo(String value) {
            addCriterion("dateStr >=", value, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDatestrLessThan(String value) {
            addCriterion("dateStr <", value, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDatestrLessThanOrEqualTo(String value) {
            addCriterion("dateStr <=", value, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDatestrLike(String value) {
            addCriterion("dateStr like", value, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDatestrNotLike(String value) {
            addCriterion("dateStr not like", value, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDatestrIn(List<String> values) {
            addCriterion("dateStr in", values, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDatestrNotIn(List<String> values) {
            addCriterion("dateStr not in", values, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDatestrBetween(String value1, String value2) {
            addCriterion("dateStr between", value1, value2, "datestr");
            return (Criteria) this;
        }

        /**
         * And datestr not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDatestrNotBetween(String value1, String value2) {
            addCriterion("dateStr not between", value1, value2, "datestr");
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