package com.evildoer.exam.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Authentication exception.
 */
public class AuthenticationException extends CommonException {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
