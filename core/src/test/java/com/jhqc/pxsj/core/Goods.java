package com.jhqc.pxsj.core;

import com.jhqc.pxsj.domain.annotation.Domain;
import com.jhqc.pxsj.domain.annotation.Id;
import com.jhqc.pxsj.domain.annotation.Join;
import com.jhqc.pxsj.domain.annotation.Property;

@Domain(table = "t_d_goods")
public class Goods {
    private Long goodsId;
    
    private Integer price;
    
    private String name;
    
    private Long shopId;

    @Id
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Property("goods_price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Property("goods_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Join(domain = Shop.class, refProperty = "shopId")
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
