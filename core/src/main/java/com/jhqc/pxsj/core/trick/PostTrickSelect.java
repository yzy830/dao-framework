package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Query;
import com.jhqc.pxsj.core.query.Query.OrderType;

public interface PostTrickSelect<T> {
    PostTrickSelect<T> select(String alias, Meta<?, ?>... metas);
    
    PostTrickSelect<T> ascOrderBy(String alias, Meta<?, ?> metas);
    
    PostTrickSelect<T> descOrderBy(String alias, Meta<?, ?> metas);
    
    PostTrickSelect<T> orderBy(String alias, Meta<?, ?> meta, OrderType orderType);
    
    PostTrickSelect<T> limit(int offset, int count);
    
    Query<T> done();
}
