package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.predicate.Predicate;

class PostSetterImpl<T> extends SetterImpl<T> implements PostSetter<T> {    
    private Predicate predicate;
    
    public PostSetterImpl(SetterImpl<T> setter) {
        super(setter.getRoot(), setter.getSettings());
    }

    public Predicate getPredicate() {
        return predicate;
    }

    @Override
    public Update<T> where(Predicate predicate) {
        this.predicate = predicate;
        
        return new UpdateImpl<>(this);
    }
}
