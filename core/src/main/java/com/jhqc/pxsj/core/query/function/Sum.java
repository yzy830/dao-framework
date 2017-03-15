package com.jhqc.pxsj.core.query.function;

import java.util.Collections;
import java.util.List;

import com.jhqc.pxsj.core.Parameterized;
import com.jhqc.pxsj.core.query.function.variants.ParamterizedNumberVariant;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.variants.NumberVariant;
import com.jhqc.pxsj.core.query.variants.Variant;

public enum Sum implements Function<Number> {
    INSTANCE
    ;

    @Override
    public Class<Number> getResultType() {
        // TODO Auto-generated method stub
        return null;
    }
    
    private static final String TEMPLATE = "sum(%s)";
    
    public NumberVariant<Number, Number> apply(Variant<? extends Number, ?> variant) {
        if(variant == null) {
            throw new IllegalArgumentException();
        }
        
        List<? extends Parameter<?>> params;
        
        if(variant instanceof Parameterized) {
            params = ((Parameterized)variant).getParams();
        } else {
            params = Collections.emptyList();
        }
        
        return new ParamterizedNumberVariant(String.format(TEMPLATE, variant.getExp()), params);
    } 
}
