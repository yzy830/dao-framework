package com.jhqc.pxsj.core;

import org.junit.Before;
import org.junit.Test;

import com.jhqc.pxsj.core.query.predicate.Predicate;
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
        Root<Goods> root = builder.root(Goods.class);
        
        Predicate predicate = builder.predicate().and(root.get(Goods_.goodsId).equal(Integer.valueOf(1)))
                                                 .and(root.get(Goods_.price).lt(Integer.valueOf(100)));
        
        builder.createQuery(Integer.class).select(root.get(Goods_.goodsId), root.get(Goods_.name))
                                          .from(root)
                                          .where(predicate);
    }
    
    @Test
    public void testJoin() {
        
    }
}
