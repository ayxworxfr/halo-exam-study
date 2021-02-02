package com.evildoer.exam.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author 安羽兮
 * @ClassName DatabaseException
 * @description: TODO
 * @datetime: 2019/12/49:17
 * @Version 1.0
 **/
public class DatabaseException extends CommonException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
