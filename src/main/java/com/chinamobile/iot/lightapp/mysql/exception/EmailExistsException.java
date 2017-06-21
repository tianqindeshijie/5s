package com.chinamobile.iot.lightapp.mysql.exception;

/**
 * Created by sxt on 2017/6/21.
 */
public class EmailExistsException extends RuntimeException {
    /**
     * Instantiates a new Record exists exception.
     *
     * @param msg the msg
     */
    public EmailExistsException(String msg) {
        super(msg);
    }

    /**
     * Instantiates a new Record exists exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EmailExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
