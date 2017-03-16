package com.jhqc.pxsj.dao.integration.exceptions;

import java.util.List;

public class InsertException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 8237499910665766545L;
    
    private String sql;
    
    private List<?> args;

    public InsertException(String sql, List<?> args) {
        super(String.format("fail to execute insert sql[%s], args[%s]", sql, args));
    }

    public String getObj() {
        return sql;
    }

    public List<?> getClazz() {
        return args;
    }
}
