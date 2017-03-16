package com.jhqc.pxsj.core.query;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;
import com.jhqc.pxsj.annotation.process.dynamicmeta.PropertyMeta;
import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.exception.AccessBeanMethodException;
import com.jhqc.pxsj.core.exception.InsertNonDomainModelException;
import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.predicate.Parameters;
import com.jhqc.pxsj.core.query.variants.Variant;

public class InsertImpl<T> implements Insert<T> {
    private static final String INSERT_TEMPLATE = "insert into %s (%s) values(%s)";
    
    private static final Variant<?, ?> NOW = com.jhqc.pxsj.core.query.function.Now.INSTANCE.apply();

    private DomainMeta meta;
    
    private String sql;
    
    private List<Parameter<?>> params = new ArrayList<>();
    
    private Set<String> ignores;
    
    private List<PropertyDescriptor> descriptors = new ArrayList<>();
    
    public InsertImpl(MetaPool pool, Class<?> domainModel, Meta<?, ?>... ignores) {
        if((domainModel == null) || (pool == null)) {
            throw new IllegalArgumentException();
        }
        
        meta = pool.getMeta(domainModel);
        if(meta == null) {
            throw new InsertNonDomainModelException(domainModel);
        }
        
        if(ignores != null) {
            this.ignores = Arrays.stream(ignores).map(Meta::getName).collect(Collectors.toSet());
        } else {
            this.ignores = new HashSet<>();
        }
        
        sql = createSql(meta, domainModel, params, this.ignores, this.descriptors);
    }

    @Override
    public String create() {
        return sql;
    }
    
    private static <T> String createSql(DomainMeta meta, Class<T> clazz, List<Parameter<?>> params, Set<String> ignores, List<PropertyDescriptor> descriptors) {        
        List<String> columns = new ArrayList<>();
        List<String> placeHolders = new ArrayList<>();
        
        if(!ignores.contains(meta.getIdMeta().getDescriptor().getName())) {
            columns.add(meta.getIdMeta().getColumnName());
            placeHolders.add("?");
            descriptors.add(meta.getIdMeta().getDescriptor());
        }
        
        for(PropertyMeta pMeta : meta.getPropertyMetas().values()) {
            if(!ignores.contains(pMeta.getDescriptor().getName())) {
                columns.add(pMeta.getColumnName());
                
                if(pMeta.isUseNow()) {
                    placeHolders.add(NOW.getExp());
                } else {
                    placeHolders.add("?");
                    descriptors.add(pMeta.getDescriptor());
                }
            }
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
        
        for(PropertyDescriptor descriptor : descriptors) {
            params.add(Parameters.newInstance(descriptor.getPropertyType(), getField(descriptor.getReadMethod(), obj)));
        }
        
        return params;
    }

    @Override
    public Class<?> getIdType() {
        return meta.getIdMeta().getDescriptor().getPropertyType();
    }

    @Override
    public Class<?> getDomainType() {
        return meta.getDomainModel();
    }
}
