package com.jhqc.pxsj.core.query.function.variants;

import java.util.Collections;
import java.util.List;

import com.jhqc.pxsj.core.query.function.ParameterizedVariant;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.variants.LongVariant;

public class ParameterizedLongVariant extends LongVariant implements ParameterizedVariant<Long, Number> {
    private List<? extends Parameter<?>> params;
    
    public ParameterizedLongVariant(String exp, List<? extends Parameter<?>> params) {
        super(Long.class, exp);
        
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
