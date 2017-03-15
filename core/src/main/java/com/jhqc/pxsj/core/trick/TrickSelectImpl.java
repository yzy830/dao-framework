package com.jhqc.pxsj.core.trick;

import java.util.Arrays;

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
        return new PostTrickSelectImpl<>(trick, false);
    }

    @Override
    public PostTrickSelect<T> autoSelect() {
        return new PostTrickSelectImpl<>(trick, true);
    }

    @Override
    public Query<T> count() {
        trick.addAttributes(Arrays.asList(trick.getBuilder().count().as("c")));
        return trick.selectDone(false);
    }

    @Override
    public Query<T> count(String alias, Meta<?, ?> meta) {
        trick.addAttributes(Arrays.asList(trick.getBuilder().count(trick.getRoot(alias).getRoot().get(meta)).as("c")));
        return trick.selectDone(false);
    }

    @Override
    public Query<T> sum(String alias, Meta<? extends Number, ?> meta) {
        trick.addAttributes(Arrays.asList(trick.getBuilder().sum(trick.getRoot(alias).getRoot().get(meta)).as("c")));
        return trick.selectDone(false);
    }
}
