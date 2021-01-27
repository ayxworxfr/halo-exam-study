package com.evildoer.exam.common.exception;

import org.springframework.http.HttpStatus;

/**
 * BeanUtils exception.
 *
 * @Author johnniang
 */
public class BeanUtilsException extends HaloException {

    public BeanUtilsException(String message) {
        super(message);
    }

    public BeanUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
