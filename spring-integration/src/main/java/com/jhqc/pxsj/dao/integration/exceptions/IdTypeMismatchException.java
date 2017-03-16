package com.jhqc.pxsj.dao.integration.exceptions;

public class IdTypeMismatchException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -8581654235434852736L;

    public IdTypeMismatchException(Class<?> domain, String sql, Class<?> idType) {
        super(String.format("the sql[%s] generate a numeric key, but the domain[%s] has id type[%s]", sql, domain, idType));
    }
}
