package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Query;

public class PostTrickSelectImpl<T> implements PostTrickSelect<T> {
    private TrickImpl<T> trick;
    
    public PostTrickSelectImpl(TrickImpl<T> trick) {
        this.trick = trick;
    }

    @Override
    public PostTrickSelect<T> select(String alias, Meta<?, ?>... metas) {
        SelectUtil.select(trick, alias, metas);
        return this;
    }

    @Override
    public Query<T> done() {
        return trick.selectDone();
    }

}
