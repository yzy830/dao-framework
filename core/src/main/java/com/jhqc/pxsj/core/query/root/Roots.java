package com.jhqc.pxsj.core.query.root;

import com.jhqc.pxsj.core.meta.MetaPool;

public final class Roots {
    private Roots() {
        throw new AssertionError();
    }
    
    public static boolean isRoot(Class<?> clazz) {
        return !isJoin(clazz);
    }
    
    public static boolean isJoin(Class<?> clazz) {
        return Join.class.isAssignableFrom(clazz);
    }
    
    public static <T> Root<T> root(Class<T> clazz, MetaPool metaPool) {
        return new RootImpl<>(clazz, metaPool);
    }
    
    public static <T> Root<T> root(Class<T> clazz, String alias, MetaPool metaPool) {
        return new RootImpl<>(clazz, metaPool, alias);
    }
}
