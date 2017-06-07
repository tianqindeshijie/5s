package com.chinamobile.iot.lightapp.mysql.response;

/**
 * Created by ztz on 2016/7/5.
 */
public class BaseResponse<T> {
    /**
     * 返回码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

