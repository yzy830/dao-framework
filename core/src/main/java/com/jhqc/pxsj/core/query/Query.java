package com.jhqc.pxsj.core.query;

public interface Query<T> {
    Query<T> where(Predicate predicate);
    
    Query<T> select(Attribute<?>...attributes);
    
    Query<T> selectAuto();
    
    <U> Query<T> from(Root<U> root);
}
