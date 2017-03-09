package com.jhqc.pxsj.core;

import com.jhqc.pxsj.annotation.process.meta.Join;

public class App {

    public static void main(String[] args) {
        System.out.println("property = " + Goods_.goodsId.getName() + ", column = " + Goods_.goodsId.getColumnName() + ", type = " + Goods_.goodsId.getPropertyType());
//        System.out.println("property = " + Goods_.name.getName() + ", column = " + Goods_.name.getColumnName() + ", type = " + Goods_.name.getPropertyType());
        System.out.println("property = " + Goods_.price.getName() + ", column = " + Goods_.price.getColumnName() + ", type = " + Goods_.price.getPropertyType());
        Join join = (Join)Goods_.shopId;
        System.out.println("property = " + join.getName() + ", column = " + join.getColumnName() + ", type = " + join.getPropertyType() + ", join column = " + join.getJoinColumn() + ", join domain = " + join.getJoinDomain());
    }
}
