package com.jhqc.pxsj.core.query.function;

import com.jhqc.pxsj.core.query.Variant;

public interface Simple<R, U> extends Function {
    Class<R> getResultType();
    
    Variant<R, U> apply();
}
