package com.jhqc.pxsj.core;

import org.junit.Before;
import org.junit.Test;

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
//        
//        builder.createQuery(Integer.class).select(root.getAttribute(Goods_.goodsId))
//                                          .from(root)
//                                          .where(root.getAttribute(meta))
    }
    
    @Test
    public void testJoin() {
        
    }
}
