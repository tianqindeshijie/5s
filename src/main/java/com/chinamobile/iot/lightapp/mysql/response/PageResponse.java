package com.chinamobile.iot.lightapp.mysql.response;

import com.github.pagehelper.PageInfo;

/**
 * Page response
 * @author sxt
 * @since 2016/10/18
 */
public class PageResponse<T> {
    /**
     * 对象信息
     */
    private PageInfo<T> data;

    public PageInfo<T> getData() {
        return data;
    }

    public void setData(PageInfo<T> data) {
        this.data = data;
    }
}
