package com.jhqc.pxsj.core.query.function.impls;

import java.util.Date;

import com.jhqc.pxsj.core.query.function.Simple;
import com.jhqc.pxsj.core.query.variants.DateVariant;

public enum Now implements Simple<Date, Date> {
    INSTANCE
    ; 
    
    @Override
    public Class<Date> getResultType() {
        return Date.class;
    }

    @Override
    public DateVariant apply() {
        return new DateVariant(getResultType(), "now()");
    }
}
