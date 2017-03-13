package com.jhqc.pxsj.core.query.predicate;

public interface Parameter<T> {
    Class<T> getJavaType();
    
    Object getValue();
}
