package com.jhqc.pxsj.core.trick;

import java.util.List;

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
    public <X, Y> TrickRoot<T, D> like(Meta<X, Y> property, Variant<Y, ?> value) {
        trick.composit(root.get(property).like(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> eq(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).eq(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> eq(Meta<X, Y> property, Variant<Y, ?> value) {
        trick.composit(root.get(property).eq(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> notEq(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).notEq(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> notEq(Meta<X, Y> property, Variant<Y, ?> value) {
        trick.composit(root.get(property).notEq(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> lt(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).lt(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> lt(Meta<X, Y> property, Variant<Y, ?> value) {
        trick.composit(root.get(property).lt(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> le(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).le(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> le(Meta<X, Y> property, Variant<Y, ?> value) {
        trick.composit(root.get(property).le(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> gt(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).gt(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> gt(Meta<X, Y> property, Variant<Y, ?> value) {
        trick.composit(root.get(property).gt(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> ge(Meta<X, Y> property, X value) {
        trick.composit(root.get(property).ge(value));
        return this;
    }

    @Override
    public <X, Y> TrickRoot<T, D> ge(Meta<X, Y> property, Variant<Y, ?> value) {
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
            List<? extends Variant<Y, ?>> value) {
         trick.composit(root.get(property).in(value));
        return this;
    }

    public Root<D> getRoot() {
        return root;
    }
}
