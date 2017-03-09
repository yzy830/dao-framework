package com.jhqc.pxsj.core.query.variants;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Predicate;

/**
 * 描述一个SQL变量。在SQL语句中，子查询、属性列、函数结果均是变量
 *
 * @param <T>
 *          变量结果的Java类型
 * @param <U>
 *          操作数类型
 */
public interface Variant<T, U> extends SelectingVariant<T> {
    Predicate like(T value);
    
    Predicate equal(T value);
    
    Predicate notEqual(T value);
    
    Predicate gt(T value);
    
    Predicate ge(T value);
    
    Predicate lt(T value);
    
    Predicate le(T value);
    
    Predicate in(T[] values);
    
    Predicate like(Variant<U, ?> value);
    
    Predicate equal(Variant<U, ?> value);
    
    Predicate notEqual(Variant<U, ?> value);
    
    Predicate gt(Variant<U, ?> value);
    
    Predicate ge(Variant<U, ?> value);
    
    Predicate lt(Variant<U, ?> value);
    
    Predicate le(Variant<U, ?> value);
    
    Predicate in(List<? extends Variant<U, ?>> values);
    
    Predicate isNull();
    
    Predicate notNull();
    
    SelectingVariant<T> as(String alias);
}
