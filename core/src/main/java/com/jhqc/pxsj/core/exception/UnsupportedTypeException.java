package com.jhqc.pxsj.core.exception;

public class UnsupportedTypeException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public UnsupportedTypeException(Class<?> type) {
        super("not supported type [" + type.getName() + "]");
    }
}
