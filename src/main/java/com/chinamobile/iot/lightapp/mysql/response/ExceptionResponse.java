package com.chinamobile.iot.lightapp.mysql.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * Exception返回的json数据
 *
 * @author sxt
 * @since 2016/10/18
 */
public class ExceptionResponse {

    private String msg;
    private Integer code;
    @ApiModelProperty("异常原因")
    private Object data;

    /**
     * Construction Method
     *
     * @param code
     * @param msg
     */
    public ExceptionResponse(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    /**
     * Construction Method
     *
     * @param code
     * @param msg
     */
    public ExceptionResponse(Integer code, String msg, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static ExceptionResponse create(Integer code, String msg) {
        return new ExceptionResponse(code, msg);
    }

    public static ExceptionResponse create(Integer code, String msg, Object data) {
        return new ExceptionResponse(code, msg, data);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}