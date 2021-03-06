package com.chinamobile.iot.lightapp.mysql.config;

/**
 * Created by xuetao on 2017/2/24.
 */
public class Constant {

    /**
     * The constant SUCCESS_CODE.
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * The constant SUCCESS_MSG.
     */
    public static final String SUCCESS_MSG = "success";

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
    public static final int APPLYTYPE_USER = 0;

    /**
     * 申请类型:1 -- 管理员邀请
     */
    public static final int APPLYTYPE_ADMIN = 1;

    /**
     * 照片类型:0 -- 用户头像
     */
    public static final int PHOTO_TYPE_USER = 0;
    /**
     * 照片类型:1 -- 工作圈头像
     */
    public static final int PHOTO_TYPE_WORKCYCLE = 1;

    /**
     * 照片类型:2 -- 大项检查照片
     */
    public static final int PHOTO_TYPE_CHECK = 2;
    /**
     * 操作类型:1 -- 新增
     */
    public static final int OPERATE_TYPE_ADD = 1;
    /**
     * 操作类型:2 -- 修改
     */
    public static final int OPERATE_TYPE_UPDATE = 2;
    /**
     * 操作类型:3 -- 删除
     */
    public static final int OPERATE_TYPE_DELETE = 3;
}
