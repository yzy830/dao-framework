package com.jhqc.pxsj.core.query;

public interface Query<T> extends Sql {    
    Class<T> getResultType();
}
