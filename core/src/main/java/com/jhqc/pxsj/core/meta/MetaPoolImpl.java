package com.jhqc.pxsj.core.meta;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;

public class MetaPoolImpl implements MetaPool {
    private Map<Class<?>, DomainMeta> pool = new HashMap<>();
    
    public MetaPoolImpl(Collection<Class<?>> domainModels) {
        if((domainModels == null) || domainModels.isEmpty()) {
            return;
        }
        
        for(Class<?> model : domainModels) {
            pool.put(model, new DomainMeta(model));
        }
    } 

    @Override
    public DomainMeta getMeta(Class<?> domainModel) {
        return pool.get(domainModel);
    }

}
