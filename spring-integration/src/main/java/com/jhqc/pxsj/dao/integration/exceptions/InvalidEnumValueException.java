package com.jhqc.pxsj.dao.integration.exceptions;

import java.beans.PropertyDescriptor;

public class InvalidEnumValueException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 3075858264000823071L;

    public InvalidEnumValueException(String value, PropertyDescriptor pd) {
        super(String.format("invalid value[%s] for enum property[%s]", value, pd.getName()));
    }
}
