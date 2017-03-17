package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.variants.Variant;

public interface TrickSet<D> {
    <X, Y> PostTrickSet<D> set(Meta<X, Y> property, X value);
    
    <X, Y> PostTrickSet<D> set(Meta<X, Y> property, Variant<? extends Y, ?> value);
    
    <X, Y> PostTrickSet<D> setEx(Meta<X, Y> property, VariantGenerator<X, Y> g);
}
