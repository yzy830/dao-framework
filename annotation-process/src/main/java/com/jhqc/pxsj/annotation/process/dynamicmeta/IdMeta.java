package com.jhqc.pxsj.annotation.process.dynamicmeta;

import java.beans.PropertyDescriptor;

import com.jhqc.pxsj.annotation.process.util.NameUtil;
import com.jhqc.pxsj.domain.annotation.Id;

/**
 * 描述一个id的元数据。Id需要单独描述，为了处理Id自动生成和Id查询的情况
 *
 */
public class IdMeta {
    //id元数据的持有方
    private DomainMeta domainMeta;
    
    private PropertyDescriptor descriptor;
    
    private String columnName;
    
    public IdMeta(DomainMeta domainMeta, PropertyDescriptor descriptor, Id idAnnotation) {
        this.domainMeta = domainMeta;
        this.descriptor = descriptor;
        this.columnName = NameUtil.getIdColumnName(descriptor);
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
