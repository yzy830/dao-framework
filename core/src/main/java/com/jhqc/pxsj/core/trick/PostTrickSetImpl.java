package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.core.query.Update;

public class PostTrickSetImpl<D> extends TrickSetImpl<D> implements PostTrickSet<D> {
    private TrickUpdateImpl<D> trickUpdate;
    
    public PostTrickSetImpl(TrickUpdateImpl<D> trickUpdate) {
        super(trickUpdate);
        this.trickUpdate = trickUpdate;
    }

    @Override
    public Update<D> done() {
        return trickUpdate.done();
    }

}
