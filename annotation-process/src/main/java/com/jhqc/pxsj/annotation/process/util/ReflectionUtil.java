package com.jhqc.pxsj.annotation.process.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import com.jhqc.pxsj.annotation.process.exceptions.GetBeanInfoExceptoin;

public class ReflectionUtil {
    private ReflectionUtil() {
        throw new AssertionError();
    }
    
    public static Map<String, PropertyDescriptor> getPropertyDescriptorMap(Class<?> clazz) {
        try {
            PropertyDescriptor[] descriptors = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
            
            Map<String, PropertyDescriptor> map = new HashMap<>();
            for(PropertyDescriptor descriptor : descriptors) {
                map.put(descriptor.getName(), descriptor);
            }
            
            return map;
        } catch (IntrospectionException e) {
            throw new GetBeanInfoExceptoin(clazz, e);
        }
    }
    
    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) {
        try {
            return Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();            
        } catch (IntrospectionException e) {
            throw new GetBeanInfoExceptoin(clazz, e);
        }
    }
}
