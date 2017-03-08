package com.jhqc.pxsj.core;

import com.jhqc.pxsj.domain.annotation.Domain;
import com.jhqc.pxsj.domain.annotation.Id;

@Domain(table = "t_d_shop")
public class Shop {
    private Long id;
    
    private String name;

    @Id("shop_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
