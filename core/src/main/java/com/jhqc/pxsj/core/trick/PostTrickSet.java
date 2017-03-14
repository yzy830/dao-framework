package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.core.query.Update;

public interface PostTrickSet<D> extends TrickSet<D> {    
    Update<D> done();
}
