package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.predicate.Predicate;

class WhereImpl<T> implements Where<T> {
    private FromImpl<T> from;
    
    private Predicate predicate;
    
    public WhereImpl(FromImpl<T> from) {
        this.from = from;
    }

    @Override
    public Query<T> where(Predicate predicate) {
        this.predicate = predicate;
        
        return new QueryImpl<>(this); 
    }

    @Override
    public Class<T> getResultType() {
        return from.getResultType();
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(from.toString()).append(" ");
        
        if(predicate != null) {
            builder.append(predicate.toString());
        }
        
        return builder.toString();
    }
    
    public Predicate getPredicate() {
        return predicate;
    }

    public FromImpl<T> getFrom() {
        return from;
    }
}
