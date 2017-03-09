package com.jhqc.pxsj.core.query.root;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;
import com.jhqc.pxsj.annotation.process.dynamicmeta.JoinRelation;
import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.annotation.process.util.PropertyNameUtil;
import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.attributes.Attributes;

public class RootImpl<T> implements Root<T> {
    private static final String AUTO_ALIAS_PREFIX = "a_g_r_";
    
    protected DomainMeta domainMeta;
    
    protected MetaPool pool;
    
    protected String alias;
    
    protected Map<Class<?>, Join<T,?>> map = new HashMap<>();
    
    public RootImpl(Class<?> domain, MetaPool pool) {
        this(domain, pool, null);
    }
    
    public RootImpl(Class<?> domain, MetaPool pool, String alias) {
        this.domainMeta = pool.getMeta(domain);
        this.pool = pool;
        if(this.domainMeta == null) {
            throw new IllegalArgumentException(String.format("class[%s] is not a domain model", domain.getName()));
        }
        
        if(StringUtils.isEmpty(alias)) {
            this.alias = PropertyNameUtil.underscoreName(AUTO_ALIAS_PREFIX + domainMeta.getEntityName());
        } else {
            this.alias = alias;
        }
    }

    @Override
    public <U> Join<T, U> join(Class<U> domain) {
        JoinRelation r = domainMeta.getJoinRelations().get(domain);
        if(r != null) {
            
        } else {
            
        }
        return null;
    }

    @Override
    public <U> Join<T, U> leftJoin(Class<U> domain) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public <X, U> Attribute<X, U> getAttribute(Meta<X, U> meta) {
        return Attributes.generateAttribute(this, meta);
    }

    @Override
    public String getAlias() {
        return alias;
    }
}
