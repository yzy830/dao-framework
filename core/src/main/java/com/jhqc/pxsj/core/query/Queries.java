package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.meta.MetaPool;

public final class Queries {
    private Queries() {
        throw new AssertionError();
    }
    
    public static <T> Select<T> createSelect(Class<T> resultType, MetaPool pool) {
        return new SelectImpl<>(resultType, pool);
    }
}
