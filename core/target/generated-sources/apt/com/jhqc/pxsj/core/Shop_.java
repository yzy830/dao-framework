package com.jhqc.pxsj.core;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.annotation.process.util.ReflectionUtil;

import java.beans.PropertyDescriptor;
import java.util.Map;

public class Shop_ {
    public static final Class<?> domain = com.jhqc.pxsj.core.Shop.class;

    private static final Map<String, PropertyDescriptor> descriptors = ReflectionUtil.getPropertyDescriptorMap(domain); 
    
    public static final Meta<java.lang.Long> id = Meta.<java.lang.Long>newInstance(descriptors.get("id"));
    
    public static final Meta<java.lang.String> name = Meta.<java.lang.String>newInstance(descriptors.get("name"));
}