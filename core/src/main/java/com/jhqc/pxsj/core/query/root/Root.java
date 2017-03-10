package com.jhqc.pxsj.core.query.root;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.attributes.Attribute;

public interface Root<T> {
    <U> Join<T, U> join(Class<U> domain);
    
    <U> Join<T, U> join(Class<U> domain, String alias);
    
    <U> Join<T, U> leftJoin(Class<U> domain);
    
    <U> Join<T, U> leftJoin(Class<U> domain, String alias);
    
    <X, U> Attribute<X, U> get(Meta<X, U> meta);
    
    String getAlias();
    
}
