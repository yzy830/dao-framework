package com.jhqc.pxsj.core;

/**
 * 表示一个拥有字符串表达式的组建，例如root可以用数据库表表示，join可以使用join [table_name] on...表示。
 * 
 * 该接口返回的字符串表达式不可以包含别名。一个具有别名的组建应该使用{@link Aliased}接口标注，并在需要时单独处理
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
