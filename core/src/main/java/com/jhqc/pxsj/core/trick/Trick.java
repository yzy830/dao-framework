package com.jhqc.pxsj.core.trick;

public interface Trick<T> {    
    <D> TrickRoot<T, D> root(Class<D> domain, String alias);
    
    Class<T> getResultType();
}
