package com.jhqc.pxsj.core.trick;

import java.util.List;
import java.util.function.Predicate;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.variants.Variant;

/**
 * 用于级联更新操作的root。在级联更新中，不允许使用连接更新
 *
 * @param <D>
 *          领域模型
 */
public interface TrickUpdateRoot<D> {
    TrickSet<D> done();
    
    <X,Y> TrickUpdateRoot<D> like(Meta<X,Y> property, X value);
    
    <X,Y> TrickUpdateRoot<D> likeIf(Meta<X,Y> property, X value, Predicate<X> condition);
    
    <X,Y> TrickUpdateRoot<D> like(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickUpdateRoot<D> likeIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickUpdateRoot<D> eq(Meta<X,Y> property, X value);
    
    <X,Y> TrickUpdateRoot<D> eqIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickUpdateRoot<D> eq(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickUpdateRoot<D> eqIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickUpdateRoot<D> notEq(Meta<X,Y> property, X value);
    
    <X,Y> TrickUpdateRoot<D> notEqIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickUpdateRoot<D> notEq(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickUpdateRoot<D> notEqIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickUpdateRoot<D> lt(Meta<X,Y> property, X value);
    
    <X,Y> TrickUpdateRoot<D> ltIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickUpdateRoot<D> lt(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickUpdateRoot<D> ltIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickUpdateRoot<D> le(Meta<X,Y> property, X value);
    
    <X,Y> TrickUpdateRoot<D> leIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickUpdateRoot<D> le(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickUpdateRoot<D> leIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickUpdateRoot<D> gt(Meta<X,Y> property, X value);
    
    <X,Y> TrickUpdateRoot<D> gtIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickUpdateRoot<D> gt(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickUpdateRoot<D> gtIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickUpdateRoot<D> ge(Meta<X,Y> property, X value);
    
    <X,Y> TrickUpdateRoot<D> geIf(Meta<X,Y> property, X value,  Predicate<X> condition);
    
    <X,Y> TrickUpdateRoot<D> ge(Meta<X,Y> property, Variant<? extends Y, ?> value);
    
    <X,Y> TrickUpdateRoot<D> geIf(Meta<X,Y> property, Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition);
    
    <X,Y> TrickUpdateRoot<D> in(Meta<X,Y> property, X[] value);
    
    <X,Y> TrickUpdateRoot<D> inIf(Meta<X,Y> property, X[] value,  Predicate<X[]> condition);
    
    <X,Y> TrickUpdateRoot<D> in(Meta<X,Y> property, List<? extends Variant<? extends Y, ?>> value);
    
    <X,Y> TrickUpdateRoot<D> inIf(Meta<X,Y> property, List<? extends Variant<? extends Y, ?>> value, Predicate<List<? extends Variant<? extends Y, ?>>> condition);
}
