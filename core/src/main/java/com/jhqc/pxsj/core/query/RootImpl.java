package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.annotation.process.meta.Meta;

public class RootImpl<T> implements Root<T> {
    private Class<T> domain;
    
    public RootImpl(Class<T> domain) {
        this.domain = domain;
    }

    @Override
    public <U> Join<T, U> join(Class<U> domain) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <U> Join<T, U> leftJoin(Class<U> domain) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <U> Join<T, U> rightJoin(Class<U> domain) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <X> Attribute<X> getAttribute(Meta meta) {
        // TODO Auto-generated method stub
        return null;
    }

}
