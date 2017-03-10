package com.jhqc.pxsj.core.query.variants;

import java.util.List;
import java.util.stream.Collectors;

public final class VariantUtil {
    private VariantUtil() {
        throw new AssertionError();
    }
    
    public static String constructSelectClause(List<SelectingVariant<?>> vars) {
        return vars.stream().map(SelectingVariant::getExp).collect(Collectors.joining(", "));
    }
}
