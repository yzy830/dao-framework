package com.jhqc.pxsj.core.query.function;

import java.util.Date;

import com.jhqc.pxsj.core.query.variants.DateVariant;

public enum Now implements Function<Date> {
    INSTANCE
    ; 
    
    @Override
    public Class<Date> getResultType() {
        return Date.class;
    }

    public DateVariant apply() {
        return new DateVariant(getResultType(), "now()");
    }
}
