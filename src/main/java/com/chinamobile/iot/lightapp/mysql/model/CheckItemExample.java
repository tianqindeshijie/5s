package com.chinamobile.iot.lightapp.mysql.model;

import java.util.ArrayList;
import java.util.List;

public class CheckItemExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_item
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_item
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_item
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
     *
     * @mbg.generated
     */
    public CheckItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
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
     * This method corresponds to the database table check_item
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
     * This method corresponds to the database table check_item
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
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
     * This class corresponds to the database table check_item
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

        public Criteria andCheckItemIdIsNull() {
            addCriterion("check_item.check_item_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdIsNotNull() {
            addCriterion("check_item.check_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdEqualTo(Integer value) {
            addCriterion("check_item.check_item_id =", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdNotEqualTo(Integer value) {
            addCriterion("check_item.check_item_id <>", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdGreaterThan(Integer value) {
            addCriterion("check_item.check_item_id >", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_item.check_item_id >=", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdLessThan(Integer value) {
            addCriterion("check_item.check_item_id <", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("check_item.check_item_id <=", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdIn(List<Integer> values) {
            addCriterion("check_item.check_item_id in", values, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdNotIn(List<Integer> values) {
            addCriterion("check_item.check_item_id not in", values, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdBetween(Integer value1, Integer value2) {
            addCriterion("check_item.check_item_id between", value1, value2, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("check_item.check_item_id not between", value1, value2, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameIsNull() {
            addCriterion("check_item.check_item_name is null");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameIsNotNull() {
            addCriterion("check_item.check_item_name is not null");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameEqualTo(String value) {
            addCriterion("check_item.check_item_name =", value, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameNotEqualTo(String value) {
            addCriterion("check_item.check_item_name <>", value, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameGreaterThan(String value) {
            addCriterion("check_item.check_item_name >", value, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("check_item.check_item_name >=", value, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameLessThan(String value) {
            addCriterion("check_item.check_item_name <", value, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameLessThanOrEqualTo(String value) {
            addCriterion("check_item.check_item_name <=", value, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameLike(String value) {
            addCriterion("check_item.check_item_name like", value, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameNotLike(String value) {
            addCriterion("check_item.check_item_name not like", value, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameIn(List<String> values) {
            addCriterion("check_item.check_item_name in", values, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameNotIn(List<String> values) {
            addCriterion("check_item.check_item_name not in", values, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameBetween(String value1, String value2) {
            addCriterion("check_item.check_item_name between", value1, value2, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andCheckItemNameNotBetween(String value1, String value2) {
            addCriterion("check_item.check_item_name not between", value1, value2, "checkItemName");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("check_item.item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("check_item.item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("check_item.item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("check_item.item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("check_item.item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_item.item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("check_item.item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("check_item.item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("check_item.item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("check_item.item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("check_item.item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("check_item.item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentIsNull() {
            addCriterion("check_item.check_item_content is null");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentIsNotNull() {
            addCriterion("check_item.check_item_content is not null");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentEqualTo(String value) {
            addCriterion("check_item.check_item_content =", value, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentNotEqualTo(String value) {
            addCriterion("check_item.check_item_content <>", value, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentGreaterThan(String value) {
            addCriterion("check_item.check_item_content >", value, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentGreaterThanOrEqualTo(String value) {
            addCriterion("check_item.check_item_content >=", value, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentLessThan(String value) {
            addCriterion("check_item.check_item_content <", value, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentLessThanOrEqualTo(String value) {
            addCriterion("check_item.check_item_content <=", value, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentLike(String value) {
            addCriterion("check_item.check_item_content like", value, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentNotLike(String value) {
            addCriterion("check_item.check_item_content not like", value, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentIn(List<String> values) {
            addCriterion("check_item.check_item_content in", values, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentNotIn(List<String> values) {
            addCriterion("check_item.check_item_content not in", values, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentBetween(String value1, String value2) {
            addCriterion("check_item.check_item_content between", value1, value2, "checkItemContent");
            return (Criteria) this;
        }

        public Criteria andCheckItemContentNotBetween(String value1, String value2) {
            addCriterion("check_item.check_item_content not between", value1, value2, "checkItemContent");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table check_item
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
     * This class corresponds to the database table check_item
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