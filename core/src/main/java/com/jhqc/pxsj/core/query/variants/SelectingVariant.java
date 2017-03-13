package com.jhqc.pxsj.core.query.variants;

import com.jhqc.pxsj.core.Aliased;
import com.jhqc.pxsj.core.StringExpression;

/**
 * 用于表示select子句中的变量，可具有alias
 *
 */
public interface SelectingVariant<T> extends StringExpression, Aliased {
    /**
     * 变量的java类型
     * 
     * @return 变量的java类型
     */
    Class<T> getJavaType();
}
