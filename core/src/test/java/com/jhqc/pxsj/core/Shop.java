package com.jhqc.pxsj.core;


import com.jhqc.pxsj.domain.annotation.Domain;
import com.jhqc.pxsj.domain.annotation.Id;
import com.jhqc.pxsj.domain.annotation.Property;

@Domain(table = "t_d_shop")
public class Shop {
    private Integer shopId;
    
    private String name;
    
    private ShopStatus status;
    
    private String address;

    @Id
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer id) {
        this.shopId = id;
    }

    @Property("shop_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShopStatus getStatus() {
        return status;
    }

    public void setStatus(ShopStatus status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
