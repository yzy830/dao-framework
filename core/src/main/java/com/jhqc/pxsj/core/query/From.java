package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.root.Root;

public interface From<T> {
    Where<T> from(Root<?> root);
    
    Class<T> getResultType();
}
