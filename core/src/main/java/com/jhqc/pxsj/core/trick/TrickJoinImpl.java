package com.jhqc.pxsj.core.trick;

import java.util.List;
import java.util.function.BooleanSupplier;

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
    
    public <X,Y> TrickJoinImpl<T, D, J> like(Meta<X,Y> property, Variant<? extends Y, ?> value) {
        super.like(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> eq(Meta<X,Y> property, X value) {
        super.eq(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> eq(Meta<X,Y> property, Variant<? extends Y, ?> value) {
        super.eq(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> notEq(Meta<X,Y> property, X value) {
        super.notEq(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> notEq(Meta<X,Y> property, Variant<? extends Y, ?> value) {
        super.notEq(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> lt(Meta<X,Y> property, X value) {
        super.lt(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> lt(Meta<X,Y> property, Variant<? extends Y, ?> value) {
        super.lt(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> le(Meta<X,Y> property, X value) {
        super.le(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> le(Meta<X,Y> property, Variant<? extends Y, ?> value) {
        super.le(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> gt(Meta<X,Y> property, X value) {
        super.gt(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> gt(Meta<X,Y> property, Variant<? extends Y, ?> value) {
        super.gt(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> ge(Meta<X,Y> property, X value) {
        super.ge(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> ge(Meta<X,Y> property, Variant<? extends Y, ?> value) {
        super.ge(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> in(Meta<X,Y> property, X[] value) {
        super.in(property, value);
        return this;
    }
    
    public <X,Y> TrickJoinImpl<T, D, J> in(Meta<X,Y> property, List<? extends Variant<? extends Y, ?>> value) {
        super.in(property, value);
        return this;
    }
    
    @Override
    public <X,Y> TrickJoinImpl<T, D, J> likeIf(Meta<X, Y> property, X value,
            BooleanSupplier condition) {
        super.likeIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> likeIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, BooleanSupplier condition) {
        super.likeIf(property, value, condition);        
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> eqIf(Meta<X, Y> property, X value,
            BooleanSupplier condition) {
        super.eqIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> eqIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, BooleanSupplier condition) {
        super.eqIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> notEqIf(Meta<X, Y> property, X value,
            BooleanSupplier condition) {
        super.notEqIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> notEqIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, BooleanSupplier condition) {
        super.notEqIf(property, value, condition);      
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> ltIf(Meta<X, Y> property, X value,
            BooleanSupplier condition) {
        super.ltIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> ltIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, BooleanSupplier condition) {
        super.ltIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> leIf(Meta<X, Y> property, X value,
            BooleanSupplier condition) {
        super.leIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> leIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, BooleanSupplier condition) {
        super.leIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> gtIf(Meta<X, Y> property, X value,
            BooleanSupplier condition) {
        super.gtIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> gtIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, BooleanSupplier condition) {
        super.gtIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> geIf(Meta<X, Y> property, X value,
            BooleanSupplier condition) {
        super.geIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> geIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, BooleanSupplier condition) {
        super.geIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> inIf(Meta<X, Y> property, X[] value,
            BooleanSupplier condition) {
        super.inIf(property, value, condition);
        return this;
    }

    @Override
    public <X,Y> TrickJoinImpl<T, D, J> inIf(Meta<X, Y> property,
            List<? extends Variant<? extends Y, ?>> value, BooleanSupplier condition) {
        super.inIf(property, value, condition);
        return this;
    }
}
