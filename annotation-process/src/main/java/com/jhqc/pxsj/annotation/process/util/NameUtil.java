package com.jhqc.pxsj.annotation.process.util;

import java.beans.PropertyDescriptor;

import org.apache.commons.lang3.StringUtils;

import com.jhqc.pxsj.domain.annotation.Domain;
import com.jhqc.pxsj.domain.annotation.Id;
import com.jhqc.pxsj.domain.annotation.Join;
import com.jhqc.pxsj.domain.annotation.Property;

public class NameUtil {
    private NameUtil() {
        throw new AssertionError();
    }
    
    public static String getIdColumnName(PropertyDescriptor descriptor) {
        Id id = descriptor.getReadMethod().getAnnotation(Id.class);
        
        if((id == null) || StringUtils.isEmpty(id.value())) {
            return PropertyNameUtil.underscoreName(descriptor.getName());
        } else {
            return id.value();
        }
    }

    public static String getPropertyColumnName(PropertyDescriptor descriptor) {
        Property property = descriptor.getReadMethod().getAnnotation(Property.class);
        
        if((property == null) || StringUtils.isEmpty(property.value())) {
            return PropertyNameUtil.underscoreName(descriptor.getName());
        } else {
            return property.value();
        }
    }
    
    public static String getJoinColumnName(PropertyDescriptor descriptor) {
        Join join = descriptor.getReadMethod().getAnnotation(Join.class);
        
        if((join == null) || StringUtils.isEmpty(join.column())) {
            return PropertyNameUtil.underscoreName(descriptor.getName());
        } else {
            return join.column();
        }
    }
    
    public static String getTargetJoinColumName(Join join) {
        if(join == null) {
            throw new NullPointerException();
        }
        
        if(StringUtils.isEmpty(join.refProperty())) {
            return null;
        }
        
        for(PropertyDescriptor p : ReflectionUtil.getPropertyDescriptors(join.domain())) {
            if(p.getName().equals(join.refProperty())) {
                return NameUtil.getJoinColumnName(p);
            }
        }
        
        return null;
    }
    
    public static String getEntityName(Class<?> domainModel, Domain domain) {
        if(domain == null) {
            throw new NullPointerException();
        }
        
        if(StringUtils.isEmpty(domain.name())) {
            return domainModel.getSimpleName();
        } else {
            return domain.name();
        }
    }
}
