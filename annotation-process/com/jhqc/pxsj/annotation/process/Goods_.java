package com.jhqc.pxsj.annotation.process;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.annotation.process.util.ReflectionUtil;

import java.beans.PropertyDescriptor;
import java.util.Map;

public class Goods_ {
    public static final Class<?> domain = com.jhqc.pxsj.annotation.process.Goods.class;

    private static final Map<String, PropertyDescriptor> descriptors = ReflectionUtil.getPropertyDescriptorMap(domain); 
    
    public static final Meta<java.lang.Long, java.lang.Number> goodsId = Meta.<java.lang.Long, java.lang.Number>newInstance(descriptors.get("goodsId"));
    
    public static final Meta<java.lang.Integer, java.lang.Number> price = Meta.<java.lang.Integer, java.lang.Number>newInstance(descriptors.get("price"));
    
    public static final Meta<java.lang.String, java.lang.String> name = Meta.<java.lang.String, java.lang.String>newInstance(descriptors.get("name"));
}