package com.jhqc.pxsj.core.query;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Predicate;

/**
 * 描述一个SQL变量。在SQL语句中，子查询、属性列、函数结果均是变量
 *
 * @param <T>
 *          变量结果的Java类型
 */
public interface Variant<T> {
    Predicate like(T value);
    
    Predicate equal(T value);
    
    Predicate notEqual(T value);
    
    Predicate gt(T value);
    
    Predicate ge(T value);
    
    Predicate lt(T value);
    
    Predicate le(T value);
    
    Predicate in(T[] values);
    
    Predicate like(Variant<T> value);
    
    Predicate equal(Variant<T> value);
    
    Predicate notEqual(Variant<T> value);
    
    Predicate gt(Variant<T> value);
    
    Predicate ge(Variant<T> value);
    
    Predicate lt(Variant<T> value);
    
    Predicate le(Variant<T> value);
    
    <U extends Variant<T>> Predicate in(List<U> values);
    
    Predicate isNull();
    
    Predicate notNull();
    
    /**
     * 变量的java类型
     * 
     * @return 变量的java类型
     */
    Class<T> getJavaType();
}
