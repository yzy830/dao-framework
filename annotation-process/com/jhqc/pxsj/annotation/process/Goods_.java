package com.jhqc.pxsj.annotation.process;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.annotation.process.util.ReflectionUtil;

import java.beans.PropertyDescriptor;
import java.util.Map;

public class Goods_ {
    public static final Class<?> domain = com.jhqc.pxsj.annotation.process.Goods.class;

    private static final Map<String, PropertyDescriptor> descriptors = ReflectionUtil.getPropertyDescriptorMap(domain); 
    
    public static final Meta<java.lang.Long> goodsId = Meta.<java.lang.Long>newInstance(descriptors.get("goodsId"));
    
    public static final Meta<java.lang.Integer> price = Meta.<java.lang.Integer>newInstance(descriptors.get("price"));
    
    public static final Meta<java.lang.String> name = Meta.<java.lang.String>newInstance(descriptors.get("name"));
}