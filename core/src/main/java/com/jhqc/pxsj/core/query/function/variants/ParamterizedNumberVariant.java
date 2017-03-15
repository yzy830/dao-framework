package com.jhqc.pxsj.core.query.function.variants;

import java.util.Collections;
import java.util.List;

import com.jhqc.pxsj.core.query.function.ParameterizedVariant;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.variants.NumberVariant;

public class ParamterizedNumberVariant extends NumberVariant<Number, Number> implements ParameterizedVariant<Number, Number> {
    private List<? extends Parameter<?>> params;

    public ParamterizedNumberVariant(String exp, List<? extends Parameter<?>> params) {
        super(Number.class, exp);
        
        if(params == null) {
            throw new IllegalArgumentException();
        }
        
        params = Collections.unmodifiableList(params);
    }

    @Override
    public List<? extends Parameter<?>> getParams() {
        return params;
    }
}
