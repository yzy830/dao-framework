package com.jhqc.pxsj.core.query.predicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jhqc.pxsj.core.query.Operation;
import com.jhqc.pxsj.core.query.variants.AbstractVariant;

class PredicateImpl implements Predicate {
    private static final String TRUE_EXP = "1 = 1";
    
    private StringBuilder sql;
    
    private List<Object> params = new ArrayList<>();
    
    public PredicateImpl() {
        sql = new StringBuilder(TRUE_EXP);
    }
    
    public <T, U> PredicateImpl(AbstractVariant<T, U> attribute, T value, Operation operation) {
        sql = new StringBuilder().append("(").append(operation.formatPrepared(attribute.getExp(), 1)).append(")");
        params.add(value);
    }
    
    public <T, U> PredicateImpl(AbstractVariant<T, U> attribute, List<T> values, Operation operation) {
        if(values == null) {
            values = new ArrayList<>();
        }
        
        sql = new StringBuilder().append("(").append(operation.formatPrepared(attribute.getExp(), values.size())).append(")");
        params.addAll(values);
    }
    
    public <T, U> PredicateImpl(AbstractVariant<T, U> attribute, Operation operation) {
        sql = new StringBuilder().append("(").append(operation.formatPrepared(attribute.getExp(), 0)).append(")");
    }
    
    public <T, U> PredicateImpl(AbstractVariant<T, U> attribute, Operation operation, AbstractVariant<U, ?> value) { 
        if(value == null) {
            throw new NullPointerException();
        }
        
        sql = new StringBuilder().append("(").append(operation.formatPlain(attribute.getExp(), new String[] {value.getExp()})).append(")");
    }
    
    public <T, U, X extends AbstractVariant<U, ?>> PredicateImpl(AbstractVariant<T, U> attribute, Operation operation, List<X> values) {
        if(values == null) {
            values = new ArrayList<>();
        }
        
        List<String> exps = new ArrayList<>();
        for(X value : values) {
            exps.add(value.getExp());
        }
        
        sql = new StringBuilder().append("(").append(operation.formatPlain(attribute.getExp(), exps.toArray(new String[] {}))).append(")");
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
        return sql.toString();
    }

    public List<Object> getParams() {
        return Collections.unmodifiableList(params);
    }
}
