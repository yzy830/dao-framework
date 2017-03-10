package com.jhqc.pxsj.core.query.autoselect;

import java.util.List;
import java.util.Map;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;
import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.autoselect.meta.ResultMeta;
import com.jhqc.pxsj.core.query.autoselect.meta.ResultPropertyMeta;
import com.jhqc.pxsj.domain.annotation.exception.MismatchPropertyException;
import com.jhqc.pxsj.domain.annotation.exception.SourceException;

public class SimpleSelector implements AutoSelector {    
    private String selectClause;
    
    public SimpleSelector(MetaPool pool, Class<?> result) {
        selectClause = constructSelect(new ResultMeta(result), pool);
    }
    
    private static String constructSelect(ResultMeta meta, MetaPool pool) {
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
        
        return builder.toString();
    }
    
    private static void constructSingleProperty(ResultPropertyMeta rpMeta, String columnName, StringBuilder builder) {
        builder.append(rpMeta.getRootAlias()).append(".").append(columnName).append(" as ").append(rpMeta.getAlias()).append(" ");
    }

    @Override
    public String select() {
        return selectClause;
    }
}
