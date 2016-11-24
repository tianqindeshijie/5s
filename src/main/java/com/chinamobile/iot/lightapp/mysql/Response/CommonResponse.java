package com.chinamobile.iot.lightapp.mysql.Response;

/**
 * 返回单个对象
 * @author sxt
 * @since 2016/10/18
 *
 * @param <T> the type parameter
 */
public class CommonResponse<T> {
    /**
     * 单个对象
     */
    private T data;

    /**
     * Gets data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(T data) {
        this.data = data;
    }

}
