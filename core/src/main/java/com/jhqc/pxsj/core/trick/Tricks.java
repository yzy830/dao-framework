package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.core.CriteriaBuilder;

public final class Tricks {
    private Tricks() {
        throw new AssertionError();
    }
    
    public static <T> Trick<T> trick(CriteriaBuilder builder, TrickType type, Class<T> resultType) {
        return new TrickImpl<T>(builder, type, resultType);
    }
    
    public static <T> TrickUpdate<T> trickUpdate(CriteriaBuilder builder, TrickType type, Class<T> domain) {
        return new TrickUpdateImpl<>(builder, type, domain);
    }
}
