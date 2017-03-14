package com.jhqc.pxsj.core.query;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;
import com.jhqc.pxsj.annotation.process.dynamicmeta.PropertyMeta;
import com.jhqc.pxsj.core.exception.AccessBeanMethodException;
import com.jhqc.pxsj.core.exception.InsertNonDomainModelException;
import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.predicate.Parameters;

public class InsertImpl<T> implements Insert<T> {
    private static final String INSERT_TEMPLATE = "insert into %s (%s) values(%s)";

    private DomainMeta meta;
    
    private String sql;
    
    private List<Parameter<?>> params = new ArrayList<>();
    
    public InsertImpl(MetaPool pool, Class<?> domainModel) {
        if((domainModel == null) || (pool == null)) {
            throw new IllegalArgumentException();
        }
        
        meta = pool.getMeta(domainModel);
        if(meta == null) {
            throw new InsertNonDomainModelException(domainModel);
        }
        sql = createSql(meta, domainModel, params);
    }

    @Override
    public String create() {
        return sql;
    }
    
    private static <T> String createSql(DomainMeta meta, Class<T> clazz, List<Parameter<?>> params) {        
        List<String> columns = new ArrayList<>();
        List<String> placeHolders = new ArrayList<>();
        
        //应该始终成立
        columns.add(meta.getIdMeta().getColumnName());
        placeHolders.add("?");
        
        for(PropertyMeta pMeta : meta.getPropertyMetas().values()) {
            columns.add(pMeta.getColumnName());
            placeHolders.add("?");
        }
        
        return String.format(INSERT_TEMPLATE, meta.getTable(), 
                             columns.stream().collect(Collectors.joining(", ")),
                             placeHolders.stream().collect(Collectors.joining(", ")));
    }
    
    private static Object getField(Method getter, Object obj) {
        try {
            return getter.invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AccessBeanMethodException(getter, e);
        }
    }
    
    private static void putField(Method setter, Object obj, Object value) {
        try {
            setter.invoke(obj, value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AccessBeanMethodException(setter, e);
        }
    }

    @Override
    public void saveId(T obj, Object id) {
        putField(meta.getIdMeta().getDescriptor().getWriteMethod(), obj, id);
    }

    @Override
    public List<? extends Parameter<?>> getParams(T obj) {
        List<Parameter<?>> params = new ArrayList<>();
        
        params.add(Parameters.newInstance(meta.getIdMeta().getDescriptor().getPropertyType(), 
                                          getField(meta.getIdMeta().getDescriptor().getReadMethod(), obj)));
        for(PropertyMeta pMeta : meta.getPropertyMetas().values()) {
            params.add(Parameters.newInstance(pMeta.getDescriptor().getPropertyType(), 
                                              getField(pMeta.getDescriptor().getReadMethod(), obj)));
        }
        
        return params;
    }
}
