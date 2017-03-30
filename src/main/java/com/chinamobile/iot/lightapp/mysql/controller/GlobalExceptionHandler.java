package com.chinamobile.iot.lightapp.mysql.controller;

import com.chinamobile.iot.lightapp.mysql.response.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuetao on 2016/10/18.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Handle sql exception exception response.
     *
     * @param request      the request
     * @param sqlException the sql exception
     * @return the exception response
     */
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleSQLException(HttpServletRequest request, SQLException sqlException) {
        log.error("Occured sql exception,Returning HTTP 500 Request", sqlException);
        String message = sqlException.getMessage();
        return ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    /**
     * Handle io exception.
     *
     * @param ioException the io exception
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ExceptionResponse handleIOException(IOException ioException) {
        log.error("Occured io exception,Returning HTTP 404 Bad Request", ioException);
        String message = ioException.getMessage();
        return ExceptionResponse.create(HttpStatus.NOT_FOUND.value(), message);
    }

    /**
     * handler illegal argument exception
     *
     * @param request                  the request
     * @param illegalArgumentException the illegal argument exception
     * @return the exception response
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ResponseBody
    public ExceptionResponse handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException illegalArgumentException) {
        log.error("Occured illegalArgumentException, Returning HTTP 400 Bad Request", illegalArgumentException);
        String message = illegalArgumentException.getMessage();
        return ExceptionResponse.create(HttpStatus.BAD_REQUEST.value(), message);
    }

    /**
     * handle method argument type mismatch Exception
     *
     * @param request   the request
     * @param exception the method argument type mismatch Exception
     * @return the exception response
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleMethodArgumentTypeMismatchException(HttpServletRequest request, Exception exception) {
        log.error("ccured MethodArgumentTypeMismatchException,Returning HTTP 500 Bad Request", exception);
        String message = exception.getMessage();
        return ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    /**
     * 其它未知错误类型的处理
     *
     * @param request   the request
     * @param exception the unknown exception
     * @return the exception response
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleOtherException(HttpServletRequest request, Exception exception) {
        log.error("Returning HTTP 500 Bad Request", exception);
        String message = exception.getMessage();
        return ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException exception) {
        log.error("Occurred MethodArgumentNotValidException, Returning HTTP 500 internal server error!", exception);
        BindingResult bindingResult = exception.getBindingResult();
        Map<String, String> errorMap = new HashMap<String, String>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            errorMap.put(field, defaultMessage);
        }
        return ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Parameter valid Invalid!", errorMap);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleMissingServletRequestParameterException(HttpServletRequest request, MissingServletRequestParameterException exception) {
        log.error("Occurred MissingServletRequestParameterException, Returning HTTP 500 internal server error!", exception);
        String parameterName = exception.getParameterName();
        String parameterType = exception.getParameterType();
        String msg=String.format("Please enter %s ,ParameterType is %s", parameterName,parameterType);
        return ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }
}