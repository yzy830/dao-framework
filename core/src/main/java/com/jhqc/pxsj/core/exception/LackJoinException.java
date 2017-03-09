package com.jhqc.pxsj.core.exception;

public class LackJoinException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 8447003903313565872L;

    public LackJoinException(Class<?> root, Class<?> join) {
        super(String.format("cannot join [%s] and [%s]", root.getName(), join.getName()));
    }
}
