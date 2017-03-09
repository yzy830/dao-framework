package com.jhqc.pxsj.core.query;

import java.util.List;

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
    public static <T> Predicate singleParam(Attribute<T> attr, T value, Operation op) {
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
    public static <T> Predicate multipleParam(Attribute<T> attr, List<T> values, Operation op) {
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
    public static <T> Predicate noParam(Attribute<T> attr, Operation op) {
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
    public static <T> Predicate plainSigleStrParam(Attribute<T> attr, String value, Operation op) {
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
    public static <T> Predicate plainMultipleStrParams(Attribute<T> attr, List<String> values, Operation op) {
        return new PredicateImpl(attr, op, values);
    }
}
