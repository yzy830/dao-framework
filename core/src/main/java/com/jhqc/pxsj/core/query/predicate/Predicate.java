package com.jhqc.pxsj.core.query.predicate;

import java.util.List;

import com.jhqc.pxsj.core.StringExpression;

public interface Predicate extends StringExpression {
    Predicate and(Predicate predicate);
    
    Predicate or(Predicate predicate);
    
    List<? extends Parameter<?>> getParams();
}
