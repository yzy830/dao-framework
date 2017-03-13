package com.jhqc.pxsj.core.query;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Parameter;

public interface Query<T> {
    String create();
    
    List<? extends Parameter<?>> getParams();
    
    Class<T> getResultType();
}
