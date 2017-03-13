package com.jhqc.pxsj.core.query;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Parameter;

public interface Sql {
    String create();
    
    List<? extends Parameter<?>> getParams();
}
