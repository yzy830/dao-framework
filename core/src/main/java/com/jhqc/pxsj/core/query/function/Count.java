package com.jhqc.pxsj.core.query.function;

import java.util.Collections;
import java.util.List;

import com.jhqc.pxsj.core.Parameterized;
import com.jhqc.pxsj.core.query.function.variants.ParameterizedLongVariant;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.variants.LongVariant;
import com.jhqc.pxsj.core.query.variants.Variant;

public enum Count implements Function<Long> {
    INSTANCE
    ;
    
    private static final String template = "count(%s)";
    
    public ParameterizedLongVariant apply(Variant<?, ?> variant) {
        List<? extends Parameter<?>> params;
        if(variant instanceof Parameterized) {
            params = ((Parameterized)variant).getParams();
        } else {
            params = Collections.emptyList();
        }
        
        return new ParameterizedLongVariant(String.format(template, variant.getExp()), params);
    }
    
    public LongVariant apply() {
        return new LongVariant(Long.class, String.format(template, "*"));
    }

    @Override
    public Class<Long> getResultType() {
        return Long.class;
    }

}
