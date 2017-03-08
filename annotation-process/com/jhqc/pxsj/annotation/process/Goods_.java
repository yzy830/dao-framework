package com.jhqc.pxsj.annotation.process;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.annotation.process.util.ReflectionUtil;

import java.beans.PropertyDescriptor;
import java.util.Map;

public class Goods_ {
    public static final Class<?> domain = com.jhqc.pxsj.annotation.process.Goods.class;

    private static final Map<String, PropertyDescriptor> descriptors = ReflectionUtil.getPropertyDescriptorMap(domain); 
    
    public static final Meta goodsId = Meta.newInstance(descriptors.get("goodsId"));
    
    public static final Meta price = Meta.newInstance(descriptors.get("price"));
    
    public static final Meta name = Meta.newInstance(descriptors.get("name"));
}