package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.core.CriteriaBuilder;
import com.jhqc.pxsj.core.trick.Trick.TrickType;

public final class Tricks {
    public static <T> Trick<T> trick(CriteriaBuilder builder, TrickType type, Class<T> resultType) {
        return new TrickImpl<T>(builder, type, resultType);
    }
}
