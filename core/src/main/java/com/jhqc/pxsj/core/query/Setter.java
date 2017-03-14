package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.variants.Variant;

/**
 * 属性设置器，用于在Update中设置属性的值
 *
 * @param <T>
 *          领域模型
 */
public interface Setter<T> {
    <X, Y> PostSetter<T> set(Attribute<X, Y> attribute, X value);
    
    <X, Y> PostSetter<T> set(Attribute<X, Y> attribute, Variant<? extends Y, ?> value);
}
