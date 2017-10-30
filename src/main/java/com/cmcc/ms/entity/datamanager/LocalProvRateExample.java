package com.cmcc.ms.entity.datamanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * The Class LocalProvRateExample.
 */
public class LocalProvRateExample {
    
    /** The order by clause. */
    protected String orderByClause;

    /** The distinct. */
    protected boolean distinct;

    /** The ored criteria. */
    protected List<Criteria> oredCriteria;

    /**
     * Instantiates a new local prov rate example.
     */
    public LocalProvRateExample() {
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
         * Adds the criterion for JDBC date.
         *
         * @param condition the condition
         * @param value the value
         * @param property the property
         */
        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        /**
         * Adds the criterion for JDBC date.
         *
         * @param condition the condition
         * @param values the values
         * @param property the property
         */
        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        /**
         * Adds the criterion for JDBC date.
         *
         * @param condition the condition
         * @param value1 the value 1
         * @param value2 the value 2
         * @param property the property
         */
        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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
         * And city user in day avg is null.
         *
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgIsNull() {
            addCriterion("city_user_in_day_avg is null");
            return (Criteria) this;
        }

        /**
         * And city user in day avg is not null.
         *
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgIsNotNull() {
            addCriterion("city_user_in_day_avg is not null");
            return (Criteria) this;
        }

        /**
         * And city user in day avg equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgEqualTo(Integer value) {
            addCriterion("city_user_in_day_avg =", value, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And city user in day avg not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgNotEqualTo(Integer value) {
            addCriterion("city_user_in_day_avg <>", value, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And city user in day avg greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgGreaterThan(Integer value) {
            addCriterion("city_user_in_day_avg >", value, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And city user in day avg greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_user_in_day_avg >=", value, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And city user in day avg less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgLessThan(Integer value) {
            addCriterion("city_user_in_day_avg <", value, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And city user in day avg less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgLessThanOrEqualTo(Integer value) {
            addCriterion("city_user_in_day_avg <=", value, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And city user in day avg in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgIn(List<Integer> values) {
            addCriterion("city_user_in_day_avg in", values, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And city user in day avg not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgNotIn(List<Integer> values) {
            addCriterion("city_user_in_day_avg not in", values, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And city user in day avg between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgBetween(Integer value1, Integer value2) {
            addCriterion("city_user_in_day_avg between", value1, value2, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And city user in day avg not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andCityUserInDayAvgNotBetween(Integer value1, Integer value2) {
            addCriterion("city_user_in_day_avg not between", value1, value2, "cityUserInDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg is null.
         *
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgIsNull() {
            addCriterion("prov_cache_day_avg is null");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg is not null.
         *
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgIsNotNull() {
            addCriterion("prov_cache_day_avg is not null");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgEqualTo(Integer value) {
            addCriterion("prov_cache_day_avg =", value, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgNotEqualTo(Integer value) {
            addCriterion("prov_cache_day_avg <>", value, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgGreaterThan(Integer value) {
            addCriterion("prov_cache_day_avg >", value, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgGreaterThanOrEqualTo(Integer value) {
            addCriterion("prov_cache_day_avg >=", value, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgLessThan(Integer value) {
            addCriterion("prov_cache_day_avg <", value, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgLessThanOrEqualTo(Integer value) {
            addCriterion("prov_cache_day_avg <=", value, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgIn(List<Integer> values) {
            addCriterion("prov_cache_day_avg in", values, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgNotIn(List<Integer> values) {
            addCriterion("prov_cache_day_avg not in", values, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgBetween(Integer value1, Integer value2) {
            addCriterion("prov_cache_day_avg between", value1, value2, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cache day avg not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andProvCacheDayAvgNotBetween(Integer value1, Integer value2) {
            addCriterion("prov_cache_day_avg not between", value1, value2, "provCacheDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg is null.
         *
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgIsNull() {
            addCriterion("prov_cdn_day_avg is null");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg is not null.
         *
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgIsNotNull() {
            addCriterion("prov_cdn_day_avg is not null");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgEqualTo(Integer value) {
            addCriterion("prov_cdn_day_avg =", value, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgNotEqualTo(Integer value) {
            addCriterion("prov_cdn_day_avg <>", value, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgGreaterThan(Integer value) {
            addCriterion("prov_cdn_day_avg >", value, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgGreaterThanOrEqualTo(Integer value) {
            addCriterion("prov_cdn_day_avg >=", value, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgLessThan(Integer value) {
            addCriterion("prov_cdn_day_avg <", value, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgLessThanOrEqualTo(Integer value) {
            addCriterion("prov_cdn_day_avg <=", value, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgIn(List<Integer> values) {
            addCriterion("prov_cdn_day_avg in", values, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgNotIn(List<Integer> values) {
            addCriterion("prov_cdn_day_avg not in", values, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgBetween(Integer value1, Integer value2) {
            addCriterion("prov_cdn_day_avg between", value1, value2, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And prov cdn day avg not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andProvCdnDayAvgNotBetween(Integer value1, Integer value2) {
            addCriterion("prov_cdn_day_avg not between", value1, value2, "provCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg is null.
         *
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgIsNull() {
            addCriterion("unity_cdn_day_avg is null");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg is not null.
         *
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgIsNotNull() {
            addCriterion("unity_cdn_day_avg is not null");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgEqualTo(Integer value) {
            addCriterion("unity_cdn_day_avg =", value, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgNotEqualTo(Integer value) {
            addCriterion("unity_cdn_day_avg <>", value, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgGreaterThan(Integer value) {
            addCriterion("unity_cdn_day_avg >", value, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgGreaterThanOrEqualTo(Integer value) {
            addCriterion("unity_cdn_day_avg >=", value, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgLessThan(Integer value) {
            addCriterion("unity_cdn_day_avg <", value, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgLessThanOrEqualTo(Integer value) {
            addCriterion("unity_cdn_day_avg <=", value, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgIn(List<Integer> values) {
            addCriterion("unity_cdn_day_avg in", values, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgNotIn(List<Integer> values) {
            addCriterion("unity_cdn_day_avg not in", values, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgBetween(Integer value1, Integer value2) {
            addCriterion("unity_cdn_day_avg between", value1, value2, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And unity cdn day avg not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andUnityCdnDayAvgNotBetween(Integer value1, Integer value2) {
            addCriterion("unity_cdn_day_avg not between", value1, value2, "unityCdnDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg is null.
         *
         * @return the criteria
         */
        public Criteria andIdcDayAvgIsNull() {
            addCriterion("idc_day_avg is null");
            return (Criteria) this;
        }

        /**
         * And idc day avg is not null.
         *
         * @return the criteria
         */
        public Criteria andIdcDayAvgIsNotNull() {
            addCriterion("idc_day_avg is not null");
            return (Criteria) this;
        }

        /**
         * And idc day avg equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdcDayAvgEqualTo(Integer value) {
            addCriterion("idc_day_avg =", value, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdcDayAvgNotEqualTo(Integer value) {
            addCriterion("idc_day_avg <>", value, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdcDayAvgGreaterThan(Integer value) {
            addCriterion("idc_day_avg >", value, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdcDayAvgGreaterThanOrEqualTo(Integer value) {
            addCriterion("idc_day_avg >=", value, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdcDayAvgLessThan(Integer value) {
            addCriterion("idc_day_avg <", value, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdcDayAvgLessThanOrEqualTo(Integer value) {
            addCriterion("idc_day_avg <=", value, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andIdcDayAvgIn(List<Integer> values) {
            addCriterion("idc_day_avg in", values, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andIdcDayAvgNotIn(List<Integer> values) {
            addCriterion("idc_day_avg not in", values, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andIdcDayAvgBetween(Integer value1, Integer value2) {
            addCriterion("idc_day_avg between", value1, value2, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And idc day avg not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andIdcDayAvgNotBetween(Integer value1, Integer value2) {
            addCriterion("idc_day_avg not between", value1, value2, "idcDayAvg");
            return (Criteria) this;
        }

        /**
         * And data is null.
         *
         * @return the criteria
         */
        public Criteria andDataIsNull() {
            addCriterion("data is null");
            return (Criteria) this;
        }

        /**
         * And data is not null.
         *
         * @return the criteria
         */
        public Criteria andDataIsNotNull() {
            addCriterion("data is not null");
            return (Criteria) this;
        }

        /**
         * And data equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDataEqualTo(Date value) {
            addCriterionForJDBCDate("data =", value, "data");
            return (Criteria) this;
        }

        /**
         * And data not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDataNotEqualTo(Date value) {
            addCriterionForJDBCDate("data <>", value, "data");
            return (Criteria) this;
        }

        /**
         * And data greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDataGreaterThan(Date value) {
            addCriterionForJDBCDate("data >", value, "data");
            return (Criteria) this;
        }

        /**
         * And data greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("data >=", value, "data");
            return (Criteria) this;
        }

        /**
         * And data less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDataLessThan(Date value) {
            addCriterionForJDBCDate("data <", value, "data");
            return (Criteria) this;
        }

        /**
         * And data less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("data <=", value, "data");
            return (Criteria) this;
        }

        /**
         * And data in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDataIn(List<Date> values) {
            addCriterionForJDBCDate("data in", values, "data");
            return (Criteria) this;
        }

        /**
         * And data not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDataNotIn(List<Date> values) {
            addCriterionForJDBCDate("data not in", values, "data");
            return (Criteria) this;
        }

        /**
         * And data between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("data between", value1, value2, "data");
            return (Criteria) this;
        }

        /**
         * And data not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("data not between", value1, value2, "data");
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