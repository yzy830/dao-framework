package com.jhqc.pxsj.core.exception;

import java.lang.reflect.Method;

public class AccessBeanMethodException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 8022547368579384401L;

    public AccessBeanMethodException(Method method, Exception e) {
        super(String.format("cannot access the method[%s.%s]", method.getDeclaringClass().getName(), method.getName()), e);
    }
}
