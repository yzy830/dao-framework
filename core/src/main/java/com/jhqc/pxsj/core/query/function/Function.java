package com.jhqc.pxsj.core.query.function;

/**
 * 表示一个SQL函数
 *
 */
public interface Function<R> {
    Class<R> getResultType();
}
