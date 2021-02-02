package com.evildoer.exam.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author 安羽兮
 * @description: 冲突异常
 * @datetime: 9:10 2019/12/4
 **/
public class ConflictException extends CommonException {
    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
