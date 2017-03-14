package com.jhqc.pxsj.core.query;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Parameter;

public interface Query<T> extends Sql {    
    Class<T> getResultType();
    
    List<? extends Parameter<?>> getParams();
}
