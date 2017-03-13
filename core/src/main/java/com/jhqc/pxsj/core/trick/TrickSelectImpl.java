package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;

class TrickSelectImpl<T> implements TrickSelect<T> {
    private TrickImpl<T> trick;
    
    public TrickSelectImpl(TrickImpl<T> trick) {
        this.trick = trick;
    }

    @Override
    public PostTrickSelect<T> select(String alias, Meta<?, ?>... metas) {  
        SelectUtil.select(trick, alias, metas);        
        return new PostTrickSelectImpl<>(trick, false);
    }

    @Override
    public PostTrickSelect<T> autoSelect() {
        return new PostTrickSelectImpl<>(trick, true);
    }
}
