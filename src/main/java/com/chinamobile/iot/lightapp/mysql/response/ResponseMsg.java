package com.chinamobile.iot.lightapp.mysql.response;

public class ResponseMsg {
    /**
     * 表示返回成功
     */
    public static final String SUCCESS = "success";
    /**
     * 不存在
     */
    public static final String NOT_FOUND = "not found";
    /**
     * 用户请求参数有误
     */
    public static final String HTTP_PARAMETER_ERROR = 400;
    /**
     * 表示API调用时的参数有误
     */
    public static final String PARAMETER_ERROR = 422;
    /**
     * 表示鉴权失败
     */
    public static final String AUTHORIZE_FAILED = 401;
    /**
     * 表示其他服务端错误
     */
    public static final String SERVER_ERROR = 500;

    /**
     * 该用户无权限访问API
     */
    public static final String ACCESS_FAILED = 4;

    /**
     * ACCESS_TOKEN失效
     */
    public static final String ACCESS_TOKEN_INVALID = 5;

    /**
     * 鉴权未知错误
     */
    public static final String ACCESS_UNKNOWN_ERROR = 6;

    /**
     * 未获取ACCESS_TOKEN参数
     */
    public static final String NO_ACCESS_TOKEN = 7;

    /**
     * 表示http请求错误
     */
    public static final String HTTP_METHOD_ERROR = 415;

    /**
     * 表示资源不存在，被删除或失效
     */
    public static final String SOURCE_NOT_EXIST_ERROR = 410;

    /**
     * 发送命令道设备失败.
     */
    public static final String SEND_COMMAND_ERROR = 412;
}
