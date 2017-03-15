package com.jhqc.pxsj.core.query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.variants.Variant;

public class QueryImpl<T> implements Query<T> {
    private WhereImpl<T> where;
    
    private String sql;
    
    private static class Order {
        private Variant<?,?> variant;
        
        private OrderType orderType;
        
        public Order(Variant<?,?> variant, OrderType orderType) {
            this.variant = variant;
            this.orderType = orderType;
        }

        public Variant<?, ?> getVariant() {
            return variant;
        }

        public OrderType getOrderType() {
            return orderType;
        }
    }
    
    private List<Order> orders = new ArrayList<>();
    
    private static class Page {
        private int offset;
        
        private int count;
        
        public Page(int offset, int count) {
            this.offset = offset;
            this.count = count;
        }

        public int getOffset() {
            return offset;
        }

        public int getCount() {
            return count;
        }
    }
    
    private Page page;
    
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
        if(!orders.isEmpty() || (page != null)) {
            StringBuilder builder = new StringBuilder(sql);
            
            if(!orders.isEmpty()) {
                builder.append(" order by ").append(orders.stream().map(t -> t.getVariant().getExp() + " " + t.getOrderType().getValue())
                                                                   .collect(Collectors.joining(", ")));
            }
            
            if(page != null) {
                builder.append(" limit ").append(page.getOffset()).append(", ").append(page.getCount());
            }
            
            return builder.toString();
        } else {
            return sql;
        }
    }

    @Override
    public List<? extends Parameter<?>> getParams() {
        return where.getPredicate().getParams();
    }

    @Override
    public Class<T> getResultType() {
        return where.getResultType();
    }

    @Override
    public Query<T> orderBy(Variant<?, ?> variant, OrderType orderType) {
        if((variant == null) || (orderType == null)) {
            throw new IllegalArgumentException();
        }
        
        orders.add(new Order(variant, orderType));
        return this;
    }

    @Override
    public Query<T> setPage(int offset, int count) {
        if(offset < 0) {
            throw new IllegalArgumentException();
        }
        
        page = new Page(offset, count);
        return this;
    }
}
