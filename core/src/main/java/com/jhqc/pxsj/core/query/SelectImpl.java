package com.jhqc.pxsj.core.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.autoselect.AutoSelector;
import com.jhqc.pxsj.core.query.autoselect.Selectors;
import com.jhqc.pxsj.core.query.variants.SelectingVariant;
import com.jhqc.pxsj.core.query.variants.VariantUtil;

class SelectImpl<T> implements Select<T> {
    
    private Class<T> resultType;
    
    private List<SelectingVariant<?>> variants = new ArrayList<>();
    
    private AutoSelector selector;
    
    private MetaPool pool;
    
    public SelectImpl(Class<T> resultType, MetaPool pool) {
        if((resultType == null) || (pool == null)) {
            throw new NullPointerException();
        }
        
        this.resultType = resultType;
        this.pool = pool;
    }

    @Override
    public From<T> select(SelectingVariant<?>... variant) {
        if((variant == null) || (variant.length == 0)) {
            throw new IllegalArgumentException();
        }
        
        variants.addAll(Arrays.asList(variant));
        
        return new FromImpl<>(this);
    }

    @Override
    public From<T> autoSelect() {
        selector = Selectors.simple(pool, resultType);
        
        return new FromImpl<>(this);
    }

    @Override
    public Class<T> getResultType() {
        return resultType;
    }
    
    public String constructSelectClause() {
        if(selector != null) {
            return selector.select();
        } else {
            return VariantUtil.constructSelectClause(variants);
        }
    }
    
    @Override
    public String toString() {
        return constructSelectClause();
    }
}
