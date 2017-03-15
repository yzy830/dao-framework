package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Query;
import com.jhqc.pxsj.core.query.Query.OrderType;

public class PostTrickSelectImpl<T> implements PostTrickSelect<T> {
    private TrickImpl<T> trick;
    
    private boolean autoSelect;
    
    public PostTrickSelectImpl(TrickImpl<T> trick, boolean autoSelect) {
        this.trick = trick;
        this.autoSelect = autoSelect;
    }

    @Override
    public PostTrickSelect<T> select(String alias, Meta<?, ?>... metas) {
        SelectUtil.select(trick, alias, metas);
        return this;
    }

    @Override
    public Query<T> done() {
        return trick.selectDone(autoSelect);
    }

    @Override
    public PostTrickSelect<T> ascOrderBy(String alias, Meta<?, ?> meta) {
        trick.orderBy(trick.getRoot(alias).getRoot().get(meta), OrderType.ASC);
        return this;
    }

    @Override
    public PostTrickSelect<T> descOrderBy(String alias, Meta<?, ?> meta) {
        trick.orderBy(trick.getRoot(alias).getRoot().get(meta), OrderType.DESC);
        return this;
    }

    @Override
    public PostTrickSelect<T> limit(int offset, int count) {
        trick.limit(offset, count);
        return this;
    }

    @Override
    public PostTrickSelect<T> orderBy(String alias, Meta<?, ?> meta,
            OrderType orderType) {
        trick.orderBy(trick.getRoot(alias).getRoot().get(meta), orderType);
        return this;
    }

}
