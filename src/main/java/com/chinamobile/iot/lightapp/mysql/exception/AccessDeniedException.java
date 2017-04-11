package com.chinamobile.iot.lightapp.mysql.exception;

/**
 * Created by xuetao on 2017/3/6.
 */
public class AccessDeniedException extends RuntimeException{
//    private int code ;  //异常对应的返回码
//    private String message;  //异常对应的描述信息

    /**
     * Instantiates a new Parameter exception.
     */
    public AccessDeniedException() {
        super();
    }

    /**
     * Instantiates a new Parameter exception.
     *
     * @param message the message
     */
    public AccessDeniedException(String message) {
        super(message);
//        message = message;
    }

//    @Override
//    public String getMessage() {
//        return message;
//    }
//
//    /**
//     * Sets message.
//     *
//     * @param message the message
//     */
//    public void setMessage(String message) {
//        this.message = message;
//    }

//    /**
//     * Instantiates a new Parameter exception.
//     *
//     * @param code   the code
//     * @param msgDes the msg des
//     */
//    public AccessDeniedException(int code, String msgDes) {
//        super();
//        this.code = code;
//        this.message = msgDes;
//    }
//
//    /**
//     * Gets code.
//     *
//     * @return the code
//     */
//    public int getCode() {
//        return code;
//    }
//
//    /**
//     * Sets code.
//     *
//     * @param code the code
//     */
//    public void setCode(int code) {
//        this.code = code;
//    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}
