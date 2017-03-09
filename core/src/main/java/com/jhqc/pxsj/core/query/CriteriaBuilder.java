package com.jhqc.pxsj.core.query;

import java.util.Date;

import com.jhqc.pxsj.core.query.predicate.Predicate;

public interface CriteriaBuilder {
    <T> Root<T> root(Class<T> domain);
    
    Predicate predicate();
    
    <T> Query<T> createQuery(Class<T> result);
    
//    <T extends Date> Variant<Date, T> now();
}
