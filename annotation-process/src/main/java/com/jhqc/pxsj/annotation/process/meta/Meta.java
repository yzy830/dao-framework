package com.jhqc.pxsj.annotation.process.meta;

import java.beans.PropertyDescriptor;

public abstract class Meta {
    private Class<?> domainClass;
    
    private Class<?> propertyType;
    
    private String name;
    
    private String columnName;
    
    public Meta(PropertyDescriptor descriptor) {
        domainClass = descriptor.getReadMethod().getDeclaringClass();
        propertyType = descriptor.getPropertyType();
        name = descriptor.getName();
    }

    public Class<?> getDomainClass() {
        return domainClass;
    }

    public Class<?> getPropertyType() {
        return propertyType;
    }

    public String getName() {
        return name;
    }

    public String getColumnName() {
        return columnName;
    }
    
    protected void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    
    public static Meta newInstance(PropertyDescriptor descriptor) {
        com.jhqc.pxsj.domain.annotation.Id id = descriptor.getReadMethod().getAnnotation(com.jhqc.pxsj.domain.annotation.Id.class);
        if(id != null) {
            return new Id(descriptor, id);
        } else {
            com.jhqc.pxsj.domain.annotation.Join join = descriptor.getReadMethod().getAnnotation(com.jhqc.pxsj.domain.annotation.Join.class);
            if(join != null) {
                return new Join(descriptor, join);
            } else {
                // 默认是普通属性，可以不配置标签
                com.jhqc.pxsj.domain.annotation.Property property = descriptor.getReadMethod().getAnnotation(com.jhqc.pxsj.domain.annotation.Property.class);
                return new Property(descriptor, property);
            }
        }
    }
}
