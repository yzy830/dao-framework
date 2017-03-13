package com.jhqc.pxsj.core.query.predicate;

public interface Parameter<T> {
    Class<? extends T> getJavaType();
    
    Object getValue();
}
