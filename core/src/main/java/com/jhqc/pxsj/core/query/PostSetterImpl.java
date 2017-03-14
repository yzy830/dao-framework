package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.variants.Variant;

class PostSetterImpl<T> implements PostSetter<T> {
    private SetterImpl<T> setter;
    
    public PostSetterImpl(SetterImpl<T> setter) {
        this.setter = setter;
    }

    @Override
    public <X, Y> Setter<T> set(Attribute<X, Y> attribute, X value) {
        setter.set(attribute, value);
        return this;
    }

    @Override
    public <X, Y> Setter<T> set(Attribute<X, Y> attribute,
            Variant<? extends Y, ?> value) {
        setter.set(attribute, value);
        return this;
    }

    @Override
    public Update<T> where(Predicate predicate) {
        setter.setPredicate(predicate);
        
        return null;
    }
}
