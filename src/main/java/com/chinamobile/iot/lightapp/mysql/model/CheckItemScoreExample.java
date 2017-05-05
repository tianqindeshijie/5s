package com.chinamobile.iot.lightapp.mysql.model;

import java.util.ArrayList;
import java.util.List;

public class CheckItemScoreExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    public CheckItemScoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
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
     * This method corresponds to the database table check_item_score
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
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
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
     * This class corresponds to the database table check_item_score
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

        public Criteria andCheckItemScoreIdIsNull() {
            addCriterion("check_item_score_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdIsNotNull() {
            addCriterion("check_item_score_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdEqualTo(Integer value) {
            addCriterion("check_item_score_id =", value, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdNotEqualTo(Integer value) {
            addCriterion("check_item_score_id <>", value, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdGreaterThan(Integer value) {
            addCriterion("check_item_score_id >", value, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_item_score_id >=", value, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdLessThan(Integer value) {
            addCriterion("check_item_score_id <", value, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("check_item_score_id <=", value, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdIn(List<Integer> values) {
            addCriterion("check_item_score_id in", values, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdNotIn(List<Integer> values) {
            addCriterion("check_item_score_id not in", values, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdBetween(Integer value1, Integer value2) {
            addCriterion("check_item_score_id between", value1, value2, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemScoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("check_item_score_id not between", value1, value2, "checkItemScoreId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdIsNull() {
            addCriterion("check_item_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdIsNotNull() {
            addCriterion("check_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdEqualTo(Integer value) {
            addCriterion("check_item_id =", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdNotEqualTo(Integer value) {
            addCriterion("check_item_id <>", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdGreaterThan(Integer value) {
            addCriterion("check_item_id >", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_item_id >=", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdLessThan(Integer value) {
            addCriterion("check_item_id <", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("check_item_id <=", value, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdIn(List<Integer> values) {
            addCriterion("check_item_id in", values, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdNotIn(List<Integer> values) {
            addCriterion("check_item_id not in", values, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdBetween(Integer value1, Integer value2) {
            addCriterion("check_item_id between", value1, value2, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andCheckItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("check_item_id not between", value1, value2, "checkItemId");
            return (Criteria) this;
        }

        public Criteria andRemarkContentIsNull() {
            addCriterion("remark_content is null");
            return (Criteria) this;
        }

        public Criteria andRemarkContentIsNotNull() {
            addCriterion("remark_content is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkContentEqualTo(String value) {
            addCriterion("remark_content =", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentNotEqualTo(String value) {
            addCriterion("remark_content <>", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentGreaterThan(String value) {
            addCriterion("remark_content >", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentGreaterThanOrEqualTo(String value) {
            addCriterion("remark_content >=", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentLessThan(String value) {
            addCriterion("remark_content <", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentLessThanOrEqualTo(String value) {
            addCriterion("remark_content <=", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentLike(String value) {
            addCriterion("remark_content like", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentNotLike(String value) {
            addCriterion("remark_content not like", value, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentIn(List<String> values) {
            addCriterion("remark_content in", values, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentNotIn(List<String> values) {
            addCriterion("remark_content not in", values, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentBetween(String value1, String value2) {
            addCriterion("remark_content between", value1, value2, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andRemarkContentNotBetween(String value1, String value2) {
            addCriterion("remark_content not between", value1, value2, "remarkContent");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdIsNull() {
            addCriterion("report_item_score_id is null");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdIsNotNull() {
            addCriterion("report_item_score_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdEqualTo(Integer value) {
            addCriterion("report_item_score_id =", value, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdNotEqualTo(Integer value) {
            addCriterion("report_item_score_id <>", value, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdGreaterThan(Integer value) {
            addCriterion("report_item_score_id >", value, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_item_score_id >=", value, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdLessThan(Integer value) {
            addCriterion("report_item_score_id <", value, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("report_item_score_id <=", value, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdIn(List<Integer> values) {
            addCriterion("report_item_score_id in", values, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdNotIn(List<Integer> values) {
            addCriterion("report_item_score_id not in", values, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdBetween(Integer value1, Integer value2) {
            addCriterion("report_item_score_id between", value1, value2, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportItemScoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("report_item_score_id not between", value1, value2, "reportItemScoreId");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(Integer value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(Integer value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(Integer value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(Integer value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(Integer value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<Integer> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<Integer> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(Integer value1, Integer value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table check_item_score
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
     * This class corresponds to the database table check_item_score
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