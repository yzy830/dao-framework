package com.jhqc.pxsj.core;

import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.Queries;
import com.jhqc.pxsj.core.query.Select;
import com.jhqc.pxsj.core.query.function.impls.Now;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.predicate.Predicates;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.root.RootImpl;
import com.jhqc.pxsj.core.query.variants.DateVariant;
import com.jhqc.pxsj.core.trick.Trick;
import com.jhqc.pxsj.core.trick.Trick.TrickType;
import com.jhqc.pxsj.core.trick.Tricks;

class CriteriaBuilderImpl implements CriteriaBuilder {
    private MetaPool metaPool;
    
    public CriteriaBuilderImpl(MetaPool metaPool) {
        this.metaPool = metaPool;
    }

    @Override
    public <T> Root<T> root(Class<T> domain) {
        return new RootImpl<>(domain, metaPool);
    }

    @Override
    public Predicate alwaysTrue() {
        return Predicates.alwaysTrue();
    }
    
    @Override
    public Predicate alwaysFalse() {
        return Predicates.alwaysFlase();
    }

    @Override
    public DateVariant now() {
        return Now.INSTANCE.apply();
    }

    @Override
    public <T> Select<T> createQuery(Class<T> result) {
        return Queries.createSelect(result, metaPool);
    }

    @Override
    public <T> Root<T> root(Class<T> domain, String alias) {
        return new RootImpl<>(domain, metaPool, alias);
    }

    @Override
    public <T> Trick<T> trick(Class<T> result) {
        return Tricks.trick(this, TrickType.AND, result);
    }

    @Override
    public <T> Trick<T> trick(Class<T> result, TrickType type) {
        return Tricks.trick(this, type, result);
    }
}
