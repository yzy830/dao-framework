package com.jhqc.pxsj.core;

import java.util.ArrayList;
import java.util.List;

import com.jhqc.pxsj.core.query.CriteriaBuilder;

public class Configuration {
    private List<Class<?>> domainModels = new ArrayList<>();
    
    public void addDomainModel(Class<?> domainModel) {
        this.domainModels.add(domainModel);
    }
    
    public CriteriaBuilder create() {
        return null;
    }
} 
