package com.jhqc.pxsj.core.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.jhqc.pxsj.core.query.variants.SelectingVariant;
import com.jhqc.pxsj.core.query.variants.VariantUtil;

class SelectImpl<T> implements Select<T> {
    
    private Class<T> resultType;
    
    private List<SelectingVariant<?>> variants = new ArrayList<>();
    
    public SelectImpl(Class<T> resultType) {
        if(resultType == null) {
            throw new NullPointerException();
        }
        
        this.resultType = resultType;
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
    public From<T> selectAuto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Class<T> getResultType() {
        return resultType;
    }

    public List<SelectingVariant<?>> getVariants() {
        return Collections.unmodifiableList(variants);
    }
    
    @Override
    public String toString() {
        return "select " + VariantUtil.constructSelectClause(variants);
    }
}
