package com.jhqc.pxsj.core.trick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.jhqc.pxsj.core.CriteriaBuilder;
import com.jhqc.pxsj.core.exception.AbsentRootAliasException;
import com.jhqc.pxsj.core.exception.DuplicatedAliasException;
import com.jhqc.pxsj.core.query.Query;
import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.root.Root;

class TrickImpl<T> implements Trick<T> {
    
    private Map<String, TrickRoot<T, ?>> rootMap = new HashMap<>();
    
    private CriteriaBuilder builder;
    
    private TrickType type;
    
    private Class<T> resultType;
    
    private List<Attribute<?, ?>> attributes = new ArrayList<>();
    
    private Root<?> root;
    
    private Predicate predicate;
    
    public TrickImpl(CriteriaBuilder builder, TrickType type, Class<T> resultType) {
        this.builder = builder;
        this.type = type;
        this.resultType = resultType;
        
        if(type == TrickType.AND) {
            predicate = builder.alwaysTrue();
        } else /* if((type == TrickType.OR)) */ {
            predicate = builder.alwaysFalse();
        }
    }

    public CriteriaBuilder getBuilder() {
        return builder;
    }

    @Override
    public <D> TrickRoot<T, D> root(Class<D> domain, String alias) {
        if(StringUtils.isEmpty(alias)) {
            throw new IllegalArgumentException("alias cannot be empty");
        }
        
        Root<D> root = builder.root(domain, alias);
        TrickRoot<T, D> trickRoot = new TrickRootImpl<>(this, root);
        addRoot(alias, trickRoot);
        
        this.root = root;
        
        return trickRoot;
    }

    TrickRoot<T, ?> getRoot(String alias) {
        if(StringUtils.isEmpty(alias)) {
            throw new IllegalArgumentException("alias cannot be empty");
        }
        
        if(!rootMap.containsKey(alias)) {
            throw new AbsentRootAliasException(alias);
        }
        
        return rootMap.get(alias);
    }
    
    void addRoot(String alias, TrickRoot<T, ?> root) {
        if(StringUtils.isEmpty(alias)) {
            throw new IllegalArgumentException("alias cannot be empty");
        }
        
        if(rootMap.containsKey(alias)) {
            throw new DuplicatedAliasException(alias);
        }
        
        rootMap.put(alias, root);
    }
    
    public void composit(Predicate p) {
        if(type == TrickType.AND) {
            predicate.and(p);
        } else {
            predicate.or(p);
        }
    }

    @Override
    public Class<T> getResultType() {
        return resultType;
    }

    public List<Attribute<?, ?>> getAttributes() {
        return Collections.unmodifiableList(attributes);
    }
    
    public void addAttributes(List<? extends Attribute<?, ?>> attrs) {
        attributes.addAll(attrs);
    }
    
    public Query<T> selectDone() {
        return builder.createQuery(resultType).select(attributes.toArray(new Attribute<?, ?>[] {})).from(root).where(predicate);
    }
    
    public Query<T> autoSelect() {
        return builder.createQuery(resultType).autoSelect().from(root).where(predicate);
    }
}
