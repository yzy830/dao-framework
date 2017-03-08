package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.annotation.process.meta.Meta;

public interface Root<T> {
    <U> Join<T, U> join(Class<U> domain);
    
    <U> Join<T, U> leftJoin(Class<U> domain);
    
    <U> Join<T, U> rightJoin(Class<U> domain);
    
    <X> Attribute<X> getAttribute(Meta meta);
}
