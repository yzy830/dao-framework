package com.jhqc.pxsj.core.query.function.variants;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.jhqc.pxsj.core.query.function.ParameterizedVariant;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.variants.DateVariant;

public class ParameterizedDateVariant extends DateVariant implements ParameterizedVariant<Date, Date> {
    private List<? extends Parameter<?>> params;
    
    public ParameterizedDateVariant(String exp, List<? extends Parameter<?>> params) {
        super(Date.class, exp);
        
        if(params == null) {
            throw new IllegalArgumentException();
        }
        
        this.params = Collections.unmodifiableList(params);
    }

    @Override
    public List<? extends Parameter<?>> getParams() {
        return params;
    }

}
