package com.jhqc.pxsj.core.query.variants;

import java.util.List;

public final class VariantUtil {
    private VariantUtil() {
        throw new AssertionError();
    }
    
    public static String constructSelectClause(List<SelectingVariant<?>> vars) {
        StringBuilder builder = new StringBuilder();
        
        for(SelectingVariant<?> v : vars) {
            builder.append(v.getExp()).append("");
        }
        
        return builder.toString();
    }
}
