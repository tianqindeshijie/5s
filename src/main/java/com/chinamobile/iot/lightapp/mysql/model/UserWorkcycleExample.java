package com.chinamobile.iot.lightapp.mysql.model;

import java.util.ArrayList;
import java.util.List;

public class UserWorkcycleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public UserWorkcycleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRelationIdIsNull() {
            addCriterion("user_workcycle.relation_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationIdIsNotNull() {
            addCriterion("user_workcycle.relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationIdEqualTo(Integer value) {
            addCriterion("user_workcycle.relation_id =", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotEqualTo(Integer value) {
            addCriterion("user_workcycle.relation_id <>", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThan(Integer value) {
            addCriterion("user_workcycle.relation_id >", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_workcycle.relation_id >=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThan(Integer value) {
            addCriterion("user_workcycle.relation_id <", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_workcycle.relation_id <=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdIn(List<Integer> values) {
            addCriterion("user_workcycle.relation_id in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotIn(List<Integer> values) {
            addCriterion("user_workcycle.relation_id not in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdBetween(Integer value1, Integer value2) {
            addCriterion("user_workcycle.relation_id between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_workcycle.relation_id not between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdIsNull() {
            addCriterion("user_workcycle.work_cycle_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdIsNotNull() {
            addCriterion("user_workcycle.work_cycle_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdEqualTo(Integer value) {
            addCriterion("user_workcycle.work_cycle_id =", value, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdNotEqualTo(Integer value) {
            addCriterion("user_workcycle.work_cycle_id <>", value, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdGreaterThan(Integer value) {
            addCriterion("user_workcycle.work_cycle_id >", value, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_workcycle.work_cycle_id >=", value, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdLessThan(Integer value) {
            addCriterion("user_workcycle.work_cycle_id <", value, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_workcycle.work_cycle_id <=", value, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdIn(List<Integer> values) {
            addCriterion("user_workcycle.work_cycle_id in", values, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdNotIn(List<Integer> values) {
            addCriterion("user_workcycle.work_cycle_id not in", values, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdBetween(Integer value1, Integer value2) {
            addCriterion("user_workcycle.work_cycle_id between", value1, value2, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andWorkCycleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_workcycle.work_cycle_id not between", value1, value2, "workCycleId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_workcycle.user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_workcycle.user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_workcycle.user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_workcycle.user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_workcycle.user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_workcycle.user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_workcycle.user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_workcycle.user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_workcycle.user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_workcycle.user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_workcycle.user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_workcycle.user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIsManagerIsNull() {
            addCriterion("user_workcycle.is_manager is null");
            return (Criteria) this;
        }

        public Criteria andIsManagerIsNotNull() {
            addCriterion("user_workcycle.is_manager is not null");
            return (Criteria) this;
        }

        public Criteria andIsManagerEqualTo(Integer value) {
            addCriterion("user_workcycle.is_manager =", value, "isManager");
            return (Criteria) this;
        }

        public Criteria andIsManagerNotEqualTo(Integer value) {
            addCriterion("user_workcycle.is_manager <>", value, "isManager");
            return (Criteria) this;
        }

        public Criteria andIsManagerGreaterThan(Integer value) {
            addCriterion("user_workcycle.is_manager >", value, "isManager");
            return (Criteria) this;
        }

        public Criteria andIsManagerGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_workcycle.is_manager >=", value, "isManager");
            return (Criteria) this;
        }

        public Criteria andIsManagerLessThan(Integer value) {
            addCriterion("user_workcycle.is_manager <", value, "isManager");
            return (Criteria) this;
        }

        public Criteria andIsManagerLessThanOrEqualTo(Integer value) {
            addCriterion("user_workcycle.is_manager <=", value, "isManager");
            return (Criteria) this;
        }

        public Criteria andIsManagerIn(List<Integer> values) {
            addCriterion("user_workcycle.is_manager in", values, "isManager");
            return (Criteria) this;
        }

        public Criteria andIsManagerNotIn(List<Integer> values) {
            addCriterion("user_workcycle.is_manager not in", values, "isManager");
            return (Criteria) this;
        }

        public Criteria andIsManagerBetween(Integer value1, Integer value2) {
            addCriterion("user_workcycle.is_manager between", value1, value2, "isManager");
            return (Criteria) this;
        }

        public Criteria andIsManagerNotBetween(Integer value1, Integer value2) {
            addCriterion("user_workcycle.is_manager not between", value1, value2, "isManager");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_workcycle
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_workcycle
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

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

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}