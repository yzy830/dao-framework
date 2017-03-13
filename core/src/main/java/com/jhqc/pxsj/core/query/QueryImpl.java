package com.jhqc.pxsj.core.query;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Predicates;

public class QueryImpl<T> implements Query<T> {
    private WhereImpl<T> where;
    
    private String sql;
    
    public QueryImpl(WhereImpl<T> where) {
        this.where = where;
        
        FromImpl<T> from = where.getFrom();
        SelectImpl<T> select = from.getSelect();
        
        sql = new StringBuilder().append("select ")
                                 .append(select.getSelectedVariantsExpression(from.getRoot()))                                                          
                                 .append(" from ")                                                      
                                 .append(from.getRoot().getJoinChainExpression())                  
                                 .append(" where ")                                                     
                                 .append(where.getPredicate().getExp())
                                 .toString();
    }

    @Override
    public String create() {
        return sql;
    }

    @Override
    public List<Object> getParams() {
        return Predicates.getParams(where.getPredicate());
    }

    @Override
    public Class<T> getResultType() {
        return where.getResultType();
    }
}
