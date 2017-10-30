package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CpLogoExample.
 */
public class CpLogoExample {
    
    /** The order by clause. */
    protected String orderByClause;

    /** The distinct. */
    protected boolean distinct;

    /** The ored criteria. */
    protected List<Criteria> oredCriteria;

    /**
     * Instantiates a new cp logo example.
     */
    public CpLogoExample() {
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
         * And cp chinese is null.
         *
         * @return the criteria
         */
        public Criteria andCpChineseIsNull() {
            addCriterion("cp_chinese is null");
            return (Criteria) this;
        }

        /**
         * And cp chinese is not null.
         *
         * @return the criteria
         */
        public Criteria andCpChineseIsNotNull() {
            addCriterion("cp_chinese is not null");
            return (Criteria) this;
        }

        /**
         * And cp chinese equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCpChineseEqualTo(String value) {
            addCriterion("cp_chinese =", value, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCpChineseNotEqualTo(String value) {
            addCriterion("cp_chinese <>", value, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCpChineseGreaterThan(String value) {
            addCriterion("cp_chinese >", value, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCpChineseGreaterThanOrEqualTo(String value) {
            addCriterion("cp_chinese >=", value, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCpChineseLessThan(String value) {
            addCriterion("cp_chinese <", value, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCpChineseLessThanOrEqualTo(String value) {
            addCriterion("cp_chinese <=", value, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCpChineseLike(String value) {
            addCriterion("cp_chinese like", value, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCpChineseNotLike(String value) {
            addCriterion("cp_chinese not like", value, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andCpChineseIn(List<String> values) {
            addCriterion("cp_chinese in", values, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andCpChineseNotIn(List<String> values) {
            addCriterion("cp_chinese not in", values, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andCpChineseBetween(String value1, String value2) {
            addCriterion("cp_chinese between", value1, value2, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And cp chinese not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andCpChineseNotBetween(String value1, String value2) {
            addCriterion("cp_chinese not between", value1, value2, "cpChinese");
            return (Criteria) this;
        }

        /**
         * And namestr is null.
         *
         * @return the criteria
         */
        public Criteria andNamestrIsNull() {
            addCriterion("nameStr is null");
            return (Criteria) this;
        }

        /**
         * And namestr is not null.
         *
         * @return the criteria
         */
        public Criteria andNamestrIsNotNull() {
            addCriterion("nameStr is not null");
            return (Criteria) this;
        }

        /**
         * And namestr equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNamestrEqualTo(String value) {
            addCriterion("nameStr =", value, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNamestrNotEqualTo(String value) {
            addCriterion("nameStr <>", value, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNamestrGreaterThan(String value) {
            addCriterion("nameStr >", value, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNamestrGreaterThanOrEqualTo(String value) {
            addCriterion("nameStr >=", value, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNamestrLessThan(String value) {
            addCriterion("nameStr <", value, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNamestrLessThanOrEqualTo(String value) {
            addCriterion("nameStr <=", value, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNamestrLike(String value) {
            addCriterion("nameStr like", value, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNamestrNotLike(String value) {
            addCriterion("nameStr not like", value, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andNamestrIn(List<String> values) {
            addCriterion("nameStr in", values, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andNamestrNotIn(List<String> values) {
            addCriterion("nameStr not in", values, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andNamestrBetween(String value1, String value2) {
            addCriterion("nameStr between", value1, value2, "namestr");
            return (Criteria) this;
        }

        /**
         * And namestr not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andNamestrNotBetween(String value1, String value2) {
            addCriterion("nameStr not between", value1, value2, "namestr");
            return (Criteria) this;
        }

        /**
         * And page is null.
         *
         * @return the criteria
         */
        public Criteria andPageIsNull() {
            addCriterion("page is null");
            return (Criteria) this;
        }

        /**
         * And page is not null.
         *
         * @return the criteria
         */
        public Criteria andPageIsNotNull() {
            addCriterion("page is not null");
            return (Criteria) this;
        }

        /**
         * And page equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPageEqualTo(String value) {
            addCriterion("page =", value, "page");
            return (Criteria) this;
        }

        /**
         * And page not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPageNotEqualTo(String value) {
            addCriterion("page <>", value, "page");
            return (Criteria) this;
        }

        /**
         * And page greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPageGreaterThan(String value) {
            addCriterion("page >", value, "page");
            return (Criteria) this;
        }

        /**
         * And page greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPageGreaterThanOrEqualTo(String value) {
            addCriterion("page >=", value, "page");
            return (Criteria) this;
        }

        /**
         * And page less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPageLessThan(String value) {
            addCriterion("page <", value, "page");
            return (Criteria) this;
        }

        /**
         * And page less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPageLessThanOrEqualTo(String value) {
            addCriterion("page <=", value, "page");
            return (Criteria) this;
        }

        /**
         * And page like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPageLike(String value) {
            addCriterion("page like", value, "page");
            return (Criteria) this;
        }

        /**
         * And page not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPageNotLike(String value) {
            addCriterion("page not like", value, "page");
            return (Criteria) this;
        }

        /**
         * And page in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPageIn(List<String> values) {
            addCriterion("page in", values, "page");
            return (Criteria) this;
        }

        /**
         * And page not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPageNotIn(List<String> values) {
            addCriterion("page not in", values, "page");
            return (Criteria) this;
        }

        /**
         * And page between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPageBetween(String value1, String value2) {
            addCriterion("page between", value1, value2, "page");
            return (Criteria) this;
        }

        /**
         * And page not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPageNotBetween(String value1, String value2) {
            addCriterion("page not between", value1, value2, "page");
            return (Criteria) this;
        }

        /**
         * And logo url is null.
         *
         * @return the criteria
         */
        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        /**
         * And logo url is not null.
         *
         * @return the criteria
         */
        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        /**
         * And logo url equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And logo url not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        /**
         * And updatetime is null.
         *
         * @return the criteria
         */
        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        /**
         * And updatetime is not null.
         *
         * @return the criteria
         */
        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        /**
         * And updatetime equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        /**
         * And updatetime not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        /**
         * And updatetime greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        /**
         * And updatetime greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        /**
         * And updatetime less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        /**
         * And updatetime less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        /**
         * And updatetime in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        /**
         * And updatetime not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        /**
         * And updatetime between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        /**
         * And updatetime not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updatetime not between", value1, value2, "updatetime");
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