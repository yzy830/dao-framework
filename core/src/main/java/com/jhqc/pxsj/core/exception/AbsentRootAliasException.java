package com.jhqc.pxsj.core.exception;

public class AbsentRootAliasException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -5582356342619447424L;

    public AbsentRootAliasException(String alias) {
        super(String.format("there's no root of alias[%s]", alias));
    }
}
