package com.jhqc.pxsj.core.query.root;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.AliasedExpression;
import com.jhqc.pxsj.core.query.attributes.Attribute;

public interface Root<T> extends AliasedExpression {
    <U> Join<T, U> join(Class<U> domain);
    
    <U> Join<T, U> join(Class<U> domain, String alias);
    
    <U> Join<T, U> leftJoin(Class<U> domain);
    
    <U> Join<T, U> leftJoin(Class<U> domain, String alias);
    
    <X, U> Attribute<X, U> get(Meta<X, U> meta);    
    
    /**
     * 获得从一个Root开始的连接链，例如 goods g left join shop s on g.shop_id = s.shop_id
     * 
     * @return 获得从一个Root开始的连接链
     */
    String getJoinChainExpression();
}
