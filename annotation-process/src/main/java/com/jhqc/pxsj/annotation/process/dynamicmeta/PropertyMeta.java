package com.jhqc.pxsj.annotation.process.dynamicmeta;

import java.beans.PropertyDescriptor;

import com.jhqc.pxsj.annotation.process.util.NameUtil;
import com.jhqc.pxsj.domain.annotation.Join;
import com.jhqc.pxsj.domain.annotation.Property;

/**
 * 描述一个普通属性或者关联属性。关联属性在存储和查询的时候和普通属性具有一致性
 *
 */
public class PropertyMeta {
    //属性元数据的持有方
    private DomainMeta domainMeta;
    
    private PropertyDescriptor descriptor;
    
    private String columnName;
    
    public PropertyMeta(DomainMeta domainMeta, PropertyDescriptor descriptor, Property propertyAnnotation) {
        this.domainMeta = domainMeta;
        this.descriptor = descriptor;
        this.columnName = NameUtil.getPropertyColumnName(descriptor);
    }
    
    public PropertyMeta(DomainMeta domainMeta, PropertyDescriptor descriptor, Join propertyAnnotation) {
        this.domainMeta = domainMeta;
        this.descriptor = descriptor;
        this.columnName = NameUtil.getJoinColumnName(descriptor);
    }

    public DomainMeta getDomainMeta() {
        return domainMeta;
    }

    public PropertyDescriptor getDescriptor() {
        return descriptor;
    }

    public String getColumnName() {
        return columnName;
    }
}
