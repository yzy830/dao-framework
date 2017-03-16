package com.jhqc.pxsj.core.query;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Parameter;

/**
 * 插入领域模型
 *
 * @param <T>
 *          领域模型
 */
public interface Insert<T> extends Sql {
    List<? extends Parameter<?>> getParams(T obj);
    
    void saveId(T obj, Object id);
    
    Class<?> getIdType();
    
    Class<?> getDomainType();
}
