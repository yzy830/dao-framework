package com.jhqc.pxsj.core.query;

public interface CriteriaBuilder {
    <T> Root<T> root(Class<T> domain);
    
    Predicate predicate();
    
    <T> Query<T> createQuery(Class<T> result);
}
