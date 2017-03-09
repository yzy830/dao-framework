package com.jhqc.pxsj.core.query.function;

import com.jhqc.pxsj.core.query.Variant;

public interface Unary<R, T> extends Function {
    Class<R> getResultType();
    
    Class<T> getOperatorType();
    
    Variant<R> apply(Variant<T> operator);
}
