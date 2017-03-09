package com.jhqc.pxsj.core.query.predicate;

public interface Predicate {
    Predicate and(Predicate predicate);
    
    Predicate or(Predicate predicate);
}
