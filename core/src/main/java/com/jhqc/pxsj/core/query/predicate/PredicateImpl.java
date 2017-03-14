package com.jhqc.pxsj.core.query.predicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.jhqc.pxsj.core.Parameterized;
import com.jhqc.pxsj.core.query.Operation;
import com.jhqc.pxsj.core.query.variants.Variant;

class PredicateImpl implements Predicate {
    private static final String TRUE_EXP = "1 = 1";
    
    private static final String FALSE_EXP = "1 = 0";
    
    private StringBuilder sql;
    
    private List<Parameter<?>> params = new ArrayList<>();
    
    public PredicateImpl(boolean isTrue) {
        if(isTrue) {
            sql = new StringBuilder(TRUE_EXP);
        } else {
            sql = new StringBuilder(FALSE_EXP);
        }
    }
    
    public <T, U> PredicateImpl(Variant<T, U> variant, T value, Operation operation) {
        sql = new StringBuilder().append("(").append(operation.formatPrepared(variant.getExp(), 1)).append(")");
        
        if(variant instanceof Parameterized) {
            Parameterized pAttribute = (Parameterized)variant;
            params.addAll(pAttribute.getParams());
        }
        params.add(Parameters.newInstance(variant.getJavaType(), value));
    }
    
    public <T, U> PredicateImpl(Variant<T, U> variant, List<T> values, Operation operation) {
        if(values == null) {
            values = new ArrayList<>();
        }
        
        sql = new StringBuilder().append("(").append(operation.formatPrepared(variant.getExp(), values.size())).append(")");
        
        if(variant instanceof Parameterized) {
            Parameterized pAttribute = (Parameterized)variant;
            params.addAll(pAttribute.getParams());
        }
        params.addAll(values.stream().map(v -> Parameters.newInstance(variant.getJavaType(), v))
                                     .collect(Collectors.toList()));
    }
    
    public <T, U> PredicateImpl(Variant<T, U> variant, Operation operation) {
        sql = new StringBuilder().append("(").append(operation.formatPrepared(variant.getExp(), 0)).append(")");
        
        if(variant instanceof Parameterized) {
            Parameterized pAttribute = (Parameterized)variant;
            params.addAll(pAttribute.getParams());
        }
    }
    
    public <T, U> PredicateImpl(Variant<T, U> variant, Operation operation, Variant<? extends U, ?> value) { 
        if(value == null) {
            throw new NullPointerException();
        }
        
        sql = new StringBuilder().append("(").append(operation.formatPlain(variant.getExp(), new String[] {value.getExp()})).append(")");
        
        if(variant instanceof Parameterized) {
            Parameterized pAttribute = (Parameterized)variant;
            params.addAll(pAttribute.getParams());
        }
        if(value instanceof Parameterized) {
            Parameterized pValue = (Parameterized)value;
            params.addAll(pValue.getParams());
        }
    } 
    
    public <T, U> PredicateImpl(Variant<T, U> variant, Operation operation, List<? extends Variant<? extends U, ?>> values) {
        if(values == null) {
            values = new ArrayList<>();
        }
        
        if(variant instanceof Parameterized) {
            Parameterized pAttribute = (Parameterized)variant;
            params.addAll(pAttribute.getParams());
        }
        
        List<String> exps = new ArrayList<>();
        for(Variant<? extends U, ?> value : values) {
            exps.add(value.getExp());
            
            if(value instanceof Parameterized) {
                Parameterized pValue = (Parameterized)value;
                params.addAll(pValue.getParams());
            }
        }
        
        sql = new StringBuilder().append("(").append(operation.formatPlain(variant.getExp(), exps.toArray(new String[] {}))).append(")");
    }

    @Override
    public Predicate and(Predicate predicate) {
        PredicateImpl p = (PredicateImpl)predicate;
        sql.append(" and ").append(p.sql);
        params.addAll(p.params);
        return this;
    }

    @Override
    public Predicate or(Predicate predicate) {
        PredicateImpl p = (PredicateImpl)predicate;
        sql.append(" or ").append(p.sql);
        params.addAll(p.params);
        return this;
    }

    @Override
    public String toString() {
        return getExp();
    }

    public List<? extends Parameter<?>> getParams() {
        return Collections.unmodifiableList(params);
    }

    @Override
    public String getExp() {
        return sql.toString();
    }
}
