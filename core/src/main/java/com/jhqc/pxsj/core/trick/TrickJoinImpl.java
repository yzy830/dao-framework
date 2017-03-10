package com.jhqc.pxsj.core.trick;

import java.util.List;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Join;
import com.jhqc.pxsj.core.query.variants.Variant;

class TrickJoinImpl<T, D, J> extends TrickRootImpl<T, J> implements TrickJoin<T, D, J> {

    public TrickJoinImpl(TrickImpl<T> trick, Join<D, J> join) {
        super(trick, join);
    }

    public <X,Y> TrickJoinImpl<T, D, J> like(Meta<X,Y> property, X value) {
        super.like(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> like(Meta<X,Y> property, Variant<Y, ?> value) {
        super.like(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> eq(Meta<X,Y> property, X value) {
        super.eq(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> eq(Meta<X,Y> property, Variant<Y, ?> value) {
        super.eq(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> notEq(Meta<X,Y> property, X value) {
        super.notEq(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> notEq(Meta<X,Y> property, Variant<Y, ?> value) {
        super.notEq(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> lt(Meta<X,Y> property, X value) {
        super.lt(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> lt(Meta<X,Y> property, Variant<Y, ?> value) {
        super.lt(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> le(Meta<X,Y> property, X value) {
        super.le(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> le(Meta<X,Y> property, Variant<Y, ?> value) {
        super.le(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> gt(Meta<X,Y> property, X value) {
        super.gt(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> gt(Meta<X,Y> property, Variant<Y, ?> value) {
        super.gt(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> ge(Meta<X,Y> property, X value) {
        super.ge(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> ge(Meta<X,Y> property, Variant<Y, ?> value) {
        super.ge(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> in(Meta<X,Y> property, X[] value) {
        super.in(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> in(Meta<X,Y> property, List<? extends Variant<Y, ?>> value) {
        super.in(property, value);
        return this;
    }
}
