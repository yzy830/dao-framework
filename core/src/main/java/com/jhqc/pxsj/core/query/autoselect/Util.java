package com.jhqc.pxsj.core.query.autoselect;

import com.jhqc.pxsj.domain.annotation.Source;

public final class Util {
    private Util() {
        throw new AssertionError();
    }
    
    public static boolean isValidResultClass(Class<?> clazz) {        
        return clazz.getAnnotation(Source.class) != null;
    }
}
