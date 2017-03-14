package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.predicate.Predicate;

public interface PostSetter<T> extends Setter<T> {
    Update<T> where(Predicate predicate);
}
