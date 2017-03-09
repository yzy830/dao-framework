package com.jhqc.pxsj.core.meta;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;

public interface MetaPool {
    public DomainMeta getMeta(Class<?> domain);
}
