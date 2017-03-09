package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.predicate.Predicate;

public interface Query<T> {
    Query<T> where(Predicate predicate);
    
//    Query<T> select(Attribute<?>...attributes);
    
    Query<T> selectAuto();
    
    <U> Query<T> from(Root<U> root);
}
