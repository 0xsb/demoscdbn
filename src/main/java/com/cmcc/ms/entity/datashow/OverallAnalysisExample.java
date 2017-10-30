package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * The Class OverallAnalysisExample.
 */
public class OverallAnalysisExample {
    
    /** The order by clause. */
    protected String orderByClause;

    /** The distinct. */
    protected boolean distinct;

    /** The ored criteria. */
    protected List<Criteria> oredCriteria;

    /**
     * Instantiates a new overall analysis example.
     */
    public OverallAnalysisExample() {
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
                throw new RuntimeException("Value list for " + property
                        + " cannot be null or empty");
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
        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2,
                                               String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()),
                    new java.sql.Date(value2.getTime()), property);
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
         * And name is null.
         *
         * @return the criteria
         */
        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        /**
         * And name is not null.
         *
         * @return the criteria
         */
        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        /**
         * And name equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        /**
         * And name not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        /**
         * And name greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        /**
         * And name greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        /**
         * And name less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        /**
         * And name less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        /**
         * And name like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        /**
         * And name not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        /**
         * And name in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        /**
         * And name not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        /**
         * And name between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        /**
         * And name not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        /**
         * And ports is null.
         *
         * @return the criteria
         */
        public Criteria andPortsIsNull() {
            addCriterion("ports is null");
            return (Criteria) this;
        }

        /**
         * And ports is not null.
         *
         * @return the criteria
         */
        public Criteria andPortsIsNotNull() {
            addCriterion("ports is not null");
            return (Criteria) this;
        }

        /**
         * And ports equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortsEqualTo(Integer value) {
            addCriterion("ports =", value, "ports");
            return (Criteria) this;
        }

        /**
         * And ports not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortsNotEqualTo(Integer value) {
            addCriterion("ports <>", value, "ports");
            return (Criteria) this;
        }

        /**
         * And ports greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortsGreaterThan(Integer value) {
            addCriterion("ports >", value, "ports");
            return (Criteria) this;
        }

        /**
         * And ports greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ports >=", value, "ports");
            return (Criteria) this;
        }

        /**
         * And ports less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortsLessThan(Integer value) {
            addCriterion("ports <", value, "ports");
            return (Criteria) this;
        }

        /**
         * And ports less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortsLessThanOrEqualTo(Integer value) {
            addCriterion("ports <=", value, "ports");
            return (Criteria) this;
        }

        /**
         * And ports in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPortsIn(List<Integer> values) {
            addCriterion("ports in", values, "ports");
            return (Criteria) this;
        }

        /**
         * And ports not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPortsNotIn(List<Integer> values) {
            addCriterion("ports not in", values, "ports");
            return (Criteria) this;
        }

        /**
         * And ports between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPortsBetween(Integer value1, Integer value2) {
            addCriterion("ports between", value1, value2, "ports");
            return (Criteria) this;
        }

        /**
         * And ports not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPortsNotBetween(Integer value1, Integer value2) {
            addCriterion("ports not between", value1, value2, "ports");
            return (Criteria) this;
        }

        /**
         * And bandwidth is null.
         *
         * @return the criteria
         */
        public Criteria andBandwidthIsNull() {
            addCriterion("bandwidth is null");
            return (Criteria) this;
        }

        /**
         * And bandwidth is not null.
         *
         * @return the criteria
         */
        public Criteria andBandwidthIsNotNull() {
            addCriterion("bandwidth is not null");
            return (Criteria) this;
        }

        /**
         * And bandwidth equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBandwidthEqualTo(Double value) {
            addCriterion("bandwidth =", value, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And bandwidth not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBandwidthNotEqualTo(Double value) {
            addCriterion("bandwidth <>", value, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And bandwidth greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBandwidthGreaterThan(Double value) {
            addCriterion("bandwidth >", value, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And bandwidth greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBandwidthGreaterThanOrEqualTo(Double value) {
            addCriterion("bandwidth >=", value, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And bandwidth less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBandwidthLessThan(Double value) {
            addCriterion("bandwidth <", value, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And bandwidth less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBandwidthLessThanOrEqualTo(Double value) {
            addCriterion("bandwidth <=", value, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And bandwidth in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBandwidthIn(List<Double> values) {
            addCriterion("bandwidth in", values, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And bandwidth not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBandwidthNotIn(List<Double> values) {
            addCriterion("bandwidth not in", values, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And bandwidth between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBandwidthBetween(Double value1, Double value2) {
            addCriterion("bandwidth between", value1, value2, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And bandwidth not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBandwidthNotBetween(Double value1, Double value2) {
            addCriterion("bandwidth not between", value1, value2, "bandwidth");
            return (Criteria) this;
        }

        /**
         * And trafficins is null.
         *
         * @return the criteria
         */
        public Criteria andTrafficinsIsNull() {
            addCriterion("trafficins is null");
            return (Criteria) this;
        }

        /**
         * And trafficins is not null.
         *
         * @return the criteria
         */
        public Criteria andTrafficinsIsNotNull() {
            addCriterion("trafficins is not null");
            return (Criteria) this;
        }

        /**
         * And trafficins equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinsEqualTo(Double value) {
            addCriterion("trafficins =", value, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficins not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinsNotEqualTo(Double value) {
            addCriterion("trafficins <>", value, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficins greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinsGreaterThan(Double value) {
            addCriterion("trafficins >", value, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficins greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinsGreaterThanOrEqualTo(Double value) {
            addCriterion("trafficins >=", value, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficins less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinsLessThan(Double value) {
            addCriterion("trafficins <", value, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficins less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficinsLessThanOrEqualTo(Double value) {
            addCriterion("trafficins <=", value, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficins in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTrafficinsIn(List<Double> values) {
            addCriterion("trafficins in", values, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficins not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTrafficinsNotIn(List<Double> values) {
            addCriterion("trafficins not in", values, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficins between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTrafficinsBetween(Double value1, Double value2) {
            addCriterion("trafficins between", value1, value2, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficins not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTrafficinsNotBetween(Double value1, Double value2) {
            addCriterion("trafficins not between", value1, value2, "trafficins");
            return (Criteria) this;
        }

        /**
         * And trafficouts is null.
         *
         * @return the criteria
         */
        public Criteria andTrafficoutsIsNull() {
            addCriterion("trafficouts is null");
            return (Criteria) this;
        }

        /**
         * And trafficouts is not null.
         *
         * @return the criteria
         */
        public Criteria andTrafficoutsIsNotNull() {
            addCriterion("trafficouts is not null");
            return (Criteria) this;
        }

        /**
         * And trafficouts equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutsEqualTo(Double value) {
            addCriterion("trafficouts =", value, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And trafficouts not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutsNotEqualTo(Double value) {
            addCriterion("trafficouts <>", value, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And trafficouts greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutsGreaterThan(Double value) {
            addCriterion("trafficouts >", value, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And trafficouts greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutsGreaterThanOrEqualTo(Double value) {
            addCriterion("trafficouts >=", value, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And trafficouts less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutsLessThan(Double value) {
            addCriterion("trafficouts <", value, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And trafficouts less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andTrafficoutsLessThanOrEqualTo(Double value) {
            addCriterion("trafficouts <=", value, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And trafficouts in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTrafficoutsIn(List<Double> values) {
            addCriterion("trafficouts in", values, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And trafficouts not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andTrafficoutsNotIn(List<Double> values) {
            addCriterion("trafficouts not in", values, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And trafficouts between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTrafficoutsBetween(Double value1, Double value2) {
            addCriterion("trafficouts between", value1, value2, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And trafficouts not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andTrafficoutsNotBetween(Double value1, Double value2) {
            addCriterion("trafficouts not between", value1, value2, "trafficouts");
            return (Criteria) this;
        }

        /**
         * And creattime is null.
         *
         * @return the criteria
         */
        public Criteria andCreattimeIsNull() {
            addCriterion("creattime is null");
            return (Criteria) this;
        }

        /**
         * And creattime is not null.
         *
         * @return the criteria
         */
        public Criteria andCreattimeIsNotNull() {
            addCriterion("creattime is not null");
            return (Criteria) this;
        }

        /**
         * And creattime equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreattimeEqualTo(Date value) {
            addCriterionForJDBCDate("creattime =", value, "creattime");
            return (Criteria) this;
        }

        /**
         * And creattime not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("creattime <>", value, "creattime");
            return (Criteria) this;
        }

        /**
         * And creattime greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterionForJDBCDate("creattime >", value, "creattime");
            return (Criteria) this;
        }

        /**
         * And creattime greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("creattime >=", value, "creattime");
            return (Criteria) this;
        }

        /**
         * And creattime less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreattimeLessThan(Date value) {
            addCriterionForJDBCDate("creattime <", value, "creattime");
            return (Criteria) this;
        }

        /**
         * And creattime less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("creattime <=", value, "creattime");
            return (Criteria) this;
        }

        /**
         * And creattime in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andCreattimeIn(List<Date> values) {
            addCriterionForJDBCDate("creattime in", values, "creattime");
            return (Criteria) this;
        }

        /**
         * And creattime not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("creattime not in", values, "creattime");
            return (Criteria) this;
        }

        /**
         * And creattime between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("creattime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        /**
         * And creattime not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("creattime not between", value1, value2, "creattime");
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
