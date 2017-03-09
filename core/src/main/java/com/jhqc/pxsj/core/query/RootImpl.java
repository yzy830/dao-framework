package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;
import com.jhqc.pxsj.annotation.process.dynamicmeta.JoinRelation;
import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.attributes.Attribute;

public class RootImpl<T> implements Root<T> {
    private DomainMeta domainMeta;
    
    private MetaPool pool;
    
    public RootImpl(Class<?> domain, MetaPool pool) {
        this.domainMeta = pool.getMeta(domain);
        this.pool = pool;
        if(this.domainMeta == null) {
            throw new IllegalArgumentException(String.format("class[%s] is not a domain model", domain.getName()));
        }
    }

    @Override
    public <U> Join<T, U> join(Class<U> domain) {
//        JoinRelation r = meta.getJoinRelations().get(domain);
//        if(r != null) {
//            
//        } else {
//            
//        }
        return null;
    }

    @Override
    public <U> Join<T, U> leftJoin(Class<U> domain) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <U> Join<T, U> rightJoin(Class<U> domain) {
        // TODO Auto-generated method stub
        return null;
    }

//    @Override
//    public <X, Y> Attribute<X, Y> getAttribute(Meta<X> meta) {
//        // TODO Auto-generated method stub
//        return null;
//    }

    @Override
    public String getAlias() {
        // TODO Auto-generated method stub
        return null;
    }

}
