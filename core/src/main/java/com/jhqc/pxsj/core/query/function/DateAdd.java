package com.jhqc.pxsj.core.query.function;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jhqc.pxsj.core.Parameterized;
import com.jhqc.pxsj.core.query.function.variants.ParameterizedDateVariant;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.predicate.Parameters;
import com.jhqc.pxsj.core.query.variants.Variant;

public enum DateAdd implements Function<Date> {
    INSTANCE
    ;
    
    public enum Type {
        SECOND("SECOND"),
        MINUTE("MINUTE"),
        HOUR("HOUR"),
        DAY("DAY"),
        WEEK("WEEK"),
        MONTH("MONTH"),
        YEAR("YEAR")
        ;
        
        private String value;
        
        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    private static final String template = "DATE_ADD(%s,? expr %s)";

    @Override
    public Class<Date> getResultType() {
        return Date.class;
    }

    public ParameterizedDateVariant apply(Variant<? extends Date, ?> operator, int interval, Type type) {
        if((operator == null) || (type == null)) {
            throw new IllegalArgumentException();
        }
        
        List<Parameter<?>> params = new ArrayList<>();
        if(operator instanceof Parameterized) {
            params.addAll(((Parameterized)operator).getParams());
        }
        params.add(Parameters.newInstance(Integer.class, interval));
        
        return new ParameterizedDateVariant(String.format(template, operator.getExp(), type.getValue()), params);
    }
    
    
}
