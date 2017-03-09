package com.jhqc.pxsj.core;

import org.junit.Before;
import org.junit.Test;

import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.root.Join;
import com.jhqc.pxsj.core.query.root.Root;

public class TestCase {
    private CriteriaBuilder builder;
    
    @Before
    public void prepare() {
        Configuration conf = new Configuration();
        
        conf.addDomainModel(Goods.class);
        conf.addDomainModel(Shop.class);
        
        builder = conf.create();
    }
    
    @Test
    public void testSimple() {
        Root<Goods> goods = builder.root(Goods.class);
        
        Predicate predicate = builder.predicate().and(goods.get(Goods_.goodsId).equal(1L))
                                                 .and(goods.get(Goods_.price).lt(100));
        
        builder.createQuery(Integer.class).select(goods.get(Goods_.goodsId), goods.get(Goods_.name))
                                          .from(goods)
                                          .where(predicate);
    }
    
    @Test
    public void testJoin() {
        Root<Goods> goods = builder.root(Goods.class);
        Join<Goods, Shop> shop = goods.join(Shop.class); 
        
        Predicate predicate = builder.predicate().and(shop.get(Shop_.id).equal(2L))
                                                 .and(goods.get(Goods_.price).lt(100));
        
        builder.createQuery(Integer.class).select(goods.get(Goods_.goodsId), goods.get(Goods_.name))
                                          .from(goods)
                                          .where(predicate);
    }
}
