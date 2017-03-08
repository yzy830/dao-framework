package com.jhqc.pxsj.core.query;

public interface Predicate {
    Predicate and(Predicate predicate);
    
    Predicate or(Predicate predicate);
}
