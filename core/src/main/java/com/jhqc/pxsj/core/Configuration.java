package com.jhqc.pxsj.core;

import java.util.ArrayList;
import java.util.List;

import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.meta.MetaPoolImpl;
import com.jhqc.pxsj.core.query.CriteriaBuilder;

public class Configuration {
    private List<Class<?>> domainModels = new ArrayList<>();
    
    public Configuration addDomainModel(Class<?> domainModel) {
        this.domainModels.add(domainModel);
        return this;
    }
    
    public CriteriaBuilder create() {
        MetaPool metaPool = new MetaPoolImpl(domainModels);
        
        return new CriteriaBuilderImpl(metaPool);
    }
} 
