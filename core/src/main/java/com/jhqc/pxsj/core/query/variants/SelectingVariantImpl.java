package com.jhqc.pxsj.core.query.variants;

class SelectingVariantImpl<T> implements SelectingVariant<T> {
    private Variant<T, ?> variant;
    
    private String alias;
    
    public SelectingVariantImpl(Variant<T, ?> variant, String alias) {
        this.variant = variant;
        this.alias = alias;
    }

    @Override
    public Class<T> getJavaType() {
        return variant.getJavaType();
    }

    public String getExp() {
        return variant.getExp();
    }

    @Override
    public String getAlias() {
        return alias;
    }
    
    @Override
    public String toString() {
        return variant.getExp();
    }
}
