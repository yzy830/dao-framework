package com.jhqc.pxsj.core;

/**
 * 表示一个拥有字符串表达式的组建，例如一个领域模型的属性，可以表示为table_name.attribute_name，一个函数的结果可以表示为now()等
 * 
 * 该接口返回的字符串表达式不可以包含别名。一个具有别名的组建应该使用{@link Aliased}接口或者{@link AliasedExpression接口}
 *
 */
public interface StringExpression {
    /**
     * 获得一个组建的字符串表达式，例如now，sum(t_d_order_base.amount)
     * 
     * @return 字符串表达式
     */
    String getExp();
}
