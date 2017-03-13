package com.jhqc.pxsj.core.query.predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jhqc.pxsj.core.type.DbEnum;

class ParameterImpl<T> implements Parameter<T> {
    private static final Logger logger = LogManager.getLogger(ParameterImpl.class);
    
    private Class<? extends T> javaType;
    
    private Object value;
    
    public ParameterImpl(Class<? extends T> javaType, T value) {
        if(javaType == null) {
            throw new IllegalArgumentException();
        }
        
        this.javaType = javaType;
        this.value = value;
    }

    @Override
    public Class<? extends T> getJavaType() {
        return javaType;
    }

    @Override
    public Object getValue() {
        Object result = value;
        
        if(DbEnum.class.isAssignableFrom(javaType)) {
            if(Enum.class.isAssignableFrom(javaType)) {
                result = ((DbEnum)value).getStringVal();
            } else {
                logger.warn(String.format("use DbEnum on non-enum type[%s]", javaType));
            }
        }
        
        return result;
    }
    
    @Override
    public String toString() {
        return getValue() == null? null : getValue().toString();
    }
}
