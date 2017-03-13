package com.jhqc.pxsj.core.query.predicate;

import java.util.List;

import com.jhqc.pxsj.core.query.Operation;
import com.jhqc.pxsj.core.query.variants.Variant;

public final class Predicates {
    private Predicates() {
        throw new AssertionError();
    }
    
    /**
     * 生成单一变量占位符的条件子句，例如name like ?
     * 
     * @param attr
     *          属性
     * @param value
     *          值
     * @param op
     *          操作
     *          
     * @return 单一变量占位符的条件子句
     */
    public static <T, U> Predicate singleParam(Variant<T, U> attr, T value, Operation op) {
        return new PredicateImpl(attr, value, op);
    }
    
    /**
     * 生成多变量占位符的条件子句，例如id in (?, ?, ?)
     * 
     * @param attr
     *          属性
     * @param values
     *          值
     * @param op
     *          操作
     *          
     * @return 多变量占位符的条件子句
     */
    public static <T, U> Predicate multipleParam(Variant<T, U> attr, List<T> values, Operation op) {
        return new PredicateImpl(attr, values, op);
    }
    
    /**
     * 生成无变量占位符的条件子句，例如price is null
     * 
     * @param attr
     *          属性
     * @param op
     *          操作
     *          
     * @return 无变量占位符的条件子句
     */
    public static <T, U> Predicate noParam(Variant<T, U> attr, Operation op) {
        return new PredicateImpl(attr, op);
    }
    
    /**
     * 生成单一字符串参数的条件子句，例如time > now()
     * 
     * @param attr
     *          属性
     * @param value
     *          字符串参数
     * @param op
     *          操作
     * 
     * @return 单一字符串参数的条件子句
     */
    public static <T, U> Predicate plainSigleStrParam(Variant<T, U> attr, Variant<? extends U, ?> value, Operation op) {
        return new PredicateImpl(attr, op, value);
    }
    
    /**
     * 生成多字符串参数的条件子句，例如id in ('1', '2', '3')
     * 
     * @param attr
     *          属性
     * @param values
     *          字符串参数
     * @param op
     *          操作
     *          
     * @return 多字符串参数的条件子句
     */
    public static <T, U> Predicate plainMultipleStrParams(Variant<T, U> attr, List<? extends Variant<? extends U, ?>> values, Operation op) {
        return new PredicateImpl(attr, op, values);
    }
    
    /**
     * 生成一个为真的Predicate
     * 
     * @return 为真的Predicate
     */
    public static Predicate alwaysTrue() {
        return new PredicateImpl(true);
    }
    
    /**
     * 生成一个为假的Predicate
     * 
     * @return 为假的Predicate
     */
    public static Predicate alwaysFlase() {
        return new PredicateImpl(false);
    }
}
