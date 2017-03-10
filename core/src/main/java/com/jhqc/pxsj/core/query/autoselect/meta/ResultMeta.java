package com.jhqc.pxsj.core.query.autoselect.meta;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jhqc.pxsj.annotation.process.util.ReflectionUtil;
import com.jhqc.pxsj.core.query.autoselect.Util;
import com.jhqc.pxsj.domain.annotation.Source;
import com.jhqc.pxsj.domain.annotation.SourceProperty;
import com.jhqc.pxsj.domain.annotation.exception.InvalidResultClassException;

public class ResultMeta {
    
    /**
     * 从数据源到所覆盖的结果集属性元数据的映射
     */
    private Map<Class<?>, List<ResultPropertyMeta>> metaMap = new HashMap<>();
    
    private Class<?> resultType;
    
    public ResultMeta(Class<?> result) {
        if(result == null) {
            throw new IllegalArgumentException();
        }
        
        if(!Util.isValidResultClass(result)) {
            throw new InvalidResultClassException(result);
        }
        
        this.resultType = result;
        
        Source mainSource = result.getAnnotation(Source.class);
        for(PropertyDescriptor descriptor : ReflectionUtil.getPropertyDescriptors(result)) {
            ResultPropertyMeta propertyMeta = generatePropertyMeta(descriptor, mainSource);
            
            if(metaMap.containsKey(propertyMeta.getSource())) {
                metaMap.get(propertyMeta.getSource()).add(propertyMeta);
            } else {
                List<ResultPropertyMeta> list = new ArrayList<>();
                list.add(propertyMeta);
                metaMap.put(propertyMeta.getSource(), list);
            }
        }
    }
    
    private ResultPropertyMeta generatePropertyMeta(PropertyDescriptor descriptor, Source mainSource) {
        Source subSource = descriptor.getReadMethod().getAnnotation(Source.class);
        if(subSource == null) {
            subSource = mainSource;
        }
        
        SourceProperty sourceProperty = descriptor.getReadMethod().getAnnotation(SourceProperty.class);
        String sourcePropertyName = descriptor.getName();
        if(sourceProperty != null) {
            //默认情况下认为结果集的属性名与数据源的属性名匹配，如果使用了SourceProperty标签，则使用指定的属性名
            sourcePropertyName = sourceProperty.value();
        }
        
        return new ResultPropertyMeta(descriptor.getName(), sourcePropertyName, subSource.domain(), subSource.alias());
    }
    
    public List<ResultPropertyMeta> getResultPropertyMetaList(Class<?> source) {
        return Collections.unmodifiableList(metaMap.get(source));
    }
    
    public Map<Class<?>, List<ResultPropertyMeta>> getMetaMap() {
        return Collections.unmodifiableMap(metaMap);
    }

    public Class<?> getResultType() {
        return resultType;
    }
}
