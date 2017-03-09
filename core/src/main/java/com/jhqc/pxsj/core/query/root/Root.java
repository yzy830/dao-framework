package com.jhqc.pxsj.core.query.root;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.attributes.Attribute;

public interface Root<T> {
    <U> Join<T, U> join(Class<U> domain);
    
    <U> Join<T, U> leftJoin(Class<U> domain);
    
    <X, U> Attribute<X, U> getAttribute(Meta<X, U> meta);
    
    String getAlias();
    
}