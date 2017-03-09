package com.jhqc.pxsj.core.query.variants;

/**
 * 用于表示select子句中的变量，可具有alias
 *
 */
public interface SelectingVariant<T> {
    /**
     * 变量的java类型
     * 
     * @return 变量的java类型
     */
    Class<T> getJavaType();
    
    /**
     * 获得别名
     * 
     * @return 别名
     */
    String getAlias();
    
    /**
     * 变量的表达式，例如now，sum(t_d_order_base.amount)等
     * 
     * @return 表达式
     */
    String getExp();
}
