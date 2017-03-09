package com.jhqc.pxsj.core.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PredicateImpl implements Predicate {
    private static final String TRUE_EXP = "1 = 1";
    
    private StringBuilder sql;
    
    private List<Object> params = new ArrayList<>();
    
    public PredicateImpl() {
        sql = new StringBuilder(TRUE_EXP);
    }
    
    public <T> PredicateImpl(Attribute<T> attribute, T value, Operation operation) {
        sql = new StringBuilder().append("(").append(operation.formatPrepared(attribute.getPath(), 1)).append(")");
        params.add(value);
    }
    
    public <T> PredicateImpl(Attribute<T> attribute, List<T> values, Operation operation) {
        if(values == null) {
            values = new ArrayList<>();
        }
        
        sql = new StringBuilder().append("(").append(operation.formatPrepared(attribute.getPath(), values.size())).append(")");
        params.addAll(values);
    }
    
    public <T> PredicateImpl(Attribute<T> attribute, Operation operation) {
        sql = new StringBuilder().append("(").append(operation.formatPrepared(attribute.getPath(), 0)).append(")");
    }
    
    public <T> PredicateImpl(Attribute<T> attribute, Operation operation, String value) {        
        sql = new StringBuilder().append("(").append(operation.formatPlain(attribute.getPath(), new String[] {value})).append(")");
    }
    
    public <T> PredicateImpl(Attribute<T> attribute, Operation operation, List<String> values) {
        if(values == null) {
            values = new ArrayList<>();
        }
        
        sql = new StringBuilder().append("(").append(operation.formatPlain(attribute.getPath(), values.toArray(new String[] {}))).append(")");
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

    @Override
    public List<Object> getParams() {
        return Collections.unmodifiableList(params);
    }
}
