package com.jhqc.pxsj.core.trick;

import java.util.List;
import java.util.function.Predicate;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.Variant;

public interface TrickRoot<T, D> {
    <J> TrickJoin<T, D, J> join(Class<J> domain, String alias);
    
    <J> TrickJoin<T, D, J> leftJoin(Class<J> domain, String alias);
    
    TrickRoot<T, ?> from(String alias);
    
    TrickSelect<T> done();
    
    Root<D> getRoot();
    
    <X,Y> TrickRoot<T, D> like(Meta<X,Y> property, X value);
    
    <X,Y> TrickRoot<T, D> likeIf(Meta<X,Y> property, X value, Predicate<X> condition);
    
    <X,Y> TrickRoot<T, D> like(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickRoot<T, D> likeIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickRoot<T, D> eq(Meta<X,Y> property, X value);
    
    <X,Y> TrickRoot<T, D> eqIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickRoot<T, D> eq(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickRoot<T, D> eqIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickRoot<T, D> notEq(Meta<X,Y> property, X value);
    
    <X,Y> TrickRoot<T, D> notEqIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickRoot<T, D> notEq(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickRoot<T, D> notEqIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickRoot<T, D> lt(Meta<X,Y> property, X value);
    
    <X,Y> TrickRoot<T, D> ltIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickRoot<T, D> lt(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickRoot<T, D> ltIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickRoot<T, D> le(Meta<X,Y> property, X value);
    
    <X,Y> TrickRoot<T, D> leIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickRoot<T, D> le(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickRoot<T, D> leIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickRoot<T, D> gt(Meta<X,Y> property, X value);
    
    <X,Y> TrickRoot<T, D> gtIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickRoot<T, D> gt(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickRoot<T, D> gtIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickRoot<T, D> ge(Meta<X,Y> property, X value);
    
    <X,Y> TrickRoot<T, D> geIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickRoot<T, D> ge(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickRoot<T, D> geIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickRoot<T, D> in(Meta<X,Y> property, X[] value);
    
    <X,Y> TrickRoot<T, D> inIf(Meta<X,Y> property, X[] value,  Predicate<X[]> condition);
    
    <X,Y> TrickRoot<T, D> in(Meta<X,Y> property, List<? extends Variant<? extends Y, ?>> value);
    
    <X,Y> TrickRoot<T, D> inIf(Meta<X,Y> property, List<? extends Variant<? extends Y, ?>> value, Predicate<List<? extends Variant<? extends Y, ?>>> condition);
    
    <X,Y> TrickRoot<T, D> isNull(Meta<X,Y> property);
    
    <X,Y> TrickRoot<T, D> notNull(Meta<X,Y> property);
}
