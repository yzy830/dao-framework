package com.jhqc.pxsj.core.query.root;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;
import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.annotation.process.util.PropertyNameUtil;
import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.attributes.Attributes;
import com.jhqc.pxsj.core.query.root.JoinImpl.JoinType;

public class RootImpl<T> implements Root<T> {
    private static final String AUTO_ALIAS_PREFIX = "_r_";
    
    protected DomainMeta domainMeta;
    
    protected MetaPool pool;
    
    protected String alias;
    
    protected Map<Class<?>, Join<T,?>> joinMap = new HashMap<>();
    
    private AliasGenerator aliasGenerator;
    
    public RootImpl(Class<?> domain, MetaPool pool) {
        this(domain, pool, generateAlias(domain, pool));
    }
    
    public RootImpl(Class<?> domain, MetaPool pool, String alias) {
        if(StringUtils.isEmpty(alias)) {
            throw new IllegalArgumentException("root alias cannot be empty");
        }
        
        this.domainMeta = pool.getMeta(domain);
        this.pool = pool;
        if(this.domainMeta == null) {
            throw new IllegalArgumentException(String.format("class[%s] is not a domain model", domain.getName()));
        }
        
        this.alias = alias;
    }
    
    private static String generateAlias(Class<?> domain, MetaPool pool) {
        DomainMeta domainMeta = pool.getMeta(domain);
        
        if(domainMeta == null) {
            throw new IllegalArgumentException(String.format("class[%s] is not a domain model", domain.getName()));
        }
        
        return AUTO_ALIAS_PREFIX + PropertyNameUtil.underscoreName(domainMeta.getEntityName());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U> Join<T, U> join(Class<U> domain) {
        if(joinMap.containsKey(domain)) {
            return (Join<T, U>)joinMap.get(domain);
        }
        
        Join<T, U> join = new JoinImpl<>(domain, pool, JoinType.INNER, this);
        joinMap.put(domain, join);
        
        return join;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U> Join<T, U> leftJoin(Class<U> domain) {
        if(joinMap.containsKey(domain)) {
            return (Join<T, U>)joinMap.get(domain);
        }
        
        Join<T, U> join = new JoinImpl<>(domain, pool, JoinType.LEFT, this);   
        joinMap.put(domain, join);
        
        return join;
    }
    
    @Override
    public <X, U> Attribute<X, U> get(Meta<X, U> meta) {
        return Attributes.generateAttribute(this, meta);
    }

    @Override
    public String getAlias() {
        return alias;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(domainMeta.getTable()).append(" ")
                                  .append(getAlias())
                                  .toString();
    }
    
    final public String construct() {
        StringBuilder builder = new StringBuilder();
        
        doConstruct(this, builder);
        
        return builder.toString();
    }
    
    private void doConstruct(Root<?> root, StringBuilder builder) {
        builder.append(root.toString());
        
        RootImpl<?> r = (RootImpl<?>)root;
        
        if(!r.joinMap.isEmpty()) {
            for(Join<?,?> join : r.joinMap.values()) {
                builder.append(" ");
                doConstruct(join, builder);
            }
        }
    }
    
    protected AliasGenerator getGenerator() {
        if(aliasGenerator == null) {
            aliasGenerator = new AliasGeneratorImpl();
        }
        
        return aliasGenerator;
    }
}
