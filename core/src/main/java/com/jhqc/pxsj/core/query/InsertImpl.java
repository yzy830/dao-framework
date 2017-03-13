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

public class InsertImpl implements Insert {
    private static final String INSERT_TEMPLATE = "insert into %s (%s) values(%s)";

    private DomainMeta meta;
    
    private String sql;
    
    private List<Parameter<?>> params = new ArrayList<>();
    
    private Object obj;
    
    public InsertImpl(MetaPool pool, Object obj) {
        if((obj == null) || (pool == null)) {
            throw new IllegalArgumentException();
        }
        
        meta = pool.getMeta(obj.getClass());
        if(meta == null) {
            throw new InsertNonDomainModelException(obj.getClass());
        }
        this.obj = obj;
        sql = createSql(meta, obj, params);
    }

    @Override
    public String create() {
        return sql;
    }

    @Override
    public List<? extends Parameter<?>> getParams() {
        return params;
    }
    
    private static String createSql(DomainMeta meta, Object obj, List<Parameter<?>> params) {        
        Object id = getField(meta.getIdMeta().getDescriptor().getReadMethod(), obj);
        List<String> columns = new ArrayList<>();
        List<String> placeHolders = new ArrayList<>();
        
        if(id != null) {
            columns.add(meta.getIdMeta().getColumnName());
            placeHolders.add("?");
            params.add(Parameters.newInstance(id.getClass(), id));
        }
        
        for(PropertyMeta pMeta : meta.getPropertyMetas().values()) {
            columns.add(pMeta.getColumnName());
            placeHolders.add("?");
            params.add(Parameters.newInstance(pMeta.getDescriptor().getPropertyType(), 
                                              getField(pMeta.getDescriptor().getReadMethod(), obj)));
        }
        
        return String.format(INSERT_TEMPLATE, meta.getTable(), 
                             columns.stream().collect(Collectors.toList()),
                             placeHolders.stream().collect(Collectors.toList()));
    }
    
    private static Object getField(Method getter, Object obj) {
        try {
            return getter.invoke(obj);
        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
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
    public void saveId(Object id) {
        putField(meta.getIdMeta().getDescriptor().getWriteMethod(), obj, id);
    }
}
