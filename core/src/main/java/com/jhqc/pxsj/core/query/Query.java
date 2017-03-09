package com.jhqc.pxsj.core.query;

import java.util.List;

public interface Query<T> {
    String create();
    
    List<Object> getParams();
}
