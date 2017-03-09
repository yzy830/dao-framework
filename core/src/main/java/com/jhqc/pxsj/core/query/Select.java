package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.variants.SelectingVariant;

public interface Select<T> {
    From<T> select(SelectingVariant<?>...variant);
    
    From<T> selectAuto();
    
    Class<T> getResultType();
}
