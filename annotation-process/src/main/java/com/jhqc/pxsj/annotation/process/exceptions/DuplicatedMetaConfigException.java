package com.jhqc.pxsj.annotation.process.exceptions;

import java.beans.PropertyDescriptor;

public class DuplicatedMetaConfigException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 872632588980402125L;
 
    public DuplicatedMetaConfigException(Class<?> domainModel, PropertyDescriptor property) {
        super(String.format("property[%s] of class[%s] has invalid meta configuration", property.getName(), domainModel.getName()));
    }
}
