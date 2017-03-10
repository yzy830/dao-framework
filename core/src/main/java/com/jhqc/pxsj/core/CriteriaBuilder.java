package com.jhqc.pxsj.core;

import com.jhqc.pxsj.core.query.Select;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.DateVariant;

public interface CriteriaBuilder {
    <T> Root<T> root(Class<T> domain);
    
    <T> Root<T> root(Class<T> domain, String alias);
    
    Predicate predicate();
    
    <T> Select<T> createQuery(Class<T> result);
    
    DateVariant now();
}
