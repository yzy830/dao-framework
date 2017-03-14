package com.jhqc.pxsj.core.query;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Parameter;

public interface Update<T> extends Sql {
    List<? extends Parameter<?>> getParams();
}
