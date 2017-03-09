package com.jhqc.pxsj.core.query.variants;

public class SelectingVariantImpl<T> implements SelectingVariant<T> {
    private AbstractVariant<T, ?> variant;
    
    private String alias;
    
    private String exp;
    
    public SelectingVariantImpl(AbstractVariant<T, ?> variant, String alias) {
        this.variant = variant;
        this.alias = alias;
        this.exp = new StringBuilder(variant.getExp()).append(" as ").append(alias).toString();
    }

    @Override
    public Class<T> getJavaType() {
        return variant.getJavaType();
    }

    public String getExp() {
        return exp;
    }

    @Override
    public String getAlias() {
        return alias;
    }
    
    @Override
    public String toString() {
        return exp;
    }
}
