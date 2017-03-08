package com.jhqc.pxsj.annotation.process.exceptions;

public class JoinAbsentPropertyException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -8635433903979017058L;

    private Class<?> targetClass;
    
    private String property;
    
    public JoinAbsentPropertyException(Class<?> targetClass, String property) {
        super(String.format("there is no property[%s] in target join class[]", property, targetClass));
        this.targetClass = targetClass;
        this.property = property;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public String getProperty() {
        return property;
    }
}
