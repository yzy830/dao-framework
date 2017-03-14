package com.jhqc.pxsj.core;

import java.util.Date;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import com.jhqc.pxsj.core.query.Insert;
import com.jhqc.pxsj.core.query.Query;
import com.jhqc.pxsj.core.query.function.DateAdd;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.root.Join;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.domain.annotation.Source;
import com.jhqc.pxsj.domain.annotation.SourceProperty;

public class AppTest {
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
        
        Predicate predicate = builder.alwaysTrue().and(goods.get(Goods_.goodsId).eq(1))
                                                 .and(goods.get(Goods_.price).lt(100));
        
        Query<Integer> query = builder.createQuery(Integer.class).select(goods.get(Goods_.goodsId), goods.get(Goods_.name))
                                                                 .from(goods)
                                                                 .where(predicate);
        
        System.out.println(query.create());
        System.out.println(query.getParams());
    }
    
    @Test
    public void testJoin() {
        Root<Goods> goods = builder.root(Goods.class);
        Join<Goods, Shop> shop = goods.join(Shop.class); 
        
        Predicate predicate = builder.alwaysTrue().and(shop.get(Shop_.shopId).eq(2))
                                                 .and(goods.get(Goods_.price).lt(100));
        
        Query<Integer> query = builder.createQuery(Integer.class).select(goods.get(Goods_.goodsId), goods.get(Goods_.name))
                                                                 .from(goods)
                                                                 .where(predicate);
        
        System.out.println(query.create());
        System.out.println(query.getParams());
    }
    
    @Source(domain = Goods.class, alias = "goods")
    public static class Result {
        private Integer goodsId;
        
        private String goodsName;
        
        private Integer shopId;
        
        private String shopName;

        public Integer getGoodsId() {
            return goodsId;
        }
        
        @SourceProperty("name")
        public String getGoodsName() {
            return goodsName;
        }

        @Source(domain = Shop.class, alias = "shop")
        public Integer getShopId() {
            return shopId;
        }

        @Source(domain = Shop.class, alias = "shop")
        @SourceProperty("name")
        public String getShopName() {
            return shopName;
        }
    }
    
    @Test
    public void testAuto() {
        Root<Goods> goods = builder.root(Goods.class, "goods");
        Join<Goods, Shop> shop = goods.leftJoin(Shop.class, "shop"); 
        
        Predicate predicate = builder.alwaysTrue().and(shop.get(Shop_.shopId).eq(3))
                                                  .and(builder.dateAdd(goods.get(Goods_.createDate), 2, DateAdd.Type.HOUR).lt(builder.now()))
                                                  .and(goods.get(Goods_.price).lt(1300))
                                                  ;
        
        Query<Result> query = builder.createQuery(Result.class).autoSelect()
                                                                .from(goods)
                                                                .where(predicate);

        System.out.println(query.create());
        System.out.println(query.getParams());
    }
    
    @Test
    public void testTrick() {        
        Query<Result> query = builder.trick(Result.class).root(Goods.class, "goods").lt(Goods_.price, 2000)
                                                                                    .gtIf(Goods_.createDate, new Date(), Objects::nonNull)
                                                         .leftJoin(Shop.class, "shop").eq(Shop_.shopId, 333)
                                                                                      .eq(Shop_.status, ShopStatus.NORMAL)
                                                         .done()
                                                         .autoSelect()
                                                         .select("goods", Goods_.createDate)
                                                         .done();
        System.out.println(query.create());
        System.out.println(query.getParams());
    }
    
    @Test
    public void testInsert() {
        Insert<Goods> insert = builder.creatInsert(Goods.class);
        
        Goods g = new Goods();
        g.setCreateDate(null);
        g.setName("测试店铺");
        g.setPrice(120);
        g.setShopId(1L);
        
        System.out.println(insert.create());
        System.out.println(insert.getParams(g));
    }
}
