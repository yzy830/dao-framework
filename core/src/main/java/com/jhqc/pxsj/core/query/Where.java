package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.predicate.Predicate;

public interface Where<T> {
    Query<T> where(Predicate predicate);
    
    Class<T> getResultType();
}
