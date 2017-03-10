package com.jhqc.pxsj.core.query.autoselect;

import com.jhqc.pxsj.core.meta.MetaPool;

public class Selectors {
    private Selectors() {
        throw new AssertionError();
    }
    
    public static AutoSelector simple(MetaPool pool, Class<?> result) {
        return new SimpleSelector(pool, result);
    }
}
