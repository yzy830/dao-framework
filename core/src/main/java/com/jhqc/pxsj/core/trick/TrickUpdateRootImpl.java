package com.jhqc.pxsj.core.trick;

import java.util.List;
import java.util.function.Predicate;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.Variant;

class TrickUpdateRootImpl<D> implements TrickUpdateRoot<D> {
    private TrickUpdateImpl<D> trickUpdate;
    
    private Root<D> root;
    
    public TrickUpdateRootImpl(TrickUpdateImpl<D> trickUpdate, Root<D> root) {
        this.trickUpdate = trickUpdate;
        this.root = root;
    }

    @Override
    public TrickSet<D> done() {
        return new TrickSetImpl<>(trickUpdate);
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> like(Meta<X, Y> property, X value) {
        trickUpdate.composite(root.get(property).like(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> likeIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).like(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> like(Meta<X, Y> property,
            Variant<? extends Y, ?> value) {
        trickUpdate.composite(root.get(property).like(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> likeIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value,
            Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).like(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> eq(Meta<X, Y> property, X value) {
        trickUpdate.composite(root.get(property).eq(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> eqIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).eq(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> eq(Meta<X, Y> property,
            Variant<? extends Y, ?> value) {
        trickUpdate.composite(root.get(property).eq(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> eqIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value,
            Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).eq(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> notEq(Meta<X, Y> property, X value) {
        trickUpdate.composite(root.get(property).notEq(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> notEqIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).notEq(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> notEq(Meta<X, Y> property,
            Variant<? extends Y, ?> value) {
        trickUpdate.composite(root.get(property).notEq(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> notEqIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value,
            Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).notEq(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> lt(Meta<X, Y> property, X value) {
        trickUpdate.composite(root.get(property).lt(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> ltIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).lt(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> lt(Meta<X, Y> property,
            Variant<? extends Y, ?> value) {
        trickUpdate.composite(root.get(property).lt(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> ltIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value,
            Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).lt(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> le(Meta<X, Y> property, X value) {
        trickUpdate.composite(root.get(property).le(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> leIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).le(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> le(Meta<X, Y> property,
            Variant<? extends Y, ?> value) {
        trickUpdate.composite(root.get(property).le(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> leIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value,
            Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).le(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> gt(Meta<X, Y> property, X value) {
        trickUpdate.composite(root.get(property).gt(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> gtIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).gt(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> gt(Meta<X, Y> property,
            Variant<? extends Y, ?> value) {
        trickUpdate.composite(root.get(property).gt(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> gtIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value,
            Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).gt(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> ge(Meta<X, Y> property, X value) {
        trickUpdate.composite(root.get(property).ge(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> geIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).ge(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> ge(Meta<X, Y> property,
            Variant<? extends Y, ?> value) {
        trickUpdate.composite(root.get(property).ge(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> geIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value,
            Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).ge(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> in(Meta<X, Y> property, X[] value) {
        trickUpdate.composite(root.get(property).in(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> inIf(Meta<X, Y> property, X[] value,
            Predicate<X[]> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).in(value));
        }
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> in(Meta<X, Y> property,
            List<? extends Variant<? extends Y, ?>> value) {
        trickUpdate.composite(root.get(property).in(value));
        return this;
    }

    @Override
    public <X, Y> TrickUpdateRoot<D> inIf(Meta<X, Y> property,
            List<? extends Variant<? extends Y, ?>> value,
            Predicate<List<? extends Variant<? extends Y, ?>>> condition) {
        if(condition.test(value)) {
            trickUpdate.composite(root.get(property).in(value));
        }
        return this;
    }

}
