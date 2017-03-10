package com.jhqc.pxsj.domain.annotation.exception;

/**
 * 结果集必须使用{@link Source}标注
 *
 */
public class InvalidResultClassException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -4809744994659558313L;

    public InvalidResultClassException(Class<?> clazz) {
        super(String.format("invalid result class[%s]", clazz));
    }
}
