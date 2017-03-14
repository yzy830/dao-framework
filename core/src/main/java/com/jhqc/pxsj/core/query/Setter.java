package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.Variant;

/**
 * 属性设置器，用于在Update中设置属性的值
 *
 * @param <T>
 *          领域模型
 */
public interface Setter<T> {
    <X, Y> PostSetter<T> set(Meta<X, Y> property, X value);
    
    <X, Y> PostSetter<T> set(Meta<X, Y> property, Variant<? extends Y, ?> value);
    
    Root<T> getRoot();
}
