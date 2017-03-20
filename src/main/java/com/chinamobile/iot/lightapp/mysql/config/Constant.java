package com.chinamobile.iot.lightapp.mysql.config;

/**
 * Created by xuetao on 2017/2/24.
 */
public class Constant {
    /**
     * The constant SESSION_NAME.
     */
    public static final String SESSION_NAME = "session-token";

    /**
     * The constant USER_ID.
     */
    public static final String USER_ID = "userId";


//------------------实体类状态静态变量-----------------------
    /**
     * 0-工作圈创建者
     */
    public static final int CYCLE_CREATER = 0;
    /**
     * 1-工作圈管理员
     */
    public static final int CYCLE_ADMIN = 1;

    /**
     * 2-工作圈成员
     */
    public static final int CYCLE_MEMBER = 2;

    /**
     * 申请类型:0 -- 用户申请.
     */
    public static final int  APPLYTYPE_USER = 0;

    /**
     * 申请类型:1 -- 管理员邀请
     */
    public static final int  APPLYTYPE_ADMIN = 1;
}
