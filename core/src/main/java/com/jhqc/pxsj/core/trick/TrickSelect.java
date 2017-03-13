package com.jhqc.pxsj.core.trick;


import com.jhqc.pxsj.annotation.process.meta.Meta;
public interface TrickSelect<T> {
    PostTrickSelect<T> select(String alias, Meta<?, ?>... metas);
    
    PostTrickSelect<T> autoSelect();
}
