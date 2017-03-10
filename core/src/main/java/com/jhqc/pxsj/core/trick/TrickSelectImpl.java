package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Query;

class TrickSelectImpl<T> implements TrickSelect<T> {
    private TrickImpl<T> trick;
    
    public TrickSelectImpl(TrickImpl<T> trick) {
        this.trick = trick;
    }

    @Override
    public PostTrickSelect<T> select(String alias, Meta<?, ?>... metas) {  
        SelectUtil.select(trick, alias, metas);        
        return new PostTrickSelectImpl<>(trick);
    }

    @Override
    public Query<T> autoSelect() {
        return trick.autoSelect();
    }
}
