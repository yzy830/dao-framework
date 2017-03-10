package com.jhqc.pxsj.core.exception;

public class DuplicatedAliasException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 2473537236397119811L;

    public DuplicatedAliasException(String alias) {
        super(String.format("the alias[%s] has been used", alias));
    }
}
