package com.jhqc.pxsj.core.trick;

public interface TrickUpdate<D> {
    TrickUpdateRoot<D> root();
    
    Class<D> getDomain();
}
