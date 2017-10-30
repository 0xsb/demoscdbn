package com.cmcc.ms.entity.datashow;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class BaseDataExample.
 */
public class BaseDataExample {
    
    /** The order by clause. */
    protected String orderByClause;

    /** The distinct. */
    protected boolean distinct;

    /** The ored criteria. */
    protected List<Criteria> oredCriteria;

    /**
     * Instantiates a new base data example.
     */
    public BaseDataExample() {
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
        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        /**
         * And id not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        /**
         * And id greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        /**
         * And id greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        /**
         * And id less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        /**
         * And id less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        /**
         * And id like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        /**
         * And id not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        /**
         * And id in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        /**
         * And id not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andIdNotIn(List<String> values) {
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
        public Criteria andIdBetween(String value1, String value2) {
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
        public Criteria andIdNotBetween(String value1, String value2) {
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
         * And dev name is null.
         *
         * @return the criteria
         */
        public Criteria andDevNameIsNull() {
            addCriterion("dev_name is null");
            return (Criteria) this;
        }

        /**
         * And dev name is not null.
         *
         * @return the criteria
         */
        public Criteria andDevNameIsNotNull() {
            addCriterion("dev_name is not null");
            return (Criteria) this;
        }

        /**
         * And dev name equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevNameEqualTo(String value) {
            addCriterion("dev_name =", value, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevNameNotEqualTo(String value) {
            addCriterion("dev_name <>", value, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevNameGreaterThan(String value) {
            addCriterion("dev_name >", value, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevNameGreaterThanOrEqualTo(String value) {
            addCriterion("dev_name >=", value, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevNameLessThan(String value) {
            addCriterion("dev_name <", value, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevNameLessThanOrEqualTo(String value) {
            addCriterion("dev_name <=", value, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevNameLike(String value) {
            addCriterion("dev_name like", value, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevNameNotLike(String value) {
            addCriterion("dev_name not like", value, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDevNameIn(List<String> values) {
            addCriterion("dev_name in", values, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDevNameNotIn(List<String> values) {
            addCriterion("dev_name not in", values, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDevNameBetween(String value1, String value2) {
            addCriterion("dev_name between", value1, value2, "devName");
            return (Criteria) this;
        }

        /**
         * And dev name not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDevNameNotBetween(String value1, String value2) {
            addCriterion("dev_name not between", value1, value2, "devName");
            return (Criteria) this;
        }

        /**
         * And dev ip is null.
         *
         * @return the criteria
         */
        public Criteria andDevIpIsNull() {
            addCriterion("dev_ip is null");
            return (Criteria) this;
        }

        /**
         * And dev ip is not null.
         *
         * @return the criteria
         */
        public Criteria andDevIpIsNotNull() {
            addCriterion("dev_ip is not null");
            return (Criteria) this;
        }

        /**
         * And dev ip equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevIpEqualTo(String value) {
            addCriterion("dev_ip =", value, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevIpNotEqualTo(String value) {
            addCriterion("dev_ip <>", value, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevIpGreaterThan(String value) {
            addCriterion("dev_ip >", value, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevIpGreaterThanOrEqualTo(String value) {
            addCriterion("dev_ip >=", value, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevIpLessThan(String value) {
            addCriterion("dev_ip <", value, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevIpLessThanOrEqualTo(String value) {
            addCriterion("dev_ip <=", value, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevIpLike(String value) {
            addCriterion("dev_ip like", value, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andDevIpNotLike(String value) {
            addCriterion("dev_ip not like", value, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDevIpIn(List<String> values) {
            addCriterion("dev_ip in", values, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andDevIpNotIn(List<String> values) {
            addCriterion("dev_ip not in", values, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDevIpBetween(String value1, String value2) {
            addCriterion("dev_ip between", value1, value2, "devIp");
            return (Criteria) this;
        }

        /**
         * And dev ip not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andDevIpNotBetween(String value1, String value2) {
            addCriterion("dev_ip not between", value1, value2, "devIp");
            return (Criteria) this;
        }

        /**
         * And port name is null.
         *
         * @return the criteria
         */
        public Criteria andPortNameIsNull() {
            addCriterion("port_name is null");
            return (Criteria) this;
        }

        /**
         * And port name is not null.
         *
         * @return the criteria
         */
        public Criteria andPortNameIsNotNull() {
            addCriterion("port_name is not null");
            return (Criteria) this;
        }

        /**
         * And port name equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortNameEqualTo(String value) {
            addCriterion("port_name =", value, "portName");
            return (Criteria) this;
        }

        /**
         * And port name not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortNameNotEqualTo(String value) {
            addCriterion("port_name <>", value, "portName");
            return (Criteria) this;
        }

        /**
         * And port name greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortNameGreaterThan(String value) {
            addCriterion("port_name >", value, "portName");
            return (Criteria) this;
        }

        /**
         * And port name greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortNameGreaterThanOrEqualTo(String value) {
            addCriterion("port_name >=", value, "portName");
            return (Criteria) this;
        }

        /**
         * And port name less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortNameLessThan(String value) {
            addCriterion("port_name <", value, "portName");
            return (Criteria) this;
        }

        /**
         * And port name less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortNameLessThanOrEqualTo(String value) {
            addCriterion("port_name <=", value, "portName");
            return (Criteria) this;
        }

        /**
         * And port name like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortNameLike(String value) {
            addCriterion("port_name like", value, "portName");
            return (Criteria) this;
        }

        /**
         * And port name not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortNameNotLike(String value) {
            addCriterion("port_name not like", value, "portName");
            return (Criteria) this;
        }

        /**
         * And port name in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPortNameIn(List<String> values) {
            addCriterion("port_name in", values, "portName");
            return (Criteria) this;
        }

        /**
         * And port name not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPortNameNotIn(List<String> values) {
            addCriterion("port_name not in", values, "portName");
            return (Criteria) this;
        }

        /**
         * And port name between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPortNameBetween(String value1, String value2) {
            addCriterion("port_name between", value1, value2, "portName");
            return (Criteria) this;
        }

        /**
         * And port name not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPortNameNotBetween(String value1, String value2) {
            addCriterion("port_name not between", value1, value2, "portName");
            return (Criteria) this;
        }

        /**
         * And port type is null.
         *
         * @return the criteria
         */
        public Criteria andPortTypeIsNull() {
            addCriterion("port_type is null");
            return (Criteria) this;
        }

        /**
         * And port type is not null.
         *
         * @return the criteria
         */
        public Criteria andPortTypeIsNotNull() {
            addCriterion("port_type is not null");
            return (Criteria) this;
        }

        /**
         * And port type equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortTypeEqualTo(String value) {
            addCriterion("port_type =", value, "portType");
            return (Criteria) this;
        }

        /**
         * And port type not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortTypeNotEqualTo(String value) {
            addCriterion("port_type <>", value, "portType");
            return (Criteria) this;
        }

        /**
         * And port type greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortTypeGreaterThan(String value) {
            addCriterion("port_type >", value, "portType");
            return (Criteria) this;
        }

        /**
         * And port type greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortTypeGreaterThanOrEqualTo(String value) {
            addCriterion("port_type >=", value, "portType");
            return (Criteria) this;
        }

        /**
         * And port type less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortTypeLessThan(String value) {
            addCriterion("port_type <", value, "portType");
            return (Criteria) this;
        }

        /**
         * And port type less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortTypeLessThanOrEqualTo(String value) {
            addCriterion("port_type <=", value, "portType");
            return (Criteria) this;
        }

        /**
         * And port type like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortTypeLike(String value) {
            addCriterion("port_type like", value, "portType");
            return (Criteria) this;
        }

        /**
         * And port type not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPortTypeNotLike(String value) {
            addCriterion("port_type not like", value, "portType");
            return (Criteria) this;
        }

        /**
         * And port type in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPortTypeIn(List<String> values) {
            addCriterion("port_type in", values, "portType");
            return (Criteria) this;
        }

        /**
         * And port type not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPortTypeNotIn(List<String> values) {
            addCriterion("port_type not in", values, "portType");
            return (Criteria) this;
        }

        /**
         * And port type between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPortTypeBetween(String value1, String value2) {
            addCriterion("port_type between", value1, value2, "portType");
            return (Criteria) this;
        }

        /**
         * And port type not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPortTypeNotBetween(String value1, String value2) {
            addCriterion("port_type not between", value1, value2, "portType");
            return (Criteria) this;
        }

        /**
         * And bus big is null.
         *
         * @return the criteria
         */
        public Criteria andBusBigIsNull() {
            addCriterion("bus_big is null");
            return (Criteria) this;
        }

        /**
         * And bus big is not null.
         *
         * @return the criteria
         */
        public Criteria andBusBigIsNotNull() {
            addCriterion("bus_big is not null");
            return (Criteria) this;
        }

        /**
         * And bus big equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusBigEqualTo(String value) {
            addCriterion("bus_big =", value, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusBigNotEqualTo(String value) {
            addCriterion("bus_big <>", value, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusBigGreaterThan(String value) {
            addCriterion("bus_big >", value, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusBigGreaterThanOrEqualTo(String value) {
            addCriterion("bus_big >=", value, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusBigLessThan(String value) {
            addCriterion("bus_big <", value, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusBigLessThanOrEqualTo(String value) {
            addCriterion("bus_big <=", value, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusBigLike(String value) {
            addCriterion("bus_big like", value, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusBigNotLike(String value) {
            addCriterion("bus_big not like", value, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBusBigIn(List<String> values) {
            addCriterion("bus_big in", values, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBusBigNotIn(List<String> values) {
            addCriterion("bus_big not in", values, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBusBigBetween(String value1, String value2) {
            addCriterion("bus_big between", value1, value2, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus big not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBusBigNotBetween(String value1, String value2) {
            addCriterion("bus_big not between", value1, value2, "busBig");
            return (Criteria) this;
        }

        /**
         * And bus small is null.
         *
         * @return the criteria
         */
        public Criteria andBusSmallIsNull() {
            addCriterion("bus_small is null");
            return (Criteria) this;
        }

        /**
         * And bus small is not null.
         *
         * @return the criteria
         */
        public Criteria andBusSmallIsNotNull() {
            addCriterion("bus_small is not null");
            return (Criteria) this;
        }

        /**
         * And bus small equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusSmallEqualTo(String value) {
            addCriterion("bus_small =", value, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusSmallNotEqualTo(String value) {
            addCriterion("bus_small <>", value, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusSmallGreaterThan(String value) {
            addCriterion("bus_small >", value, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusSmallGreaterThanOrEqualTo(String value) {
            addCriterion("bus_small >=", value, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusSmallLessThan(String value) {
            addCriterion("bus_small <", value, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusSmallLessThanOrEqualTo(String value) {
            addCriterion("bus_small <=", value, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusSmallLike(String value) {
            addCriterion("bus_small like", value, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBusSmallNotLike(String value) {
            addCriterion("bus_small not like", value, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBusSmallIn(List<String> values) {
            addCriterion("bus_small in", values, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBusSmallNotIn(List<String> values) {
            addCriterion("bus_small not in", values, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBusSmallBetween(String value1, String value2) {
            addCriterion("bus_small between", value1, value2, "busSmall");
            return (Criteria) this;
        }

        /**
         * And bus small not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBusSmallNotBetween(String value1, String value2) {
            addCriterion("bus_small not between", value1, value2, "busSmall");
            return (Criteria) this;
        }

        /**
         * And peer device is null.
         *
         * @return the criteria
         */
        public Criteria andPeerDeviceIsNull() {
            addCriterion("peer_device is null");
            return (Criteria) this;
        }

        /**
         * And peer device is not null.
         *
         * @return the criteria
         */
        public Criteria andPeerDeviceIsNotNull() {
            addCriterion("peer_device is not null");
            return (Criteria) this;
        }

        /**
         * And peer device equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPeerDeviceEqualTo(String value) {
            addCriterion("peer_device =", value, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device not equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPeerDeviceNotEqualTo(String value) {
            addCriterion("peer_device <>", value, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device greater than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPeerDeviceGreaterThan(String value) {
            addCriterion("peer_device >", value, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device greater than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPeerDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("peer_device >=", value, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device less than.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPeerDeviceLessThan(String value) {
            addCriterion("peer_device <", value, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device less than or equal to.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPeerDeviceLessThanOrEqualTo(String value) {
            addCriterion("peer_device <=", value, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPeerDeviceLike(String value) {
            addCriterion("peer_device like", value, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device not like.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andPeerDeviceNotLike(String value) {
            addCriterion("peer_device not like", value, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPeerDeviceIn(List<String> values) {
            addCriterion("peer_device in", values, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device not in.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andPeerDeviceNotIn(List<String> values) {
            addCriterion("peer_device not in", values, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPeerDeviceBetween(String value1, String value2) {
            addCriterion("peer_device between", value1, value2, "peerDevice");
            return (Criteria) this;
        }

        /**
         * And peer device not between.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andPeerDeviceNotBetween(String value1, String value2) {
            addCriterion("peer_device not between", value1, value2, "peerDevice");
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
