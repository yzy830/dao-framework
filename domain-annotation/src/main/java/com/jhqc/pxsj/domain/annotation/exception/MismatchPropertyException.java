package com.jhqc.pxsj.domain.annotation.exception;

/**
 * 结果集的属性与数据源的属性不匹配
 *
 */
public class MismatchPropertyException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 810927374151503194L;

    public MismatchPropertyException(Class<?> resultClass, Class<?> sourceClass, String propertyName) {
        super(String.format("there's no matching property[%s] in source class[%s], result class = ", 
                propertyName, sourceClass, resultClass));
    }
}
