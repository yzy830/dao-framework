package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Query;

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

}
