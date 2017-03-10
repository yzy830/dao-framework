package com.jhqc.pxsj.core.trick;

public interface Trick<T> {
    public enum TrickType {
        AND,
        OR
    }
    
    <D> TrickRoot<T, D> root(Class<D> domain, String alias);
    
    Class<T> getResultType();
}
