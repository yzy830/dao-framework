package com.jhqc.pxsj.annotation.process.exceptions;

import java.beans.PropertyDescriptor;

public class SetterTypeMismatchException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -8586848056274162892L;
    
    private Object obj;
    
    private PropertyDescriptor descriptor;

    public SetterTypeMismatchException(Object obj, PropertyDescriptor descriptor) {
        super("type mismatch, target class = " + obj.getClass() + ", descriptor = " + descriptor.getWriteMethod().getDeclaringClass());
        this.obj = obj;
        this.descriptor = descriptor;
    }

    public Object getObj() {
        return obj;
    }

    public PropertyDescriptor getDescriptor() {
        return descriptor;
    }
}
