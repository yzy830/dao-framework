package com.jhqc.pxsj.core.query.function.impls;

import java.util.Date;

import com.jhqc.pxsj.core.query.Variant;
import com.jhqc.pxsj.core.query.function.Simple;
import com.jhqc.pxsj.core.query.variants.DateVariant;

public class Now implements Simple<Date, Date> {
    
    @Override
    public Class<Date> getResultType() {
        return Date.class;
    }

    @Override
    public Variant<Date, Date> apply() {
        return new DateVariant(getResultType(), "now()");
    }
}
