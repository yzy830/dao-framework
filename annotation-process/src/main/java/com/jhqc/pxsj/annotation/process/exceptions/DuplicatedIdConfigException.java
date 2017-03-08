package com.jhqc.pxsj.annotation.process.exceptions;

import java.beans.PropertyDescriptor;

public class DuplicatedIdConfigException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -962908897406163942L;

    public DuplicatedIdConfigException(Class<?> domainModel, PropertyDescriptor property1, PropertyDescriptor property2) {
        super(String.format("duplicated id configuaration in class[%s], property1 = %s, property2 = %s", 
                domainModel.getName(), property1.getName(), property2.getName()));
    }
}
