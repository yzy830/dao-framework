package com.jhqc.pxsj.core.trick;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.jhqc.pxsj.annotation.process.meta.Meta;

final class SelectUtil {
    private SelectUtil() {
        throw new AssertionError();
    }
    
    static <T> void select(TrickImpl<T> trick, String alias, Meta<?, ?>... metas) {
        if(StringUtils.isEmpty(alias)) {
            throw new IllegalArgumentException("alias cannot be empty");
        }
        
        if((metas == null) || (metas.length == 0)) {
            throw new IllegalArgumentException("metas cannot be empty");
        }
        
        trick.addAttributes(Arrays.stream(metas).map(t -> {
                                                    TrickRootImpl<T,?> root = (TrickRootImpl<T,?>)trick.getRoot(alias);
                                                    return root.getRoot().get(t);
                                                    })
                                               .collect(Collectors.toList()));
    }
}
