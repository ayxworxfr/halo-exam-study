package com.evildoer.exam.common.function;

/**
 * @author evildoer
 */
@FunctionalInterface
public interface CacheSelector<T> {
    T select() throws Exception;
}
