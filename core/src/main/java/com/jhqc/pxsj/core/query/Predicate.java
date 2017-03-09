package com.jhqc.pxsj.core.query;

import java.util.List;

public interface Predicate {
    Predicate and(Predicate predicate);
    
    Predicate or(Predicate predicate);
    
    List<Object> getParams();
}
