package com.jhqc.pxsj.core.exception;

/**
 * 尝试插入非领域模型时，会抛出这个异常
 *
 */
public class InsertNonDomainModelException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -5374749574076500226L;

    public InsertNonDomainModelException(Class<?> clazz) {
        super(String.format("[%s] is not a domain model", clazz));
    }
}
