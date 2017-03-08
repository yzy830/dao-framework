package com.jhqc.pxsj.core.query;

import java.util.List;

public interface Attribute<T> {
    Predicate like(String value);
    
    Predicate equal(T value);
    
    Predicate notEqual(T value);
    
    Predicate gt(T value);
    
    Predicate ge(T value);
    
    Predicate lt(T value);
    
    Predicate le(T value);
    
    Predicate in(List<T> values);
    
    Predicate isNull();
    
    Predicate notNull();
}
