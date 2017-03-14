package com.jhqc.pxsj.core.trick;

import java.util.List;
import java.util.function.Predicate;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.variants.Variant;

public interface TrickJoin<T, D, J> extends TrickRoot<T, J>  {
    <X,Y> TrickJoin<T, D, J> like(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> likeIf(Meta<X,Y> property, X value, Predicate<X> condition);
    
    <X,Y> TrickJoin<T, D, J> like(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> likeIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickJoin<T, D, J> eq(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> eqIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickJoin<T, D, J> eq(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> eqIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickJoin<T, D, J> notEq(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> notEqIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickJoin<T, D, J> notEq(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> notEqIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickJoin<T, D, J> lt(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> ltIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickJoin<T, D, J> lt(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> ltIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickJoin<T, D, J> le(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> leIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickJoin<T, D, J> le(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> leIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickJoin<T, D, J> gt(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> gtIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickJoin<T, D, J> gt(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> gtIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickJoin<T, D, J> ge(Meta<X,Y> property, X value);
    
    <X,Y> TrickJoin<T, D, J> geIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickJoin<T, D, J> ge(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickJoin<T, D, J> geIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickJoin<T, D, J> in(Meta<X,Y> property, X[] value);
    
    <X,Y> TrickJoin<T, D, J> inIf(Meta<X,Y> property, X[] value,  Predicate<X[]> condition);
    
    <X,Y> TrickJoin<T, D, J> in(Meta<X,Y> property, List<? extends Variant<? extends Y, ?>> value);
    
    <X,Y> TrickJoin<T, D, J> inIf(Meta<X,Y> property, List<? extends Variant<? extends Y, ?>> value, Predicate<List<? extends Variant<? extends Y, ?>>> condition);
}
