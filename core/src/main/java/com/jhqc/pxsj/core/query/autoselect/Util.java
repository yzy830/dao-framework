package com.jhqc.pxsj.core.query.autoselect;

import java.util.List;
import java.util.Map;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;
import com.jhqc.pxsj.annotation.process.dynamicmeta.IdMeta;
import com.jhqc.pxsj.annotation.process.dynamicmeta.PropertyMeta;
import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.autoselect.meta.ResultMeta;
import com.jhqc.pxsj.core.query.autoselect.meta.ResultPropertyMeta;
import com.jhqc.pxsj.core.query.autoselect.template.ClauseTemplate;
import com.jhqc.pxsj.core.query.autoselect.template.Templates;
import com.jhqc.pxsj.domain.annotation.Source;
import com.jhqc.pxsj.domain.annotation.exception.MismatchPropertyException;
import com.jhqc.pxsj.domain.annotation.exception.SourceException;

public final class Util {    
    private Util() {
        throw new AssertionError();
    }
    
    public static boolean isValidResultClass(Class<?> clazz) {        
        return clazz.getAnnotation(Source.class) != null;
    }
    
    public static ClauseTemplate constructSelectFromDomainMeta(DomainMeta meta) {
        final String ROOT_PLACE_HOLDER = "#{root}";
        
        StringBuilder builder = new StringBuilder();
        
        processId(meta.getIdMeta(), ROOT_PLACE_HOLDER, builder);
        
        for(PropertyMeta propertyMeta : meta.getPropertyMetas().values()) {
            processPropertyMeta(propertyMeta, ROOT_PLACE_HOLDER, builder);
        }
        
        return Templates.rootOnly(builder.toString(), ROOT_PLACE_HOLDER);
    }
    
    private static void processId(IdMeta meta, String rootAlias, StringBuilder builder) {
        builder.append(rootAlias).append(meta.getColumnName()).append(" as ").append(meta.getDescriptor().getName()).append(" ");
    }
    
    private static void processPropertyMeta(PropertyMeta meta, String rootAlias, StringBuilder builder) {
        builder.append(rootAlias).append(meta.getColumnName()).append(" as ").append(meta.getDescriptor().getName()).append(" ");
    }
    
    public static ClauseTemplate constructSelectFromResultMeta(ResultMeta meta, MetaPool pool) {
        StringBuilder builder = new StringBuilder();
        
        for(Map.Entry<Class<?>, List<ResultPropertyMeta>> entry : meta.getMetaMap().entrySet()) {
            DomainMeta domainMeta = pool.getMeta(entry.getKey());
            
            if(domainMeta == null) {
                throw new SourceException(meta.getResultType(), entry.getKey());
            }
            
            for(ResultPropertyMeta rpMeta : entry.getValue()) {
                if(domainMeta.getIdMeta().getDescriptor().getName().equals(rpMeta.getSourceProperty())) {
                    constructSingleProperty(rpMeta, 
                            domainMeta.getIdMeta().getColumnName(), 
                            builder);
                } else if(domainMeta.getPropertyMetas().containsKey(rpMeta.getSourceProperty())) {
                    constructSingleProperty(rpMeta, 
                            domainMeta.getPropertyMetas().get(rpMeta.getSourceProperty()).getColumnName(), 
                            builder);
                } else {
                    throw new MismatchPropertyException(meta.getResultType(), entry.getKey(), rpMeta.getPropertyName());
                }
            }
        }
        
        return Templates.trival(builder.toString());
    }
    
    private static void constructSingleProperty(ResultPropertyMeta rpMeta, String columnName, StringBuilder builder) {
        builder.append(rpMeta.getRootAlias()).append(".").append(columnName).append(" as ").append(rpMeta.getAlias()).append(" ");
    }
}
