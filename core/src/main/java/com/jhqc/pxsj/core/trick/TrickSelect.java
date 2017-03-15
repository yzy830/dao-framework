package com.jhqc.pxsj.core.trick;


import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Query;
public interface TrickSelect<T> {
    PostTrickSelect<T> select(String alias, Meta<?, ?>... metas);
    
    PostTrickSelect<T> autoSelect();
    
    Query<T> count();
    
    Query<T> count(String alias, Meta<?, ?> meta);
    
    Query<T> sum(String alias, Meta<? extends Number, ?> meta);
}
