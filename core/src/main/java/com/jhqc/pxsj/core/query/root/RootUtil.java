package com.jhqc.pxsj.core.query.root;

import com.jhqc.pxsj.core.exception.ConstructFromClauseException;

public final class RootUtil {
    private RootUtil() {
        throw new AssertionError();
    }
    
    public static String constructFromClause(Root<?> root) {
        if(!(root instanceof RootImpl)) {
            throw new ConstructFromClauseException(root);
        }
        
        RootImpl<?> r = (RootImpl<?>)root;
        
        return r.construct();
    }
}
