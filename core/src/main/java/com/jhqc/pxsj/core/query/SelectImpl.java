package com.jhqc.pxsj.core.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.autoselect.AutoSelector;
import com.jhqc.pxsj.core.query.autoselect.Selectors;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.SelectingVariant;

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
    public From<T> autoSelect(SelectingVariant<?>... additionalVariants) {
        if((additionalVariants == null) || (additionalVariants.length == 0)) {
            throw new IllegalArgumentException();
        }
        
        variants.addAll(Arrays.asList(additionalVariants));
        
        selector = Selectors.simple(pool, resultType);
        
        return new FromImpl<>(this);
    }

    @Override
    public Class<T> getResultType() {
        return resultType;
    }
    
    public String getSelectedVariantsExpression(Root<?> root) {
        if(root == null) {
            throw new IllegalArgumentException();
        }
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(selectVariants(variants));
        
        if(selector != null) {
            if(!variants.isEmpty()) {
                builder.append(", ");
            }
            builder.append(selector.select(root));
        }
        
        return builder.toString();
    }
    
    private static String selectVariants(List<? extends SelectingVariant<?>> variants) {
        return variants.stream().map(t -> t.getExp() + " as " + t.getAlias()).collect(Collectors.joining(", "));
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append(selectVariants(variants));
        
        if(selector != null) {
            if(!variants.isEmpty()) {
                builder.append(", ");
            }
            builder.append(selector.getTemplate().getTemplate());
        }
        
        return builder.toString();
    }
}
