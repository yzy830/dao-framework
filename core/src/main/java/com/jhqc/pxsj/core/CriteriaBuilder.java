package com.jhqc.pxsj.core;

import java.util.Date;

import com.jhqc.pxsj.core.query.Query;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.DateVariant;

public interface CriteriaBuilder {
    <T> Root<T> root(Class<T> domain);
    
    Predicate predicate();
    
    <T> Query<T> createQuery(Class<T> result);
    
    DateVariant now();
}
