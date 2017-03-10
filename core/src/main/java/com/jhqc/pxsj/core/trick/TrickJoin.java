package com.jhqc.pxsj.core.trick;

import java.util.List;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.variants.Variant;

public interface TrickJoin<T, D, J> extends TrickRoot<T, J>  {
    <X,Y> TrickJoin<T, D, J> like(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> like(Meta<X,Y> property, Variant<Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> eq(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> eq(Meta<X,Y> property, Variant<Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> notEq(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> notEq(Meta<X,Y> property, Variant<Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> lt(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> lt(Meta<X,Y> property, Variant<Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> le(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> le(Meta<X,Y> property, Variant<Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> gt(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> gt(Meta<X,Y> property, Variant<Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> ge(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> ge(Meta<X,Y> property, Variant<Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> in(Meta<X,Y> property, X[] value);
    
    <X,Y> TrickJoin<T, D, J> in(Meta<X,Y> property, List<? extends Variant<Y, ?>> value);
}
