package com.jhqc.pxsj.core;

import java.util.Date;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Insert;
import com.jhqc.pxsj.core.query.Select;
import com.jhqc.pxsj.core.query.Setter;
import com.jhqc.pxsj.core.query.function.DateAdd;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.DateVariant;
import com.jhqc.pxsj.core.query.variants.Variant;
import com.jhqc.pxsj.core.trick.Trick;
import com.jhqc.pxsj.core.trick.TrickType;
import com.jhqc.pxsj.core.trick.TrickUpdate;

public interface CriteriaBuilder {
    <T> Root<T> root(Class<T> domain);
    
    <T> Root<T> root(Class<T> domain, String alias);
    
    Predicate alwaysTrue();
    
    Predicate alwaysFalse();
    
    <T> Select<T> createQuery(Class<T> result);
    
    <T> Insert<T> creatInsert(Class<T> domainModel, Meta<?, ?>... ignores);
    
    <T> Setter<T> createUpdate(Class<T> domainModel);
    
    <T> Trick<T> trick(Class<T> result);
    
    <T> Trick<T> trick(Class<T> result, TrickType type);
    
    <T> TrickUpdate<T> trickUpdate(Class<T> domainModel);
    
    <T> TrickUpdate<T> trickUpdate(Class<T> domainModel, TrickType type);
    
    DateVariant now();
    
    DateVariant dateAdd(Variant<? extends Date, ?> date, int interval, DateAdd.Type type);
}
