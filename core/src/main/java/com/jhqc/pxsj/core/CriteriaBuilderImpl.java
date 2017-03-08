package com.jhqc.pxsj.core;

import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.CriteriaBuilder;
import com.jhqc.pxsj.core.query.Predicate;
import com.jhqc.pxsj.core.query.Query;
import com.jhqc.pxsj.core.query.Root;

public class CriteriaBuilderImpl implements CriteriaBuilder {
    private MetaPool metaPool;
    
    public CriteriaBuilderImpl(MetaPool metaPool) {
        this.metaPool = metaPool;
    }

    @Override
    public <T> Root<T> root(Class<T> domain) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Predicate predicate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> Query<T> createQuery(Class<T> result) {
        // TODO Auto-generated method stub
        return null;
    }
}
