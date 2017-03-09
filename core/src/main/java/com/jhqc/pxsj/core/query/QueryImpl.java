package com.jhqc.pxsj.core.query;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Predicates;
import com.jhqc.pxsj.core.query.root.RootUtil;
import com.jhqc.pxsj.core.query.variants.VariantUtil;

public class QueryImpl<T> implements Query<T> {
    private WhereImpl<T> where;
    
    private String sql;
    
    public QueryImpl(WhereImpl<T> where) {
        this.where = where;
        
        FromImpl<T> from = where.getFrom();
        SelectImpl<T> selet = from.getSelect();
        
        sql = new StringBuilder().append("select ")                                                     
                                 .append(VariantUtil.constructSelectClause(selet.getVariants()))        
                                 .append(" from ")                                                      
                                 .append(RootUtil.constructFromClause(from.getRoot()))                  
                                 .append(" where ")                                                     
                                 .append(Predicates.getCriteriaClause(where.getPredicate()))
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
}
