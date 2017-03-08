package com.jhqc.pxsj.core;

import java.io.Serializable;
import java.util.List;

import com.jhqc.pxsj.core.query.Predicate;

public interface BaseDao<E, ID extends Serializable> {
    E find(ID id);
    
    List<E> find(ID...ids);
    
    // 需要字段映射、表关联元数据
    List<E> find(Predicate query);
    
    <T> T find(Class<T> clazz, ID id);
    
    <T> List<T> find(Class<T> clazz, ID...ids);
    
    // 需要字段映射、表关联元数据
    // 结果集映射
    <T> List<T> find(Class<T> clazz, Predicate query);
    
    //
    void save(E entity);
    
    //
    void save(E... entity);
    
    void delete(ID id);
    
    void delete(ID...ids);
    
    void update(E entity);
    
    //
    interface PartialUpdater {
        
        
        int update();
    }
}
