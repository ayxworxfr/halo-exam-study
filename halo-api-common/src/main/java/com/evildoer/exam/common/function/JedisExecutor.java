package com.evildoer.exam.common.function;


import com.evildoer.exam.common.exception.RedisConnectException;

@FunctionalInterface
public interface JedisExecutor<T, R> {
    R excute(T t) throws RedisConnectException;
}
