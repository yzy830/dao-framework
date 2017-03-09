package com.jhqc.pxsj.core.query.function;

import com.jhqc.pxsj.core.query.variants.Variant;

public interface Unary<R, T> extends Function {
    Class<R> getResultType();
    
    Class<T> getOperatorType();
    
    <U, V> Variant<R, U> apply(Variant<T, V> operator);
}
