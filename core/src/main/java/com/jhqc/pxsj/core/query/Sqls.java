package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.root.Root;

public final class Sqls {
    private Sqls() {
        throw new AssertionError();
    }
    
    public static <T> Insert<T> createInsert(MetaPool pool, Class<T> domainModel) {
        return new InsertImpl<>(pool, domainModel);
    }

    public static <T> Select<T> createSelect(Class<T> resultType, MetaPool pool) {
        return new SelectImpl<>(resultType, pool);
    }
    
    public static <T> Setter<T> createUpdate(Root<T> root) {
        return new SetterImpl<>(root);
    }
}
