package com.jhqc.pxsj.core.trick;

import java.util.List;
import java.util.function.Predicate;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.Variant;

class TrickRootImpl<T, D> implements TrickRoot<T, D> {
    private TrickImpl<T> trick;
    
    private Root<D> root;
    
    public TrickRootImpl(TrickImpl<T> trick, Root<D> root) {
        this.trick = trick;
        this.root = root;
    }

    @Override
    public <J> TrickJoin<T, D, J> join(Class<J> domain, String alias) {
        TrickJoinImpl<T, D, J> trickJoin = new TrickJoinImpl<>(trick, root.join(domain, alias));
        trick.addRoot(alias, trickJoin);
        return trickJoin;
    }
    
    @Override
    public <J> TrickJoin<T, D, J> leftJoin(Class<J> domain, String alias) {
        TrickJoinImpl<T, D, J> trickJoin = new TrickJoinImpl<>(trick, root.leftJoin(domain, alias));
        trick.addRoot(alias, trickJoin);
        return trickJoin;
    }

    @Override
    public TrickRoot<T, ?> from(String alias) {
        return trick.getRoot(alias);
    }

    @Override
    public TrickSelect<T> done() {
        return new TrickSelectImpl<>(trick);
    }

    @Override
    public <X, Y> TrickRoot<T, D> like(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).like(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> like(Meta<X, Y> property, Variant<? extends Y, ?> value) {
        trick.composit(root.get(property).like(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> eq(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).eq(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> eq(Meta<X, Y> property, Variant<? extends Y, ?> value) {
        trick.composit(root.get(property).eq(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> notEq(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).notEq(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> notEq(Meta<X, Y> property, Variant<? extends Y, ?> value) {
        trick.composit(root.get(property).notEq(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> lt(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).lt(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> lt(Meta<X, Y> property, Variant<? extends Y, ?> value) {
        trick.composit(root.get(property).lt(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> le(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).le(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> le(Meta<X, Y> property, Variant<? extends Y, ?> value) {
        trick.composit(root.get(property).le(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> gt(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).gt(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> gt(Meta<X, Y> property, Variant<? extends Y, ?> value) {
        trick.composit(root.get(property).gt(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> ge(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).ge(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> ge(Meta<X, Y> property, Variant<? extends Y, ?> value) {
        trick.composit(root.get(property).ge(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> in(Meta<X, Y> property, X[] value) {
        trick.composit(root.get(property).in(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> in(Meta<X, Y> property,
            List<? extends Variant<? extends Y, ?>> value) {
         trick.composit(root.get(property).in(value));
        return this;
    }

    @Override
    public Root<D> getRoot() {
        return root;
    }

    @Override
    public <X, Y> TrickRoot<T, D> likeIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            this.like(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> likeIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            this.like(property, value);
        }
        
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> eqIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            this.eq(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> eqIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            this.eq(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> notEqIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            this.notEq(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> notEqIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            this.notEq(property, value);
        }        
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> ltIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            this.lt(property, value);
        }
        
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> ltIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            this.lt(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> leIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            this.le(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> leIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            this.le(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> gtIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            this.gt(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> gtIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            this.gt(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> geIf(Meta<X, Y> property, X value,
            Predicate<X> condition) {
        if(condition.test(value)) {
            this.ge(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> geIf(Meta<X, Y> property,
            Variant<? extends Y, ?> value, Predicate<Variant<? extends Y, ?>> condition) {
        if(condition.test(value)) {
            this.ge(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> inIf(Meta<X, Y> property, X[] value,
            Predicate<X[]> condition) {
        if(condition.test(value)) {
            this.in(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> inIf(Meta<X, Y> property,
            List<? extends Variant<? extends Y, ?>> value, Predicate<List<? extends Variant<? extends Y, ?>>> condition) {
        if(condition.test(value)) {
            this.in(property, value);
        }
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> isNull(Meta<X, Y> property) {
        trick.composit(root.get(property).isNull());
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> notNull(Meta<X, Y> property) {
        trick.composit(root.get(property).notNull());
        return this;
    }
}
