package com.chinamobile.iot.lightapp.mysql.model;

import java.util.ArrayList;
import java.util.List;

public class DiagramExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table diagram
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table diagram
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table diagram
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    public DiagramExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
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
     * This method corresponds to the database table diagram
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
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
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
     * This class corresponds to the database table diagram
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

        public Criteria andDiagramIdIsNull() {
            addCriterion("diagram_id is null");
            return (Criteria) this;
        }

        public Criteria andDiagramIdIsNotNull() {
            addCriterion("diagram_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiagramIdEqualTo(Integer value) {
            addCriterion("diagram_id =", value, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramIdNotEqualTo(Integer value) {
            addCriterion("diagram_id <>", value, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramIdGreaterThan(Integer value) {
            addCriterion("diagram_id >", value, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("diagram_id >=", value, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramIdLessThan(Integer value) {
            addCriterion("diagram_id <", value, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramIdLessThanOrEqualTo(Integer value) {
            addCriterion("diagram_id <=", value, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramIdIn(List<Integer> values) {
            addCriterion("diagram_id in", values, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramIdNotIn(List<Integer> values) {
            addCriterion("diagram_id not in", values, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramIdBetween(Integer value1, Integer value2) {
            addCriterion("diagram_id between", value1, value2, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramIdNotBetween(Integer value1, Integer value2) {
            addCriterion("diagram_id not between", value1, value2, "diagramId");
            return (Criteria) this;
        }

        public Criteria andDiagramNameIsNull() {
            addCriterion("diagram_name is null");
            return (Criteria) this;
        }

        public Criteria andDiagramNameIsNotNull() {
            addCriterion("diagram_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiagramNameEqualTo(String value) {
            addCriterion("diagram_name =", value, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameNotEqualTo(String value) {
            addCriterion("diagram_name <>", value, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameGreaterThan(String value) {
            addCriterion("diagram_name >", value, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameGreaterThanOrEqualTo(String value) {
            addCriterion("diagram_name >=", value, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameLessThan(String value) {
            addCriterion("diagram_name <", value, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameLessThanOrEqualTo(String value) {
            addCriterion("diagram_name <=", value, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameLike(String value) {
            addCriterion("diagram_name like", value, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameNotLike(String value) {
            addCriterion("diagram_name not like", value, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameIn(List<String> values) {
            addCriterion("diagram_name in", values, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameNotIn(List<String> values) {
            addCriterion("diagram_name not in", values, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameBetween(String value1, String value2) {
            addCriterion("diagram_name between", value1, value2, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramNameNotBetween(String value1, String value2) {
            addCriterion("diagram_name not between", value1, value2, "diagramName");
            return (Criteria) this;
        }

        public Criteria andDiagramContentIsNull() {
            addCriterion("diagram_content is null");
            return (Criteria) this;
        }

        public Criteria andDiagramContentIsNotNull() {
            addCriterion("diagram_content is not null");
            return (Criteria) this;
        }

        public Criteria andDiagramContentEqualTo(String value) {
            addCriterion("diagram_content =", value, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentNotEqualTo(String value) {
            addCriterion("diagram_content <>", value, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentGreaterThan(String value) {
            addCriterion("diagram_content >", value, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentGreaterThanOrEqualTo(String value) {
            addCriterion("diagram_content >=", value, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentLessThan(String value) {
            addCriterion("diagram_content <", value, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentLessThanOrEqualTo(String value) {
            addCriterion("diagram_content <=", value, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentLike(String value) {
            addCriterion("diagram_content like", value, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentNotLike(String value) {
            addCriterion("diagram_content not like", value, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentIn(List<String> values) {
            addCriterion("diagram_content in", values, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentNotIn(List<String> values) {
            addCriterion("diagram_content not in", values, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentBetween(String value1, String value2) {
            addCriterion("diagram_content between", value1, value2, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andDiagramContentNotBetween(String value1, String value2) {
            addCriterion("diagram_content not between", value1, value2, "diagramContent");
            return (Criteria) this;
        }

        public Criteria andCycleIdIsNull() {
            addCriterion("cycle_id is null");
            return (Criteria) this;
        }

        public Criteria andCycleIdIsNotNull() {
            addCriterion("cycle_id is not null");
            return (Criteria) this;
        }

        public Criteria andCycleIdEqualTo(Integer value) {
            addCriterion("cycle_id =", value, "cycleId");
            return (Criteria) this;
        }

        public Criteria andCycleIdNotEqualTo(Integer value) {
            addCriterion("cycle_id <>", value, "cycleId");
            return (Criteria) this;
        }

        public Criteria andCycleIdGreaterThan(Integer value) {
            addCriterion("cycle_id >", value, "cycleId");
            return (Criteria) this;
        }

        public Criteria andCycleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cycle_id >=", value, "cycleId");
            return (Criteria) this;
        }

        public Criteria andCycleIdLessThan(Integer value) {
            addCriterion("cycle_id <", value, "cycleId");
            return (Criteria) this;
        }

        public Criteria andCycleIdLessThanOrEqualTo(Integer value) {
            addCriterion("cycle_id <=", value, "cycleId");
            return (Criteria) this;
        }

        public Criteria andCycleIdIn(List<Integer> values) {
            addCriterion("cycle_id in", values, "cycleId");
            return (Criteria) this;
        }

        public Criteria andCycleIdNotIn(List<Integer> values) {
            addCriterion("cycle_id not in", values, "cycleId");
            return (Criteria) this;
        }

        public Criteria andCycleIdBetween(Integer value1, Integer value2) {
            addCriterion("cycle_id between", value1, value2, "cycleId");
            return (Criteria) this;
        }

        public Criteria andCycleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cycle_id not between", value1, value2, "cycleId");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeIsNull() {
            addCriterion("diagram_type is null");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeIsNotNull() {
            addCriterion("diagram_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeEqualTo(Integer value) {
            addCriterion("diagram_type =", value, "diagramType");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeNotEqualTo(Integer value) {
            addCriterion("diagram_type <>", value, "diagramType");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeGreaterThan(Integer value) {
            addCriterion("diagram_type >", value, "diagramType");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("diagram_type >=", value, "diagramType");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeLessThan(Integer value) {
            addCriterion("diagram_type <", value, "diagramType");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeLessThanOrEqualTo(Integer value) {
            addCriterion("diagram_type <=", value, "diagramType");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeIn(List<Integer> values) {
            addCriterion("diagram_type in", values, "diagramType");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeNotIn(List<Integer> values) {
            addCriterion("diagram_type not in", values, "diagramType");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeBetween(Integer value1, Integer value2) {
            addCriterion("diagram_type between", value1, value2, "diagramType");
            return (Criteria) this;
        }

        public Criteria andDiagramTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("diagram_type not between", value1, value2, "diagramType");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table diagram
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
     * This class corresponds to the database table diagram
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