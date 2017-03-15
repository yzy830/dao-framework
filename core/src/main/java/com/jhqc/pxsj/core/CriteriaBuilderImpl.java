package com.jhqc.pxsj.core;

import java.util.Date;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.Insert;
import com.jhqc.pxsj.core.query.Select;
import com.jhqc.pxsj.core.query.Setter;
import com.jhqc.pxsj.core.query.Sqls;
import com.jhqc.pxsj.core.query.function.DateAdd.Type;
import com.jhqc.pxsj.core.query.function.Count;
import com.jhqc.pxsj.core.query.function.DateAdd;
import com.jhqc.pxsj.core.query.function.Now;
import com.jhqc.pxsj.core.query.function.Sum;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.predicate.Predicates;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.root.Roots;
import com.jhqc.pxsj.core.query.variants.DateVariant;
import com.jhqc.pxsj.core.query.variants.LongVariant;
import com.jhqc.pxsj.core.query.variants.NumberVariant;
import com.jhqc.pxsj.core.query.variants.Variant;
import com.jhqc.pxsj.core.trick.Trick;
import com.jhqc.pxsj.core.trick.TrickType;
import com.jhqc.pxsj.core.trick.TrickUpdate;
import com.jhqc.pxsj.core.trick.Tricks;

class CriteriaBuilderImpl implements CriteriaBuilder {
    private MetaPool metaPool;
    
    public CriteriaBuilderImpl(MetaPool metaPool) {
        this.metaPool = metaPool;
    }

    @Override
    public <T> Root<T> root(Class<T> domain) {
        return Roots.root(domain, metaPool);
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
        return Sqls.createSelect(result, metaPool);
    }

    @Override
    public <T> Root<T> root(Class<T> domain, String alias) {
        return Roots.root(domain, alias, metaPool);
    }

    @Override
    public <T> Trick<T> trick(Class<T> result) {
        return Tricks.trick(this, TrickType.AND, result);
    }

    @Override
    public <T> Trick<T> trick(Class<T> result, TrickType type) {
        return Tricks.trick(this, type, result);
    }

    @Override
    public DateVariant dateAdd(Variant<? extends Date, ?> date, int interval,
            Type type) {
        return DateAdd.INSTANCE.apply(date, interval, type);
    }

    @Override
    public <T> Insert<T> creatInsert(Class<T> domain, Meta<?, ?>... ignores) {
        return Sqls.createInsert(metaPool, domain, ignores);
    }

    @Override
    public <T> Setter<T> createUpdate(Class<T> domainModel) {
        return Sqls.createUpdate(this.root(domainModel));
    }

    @Override
    public <T> TrickUpdate<T> trickUpdate(Class<T> domainModel) {
        return Tricks.trickUpdate(this, TrickType.AND, domainModel);
    }

    @Override
    public <T> TrickUpdate<T> trickUpdate(Class<T> domainModel, TrickType type) {
        return Tricks.trickUpdate(this, type, domainModel);
    }

    @Override
    public LongVariant count() {
        return Count.INSTANCE.apply();
    }

    @Override
    public LongVariant count(Variant<?, ?> variant) {
        return Count.INSTANCE.apply(variant);
    }

    @Override
    public NumberVariant<? extends Number, Number> sum(Variant<? extends Number, ?> variant) {
        return Sum.INSTANCE.apply(variant);
    }
}
